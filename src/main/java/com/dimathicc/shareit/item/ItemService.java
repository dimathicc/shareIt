package com.dimathicc.shareit.item;

import java.util.List;

public interface ItemService {
    ItemDTO addItem(long userId, ItemDTO itemDTO) throws ItemNotFoundException;

    ItemDTO editItem(long itemId, long userId, ItemDTO itemDTO) throws ItemNotFoundException, ItemEditException;

    ItemDTO showItem(long userId, long itemId);

    List<ItemDTO> showAllMyItems(long userId);

    List<ItemDTO> searchItems(long userId, String text);
}
