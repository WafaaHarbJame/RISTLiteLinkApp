package com.ristlitelink.ristlitelink.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ErrorModel {

    @SerializedName("status")
    @Expose
    public int status;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("details")
    @Expose
    public String[] details = null;

    @SerializedName("title")
    @Expose
    public String title = null;


    @SerializedName("errors")
    @Expose
    public String errors = null;




}
