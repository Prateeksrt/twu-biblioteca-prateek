package com.twu.biblioteca;

public class User {
    private String libraryNumber;
    private String password;
    private boolean isLibrarian;

    private User(String libraryNumber, String password, boolean isLibrarian) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.isLibrarian = isLibrarian;
    }

    public static User createUser(String libraryNumber, String password ){
        return new User(libraryNumber,password,false);
    }

    public static User createLibrarian(String libraryNumber, String password){
        return new User(libraryNumber,password,true);
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLibrarian() {
        return isLibrarian;
    }

    @Override
    public String toString() {
        return "User{" +
                "libraryNumber='" + libraryNumber + '\'' +
                ", isLibrarian=" + isLibrarian +
                '}';
    }
}
