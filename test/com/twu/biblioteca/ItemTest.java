package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ItemTest {

    @Test
    public void createBook(){
        Item book1 = Item.createBook("book1", "xyz","2000");
        assertTrue(book1.isBook());
    }

    @Test
    public void createMovie(){
        Item movie1 = Item.createMovie("matrix", "prateek", "2000", -1);
        assertTrue(movie1.isMovie());
    }

    @Test
    public void test_is_movie_No(){
        Item book1 = Item.createBook("my Book", "fuhfiue", "2012");
        assertFalse(book1.isMovie());
    }
}
