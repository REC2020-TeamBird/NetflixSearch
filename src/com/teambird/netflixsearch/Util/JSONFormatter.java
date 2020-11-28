package com.teambird.netflixsearch.Util;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class JSONFormatter {
    // Remove quotes out of json: https://stackoverflow.com/questions/2608665/how-can-i-trim-beginning-and-ending-double-quotes-from-a-string
    // Replacing double quotes: https://stackoverflow.com/questions/32240675/javascript-regex-to-replace-a-whole-word
    public static List<String> JSONToList(String data, String attribute) {
        List<String> Data = new ArrayList<>();
        String JSONString = data;

        if (!Objects.isNull(JSONString) && JSONString.length() > 0) {
            JSONString = JSONString.replaceAll("^\"|\"$", "")
                    .replaceAll("^\"|\"$", "")
                    .replaceAll("\"\"", "\"")
                    .replace("[", "")
                    .replace("]", "")
                    .replaceAll("},", "}},");
            List<String> JSONValues = Arrays.asList(JSONString.split("},"));
            JSONValues.forEach(Value -> {
                JSONObject jsonObject = new JSONObject(Value);
                if (jsonObject.has(attribute)) {
                    Data.add(jsonObject.getString(attribute));
                }
            });
        }

        return Data;
    }
}
