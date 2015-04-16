package com.twu.biblioteca;


import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void testLibraryWelcomeMsg(){
        assertEquals("Welcome! to Bibloteca.", new Library().getWelcomeMsg());
    }

    @Test
    public void testBookName(){
        Book myBook = new Book();
        assertEquals("hi","My Book", myBook.getName());
    }
}
