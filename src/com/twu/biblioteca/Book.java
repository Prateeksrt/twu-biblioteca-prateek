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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        return !(publishedIn != null ? !publishedIn.equals(book.publishedIn) : book.publishedIn != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (publishedIn != null ? publishedIn.hashCode() : 0);
        return result;
    }
}
