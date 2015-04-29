package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.BiPredicate;

public class UI {

    public static final String ERR_MSG_INVALID_SELECTION = "Select a valid option!";

    public static <E> String getPrintableMenu(List<E> menu){
        String printableMenu = "";
        int itemNumber = 1;
        for(E menuItem : menu){
            printableMenu += (itemNumber++) + ". "+menuItem.toString()+"\n";
        }
        printableMenu += 0+". to exit";

        return printableMenu;
    }

    public static <E> boolean isValidSelection(List<E> menu, int selectedIndex){
        final boolean isZeroOrGreater = selectedIndex >= 0;
        final boolean isMenuSizeOrLess = selectedIndex <= menu.size();
        return isZeroOrGreater && isMenuSizeOrLess;
    }

    public static String getInput(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public static int getSelectedInput(){
        return 1;
    }

    public static void printBlock(String msg){
        final String line = "----------------------------------------------";
        System.out.println(line + "\n" + msg + "\n" + line);
    }

    public static void printHeader(String msg){
        printBlock("\t\t\t" + msg);
    }

    public static <E> int getUserInput(List<E> menuToChooseFrom){
        int selectedItem;
        final String printableMenu =  getPrintableMenu(menuToChooseFrom);
        try {
            selectedItem = getSelectedIndex(printableMenu);
            if(isValidSelection(menuToChooseFrom, selectedItem)) {
                return selectedItem;
            }
            throw new NumberFormatException();
        } catch (NumberFormatException e) {
            return invalidSelectionResponse(menuToChooseFrom);
        }
    }

    public static String getUserInput(String msg){
        printBlock(msg);
        return getInput();
    }

    public static int getSelectedIndex(String menu) throws NumberFormatException {
        return Integer.parseInt(getUserInput(menu));
    }

    private static <E> int invalidSelectionResponse(List<E> menuToChooseFrom){
        System.out.println(ERR_MSG_INVALID_SELECTION);
        return getUserInput(menuToChooseFrom);
    }

    public static BiPredicate<List,Integer> isValidMenuSelection = (list,index) -> index>0 && index <= list.size();
}
