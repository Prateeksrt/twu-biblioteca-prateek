package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;

import static com.twu.biblioteca.Message.*;

public class Console {

    private BufferedReader reader;

    private PrintStream printer;

    private User currentUser;

    public Console() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        printer = System.out;
    }

    public void run(final Library library){
        print(library.getWelcomeMsg());
        login(library);
    }

    private int getSelectedService(Library library) {
        printMenu(library.getAvailableServices());
        print(ASK_USER_TO_SELECT_SERVICE);
        Integer selected = readInteger();
        return selected == null ? Integer.MIN_VALUE : selected;
    }

    private void returnBook(Library library) {
        print(ASK_USER_TO_ENTER_BOOK_NAME_TO_RETURN);
        String bookName0 = readString();
        if(library.returnBook(bookName0)) {
            currentUser.removeItem(library.getAvailableBook(bookName0));
            print(BOOK_SUCCESSFUL_RETURN_MESSAGE);
        } else {
            print(BOOK_UNSUCCESSFUL_RETURN_MESSAGE);
        }
    }

    private void checkOutBook(final Library library){
        printMenu(library.getAvailableBooks());
        print(ASK_USER_TO_SELECT_BOOK);
        String bookName = readString();
        if(library.checkOutBook(bookName)) {
            currentUser.addItem(library.getIssuedBook(bookName));
            print(BOOK_SUCCESSFUL_CHECK_OUT_MESSAGE);
            return;
        }
        print(BOOK_UNSUCCESSFUL_CHECK_OUT_MESSAGE);
    }

    private void checkOutMovie(final Library library){
        printMenu(library.getAvailableMovies());
        print(ASK_USER_TO_SELECT_MOVIE);
        String movieName = readString();
        if(library.checkOutMovie(movieName)) {
            currentUser.addItem(library.getIssuedMovie(movieName));
            print(MOVIE_SUCCESSFUL_CHECK_OUT_MESSAGE);
            return;
        }
        print(MOVIE_UNSUCCESSFUL_CHECK_OUT_MESSAGE);
    }

    private void print(String msg){
       printer.println(msg);
    }

    private String readString(){
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer readInteger(){
        String integer = this.readString();
        try {
            if (integer != null) {
                return Integer.parseInt(integer);
            } else return null;
        } catch(NumberFormatException e){
            return null;
        }
    }

    private <E> void printMenu(List<E> menu){
        int count = 0;
        for (E item : menu) {
            print(++count + ". " + item.toString());
        }
    }

    private void login(Library library){
        print("Enter the library Number");
        String libraryNumber = readString();
        User user = library.getUserViaLibraryNumber(libraryNumber);
        if(user!=null){
            print("Enter the password");
            String password = readString();
            if(user.isValidPassword(password)){
                currentUser = user;
                if(currentUser.isLibrarian()){
                    librarianFlow(library);
                } else {
                    userFlow(library);
                }
            } else {
                print("Incorrect Password");
            }
        } else {
            print("This is not a valid library number");
        }

    }

    private void userFlow(Library library){
        while(true){
            int selectedIndex = getSelectedService(library);
            switch(selectedIndex){
                case 1:
                    checkOutBook(library);
                    break;
                case 2:
                    returnBook(library);
                    break;
                case 3:
                    checkOutMovie(library);
                    break;
                case 0:
                    return;
                default:
                    print(INVALID_SERVICE_SELECTION_MESSAGE);
            }
        }
    }

    private void librarianFlow(Library library){
        print("User with book issued");
        List<User> userWithBooks = library.getUserWithIssuedBooks();
        if(userWithBooks.size()<1){
            print("No book has been issued.");
        }
        for(User user : userWithBooks){
            for(Item item : user.getIssuedBook()){
                print(user.getLibraryNumber()+" has book "+item.getName());
            }
        }

        print("User with movie issued");
        List<User> userWithMovies = library.getUserWithIssuedMovies();
        if(userWithMovies.size()<1){
            print("No movie has been issued.");
        }
        for(User user : userWithMovies){
            for(Item item : user.getIssuedMovie()){
                print(user.getLibraryNumber()+" has movie "+item.getName());
            }
        }
    }
}
