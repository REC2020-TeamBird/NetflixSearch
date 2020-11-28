package com.teambird.netflixsearch.Objects;
import java.util.ArrayList;
public class Credits {
    int Movie_id;
    String Movie_title;
    String title;

/*cast
    cast_id, character, credit_id, gender, id, name, order */

/*crew
    credit_it, department, gender, id, job, name,
 */

    public Credits (int Movie_id, String Movie_title, String cast, String crew){
        this.Movie_id= Movie_id;
        this.title= Movie_title;

    }
    private int movie(int Movie_id){
    return 0;
    }
    private String title(String title){
    return "";
    }
    private String cast(int cast_id, String character, int credit_id, int gender, int id, String name, int order) {
        return "";
    }
    private String crew(String credit_id, String department, int gender, int id, String job, String name){
        return "";
    }
}