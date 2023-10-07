package com.dimathicc.shareit.item.dao;

import com.dimathicc.shareit.item.model.Item;

import java.util.List;

public interface ItemRepository {
    long findIdByTitle(String title);

    void addItem(Item item);

    void editItem(long itemId, long userId, Item item);

    Item showItem(long userId);

    List<Item> showAllMyItems(long userId);

    List<Item> searchItems(long userId, String text);

}
