package com.teambird.netflixsearch.Objects;

import com.teambird.netflixsearch.Util.JSONFormatter;

import java.util.Arrays;
import java.util.List;

public class Movie {

    private int Budget;
    private List<String> Genres;
    private String URL;
    private int MovieId;
    private List<String> Keywords;
    private String Languages;
    private String OriginalTitle;
    private String Overview;
    private double Popularity;
    private List<String> ProductionCompanies;
    private List<String> ProductionCountries;
    private String ReleaseDate;
    private double Revenue;
    private int Runtime;
    private List<String> SpokenLanguages;
    private String Status;
    private String TagLine;
    private String Title;
    private double VoteAverage;
    private int VoteCount;

    public Movie(String MovieData) {
        // Split regex: https://stackoverflow.com/questions/18893390/splitting-on-comma-outside-quotes
        List<String> Data = Arrays.asList(MovieData.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"));

        for (int i = 0; i < Data.size(); i++) {
            switch (i) {
                case 0:
                    this.Budget = Integer.parseInt(Data.get(i));
                    break;
                case 1:
                    this.Genres = JSONFormatter.JSONToList(Data.get(i), "name");
                    break;
                case 2:
                    this.URL = Data.get(i);
                    break;
                case 3:
                    this.MovieId = Integer.parseInt(Data.get(i));
                    break;
                case 4:
                    this.Keywords = JSONFormatter.JSONToList(Data.get(i), "name");
                    break;
                case 5:
                    this.Languages = Data.get(i);
                    break;
                case 6:
                    this.OriginalTitle = Data.get(i);
                    break;
                case 7:
                    this.Overview = Data.get(i);
                    break;
                case 8:
                    this.Popularity = Double.parseDouble(Data.get(i));
                    break;
                case 9:
                    this.ProductionCompanies = JSONFormatter.JSONToList(Data.get(i), "name");
                    break;
                case 10:
                    this.ProductionCountries = JSONFormatter.JSONToList(Data.get(i), "name");
                    break;
                case 11:
                    this.ReleaseDate = Data.get(i);
                    break;
                case 12:
                    this.Revenue = Double.parseDouble(Data.get(i));
                    break;
                case 13:
                    this.Runtime = Integer.parseInt(Data.get(i));
                    break;
                case 14:
                    this.SpokenLanguages = JSONFormatter.JSONToList(Data.get(i), "name");
                    break;
                case 15:
                    this.Status = Data.get(i);
                    break;
                case 16:
                    this.TagLine = Data.get(i);
                    break;
                case 17:
                    this.Title = Data.get(i);
                    break;
                case 18:
                    this.VoteAverage = Double.parseDouble(Data.get(i));
                    break;
                case 19:
                    this.VoteCount = Integer.parseInt(Data.get(i));
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return "\nMovie{" +
                "\nBudget=" + Budget +
                "\n, Genres=" + Genres +
                "\n, URL='" + URL + '\'' +
                "\n, MovieId=" + MovieId +
                "\n, Keywords=" + Keywords +
                "\n, Languages='" + Languages + '\'' +
                "\n, OriginalTitle='" + OriginalTitle + '\'' +
                "\n, Overview='" + Overview + '\'' +
                "\n, Popularity=" + Popularity +
                "\n, ProductionCompanies=" + ProductionCompanies +
                "\n, ProductionCountries=" + ProductionCountries +
                "\n, ReleaseDate='" + ReleaseDate + '\'' +
                "\n, Revenue=" + Revenue +
                "\n, Runtime=" + Runtime +
                "\n, SpokenLanguages=" + SpokenLanguages +
                "\n, Status='" + Status + '\'' +
                "\n, TagLine='" + TagLine + '\'' +
                "\n, Title='" + Title + '\'' +
                "\n, VoteAverage=" + VoteAverage +
                "\n, VoteCount=" + VoteCount +
                '}';
    }
}
