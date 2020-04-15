package com.example.cookversity.Entities;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.ToStringBuilder;

public class Recipe implements Serializable
{

    @SerializedName("vegetarian")
    @Expose
    private Boolean vegetarian;
    @SerializedName("vegan")
    @Expose
    private Boolean vegan;
    @SerializedName("glutenFree")
    @Expose
    private Boolean glutenFree;
    @SerializedName("dairyFree")
    @Expose
    private Boolean dairyFree;
    @SerializedName("veryHealthy")
    @Expose
    private Boolean veryHealthy;
    @SerializedName("cheap")
    @Expose
    private Boolean cheap;
    @SerializedName("veryPopular")
    @Expose
    private Boolean veryPopular;
    @SerializedName("sustainable")
    @Expose
    private Boolean sustainable;
    @SerializedName("weightWatcherSmartPoints")
    @Expose
    private Integer weightWatcherSmartPoints;
    @SerializedName("gaps")
    @Expose
    private String gaps;
    @SerializedName("lowFodmap")
    @Expose
    private Boolean lowFodmap;
    @SerializedName("sourceUrl")
    @Expose
    private String sourceUrl;
    @SerializedName("spoonacularSourceUrl")
    @Expose
    private String spoonacularSourceUrl;
    @SerializedName("aggregateLikes")
    @Expose
    private Integer aggregateLikes;
    @SerializedName("spoonacularScore")
    @Expose
    private Integer spoonacularScore;
    @SerializedName("healthScore")
    @Expose
    private Integer healthScore;
    @SerializedName("creditsText")
    @Expose
    private String creditsText;
    @SerializedName("license")
    @Expose
    private String license;
    @SerializedName("sourceName")
    @Expose
    private String sourceName;
    @SerializedName("pricePerServing")
    @Expose
    private Double pricePerServing;
    @SerializedName("extendedIngredients")
    @Expose
    private List<ExtendedIngredient> extendedIngredients = null;
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
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("imageType")
    @Expose
    private String imageType;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("cuisines")
    @Expose
    private List<Object> cuisines = null;
    @SerializedName("dishTypes")
    @Expose
    private List<String> dishTypes = null;
    @SerializedName("diets")
    @Expose
    private List<String> diets = null;
    @SerializedName("occasions")
    @Expose
    private List<Object> occasions = null;
    @SerializedName("winePairing")
    @Expose
    private WinePairing winePairing;
    @SerializedName("instructions")
    @Expose
    private String instructions;
    @SerializedName("analyzedInstructions")
    @Expose
    private List<Object> analyzedInstructions = null;
    @SerializedName("originalId")
    @Expose
    private Object originalId;
    private final static long serialVersionUID = 10914380896603969L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Recipe() {
    }

