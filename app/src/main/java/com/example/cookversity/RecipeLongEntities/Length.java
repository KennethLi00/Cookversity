package com.example.cookversity.RecipeLongEntities;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Length implements Serializable
{

    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("unit")
    @Expose
    private String unit;
    private final static long serialVersionUID = 6201565404296302108L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Length() {
    }

    /**
     *
     * @param number
     * @param unit
     */
    public Length(Integer number, String unit) {
        super();
        this.number = number;
        this.unit = unit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Length withNumber(Integer number) {
        this.number = number;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Length withUnit(String unit) {
        this.unit = unit;
        return this;
    }

}