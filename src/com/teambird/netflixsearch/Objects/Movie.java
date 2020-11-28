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
    private double Runtime;
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
            String value = Data.get(i);

            switch (i) {
                case 0:
                    this.Budget = Integer.parseInt(value);

                    break;
                case 1:
                    this.Genres = JSONFormatter.JSONToList(value, "name");
                    break;
                case 2:
                    this.URL = value;
                    break;
                case 3:
                    this.MovieId = Integer.parseInt(value);
                    break;
                case 4:
                    this.Keywords = JSONFormatter.JSONToList(value, "name");
                    break;
                case 5:
                    this.Languages = value;
                    break;
                case 6:
                    this.OriginalTitle = value;
                    break;
                case 7:
                    this.Overview = value;
                    break;
                case 8:
                    this.Popularity = Double.parseDouble(value);
                    break;
                case 9:
                    this.ProductionCompanies = JSONFormatter.JSONToList(value, "name");
                    break;
                case 10:
                    this.ProductionCountries = JSONFormatter.JSONToList(value, "name");
                    break;
                case 11:
                    this.ReleaseDate = value;
                    break;
                case 12:
                    this.Revenue = Double.parseDouble(value);
                    break;
                case 13:
                    if (value.length() == 0 ){
                        value = "-1";
                    }
                    this.Runtime = Double.parseDouble(value);
                    break;
                case 14:
                    this.SpokenLanguages = JSONFormatter.JSONToList(value, "name");
                    break;
                case 15:
                    this.Status = value;
                    break;
                case 16:
                    this.TagLine = value;
                    break;
                case 17:
                    this.Title = value;
                    break;
                case 18:
                    if (value.length() == 0 ){
                        value = "-1";
                    }
                    this.VoteAverage = Double.parseDouble(value);
                    break;
                case 19:
                    if (value.length() == 0 ){
                        value = "-1";
                    }
                    this.VoteCount = Integer.parseInt(value);
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
