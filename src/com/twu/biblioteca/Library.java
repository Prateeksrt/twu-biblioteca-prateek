package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> availableBooks;

    private List<Book> issuedBooks;

    private List<String> availableServices;

    public Library(){
        availableBooks = new ArrayList<>();
        availableBooks.add(new Book("My Book", "xyz", "2000"));
        availableBooks.add(new Book("My Book2","abc", "2001"));
        availableBooks.add(new Book("My Book3","xyz", "2002"));
        availableServices = new ArrayList<>();
        availableServices.add("List All books");
        availableServices.add("Return Book");
        issuedBooks = new ArrayList<>();

    }

    public String getWelcomeMsg(){
        return "Welcome! to Bibloteca.";
    }

    public List<Book> getAvailableBooks(){
        return availableBooks;
    }

    public List<String> getAvailableServices() {
        return availableServices;
    }

    public String checkOut(int bookNumber){
        try {
            issuedBooks.add(availableBooks.remove(bookNumber - 1));
            return "Thank you! Enjoy the book";
        } catch (Exception e){
            return "That book is not available.";
        }
    }

    @Override
    public String toString() {
        return "Library{" +
                "availableBooks=" + availableBooks +
                '}';
    }

    public String returnBook(final String bookName){
        Book bookToReturn = null;
        for(Book issuedBook : issuedBooks) {
            if (issuedBook.getName().equals(bookName)) {
                bookToReturn = issuedBook;
            }
        }

        if(bookToReturn!=null){
            transferBookForIssuedToAvailable(bookToReturn);
            return "Thank you for returning the book.";
        }
        return "That is not a valid book to return.";
    }

    private void transferBookForIssuedToAvailable(Book issuedBook){
        issuedBooks.remove(issuedBook);
        availableBooks.add(issuedBook);
    }
}
