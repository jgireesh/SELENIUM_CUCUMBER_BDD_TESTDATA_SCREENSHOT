package com.cucumber.utils;

import java.util.HashMap;
import java.util.Map;

public class TestDataStore {

    private static final TestDataStore instance = new TestDataStore();
    private static final HashMap<String, String> stringValues = new HashMap<>();
    private static final HashMap<String, HashMap<String,String>> mapValues = new HashMap<>();

    public static TestDataStore getInstance(){
        return instance;
    }

    public void setStringValue(String key, String value){
        stringValues.put(key,value);
    }

    public String getStringValue(String key){
        return stringValues.get(key);
    }

    public Map<String,String> getMapValues(String key){
        return mapValues.get(key);
    }

    public void setMapValues(String key, HashMap<String,String> value){
        mapValues.put(key,value);
    }

}
