package com.teambird.netflixsearch;

import com.teambird.netflixsearch.Objects.Credits;
import com.teambird.netflixsearch.Objects.Movie;
import com.teambird.netflixsearch.Search.SearchEngine;

public class Main {

    public Main() {
        FileReader moviesCSV = new FileReader("tmdb_5000_movies.csv");
        FileReader creditsCSV = new FileReader("tmdb_5000_credits.csv");

        SearchEngine searchEngine = new SearchEngine(moviesCSV.getData(), creditsCSV.getData());
    }

    public static void main(String[] args){
        new Main();
    }
}
