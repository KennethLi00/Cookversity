package com.example.cookversity.RecipeLongEntities;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metric implements Serializable
{

    @SerializedName("amount")
    @Expose
    private double amount;
    @SerializedName("unitShort")
    @Expose
    private String unitShort;
    @SerializedName("unitLong")
    @Expose
    private String unitLong;
    private final static long serialVersionUID = 8340289469293558624L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Metric() {
    }

    /**
     *
     * @param amount
     * @param unitShort
     * @param unitLong
     */
    public Metric(double amount, String unitShort, String unitLong) {
        super();
        this.amount = amount;
        this.unitShort = unitShort;
        this.unitLong = unitLong;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Metric withAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public String getUnitShort() {
        return unitShort;
    }

    public void setUnitShort(String unitShort) {
        this.unitShort = unitShort;
    }

    public Metric withUnitShort(String unitShort) {
        this.unitShort = unitShort;
        return this;
    }

    public String getUnitLong() {
        return unitLong;
    }

    public void setUnitLong(String unitLong) {
        this.unitLong = unitLong;
    }

    public Metric withUnitLong(String unitLong) {
        this.unitLong = unitLong;
        return this;
    }

}