package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> availableBooks;

    private List<Book> issuedBooks;

    private List<String> availableServices;

    public String getWelcomeMsg(){
        return "Welcome! to Bibloteca.";
    }

    public String checkOut(int bookNumber){
        try {
            transferBookForAvailableToIssued(bookNumber - 1);
            return "Thank you! Enjoy the book";
        } catch (Exception e){
            return "That book is not available.";
        }
    }

    public String returnBook(final String bookName){
        Book bookToReturn = getIssuedBookByName(bookName);
        if(bookToReturn!=null){
            transferBookForIssuedToAvailable(bookToReturn);
            return "Thank you for returning the book.";
        }
        return "That is not a valid book to return.";
    }

    public List<Book> getAvailableBooks(){
        return availableBooks;
    }

    public List<String> getAvailableServices() {
        return availableServices;
    }

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

    private void transferBookForIssuedToAvailable(Book issuedBook){
        issuedBooks.remove(issuedBook);
        availableBooks.add(issuedBook);
    }

    private void transferBookForAvailableToIssued(int bookNumber) {
        Book toBeIssued = availableBooks.remove(bookNumber);
        issuedBooks.add(toBeIssued);
    }

    private Book getIssuedBookByName(String bookName){
        for(Book issuedBook : this.issuedBooks) {
            if (issuedBook.getName().equals(bookName)) {
                return issuedBook;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Library{" +
                "availableBooks=" + availableBooks +
                '}';
    }
}
