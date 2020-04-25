package com.example.cookversity.Entities;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RecipeShort implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("readyInMinutes")
    @Expose
    private Integer readyInMinutes;
    @SerializedName("servings")
    @Expose
    private Integer servings;
    @SerializedName("sourceUrl")
    @Expose
    private String sourceUrl;
    @SerializedName("openLicense")
    @Expose
    private Integer openLicense;
    @SerializedName("image")
    @Expose
    private String image;
    private final static long serialVersionUID = 6079923461037565225L;

    /**
     * No args constructor for use in serialization
     *
     */
    public RecipeShort() {
    }

    /**
     *
     * @param readyInMinutes
     * @param sourceUrl
     * @param image
     * @param servings
     * @param openLicense
     * @param id
     * @param title
     */
    public RecipeShort(Integer id, String title, Integer readyInMinutes, Integer servings, String sourceUrl, Integer openLicense, String image) {
        super();
        this.id = id;
        this.title = title;
        this.readyInMinutes = readyInMinutes;
        this.servings = servings;
        this.sourceUrl = sourceUrl;
        this.openLicense = openLicense;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RecipeShort withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RecipeShort withTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(Integer readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public RecipeShort withReadyInMinutes(Integer readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
        return this;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public RecipeShort withServings(Integer servings) {
        this.servings = servings;
        return this;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public RecipeShort withSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
        return this;
    }

    public Integer getOpenLicense() {
        return openLicense;
    }

    public void setOpenLicense(Integer openLicense) {
        this.openLicense = openLicense;
    }

    public RecipeShort withOpenLicense(Integer openLicense) {
        this.openLicense = openLicense;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public RecipeShort withImage(String image) {
        this.image = image;
        return this;
    }


}