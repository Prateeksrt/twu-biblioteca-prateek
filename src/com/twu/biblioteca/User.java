package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private String libraryNumber;
    private String password;
    private boolean isLibrarian;
    private List<Item> items;

    private User(String libraryNumber, String password, boolean isLibrarian) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.isLibrarian = isLibrarian;
        this.items = new ArrayList<>();
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

    public boolean isValidPassword(String password){
        return this.getPassword().equals(password);
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public boolean hasItem(){
        return items.size()>0;
    }

    public List<Item> getIssuedBook(){
        return items.stream()
                .filter((item)->item.isBook())
                .collect(Collectors.toList());
    }

    public List<Item> getIssuedMovie(){
        return items.stream()
                .filter((item)->item.isMovie())
                .collect(Collectors.toList());
    }



    @Override
    public String toString() {
        return "User{" +
                "libraryNumber='" + libraryNumber + '\'' +
                ", isLibrarian=" + isLibrarian +
                '}';
    }
}
