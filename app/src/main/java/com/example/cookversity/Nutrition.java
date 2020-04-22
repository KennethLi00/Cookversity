package com.example.cookversity;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Nutrition {
    private String title;
    private String url;
    private int logo;
    private int id;

    public Nutrition(int id, String title, String url, int logo) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.logo = logo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public static List<Nutrition> getNutritionWebsList() {
        List<Nutrition> list = new ArrayList<>();
        list.add(new Nutrition(1, "Food Essentials", "https://www.eatforhealth.gov.au/food-essentials", R.drawable.ausgov));
        list.add(new Nutrition(2, "Australian Guide to Healthy Eating", "https://www.eatforhealth.gov.au/guidelines/australian-guide-healthy-eating", R.drawable.ausgov));
        list.add(new Nutrition(3, "Healthy Eating Pyramid", "https://www.nutritionaustralia.org/national/resource/healthy-eating-pyramid", R.drawable.nutritionaus));
        list.add(new Nutrition(4, "Breakfast", "https://www.nutritionaustralia.org/national/resource/breakfast", R.drawable.nutritionaus));
        list.add(new Nutrition(5, "Recommended Daily Intakes", "https://www.nutritionaustralia.org/national/resource/australian-dietary-guidelines-recommended-daily-intakes", R.drawable.nutritionaus));
        return list;
    }
}
