package com.twu.biblioteca;

public class LibRepository {

    private static Library library;

    public static Library getLibrary(){
            library = new Library(ItemRepository.prePopulatedItems(),UserRepository.prePopulatedUser());
            return library;
    }
}
