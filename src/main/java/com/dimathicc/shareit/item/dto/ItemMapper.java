package com.dimathicc.shareit.item.dto;

import com.dimathicc.shareit.item.model.Item;
import com.dimathicc.shareit.item.dao.ItemRepository;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    private final ItemRepository itemRepository;
    private long id;

    public ItemMapper(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item itemDTOToItem(long userId, ItemDTO itemDTO) {
        Item item = new Item();
        item.setId(itemRepository.findIdByTitle(itemDTO.getTitle()));
        if (item.getId() == -1) item.setId(id++);
        item.setOwnerId(userId);
        item.setTitle(itemDTO.getTitle());
        item.setDescription(itemDTO.getDescription());
        item.setItemStatus(itemDTO.getItemStatus());
        return item;
    }

    public ItemDTO itemToItemDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setTitle(item.getTitle());
        itemDTO.setDescription(item.getDescription());
        itemDTO.setItemStatus(item.getItemStatus());
        return itemDTO;
    }
}
