package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UITest {

    @Test
    public void testPrintMenu(){
        List<String> newList = new ArrayList<>();
        newList.add("Go");
        newList.add("Come");
        newList.add("Leave");
        String expectedString = "1. Go\n2. Come\n3. Leave\n0. to exit";
        assertEquals(expectedString, UI.getPrintableMenu(newList));
    }


}