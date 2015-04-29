package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {

    private final static String availableBookString = "[Name : My Book, Author : xyz, Published in : 2000," +
            " Name : My Book2, Author : abc, Published in : 2001," +
            " Name : My Book3, Author : xyz, Published in : 2002]";

    private final static String  availableServiceString = "[List all books, Return Book, List all movies]";

    private final static String availableMovieString = "[Name : Furious 8, Year : 2015, Director : prateek, Rating : 5, " +
            "Name : Matrix, Year : 2000, Director : richi, Rating : 10, " +
            "Name : LOTR, Year : 2003, Director : pooja, Rating : not rated]";
    
    private Library biblioteca;
    
    @Before
    public void setUp(){
        biblioteca = LibRepository.getLibrary();
    }

    @Test
    public void test_Get_Welcome_Msg() throws Exception {

        assertEquals("Welcome! to Bibloteca.", biblioteca.getWelcomeMsg());

    }

    @Test
    public void test_Get_Available_Books() throws Exception {

        assertEquals(availableBookString, biblioteca.getAvailableBooks().toString());

    }

    @Test
    public void test_Get_Available_Services() throws Exception {

        List<String> services = biblioteca.getAvailableServices();
        assertEquals(availableServiceString, services.toString());

    }

    @Test
    public void test_return_book_wrong_book_test(){
        assertFalse(biblioteca.returnBook("ramu"));
    }

    @Test
    public void testBookCheckOut() {
        assertTrue(biblioteca.checkOutBook("My Book"));
    }

    @Test
    public void testBookCheckOut_unsuccessful() {
        assertFalse(biblioteca.checkOutBook("Not My Book"));
    }

    @Test
    public void test_Book_Return_unsuccessful_when_no_book_issued(){
        assertFalse(biblioteca.returnBook("My Book"));
    }

    @Test
    public void test_Book_Return_Successful(){
        assertTrue(biblioteca.checkOutBook("My Book"));
        assertTrue(biblioteca.returnBook("My Book"));
    }

    @Test
    public void test_Book_Return_Unsuccessful_wrong_book_name(){
        assertTrue(biblioteca.checkOutBook("My Book"));
        assertFalse(biblioteca.returnBook("My Booker"));
    }

    @Test
    public void test_Get_Available_Movies(){

        assertEquals(availableMovieString,biblioteca.getAvailableMovies().toString());

    }

    @Test
    public void test_Check_Out_Movie_successful(){
        assertTrue(biblioteca.checkOutMovie("Matrix"));
    }

    @Test
    public void test_Check_Out_Movie_unsuccessful(){
        assertFalse(biblioteca.checkOutBook("matrix reloaded"));
    }
}