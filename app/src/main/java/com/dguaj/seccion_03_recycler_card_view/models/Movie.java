package com.dguaj.seccion_03_recycler_card_view.models;

/**
 * Created by dguaj on 14-04-17.
 */

public class Movie {
    private String name;
    private int poster;

    public Movie() {
    }

    public Movie(String name, int poster) {
        this.name = name;
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}
