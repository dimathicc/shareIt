package com.dimathicc.shareit.item;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper mapper;


    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper mapper) {
        this.itemRepository = itemRepository;
        this.mapper = mapper;
    }

    @Override
    public ItemDTO addItem(long userId, ItemDTO itemDTO) {
        Item item = mapper.itemDTOToItem(userId, itemDTO);
        item.setItemStatus(ItemStatus.AVAILABLE);
        item.setOwnerId(userId);
        itemRepository.addItem(item);
        return itemDTO;
    }

    @Override
    public ItemDTO editItem(long itemId, long userId, ItemDTO itemDTO) throws ItemEditException {
        Item item = mapper.itemDTOToItem(userId, itemDTO);
        if (item.getOwnerId() == userId) {
            itemRepository.editItem(itemId, userId, item);
        } else {
            throw new ItemEditException("Item is not your, so you can't edit it");
        }
        return itemDTO;
    }

    @Override
    public ItemDTO showItem(long userId, long itemId) {
        Item item = itemRepository.showItem(itemId);
        return mapper.itemToItemDTO(item);
    }

    @Override
    public List<ItemDTO> showAllMyItems(long userId) {
        List<Item> items = itemRepository.showAllMyItems(userId);
        List<ItemDTO> itemDTOS = new ArrayList<>();
        for (Item item : items) {
            itemDTOS.add(mapper.itemToItemDTO(item));
        }
        return itemDTOS;
    }

    @Override
    public List<ItemDTO> searchItems(long userId, String text) {
        List<Item> items = itemRepository.searchItems(userId, text);
        List<ItemDTO> itemDTOS = new ArrayList<>();
        for (Item item : items) {
            itemDTOS.add(mapper.itemToItemDTO(item));
        }
        return itemDTOS;
    }
}
