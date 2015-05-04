package com.twu.biblioteca;

public interface Message {

    String WELCOME_MSG = "Welcome to Library";

    String ASK_USER_TO_SELECT_SERVICE = "Number to select the corresponding service";

    String ASK_USER_TO_SELECT_BOOK = "Enter the book name to check out";

    String ASK_USER_TO_SELECT_MOVIE = "Enter the movie name to check out";

    String ASK_USER_TO_ENTER_BOOK_NAME_TO_RETURN = "Enter the book name to return";

    String BOOK_SUCCESSFUL_CHECK_OUT_MESSAGE = "Enjoy the book!";

    String BOOK_UNSUCCESSFUL_CHECK_OUT_MESSAGE = "Sorry! This book is not available";

    String MOVIE_SUCCESSFUL_CHECK_OUT_MESSAGE = "Enjoy the movie!";

    String MOVIE_UNSUCCESSFUL_CHECK_OUT_MESSAGE = "Sorry! This movie is not available";

    String BOOK_SUCCESSFUL_RETURN_MESSAGE = "Thank you! For Returning the book";

    String BOOK_UNSUCCESSFUL_RETURN_MESSAGE = "Sorry! Not a valid book to return";

    String INVALID_SERVICE_SELECTION_MESSAGE = "Select a number which represent the service you wish to use.";
}
