package com.example.cookversity.RecipeLongEntities;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExtendedIngredient implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("aisle")
    @Expose
    private String aisle;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("consistency")
    @Expose
    private String consistency;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("original")
    @Expose
    private String original;
    @SerializedName("originalString")
    @Expose
    private String originalString;
    @SerializedName("originalName")
    @Expose
    private String originalName;
    @SerializedName("amount")
    @Expose
    private double amount;
    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("meta")
    @Expose
    private List<String> meta = null;
    @SerializedName("metaInformation")
    @Expose
    private List<String> metaInformation = null;
    @SerializedName("measures")
    @Expose
    private Measures measures;
    private final static long serialVersionUID = -3878282971165780736L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ExtendedIngredient() {
    }

    /**
     *
     * @param image
     * @param amount
     * @param original
     * @param aisle
     * @param consistency
     * @param originalName
     * @param unit
     * @param measures
     * @param meta
     * @param name
     * @param originalString
     * @param id
     * @param metaInformation
     */
    public ExtendedIngredient(Integer id, String aisle, String image, String consistency, String name, String original, String originalString, String originalName, double amount, String unit, List<String> meta, List<String> metaInformation, Measures measures) {
        super();
        this.id = id;
        this.aisle = aisle;
        this.image = image;
        this.consistency = consistency;
        this.name = name;
        this.original = original;
        this.originalString = originalString;
        this.originalName = originalName;
        this.amount = amount;
        this.unit = unit;
        this.meta = meta;
        this.metaInformation = metaInformation;
        this.measures = measures;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ExtendedIngredient withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public ExtendedIngredient withAisle(String aisle) {
        this.aisle = aisle;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ExtendedIngredient withImage(String image) {
        this.image = image;
        return this;
    }

    public String getConsistency() {
        return consistency;
    }

    public void setConsistency(String consistency) {
        this.consistency = consistency;
    }

    public ExtendedIngredient withConsistency(String consistency) {
        this.consistency = consistency;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExtendedIngredient withName(String name) {
        this.name = name;
        return this;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public ExtendedIngredient withOriginal(String original) {
        this.original = original;
        return this;
    }

    public String getOriginalString() {
        return originalString;
    }

    public void setOriginalString(String originalString) {
        this.originalString = originalString;
    }

    public ExtendedIngredient withOriginalString(String originalString) {
        this.originalString = originalString;
        return this;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public ExtendedIngredient withOriginalName(String originalName) {
        this.originalName = originalName;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ExtendedIngredient withAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public ExtendedIngredient withUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public List<String> getMeta() {
        return meta;
    }

    public void setMeta(List<String> meta) {
        this.meta = meta;
    }

    public ExtendedIngredient withMeta(List<String> meta) {
        this.meta = meta;
        return this;
    }

    public List<String> getMetaInformation() {
        return metaInformation;
    }

    public void setMetaInformation(List<String> metaInformation) {
        this.metaInformation = metaInformation;
    }

    public ExtendedIngredient withMetaInformation(List<String> metaInformation) {
        this.metaInformation = metaInformation;
        return this;
    }

    public Measures getMeasures() {
        return measures;
    }

    public void setMeasures(Measures measures) {
        this.measures = measures;
    }

    public ExtendedIngredient withMeasures(Measures measures) {
        this.measures = measures;
        return this;
    }

}