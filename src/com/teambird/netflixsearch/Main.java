package com.teambird.netflixsearch;

public class Main {

    public Main() {
        FileReader moviesCSV = new FileReader("tmdb_5000_movies.csv");
        FileReader creditsCSV = new FileReader("tmdb_5000_credits.csv");

        System.out.println(moviesCSV.getData().get(0));
    }

    public static void main(String[] args){
        new Main();
    }
}
