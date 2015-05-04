//Responsibility of this class: User interaction bridge
package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String args[]) {
        Console console = new Console();
        Library library = LibRepository.getLibrary();
        console.run(library);
    }

}
