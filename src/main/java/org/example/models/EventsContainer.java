package org.example.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EventsContainer {

    @SerializedName("object_list")
    private List<Event> events;

    public List<Event> getEvents() {
        return events;
    }
}
