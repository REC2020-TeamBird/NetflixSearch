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
    private int Popularity;
    private List<String> ProductionCompanies;
    private List<String> ProductionCountries;
    private String ReleaseDate;
    private int Revenue;
    private int Runtime;
    private List<String> SpokenLanguages;
    private String Status;
    private String TagLine;
    private String Title;
    private int VoteAverage;
    private int VoteCount;

    public Movie(String MovieData) {
        // Split regex: https://stackoverflow.com/questions/18893390/splitting-on-comma-outside-quotes
        List<String> Data = Arrays.asList(MovieData.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"));
        JSONFormatter.JSONToList(Data.get(1), "name");
//        JSONObject jsonObject = new JSONObject(Data.get(1).replaceAll("^\"|\"$", ""));
//
//
//        System.out.println(jsonObject.toString());

//        for (int i = 0; i < Data.size(); i++) {
//            switch (i) {
//                case 0:
//                    this.Budget = Integer.parseInt(Data.get(i));
//                    break;
//                case 1:
//
//                    break;
//                case 2:
//                    break;
//                case 3:
//                    break;
//                case 4:
//                    break;
//                case 5:
//                    break;
//                case 6:
//                    break;
//                case 7:
//                    break;
//                case 8:
//                    break;
//                case 9:
//                    break;
//                case 10:
//                    break;
//                case 11:
//                    break;
//                case 12:
//                    break;
//                case 13:
//                    break;
//                case 14:
//                    break;
//                case 15:
//                    break;
//                case 16:
//                    break;
//                case 17:
//                    break;
//                case 18:
//                    break;
//                case 19:
//                    break;
//                default:
//                    break;
//            }
//        }
    }

}
