package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemRepository {

    private List<Item> availableItems;
    private List<Item> issuedItems;

    public ItemRepository(List<Item> availableItems) {
        this.availableItems = availableItems;
        issuedItems = new ArrayList<>();
    }

    public List<Item> getAvailableBooks(){
        return getItemList(ItemType.BOOK, getAvailableItems());
    }

    public List<Item> getAvailableMovies() {
        return getItemList(ItemType.MOVIE, getAvailableItems());
    }

    public List<Item> getIssuedBooks(){
        return getItemList(ItemType.BOOK, getIssuedItems());
    }

    public List<Item> getIssuedMovies() {
        return getItemList(ItemType.MOVIE, getIssuedItems());
    }

    public Item getBookByName(String bookName) {
        return getItemByName(bookName, getAvailableBooks());
    }

    public Item getMovieByName(String movieName) {
        return getItemByName(movieName, getAvailableMovies());
    }

    public Item getIssuedBookByName(String bookName){
        return getItemByName(bookName,getIssuedBooks());
    }

    public Item getIssuedMovieByName(String bookName){
        return getItemByName(bookName,getIssuedMovies());
    }

    public void lend(Item item){
        availableItems.remove(item);
        issuedItems.add(item);
    }

    public void returnBack(Item item){
        issuedItems.remove(item);
        availableItems.add(item);
    }

    private List<Item> getItemList(ItemType itemType, List<Item> listToGetFrom){
        return listToGetFrom.stream()
                .filter((item) -> item.getItemType().equals(itemType))
                .collect(Collectors.toList());
    }

    private Item getItemByName(String itemName, List<Item> listToGetFrom){
        return listToGetFrom.stream()
                .filter((item)->item.getName().equals(itemName))
                .findFirst().orElse(null);
    }

    private List<Item> getAvailableItems() {
        return availableItems;
    }

    private List<Item> getIssuedItems() {
        return issuedItems;
    }

    public static List<Item> prePopulatedItems() {
        List<Item> availableItems = new ArrayList<>();
        availableItems.add(Item.createBook("My Book", "xyz", "2000"));
        availableItems.add(Item.createBook("My Book2", "abc", "2001"));
        availableItems.add(Item.createBook("My Book3", "xyz", "2002"));
        availableItems.add(Item.createMovie("Furious 8", "prateek", "2015", 5));
        availableItems.add(Item.createMovie("Matrix", "richi", "2000", 10));
        availableItems.add(Item.createMovie("LOTR", "pooja", "2003", -1));
        return availableItems;
    }
}
