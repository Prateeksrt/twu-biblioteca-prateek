package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prateeks on 4/28/15.
 */
public class LibRepository {

    private static Library library;

    public static Library getLibrary(){

            List<User> libraryUser = new ArrayList<>();
            libraryUser.add(User.createUser("1234567", "111"));
            libraryUser.add(User.createLibrarian("1112222", "000"));
            library = new Library(ItemRepository.prePopulatedItems(),libraryUser);
            return library;
    }
}
