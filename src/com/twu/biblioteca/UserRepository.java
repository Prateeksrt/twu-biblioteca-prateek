package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by prateeks on 5/4/15.
 */
public class UserRepository {

    List<User> users;

    public UserRepository(List<User> users){
        this.users = users;
    }

    public User getUserViaLibraryNumber(String libraryNumber){
        return users.stream()
                .filter((user)->user.getLibraryNumber().equals(libraryNumber))
                .findFirst()
                .orElse(null);
    }

    public static List<User> prePopulatedUser(){
        List<User> preUser = new ArrayList<>();
        User user1 = User.createUser("1234567", "123");
        user1.addItem(Item.createBook("My Book", "xyz", "2000"));
        preUser.add(user1);
        preUser.add(User.createUser("7654321", "123"));
        preUser.add(User.createLibrarian("1111111","111"));
        return preUser;
    }

    public List<User> getUserWithItemsIssued(){
        return users.stream()
                .filter((user) -> user.hasItem())
                .collect(Collectors.toList());
    }
}
