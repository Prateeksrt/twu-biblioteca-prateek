package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private String publishedIn;


    public Book(String name, String author, String publishedIn){
        this.name =name;
        this.author = author;
        this.publishedIn = publishedIn;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return "Name : "+name
                +", Author : "+author
                +", Published in : "+publishedIn;
    }
}
