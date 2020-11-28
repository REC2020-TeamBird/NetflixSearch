package com.teambird.netflixsearch;

import com.teambird.netflixsearch.Objects.Credits;
import com.teambird.netflixsearch.Objects.Movie;

public class Main {

    public Main() {
        FileReader moviesCSV = new FileReader("tmdb_5000_movies.csv");
        FileReader creditsCSV = new FileReader("tmdb_5000_credits.csv");

        Movie movie = new Movie(moviesCSV.getData().get(0));
        Credits credit = new Credits(creditsCSV.getData().get(0));
    }

    public static void main(String[] args){
        new Main();
    }
}
