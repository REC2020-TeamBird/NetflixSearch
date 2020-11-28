package com.teambird.netflixsearch.Search;

import com.teambird.netflixsearch.Objects.Credits;
import com.teambird.netflixsearch.Objects.Movie;

import java.util.*;

// https://stackoverflow.com/questions/4258700/collections-sort-with-multiple-fields

public class SearchEngine {

    private final List<Movie> Movies;
    private final List<Credits> Credits;

    private final String[] Parameters = {"Genres", "Keywords", "Languages", "Title"};

    public SearchEngine(List<String> Movies, List<String> Credits) {
        System.out.println("Importing data...");

        this.Movies = new ArrayList<>();
        this.Credits = new ArrayList<>();

        for (String movie : Movies) {
            this.Movies.add(new Movie(movie));
        }

        for (String credit : Credits) {
            this.Credits.add(new Credits(credit));
        }

        System.out.println("Importing data completed!");
    }

    private void DisplayParams() {
        System.out.println("\nThe following parameters can be used for searching:");

        for (String parameter : Parameters) {
            System.out.printf("- %s\n", parameter);
        }

        System.out.println("\nWhen searching, either a single word or a set of words separated by commas can be used!");
    }

    private void Search() {
        Map<String, List<String>> SearchData = new HashMap<>();

        for (String parameter : Parameters) {
            System.out.printf("\nPlease enter the %s or leave blank:", parameter);

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            input = input.replaceAll(" ","");

            if (input.length() > 0) {
                List<String> inputs = Arrays.asList(input.split(","));

                for (int i = 0; i < inputs.size(); i++) {
                    inputs.set(i, inputs.get(i).toLowerCase());
                }

                SearchData.put(parameter, inputs);
            }
        }

        if (SearchData.size() > 0) {
            SearchAlgorithm.SearchMovies(this.Movies, SearchData);
        } else {
            System.out.println("No parameters entered!");
        }

        Menu();
    }

    private void Select5Random() {

    }

    public void Menu() {
        System.out.println("\n=====Netflix Object Oriented Search (OOS)=====");
        System.out.println("Please select an option:");
        System.out.println("1) List all search parameters");
        System.out.println("2) Search movie");
        System.out.println("3) Select 5 Random Movies");
        System.out.println("4) Close");

        Scanner scanner = new Scanner(System.in);

        try {
            int Value = scanner.nextInt();

            if (Value >= 1 && Value <= 4) {
                switch (Value) {
                    case 1:
                        DisplayParams();
                        Menu();
                        break;
                    case 2:
                        Search();
                        Menu();
                        break;
                    case 3:
                        Select5Random();
                    case 4:
                        System.out.println("\nThank you!");
                        System.exit(0);
                        break;
                    default:
                        Menu();
                        break;
                }
            } else {
                System.out.println("\nInvalid input! Please enter a valid number between 1 and 3!\n");
                Menu();
            }
        } catch (InputMismatchException e) {
            System.out.println("\nInvalid input! Please enter a valid number between 1 and 3!\n");
            Menu();
        }

    }
}
