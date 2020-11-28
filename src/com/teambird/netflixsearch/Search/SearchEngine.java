package com.teambird.netflixsearch.Search;

import com.teambird.netflixsearch.Objects.Credits;
import com.teambird.netflixsearch.Objects.Movie;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private List<Movie> Movies;
    private List<Credits> Credits;

    public SearchEngine(List<String> Movies, List<String> Credits) {
        System.out.println("Importing data...");

        this.Movies = new ArrayList<>();
        this.Credits = new ArrayList<>();

        for (int i = 0; i < Movies.size(); i++) {
            this.Movies.add(new Movie(Movies.get(i)));
        }
    }
}
