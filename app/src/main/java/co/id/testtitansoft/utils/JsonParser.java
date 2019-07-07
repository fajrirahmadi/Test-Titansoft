package co.id.testtitansoft.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by Dell on 2/27/2018.
 */

public class JsonParser {

    private Gson gson;

    public JsonParser(Gson gson) {
        this.gson = gson;
    }

    public <T> T getObject(Object object, Class<T> classOfT) {
        try {
            JsonObject jsonObject = gson.toJsonTree(object).getAsJsonObject();
            return gson.fromJson(jsonObject.toString(), classOfT);
        } catch (IllegalStateException e) {
            return null;
        }
    }

    public <T> T getObjects(Object object, Type type) {
        JsonArray jsonArray = gson.toJsonTree(object).getAsJsonArray();
        return gson.fromJson(jsonArray, type);
    }

    public <T> T getObject(String value, Class<T> classOfT) {
        return gson.fromJson(value, classOfT);
    }

    public String getObjectToString(Object object) {
        return gson.toJson(object);
    }

    private JsonObject convertMapToJsonObject(Map<String, String> data) {
        JsonObject jsonObject = new JsonObject();
        for (String key : data.keySet())
            jsonObject.addProperty(key, data.get(key));
        return jsonObject;
    }

    public <T> T getObject(Map<String, String> data, Class<T> classOfT) {
        JsonObject jsonObject = convertMapToJsonObject(data);
        return gson.fromJson(jsonObject.toString(), classOfT);
    }

    public String getObjectToJson(Object object) {
        JsonObject jsonObject = gson.toJsonTree(object).getAsJsonObject();
        return jsonObject.toString();
    }
}