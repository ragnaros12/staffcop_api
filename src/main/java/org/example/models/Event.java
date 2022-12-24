package org.example.models;

import com.google.gson.annotations.SerializedName;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

public class Event {
    @SerializedName("text_data")
    private String text;

    @SerializedName("time_registered")
    private String time;

    @SerializedName("agent_eventtype.name")
    private String name;

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "тип события: " + getName() + ", время исполнения: " + getTime() + ", текст: " + Jsoup.clean(getText(), new Safelist());
    }
}
