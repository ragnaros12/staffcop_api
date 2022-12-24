package org.example.other;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Mapper {
    private final Map<String, String> mappingData;

    public Mapper(Map<String, String> mappingData) {
        this.mappingData = mappingData;
    }


    public String getValue(String category, String name){
        return mappingData.get(category + "-" + name);
    }

    public String getByKey(String category){
        return mappingData.keySet().stream().filter(u -> u.startsWith(category)).map(u -> u.substring(category.length() + 1)).collect(Collectors.joining(", "));
    }
}
