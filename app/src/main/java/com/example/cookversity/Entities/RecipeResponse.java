package com.example.cookversity.Entities;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.ToStringBuilder;

public class RecipeResponse implements Serializable
{

    @SerializedName("recipes")
    @Expose
    private List<Recipe> recipes = null;
    private final static long serialVersionUID = 1488276249222883315L;

    /**
     * No args constructor for use in serialization
     *
     */
    public RecipeResponse() {
    }

    /**
     *
     * @param recipes
     */
    public RecipeResponse(List<Recipe> recipes) {
        super();
        this.recipes = recipes;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public RecipeResponse withRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
        return this;
    }

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("recipes", recipes).toString();
//    }

}