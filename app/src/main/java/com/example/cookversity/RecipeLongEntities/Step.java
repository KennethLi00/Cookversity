package com.example.cookversity.RecipeLongEntities;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Step implements Serializable
{

    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("step")
    @Expose
    private String step;
    @SerializedName("ingredients")
    @Expose
    private List<Ingredient> ingredients = null;
    @SerializedName("equipment")
    @Expose
    private List<Equipment> equipment = null;
    @SerializedName("length")
    @Expose
    private Length length;
    private final static long serialVersionUID = 8004622020557514401L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Step() {
    }

    /**
     *
     * @param number
     * @param length
     * @param ingredients
     * @param equipment
     * @param step
     */
    public Step(Integer number, String step, List<Ingredient> ingredients, List<Equipment> equipment, Length length) {
        super();
        this.number = number;
        this.step = step;
        this.ingredients = ingredients;
        this.equipment = equipment;
        this.length = length;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Step withNumber(Integer number) {
        this.number = number;
        return this;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public Step withStep(String step) {
        this.step = step;
        return this;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Step withIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public Step withEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
        return this;
    }

    public Length getLength() {
        return length;
    }

    public void setLength(Length length) {
        this.length = length;
    }

    public Step withLength(Length length) {
        this.length = length;
        return this;
    }

}