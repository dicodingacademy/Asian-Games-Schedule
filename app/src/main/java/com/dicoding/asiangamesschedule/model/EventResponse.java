
package com.dicoding.asiangamesschedule.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventResponse {

    @SerializedName("arenas")
    @Expose
    private List<Arena> arenas = null;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("imageUrl")
    @Expose
    private Object imageUrl;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("subEvents")
    @Expose
    private List<SubEvent> subEvents = null;

    public List<Arena> getArenas() {
        return arenas;
    }

    public String getDescription() {
        return description;
    }

    public String getEndTime() {
        return endTime;
    }

    public int getId() {
        return id;
    }

    public Object getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getStartTime() {
        return startTime;
    }

    public List<SubEvent> getSubEvents() {
        return subEvents;
    }

}
