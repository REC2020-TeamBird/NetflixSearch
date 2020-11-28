package com.teambird.netflixsearch.Objects;
import com.teambird.netflixsearch.Util.JSONFormatter;
import org.json.JSONException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://stackoverflow.com/questions/6109882/regex-match-all-characters-between-two-strings
//https://stackoverflow.com/questions/600733/using-java-to-find-substring-of-a-bigger-string-using-regular-expression
//https://stackoverflow.com/questions/928072/whats-the-regular-expression-that-matches-a-square-bracket

public class Credits {
    int Movie_id;
    String Movie_Title;
    List<Actor> Actors;

    public Credits (String CreditData) {
        List<String> Data = Arrays.asList(CreditData.split(","));

        this.Movie_id = Integer.parseInt(Data.get(0));
        this.Movie_Title = Data.get(1);
        this.Actors = new ArrayList<>();

        Pattern matchPattern = Pattern.compile("\\[[^]]*]");
        Matcher matcher = matchPattern.matcher(CreditData);

        if (matcher.find()) {
            // https://stackoverflow.com/questions/1005073/initialization-of-an-arraylist-in-one-line
            try {
                List<Map<String, String>> ActorData = JSONFormatter.JSONToList(matcher.group(), Arrays.asList("character", "name"));
                ActorData.forEach(actor -> Actors.add(new Actor(actor.get("character"), actor.get("name"))));
            } catch (JSONException ignore) {}
        }
    }
}