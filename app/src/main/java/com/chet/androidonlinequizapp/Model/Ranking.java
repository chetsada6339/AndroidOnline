package com.chet.androidonlinequizapp.Model;

/**
 * Created by user on 29/11/2560.
 */

public class Ranking {
    private String Name;
    private String Image;

    public Ranking() {
    }

    public Ranking(String name, String image) {
        Name = name;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
