package com.dimathicc.shareit.item.dao;

import com.dimathicc.shareit.item.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private final List<Item> items = new ArrayList<>();

    @Override
    public long findIdByTitle(String title) {
        for (Item item : items) {
            if (item.getTitle().equals(title)) {
                return item.getId();
            }
        }
        return -1;
    }

    @Override
    public void addItem(Item item) {
        items.add(item);
    }


    @Override
    public void editItem(long itemId, long userId, Item item) {
    }

    @Override
    public Item showItem(long itemId) {
        return items.get((int) itemId);
    }

    @Override
    public List<Item> showAllMyItems(long userId) {
        List<Item> foundItems = new ArrayList<>();
        for(Item item : items) {
            if (item.getOwnerId() == userId) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    @Override
    public List<Item> searchItems(long userId, String text) {
        return null;
    }
}
