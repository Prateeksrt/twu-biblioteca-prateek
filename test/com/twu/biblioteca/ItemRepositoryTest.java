package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by prateeks on 4/28/15.
 */
public class ItemRepositoryTest {

    ItemRepository items = null;

    @Before
    public void setUp(){
        items = new ItemRepository(ItemRepository.prePopulatedItems());
    }

    @Test
    public void test_get_book_by_name(){
        assertTrue(items.getBookByName("My Book").isBook());
    }

    @Test
    public void test_get_issued_book_by_name_wrong_book(){
        assertNull(items.getIssuedBookByName("ramu"));
    }

    @Test
    public void test_get_movie_by_name(){
        assertTrue(items.getMovieByName("Matrix").isMovie());
    }

    @Test
    public void test_get_movie_by_name_wrong_name(){
        assertNull(items.getMovieByName("xyz"));
    }

}