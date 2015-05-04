package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 *Responsibility:  Provide library service to customer (user)
 */
public class Library {

    private List<String> availableServices;
    private ItemRepository itemRepository;
    private UserRepository userRepository;

    public Library(List<Item> items, List<User> users){
        this.itemRepository = new ItemRepository(items);
        this.userRepository = new UserRepository(users);
        populateServices();
    }

    public String getWelcomeMsg(){
        return Message.WELCOME_MSG;
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

    public Item getIssuedBook(String bookName){
        return itemRepository.getIssuedBookByName(bookName);
    }

    public Item getIssuedMovie(String movieName){
        return itemRepository.getIssuedMovieByName(movieName);
    }
    
    public Item getAvailableMovie(String movieName){
        return itemRepository.getMovieByName(movieName);
    }
    
    public Item getAvailableBook(String bookName){
        return itemRepository.getMovieByName(bookName);
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

    public User getUserViaLibraryNumber(final String libraryNumber){
        return userRepository.getUserViaLibraryNumber(libraryNumber);
    }

    public List<User> getUserWithIssuedBooks(){
        return userRepository.getUserWithItemsIssued()
                .stream().filter((user)->user.getIssuedBook().size()>0)
                .collect(Collectors.toList());
    }

    public List<User> getUserWithIssuedMovies(){
        return userRepository.getUserWithItemsIssued()
                .stream().filter((user)->user.getIssuedMovie().size()>0)
                .collect(Collectors.toList());
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



    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
