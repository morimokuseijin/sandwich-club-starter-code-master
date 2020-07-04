package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String NAME = "name";
    private static final String MAIN_NAME = "mainName";
    private static final String ALSO_KNOWN_AS = "alsoKnownAs";
    private static final String PLACE_OF_ORIGIN ="placeOfOrigin";
    private static final String DESCRIPTION ="description";
    private static final String IMAGE ="image";
    private static final String INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json) {
Sandwich sandwich = new Sandwich();
try {
    JSONObject mJSONObject =new JSONObject(json);
    JSONObject mNameObject = mJSONObject.getJSONObject(NAME);
    sandwich.setMainName(mNameObject.getString(MAIN_NAME));
    JSONArray getAlsoKnownAs = mNameObject.getJSONArray(ALSO_KNOWN_AS);
    List<String> alsoKnownAs = new ArrayList<>();
    for(int i=0 ; i< getAlsoKnownAs.length() ; i++){
        alsoKnownAs.add(getAlsoKnownAs.getString(i));
    }
sandwich.setAlsoKnownAs(alsoKnownAs);
    sandwich.setPlaceOfOrigin(mJSONObject.getString(PLACE_OF_ORIGIN));
    sandwich.setDescription(DESCRIPTION);
    sandwich.setImage(IMAGE);
    JSONArray getIngredients = mNameObject.getJSONArray(INGREDIENTS);
    List<String> ingredients = new ArrayList<>();
    for (int a = 0;a<getIngredients.length();a++){
        ingredients.add(getIngredients.getString(a));
    }
    sandwich.setIngredients(ingredients);

} catch (JSONException e) {
    e.printStackTrace();
}
        return sandwich;
    }
}
