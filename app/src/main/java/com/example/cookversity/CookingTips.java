package com.example.cookversity;

import java.util.ArrayList;
import java.util.Random;

public class CookingTips {
    private String value;

    public CookingTips() {
    }

    public CookingTips(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

//    https://www.purewow.com/food/most-used-cooking-tips
//    https://www.epicurious.com/expert-advice/best-cooking-advice-ever-article
    public static ArrayList<CookingTips> getCookingTips() {
        ArrayList<CookingTips> list = new ArrayList<>();
        list.add(new CookingTips("Place your eggs in a bowl of cold water, if they float to the surface they’ve gone bad and shouldn’t be eaten!"));
        list.add(new CookingTips("Adding salt to water delays the process of boiling."));
        list.add(new CookingTips("Plastic cutting boards are more sanitary than bamboo or wood."));
        list.add(new CookingTips("Put your chopping board on top of damp paper or a kitchen towel so it doesn't slide!"));
        list.add(new CookingTips("Be sure to read the entire recipe before you start cooking!"));
        list.add(new CookingTips("Refrigerate your cookie dough before baking to ensure softer and chewier cookies!"));
        list.add(new CookingTips("Quickly pickle your vegetables by pouring a bit of salt, sugar and white vinegar that's been whisked together."));
        list.add(new CookingTips("Before cooking with spices, give them a whiff! If they have no smell then they won't add any flavour and have probably gone off."));
        list.add(new CookingTips("If your eggs don't slide off your NON-STICK skillet then it's time to replace it!"));
        list.add(new CookingTips("Store salad greens in ziplock bag with paper towel (it absorbs the moisture and keeps your greens crispy!)"));
        return list;
    }

    @Override
    public String toString() {
        return value;
    }
}
