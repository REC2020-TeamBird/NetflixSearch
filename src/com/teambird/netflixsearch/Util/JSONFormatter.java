package com.teambird.netflixsearch.Util;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.json.JSONObject;

import java.util.*;

public class JSONFormatter {
    // Remove quotes out of json: https://stackoverflow.com/questions/2608665/how-can-i-trim-beginning-and-ending-double-quotes-from-a-string
    // Replacing double quotes: https://stackoverflow.com/questions/32240675/javascript-regex-to-replace-a-whole-word

    private static List<String> getFormattedList(String str) {
        str = str.replaceAll("^\"|\"$", "")
                .replaceAll("^\"|\"$", "")
                .replaceAll("\"\"", "\"")
                .replace("[", "")
                .replace("]", "")
                .replaceAll("},", "}},");

        return Arrays.asList(str.split("},"));
    }

    public static List<String> JSONToList(String data, String attribute) {
        List<String> Data = new ArrayList<>();

        if (!Objects.isNull(data) && data.length() > 0) {
            getFormattedList(data).forEach(Value -> {
                JSONObject jsonObject = new JSONObject(Value);

                if (jsonObject.has(attribute)) {
                    Data.add(jsonObject.getString(attribute));
                }
            });
        }

        return Data;
    }

    public static List<Map<String, String>> JSONToList(String data, List<String> attributes) {
        List<Map<String, String>> Data = new ArrayList<>();

        if (!Objects.isNull(data) && data.length() > 0) {
            getFormattedList(data).forEach(Value -> {
                JSONObject jsonObject = new JSONObject(Value);
                Map<String, String> MatchedData = null;

                for (String attribute : attributes) {
                    if (jsonObject.has(attribute)) {
                        if (MatchedData == null) {
                            MatchedData = new HashMap<>();
                        }
                        MatchedData.put(attribute, jsonObject.getString(attribute));
                    }
                }

                Data.add(MatchedData);
            });
        }

        return Data;
    }
}
