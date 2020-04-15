package com.example.cookversity.Entities;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.ToStringBuilder;

public class Us implements Serializable
{

    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("unitShort")
    @Expose
    private String unitShort;
    @SerializedName("unitLong")
    @Expose
    private String unitLong;
    private final static long serialVersionUID = 216339383887183742L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Us() {
    }

    /**
     *
     * @param amount
     * @param unitShort
     * @param unitLong
     */
    public Us(Double amount, String unitShort, String unitLong) {
        super();
        this.amount = amount;
        this.unitShort = unitShort;
        this.unitLong = unitLong;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Us withAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public String getUnitShort() {
        return unitShort;
    }

    public void setUnitShort(String unitShort) {
        this.unitShort = unitShort;
    }

    public Us withUnitShort(String unitShort) {
        this.unitShort = unitShort;
        return this;
    }

    public String getUnitLong() {
        return unitLong;
    }

    public void setUnitLong(String unitLong) {
        this.unitLong = unitLong;
    }

    public Us withUnitLong(String unitLong) {
        this.unitLong = unitLong;
        return this;
    }

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("amount", amount).append("unitShort", unitShort).append("unitLong", unitLong).toString();
//    }

}
