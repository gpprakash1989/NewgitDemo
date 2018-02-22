package com.Tecksystem.country.Utility;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class TestUtility {


	private static String getLargestCityAndCapital(String searchState, String responseBody) {
        JsonObject resultData = getJsonObjectFromJsonLevelOne("RestResponse", responseBody);
        JsonArray jArray = getJsonArrayFromJsonElement("result", resultData);
        for(int i = 0; i < jArray.size(); i++) {
            JsonObject jobj1 = jArray.get(i).getAsJsonObject();
            String StateName = jobj1.get("name").getAsString();
            String StateAbbr = jobj1.get("abbr").getAsString();
            if(searchState.equalsIgnoreCase(StateName) || searchState.equalsIgnoreCase(StateAbbr)) {
                String largestCity = jobj1.get("largest_city").getAsString();
                String capital = jobj1.get("capital").getAsString();
                return("Largest City is : " + largestCity + " and Capital is : " + capital);
            }
        }
        return ("No such city found.");
    }

    private static JsonObject getJsonObjectFromJsonLevelOne(String jsonElementIdentity, String jsonString) {
        JsonObject jobj = new Gson().fromJson(jsonString, JsonObject.class);
        return (jobj.get(jsonElementIdentity).getAsJsonObject());
    }

    public static JsonArray getJsonArrayFromJsonElement(String jsonElement, JsonObject jsonObject) {
        JsonArray properties = jsonObject.getAsJsonArray(jsonElement);
        return properties;
    }
}


