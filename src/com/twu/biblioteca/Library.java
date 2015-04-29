package com.twu.biblioteca;

import java.util.*;

/*
 *Responsibility:  Provide library service to customer (user)
 */
public class Library {

    private List<String> availableServices;
    private List<User> libraryUser;
    private ItemRepository itemRepository;

    public Library(List<Item> items, List<User> users){
        this.itemRepository = new ItemRepository(items);
        this.libraryUser = users;
        populateServices();
    }

    public String getWelcomeMsg(){
        return "Welcome! to Bibloteca.";
    }

    public List<Item> getAvailableBooks(){
        return itemRepository.getAvailableBooks();
    }

    public List<Item> getAvailableMovies() {
        return itemRepository.getAvailableMovies();
    }

    public List<String> getAvailableServices() {
        return availableServices;
    }

    public boolean checkOutBook(String bookName){
        Item bookToCheckOut = itemRepository.getBookByName(bookName);
        return lendFromRepository(bookToCheckOut);
    }

    public boolean checkOutMovie(String movieName){
        Item bookToCheckOut = itemRepository.getMovieByName(movieName);
        return lendFromRepository(bookToCheckOut);
    }

    public boolean returnBook(final String bookName){
        Item bookToReturn = itemRepository.getIssuedBookByName(bookName);
        return returnToRepository(bookToReturn);
    }

    public boolean returnMovie(final String movieName) {
        Item movieToReturn = itemRepository.getIssuedMovieByName(movieName);
        return returnToRepository(movieToReturn);
    }

    private boolean lendFromRepository(Item itemToCheckOut){
        if(itemToCheckOut==null){ return false;}
        itemRepository.lend(itemToCheckOut);
        return true;
    }

    private boolean returnToRepository(Item itemToReturn) {
        if(itemToReturn==null){ return false;}
        itemRepository.returnBack(itemToReturn);
        return true;
    }

    private void populateServices(){
        availableServices = new ArrayList<>();
        availableServices.add("List all books");
        availableServices.add("Return Book");
        availableServices.add("List all movies");
    }
}
