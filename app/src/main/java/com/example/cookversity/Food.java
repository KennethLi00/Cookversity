package com.example.cookversity;

public class Food {
    private String name;
    private String cal;
    private int image;

    public Food(String name, String cal, int image) {
        this.name = name;
        this.cal = cal;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCal() {
        return cal;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
