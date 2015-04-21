package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {
    
    private Library biblioteca;
    
    @Before
    public void setUp(){
        biblioteca = new Library();
    }

    @Test
    public void testGetWelcomeMsg() throws Exception {

        assertEquals("Welcome! to Bibloteca.", biblioteca.getWelcomeMsg());

    }

    @Test
    public void testGetAvailableBooks() throws Exception {
        
        String bookTestString = "[Name : My Book, Author : xyz, Published in : 2000," +
                " Name : My Book2, Author : abc, Published in : 2001," +
                " Name : My Book3, Author : xyz, Published in : 2002]";
        assertEquals(bookTestString, biblioteca.getAvailableBooks().toString());

    }

    @Test
    public void testGetAvailableServices() throws Exception {

        List<String> services = biblioteca.getAvailableServices();
        assertEquals("[List All books, Return Book]",services.toString());
    }

    @Test
    public void testBookCheckOut() {
        biblioteca.checkOut(2);
        String expectedString = "[Name : My Book, Author : xyz, Published in : 2000," +
                " Name : My Book3, Author : xyz, Published in : 2002]";
        assertEquals(expectedString, biblioteca.getAvailableBooks().toString());
    }

    @Test
    public void test_Book_Check_Out_SuccessFull_Message(){
        String expectedString = "Thank you! Enjoy the book";
        assertEquals(expectedString, biblioteca.checkOut(2));
    }

    @Test
    public void test_Book_Check_Out_Un_SuccessFull_Message(){
        String expectedString = "That book is not available.";
        assertEquals(expectedString, biblioteca.checkOut(4));
    }

    @Test
    public void test_Book_Return(){
        String expectedString = "[Name : My Book, Author : xyz, Published in : 2000," +
                " Name : My Book3, Author : xyz, Published in : 2002,"+
                " Name : My Book2, Author : abc, Published in : 2001]";
        biblioteca.checkOut(2);
        biblioteca.returnBook("My Book2");
        assertEquals(expectedString, biblioteca.getAvailableBooks().toString());
    }

    @Test
    public void test_Book_Return_SuccessFully(){
        String expectedString = "Thank you for returning the book.";
        biblioteca.checkOut(2);
        assertEquals(expectedString, biblioteca.returnBook("My Book2"));
    }

    @Test
    public void test_Book_Return_Un_SuccessFully(){
        String expectedString = "That is not a valid book to return.";
        biblioteca.checkOut(2);
        assertEquals(expectedString, biblioteca.returnBook("My Book9"));
    }
}