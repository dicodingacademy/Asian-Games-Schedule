
package com.dicoding.asiangamesschedule.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Arena {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
