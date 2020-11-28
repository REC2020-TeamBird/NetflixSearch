package com.teambird.netflixsearch.Objects;

import com.teambird.netflixsearch.Util.JSONFormatter;

import java.util.*;

public class Movie {
    
    private final Map<String, List<String>> map;
    public int Matches;
    public List<String> MatchedParams;

    public Movie(String MovieData) {
        map = new HashMap<>();
        Matches = 0;
        MatchedParams = new ArrayList<>();
        // Split regex: https://stackoverflow.com/questions/18893390/splitting-on-comma-outside-quotes
        List<String> Data = Arrays.asList(MovieData.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"));

        for (int i = 0; i < Data.size(); i++) {
            String value = Data.get(i);
            List<String> data = new ArrayList<>();

            switch (i) {
                case 0:
                    data.add(value);
                    map.put("Budget", data);
                    break;
                case 1:
                    map.put("Genres", JSONFormatter.JSONToList(value, "name"));
                    break;
                case 2:
                    data.add(value);
                    map.put("URL", data);
                    break;
                case 3:
                    data.add(value);
                    map.put("MovieId", data);
                    break;
                case 4:
                    map.put("Keywords", JSONFormatter.JSONToList(value, "name"));
                    break;
                case 5:
                    data.add(value);
                    map.put("Languages", data);
                    break;
                case 6:
                    data.add(value);
                    map.put("OriginalTitle", data);
                    break;
                case 7:
                    data.add(value);
                    map.put("Overview", data);
                    break;
                case 8:
                    data.add(value);
                    map.put("Popularity", data);
                    break;
                case 9:
                    map.put("ProductionCompanies", JSONFormatter.JSONToList(value, "name"));
                    break;
                case 10:
                    map.put("ProductionCountries", JSONFormatter.JSONToList(value, "name"));
                    break;
                case 11:
                    data.add(value);
                    map.put("ReleaseDate", data);
                    break;
                case 12:
                    data.add(value);
                    map.put("Revenue", data);
                    break;
                case 13:
                    data.add(value);
                    map.put("Runtime", data);
                    break;
                case 14:
                    map.put("SpokenLanguages", JSONFormatter.JSONToList(value, "name"));
                    break;
                case 15:
                    data.add(value);
                    map.put("Status", data);
                    break;
                case 16:
                    data.add(value);
                    map.put("TagLine", data);
                    break;
                case 17:
                    data.add(value);
                    map.put("Title", data);
                    break;
                case 18:
                    data.add(value);
                    map.put("VoteAverage", data);
                    break;
                case 19:
                    data.add(value);
                    map.put("VoteCount", data);
                    break;
                default:
                    break;
            }
        }
    }

    public Map<String, List<String>> getMap() {
        return this.map;
    }

    @Override
    public String toString() {
        String Title = this.map.get("Title").size() > 0 ? this.map.get("Title").get(0) : "Unknown";
        String TagLine = this.map.get("TagLine").size() > 0 ? "- " + this.map.get("TagLine").get(0) : "";
        String Overview = this.map.get("Overview").size() > 0 ? this.map.get("Overview").get(0) : "";
        String Popularity = this.map.get("Popularity").size() > 0 ? this.map.get("Popularity").get(0) : "nil";
        String Budget = this.map.get("Budget").size() > 0 ? this.map.get("Budget").get(0) : "nil";

        if (this.MatchedParams.size() > 0) {
            return String.format("%s %s\nOverview: %s\nPopularity: %s - Budget: $%s\nMatched Parameters: %s", Title, TagLine, Overview, Popularity, Budget, this.MatchedParams.toString());
        } else {
            return String.format("%s %s\nOverview: %s\nPopularity: %s - Budget: $%s", Title, TagLine, Overview, Popularity, Budget);
        }
    }
}
