package com.example.cookversity.RecipeLongEntities;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnalyzedInstruction implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("steps")
    @Expose
    private List<Step> steps = null;
    private final static long serialVersionUID = -8770740933083323770L;

    /**
     * No args constructor for use in serialization
     *
     */
    public AnalyzedInstruction() {
    }

    /**
     *
     * @param name
     * @param steps
     */
    public AnalyzedInstruction(String name, List<Step> steps) {
        super();
        this.name = name;
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnalyzedInstruction withName(String name) {
        this.name = name;
        return this;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public AnalyzedInstruction withSteps(List<Step> steps) {
        this.steps = steps;
        return this;
    }

}