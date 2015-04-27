package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class Library {

    private List<Book> availableBooks;
    private List<Book> issuedBooks;
    private List<String> availableServices;
    private List<Movie>  availableMovies;
    private List<Movie> issuedMovies;
    private List<User> libraryUser;

    public String getWelcomeMsg(){
        return "Welcome! to Bibloteca.";
    }

    public String checkOut(int bookNumber){
        if(bookNumber < 0 || bookNumber >= availableMovies.size()){
            return "That book is not available.";
        }
        transferBookFromAvailableToIssued(bookNumber - 1);
        return "Thank you! Enjoy the book";

    }

    public String checkOutMovie(int movieNumber) {
        if(transferMovieFromAvailableToIssued(movieNumber)){
            return "Thank you! Enjoy the movie";
        }
        return "That movie is not available.";
    }

    private boolean transferMovieFromAvailableToIssued(int movieNumber) {
        if(movieNumber < 1 && movieNumber > availableMovies.size()){ return false; }
        Movie toBeIssued = availableMovies.remove(movieNumber - 1);
        issuedMovies.add(toBeIssued);
        return true;
    }

    public String returnBook(final String bookName){
        Book bookToReturn = getIssuedBookByName(bookName);
        if(bookToReturn!=null){
            transferBookFromIssuedToAvailable(bookToReturn);
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

    public List<Movie> getAvailableMovies() {
        return availableMovies;
    }

    public Library(){
        populateServices();
        populateUser();
        populateBooks();
        populateMovies();
        issuedBooks = new ArrayList<>();
        issuedMovies = new ArrayList<>();
    }

    private void transferBookFromIssuedToAvailable(Book issuedBook){
        issuedBooks.remove(issuedBook);
        availableBooks.add(issuedBook);
    }

    private void transferBookFromAvailableToIssued(int bookNumber) {
        Book toBeIssued = availableBooks.remove(bookNumber);
        issuedBooks.add(toBeIssued);
    }

    private Book getIssuedBookByName(String bookName){

        Optional<Book> book = issuedBooks.stream()
                .filter((issuedBook) -> issuedBook.getName().equals(bookName))
                .findFirst();

        return book.isPresent() ? book.get() : null;

    }

    private void populateServices(){
        availableServices = new ArrayList<>();
        availableServices.add("List all books");
        availableServices.add("Return Book");
        availableServices.add("List all movies");
    }

    private void populateBooks(){
        availableBooks = new ArrayList<>();
        availableBooks.add(new Book("My Book", "xyz", "2000"));
        availableBooks.add(new Book("My Book2","abc", "2001"));
        availableBooks.add(new Book("My Book3","xyz", "2002"));
    }

    private void populateMovies(){
        availableMovies = new ArrayList<>();
        availableMovies.add(new Movie("Furious 8", 2015, "prateek", 5));
        availableMovies.add(new Movie("Matrix", 2000, "richi", 10));
        availableMovies.add(new Movie("LOTR", 2003, "pooja", -1));
    }

    private void populateUser(){
        libraryUser = new ArrayList<>();
        libraryUser.add(User.createUser("1234567", "111"));
        libraryUser.add(User.createLibrarian("1112222", "000"));
    }

    @Override
    public String toString() {
        return "Library{" +
                "availableBooks=" + availableBooks +
                '}';
    }

    public String login(String s, String s1) {
        User loginUser = libraryUser.stream()
                .filter((user) -> user.getLibraryNumber().equals(s))
                .findFirst()
                .orElseGet(()->null);
        if(isNull.test(loginUser)) { return "invalid library number";}
        return isValidPassword(s1,loginUser)? "logged in" : "invalid password";
    }

    private boolean isValidPassword(String password, User user){
        return user.getPassword().equals(password);
    }

    private Predicate<User> isNull = (user) -> Objects.isNull(user);
}