    /**
     *
     * @param instructions
     * @param sustainable
     * @param analyzedInstructions
     * @param glutenFree
     * @param veryPopular
     * @param healthScore
     * @param title
     * @param diets
     * @param aggregateLikes
     * @param sourceUrl
     * @param creditsText
     * @param readyInMinutes
     * @param dairyFree
     * @param servings
     * @param vegetarian
     * @param id
     * @param imageType
     * @param winePairing
     * @param summary
     * @param image
     * @param veryHealthy
     * @param vegan
     * @param cheap
     * @param extendedIngredients
     * @param dishTypes
     * @param gaps
     * @param cuisines
     * @param lowFodmap
     * @param license
     * @param weightWatcherSmartPoints
     * @param occasions
     * @param spoonacularScore
     * @param pricePerServing
     * @param spoonacularSourceUrl
     * @param sourceName
     * @param originalId
     */
    public Recipe(Boolean vegetarian, Boolean vegan, Boolean glutenFree, Boolean dairyFree, Boolean veryHealthy, Boolean cheap, Boolean veryPopular, Boolean sustainable, Integer weightWatcherSmartPoints, String gaps, Boolean lowFodmap, String sourceUrl, String spoonacularSourceUrl, Integer aggregateLikes, Integer spoonacularScore, Integer healthScore, String creditsText, String license, String sourceName, Double pricePerServing, List<ExtendedIngredient> extendedIngredients, Integer id, String title, Integer readyInMinutes, Integer servings, String image, String imageType, String summary, List<Object> cuisines, List<String> dishTypes, List<String> diets, List<Object> occasions, WinePairing winePairing, String instructions, List<Object> analyzedInstructions, Object originalId) {
        super();
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.glutenFree = glutenFree;
        this.dairyFree = dairyFree;
        this.veryHealthy = veryHealthy;
        this.cheap = cheap;
        this.veryPopular = veryPopular;
        this.sustainable = sustainable;
        this.weightWatcherSmartPoints = weightWatcherSmartPoints;
        this.gaps = gaps;
        this.lowFodmap = lowFodmap;
        this.sourceUrl = sourceUrl;
        this.spoonacularSourceUrl = spoonacularSourceUrl;
        this.aggregateLikes = aggregateLikes;
        this.spoonacularScore = spoonacularScore;
        this.healthScore = healthScore;
        this.creditsText = creditsText;
        this.license = license;
        this.sourceName = sourceName;
        this.pricePerServing = pricePerServing;
        this.extendedIngredients = extendedIngredients;
        this.id = id;
        this.title = title;
        this.readyInMinutes = readyInMinutes;
        this.servings = servings;
        this.image = image;
        this.imageType = imageType;
        this.summary = summary;
        this.cuisines = cuisines;
        this.dishTypes = dishTypes;
        this.diets = diets;
        this.occasions = occasions;
        this.winePairing = winePairing;
        this.instructions = instructions;
        this.analyzedInstructions = analyzedInstructions;
        this.originalId = originalId;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Recipe withVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
        return this;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    public Recipe withVegan(Boolean vegan) {
        this.vegan = vegan;
        return this;
    }

    public Boolean getGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(Boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public Recipe withGlutenFree(Boolean glutenFree) {
        this.glutenFree = glutenFree;
        return this;
    }

    public Boolean getDairyFree() {
        return dairyFree;
    }

    public void setDairyFree(Boolean dairyFree) {
        this.dairyFree = dairyFree;
    }

    public Recipe withDairyFree(Boolean dairyFree) {
        this.dairyFree = dairyFree;
        return this;
    }

    public Boolean getVeryHealthy() {
        return veryHealthy;
    }

    public void setVeryHealthy(Boolean veryHealthy) {
        this.veryHealthy = veryHealthy;
    }

    public Recipe withVeryHealthy(Boolean veryHealthy) {
        this.veryHealthy = veryHealthy;
        return this;
    }

    public Boolean getCheap() {
        return cheap;
    }

    public void setCheap(Boolean cheap) {
        this.cheap = cheap;
    }

    public Recipe withCheap(Boolean cheap) {
        this.cheap = cheap;
        return this;
    }

    public Boolean getVeryPopular() {
        return veryPopular;
    }

    public void setVeryPopular(Boolean veryPopular) {
        this.veryPopular = veryPopular;
    }

    public Recipe withVeryPopular(Boolean veryPopular) {
        this.veryPopular = veryPopular;
        return this;
    }

    public Boolean getSustainable() {
        return sustainable;
    }

    public void setSustainable(Boolean sustainable) {
        this.sustainable = sustainable;
    }

    public Recipe withSustainable(Boolean sustainable) {
        this.sustainable = sustainable;
        return this;
    }

    public Integer getWeightWatcherSmartPoints() {
        return weightWatcherSmartPoints;
    }

    public void setWeightWatcherSmartPoints(Integer weightWatcherSmartPoints) {
        this.weightWatcherSmartPoints = weightWatcherSmartPoints;
    }

    public Recipe withWeightWatcherSmartPoints(Integer weightWatcherSmartPoints) {
        this.weightWatcherSmartPoints = weightWatcherSmartPoints;
        return this;
    }

    public String getGaps() {
        return gaps;
    }

    public void setGaps(String gaps) {
        this.gaps = gaps;
    }

    public Recipe withGaps(String gaps) {
        this.gaps = gaps;
        return this;
    }

    public Boolean getLowFodmap() {
        return lowFodmap;
    }

    public void setLowFodmap(Boolean lowFodmap) {
        this.lowFodmap = lowFodmap;
    }

    public Recipe withLowFodmap(Boolean lowFodmap) {
        this.lowFodmap = lowFodmap;
        return this;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public Recipe withSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
        return this;
    }

    public String getSpoonacularSourceUrl() {
        return spoonacularSourceUrl;
    }

    public void setSpoonacularSourceUrl(String spoonacularSourceUrl) {
        this.spoonacularSourceUrl = spoonacularSourceUrl;
    }

    public Recipe withSpoonacularSourceUrl(String spoonacularSourceUrl) {
        this.spoonacularSourceUrl = spoonacularSourceUrl;
        return this;
    }

    public Integer getAggregateLikes() {
        return aggregateLikes;
    }

    public void setAggregateLikes(Integer aggregateLikes) {
        this.aggregateLikes = aggregateLikes;
    }

    public Recipe withAggregateLikes(Integer aggregateLikes) {
        this.aggregateLikes = aggregateLikes;
        return this;
    }

    public Integer getSpoonacularScore() {
        return spoonacularScore;
    }

    public void setSpoonacularScore(Integer spoonacularScore) {
        this.spoonacularScore = spoonacularScore;
    }

    public Recipe withSpoonacularScore(Integer spoonacularScore) {
        this.spoonacularScore = spoonacularScore;
        return this;
    }

    public Integer getHealthScore() {
        return healthScore;
    }

    public void setHealthScore(Integer healthScore) {
        this.healthScore = healthScore;
    }

    public Recipe withHealthScore(Integer healthScore) {
        this.healthScore = healthScore;
        return this;
    }

    public String getCreditsText() {
        return creditsText;
    }

    public void setCreditsText(String creditsText) {
        this.creditsText = creditsText;
    }

    public Recipe withCreditsText(String creditsText) {
        this.creditsText = creditsText;
        return this;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Recipe withLicense(String license) {
        this.license = license;
        return this;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Recipe withSourceName(String sourceName) {
        this.sourceName = sourceName;
        return this;
    }

    public Double getPricePerServing() {
        return pricePerServing;
    }

    public void setPricePerServing(Double pricePerServing) {
        this.pricePerServing = pricePerServing;
    }

    public Recipe withPricePerServing(Double pricePerServing) {
        this.pricePerServing = pricePerServing;
        return this;
    }

    public List<ExtendedIngredient> getExtendedIngredients() {
        return extendedIngredients;
    }

    public void setExtendedIngredients(List<ExtendedIngredient> extendedIngredients) {
        this.extendedIngredients = extendedIngredients;
    }

    public Recipe withExtendedIngredients(List<ExtendedIngredient> extendedIngredients) {
        this.extendedIngredients = extendedIngredients;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Recipe withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Recipe withTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(Integer readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public Recipe withReadyInMinutes(Integer readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
        return this;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public Recipe withServings(Integer servings) {
        this.servings = servings;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Recipe withImage(String image) {
        this.image = image;
        return this;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public Recipe withImageType(String imageType) {
        this.imageType = imageType;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Recipe withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public List<Object> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<Object> cuisines) {
        this.cuisines = cuisines;
    }

    public Recipe withCuisines(List<Object> cuisines) {
        this.cuisines = cuisines;
        return this;
    }

    public List<String> getDishTypes() {
        return dishTypes;
    }

    public void setDishTypes(List<String> dishTypes) {
        this.dishTypes = dishTypes;
    }

    public Recipe withDishTypes(List<String> dishTypes) {
        this.dishTypes = dishTypes;
        return this;
    }

    public List<String> getDiets() {
        return diets;
    }

    public void setDiets(List<String> diets) {
        this.diets = diets;
    }

    public Recipe withDiets(List<String> diets) {
        this.diets = diets;
        return this;
    }

    public List<Object> getOccasions() {
        return occasions;
    }

    public void setOccasions(List<Object> occasions) {
        this.occasions = occasions;
    }

    public Recipe withOccasions(List<Object> occasions) {
        this.occasions = occasions;
        return this;
    }

    public WinePairing getWinePairing() {
        return winePairing;
    }

    public void setWinePairing(WinePairing winePairing) {
        this.winePairing = winePairing;
    }

    public Recipe withWinePairing(WinePairing winePairing) {
        this.winePairing = winePairing;
        return this;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Recipe withInstructions(String instructions) {
        this.instructions = instructions;
        return this;
    }

    public List<Object> getAnalyzedInstructions() {
        return analyzedInstructions;
    }

    public void setAnalyzedInstructions(List<Object> analyzedInstructions) {
        this.analyzedInstructions = analyzedInstructions;
    }

    public Recipe withAnalyzedInstructions(List<Object> analyzedInstructions) {
        this.analyzedInstructions = analyzedInstructions;
        return this;
    }

    public Object getOriginalId() {
        return originalId;
    }

    public void setOriginalId(Object originalId) {
        this.originalId = originalId;
    }

    public Recipe withOriginalId(Object originalId) {
        this.originalId = originalId;
        return this;
    }

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("vegetarian", vegetarian).append("vegan", vegan).append("glutenFree", glutenFree).append("dairyFree", dairyFree).append("veryHealthy", veryHealthy).append("cheap", cheap).append("veryPopular", veryPopular).append("sustainable", sustainable).append("weightWatcherSmartPoints", weightWatcherSmartPoints).append("gaps", gaps).append("lowFodmap", lowFodmap).append("sourceUrl", sourceUrl).append("spoonacularSourceUrl", spoonacularSourceUrl).append("aggregateLikes", aggregateLikes).append("spoonacularScore", spoonacularScore).append("healthScore", healthScore).append("creditsText", creditsText).append("license", license).append("sourceName", sourceName).append("pricePerServing", pricePerServing).append("extendedIngredients", extendedIngredients).append("id", id).append("title", title).append("readyInMinutes", readyInMinutes).append("servings", servings).append("image", image).append("imageType", imageType).append("summary", summary).append("cuisines", cuisines).append("dishTypes", dishTypes).append("diets", diets).append("occasions", occasions).append("winePairing", winePairing).append("instructions", instructions).append("analyzedInstructions", analyzedInstructions).append("originalId", originalId).toString();
//    }

}