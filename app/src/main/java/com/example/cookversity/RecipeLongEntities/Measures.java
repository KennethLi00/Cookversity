package com.example.cookversity.RecipeLongEntities;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Measures implements Serializable
{

    @SerializedName("us")
    @Expose
    private Us us;
    @SerializedName("metric")
    @Expose
    private Metric metric;
    private final static long serialVersionUID = 8703081874010592319L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Measures() {
    }

    /**
     *
     * @param metric
     * @param us
     */
    public Measures(Us us, Metric metric) {
        super();
        this.us = us;
        this.metric = metric;
    }

    public Us getUs() {
        return us;
    }

    public void setUs(Us us) {
        this.us = us;
    }

    public Measures withUs(Us us) {
        this.us = us;
        return this;
    }

    public Metric getMetric() {
        return metric;
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    public Measures withMetric(Metric metric) {
        this.metric = metric;
        return this;
    }

}