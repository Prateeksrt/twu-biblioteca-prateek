package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MovieTest {

    @Test
    public void test_Get_Movie_Detail_With_5_Rating(){
        Movie newMovie = new Movie("Furious 8",2015,"prateek", 5);
        String expectedString = "Name : Furious 8, Year : 2015, Director : prateek, Rating : 5";
        assertEquals(expectedString, newMovie.toString());
    }

    @Test
    public void test_Get_Movie_Detail_With_No_Rating(){
        Movie newMovie = new Movie("Furious 8",2015,"prateek", -1);
        String expectedString = "Name : Furious 8, Year : 2015, Director : prateek, Rating : not rated";
        assertEquals(expectedString, newMovie.toString());
    }
}
