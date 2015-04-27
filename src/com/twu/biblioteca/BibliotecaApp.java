//Responsibility of this class: User interaction bridge
package com.twu.biblioteca;

public class BibliotecaApp {

    private Library biblioteca;

    public static void main(String[] args) {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.run();

    }

    private BibliotecaApp(){

        biblioteca = new Library();

    }

    private void run(){

        this.printWelcomeMessage();
        this.startLibraryServices();

    }

    private void printWelcomeMessage(){
        UI.printBlock(biblioteca.getWelcomeMsg());
    }

    private void startLibraryServices(){

        int userInput = askUserToSelectTheService();
        switch(userInput){

            case 1:
                selectBook();
                startLibraryServices();
                break;
            case 2:
                returnBook();
                startLibraryServices();
                break;
            case 3:
                selectMovie();
                startLibraryServices();
                break;
        }

    }

    private int askUserToSelectTheService(){
        final String SELECT_SERVICE_HEADER = "Select the Service to use : ";

        UI.printHeader(SELECT_SERVICE_HEADER);
        return UI.getUserInput(biblioteca.getAvailableServices());
    }

    private void selectBook(){
        UI.printHeader("Select the Book to check out :");
        int input = UI.getUserInput(biblioteca.getAvailableBooks());
        if(input<=0) return;
        System.out.println(biblioteca.checkOut(input));
    }

    private void returnBook(){
        String bookName = UI.getUserInput("Enter the Book Name to return");
        if(bookName !=null){
            System.out.println(biblioteca.returnBook(bookName));
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }

    private void selectMovie(){
        UI.printHeader("Select the Movie to check out :");
        int input = UI.getUserInput(biblioteca.getAvailableMovies());
        if(input<=0) return;
        System.out.println(biblioteca.checkOutMovie(input));
    }
}
