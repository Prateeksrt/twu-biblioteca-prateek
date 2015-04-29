package com.twu.biblioteca;

public class Item {

    private String name;

    private String author;

    private String publishedIn;

    private String director;

    private String releaseIn;

    private int rating;

    private ItemType itemType;

    public static Item createBook(String name, String author, String publishedIn) {
        return new Item(name, author, publishedIn, null, null, -1, ItemType.BOOK);
    }

    public static Item createMovie(String name, String director, String releasedIn, int rating) {
        return new Item(name, null, null, director, releasedIn, rating, ItemType.MOVIE);
    }

    public String getName() {
        return name;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public boolean isBook() {
        return itemType.equals(ItemType.BOOK);
    }

    public boolean isMovie() {
        return itemType.equals(ItemType.MOVIE);
    }

    @Override
    public String toString() {
        switch (itemType) {
            case BOOK:
                return getBookString();
            case MOVIE:
                return getMovieString();
            default:
                return null;
        }
    }

    private String getMovieString() {
        return "Name : " + name +
                ", Year : " + releaseIn +
                ", Director : " + director +
                ", Rating : " + (rating < 1 ? "not rated" : rating);
    }

    private String getBookString() {
        return "Name : " + name +
                ", Author : " + author +
                ", Published in : " + publishedIn;
    }

    private Item(String name, String author, String publishedIn, String director, String releasedIn, int rating,
                 ItemType itemType) {
        this.name = name;
        this.author = author;
        this.publishedIn = publishedIn;
        this.director = director;
        this.releaseIn = releasedIn;
        this.rating = rating;
        this.itemType = itemType;
    }
}
