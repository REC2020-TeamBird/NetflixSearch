package com.teambird.netflixsearch.Search;

import com.teambird.netflixsearch.Objects.Movie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class SearchAlgorithm {

    public static void SearchMovies(List<Movie> Movies, Map<String, List<String>> SearchData) {
        List<Movie> PossibleMovies = new ArrayList<>();

        for (Movie movie : Movies) {
            int Matches = 0;
            movie.Matches = 0;
            movie.MatchedParams = new ArrayList<>();

            for (Map.Entry<String, List<String>> entry : SearchData.entrySet()) {
                String Name = entry.getKey();
                List<String> Params = entry.getValue();
                List<String> Values = movie.getMap().get(Name);

                if (Name.equals("Genres") || Name.equals("Keywords") || Name.equals("Languages")) {
                    for (String param : Params) {
                        if (Values.contains(param)) {
                            Matches += 1;
                            movie.MatchedParams.add(param);
                        }
                    }
                } else {
                    double ParamValue = Double.parseDouble(Params.get(0));

                    if (Double.parseDouble(Values.get(0)) > ParamValue) {
                        System.out.printf("%f %f\n", Double.parseDouble(Values.get(0)), ParamValue);
                        Matches += 1;
                        movie.MatchedParams.add(Name);
                    }
                }
            }

            if (Matches > 0) {
                movie.Matches = Matches;
                PossibleMovies.add(movie);
            }
        }

        //https://stackoverflow.com/questions/4258700/collections-sort-with-multiple-fields
        //https://stackoverflow.com/questions/32995559/reverse-a-comparator-in-java-8
        PossibleMovies.sort((o1, o2) -> o2.Matches - o1.Matches);

        if (PossibleMovies.size() > 0) {
            List<Movie> DisplayedMovies = new ArrayList<>();

            if (PossibleMovies.size() > 5) {
                for (int i = 0; i < 5; i++) {
                    DisplayedMovies.add(PossibleMovies.get(i));
                }
            } else {
                DisplayedMovies.addAll(PossibleMovies);
            }

            for (int i = 0; i < DisplayedMovies.size(); i++) {
                Movie movie = PossibleMovies.get(i);
                System.out.printf("\nMovie #%d - Total Matches: %d\n==========================\n%s\n", i+1, movie.Matches, movie.toString());
            }
        } else {
            System.out.println("\nNo movies have been found given the parameters provided!\n");
        }
    }
}
