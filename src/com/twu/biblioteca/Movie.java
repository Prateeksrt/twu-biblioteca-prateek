package com.twu.biblioteca;

/**
 * Created by prateeks on 4/21/15.
 */
public class Movie {

    private String name;

    private int year;

    private String director;

    private int rating;

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Name : "+name+
                ", Year : "+year+
                ", Director : "+director+
                ", Rating : "+(rating < 0 ? "not rated":rating);
    }
}
