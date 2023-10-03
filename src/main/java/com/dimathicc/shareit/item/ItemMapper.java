package com.dimathicc.shareit.item;

import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    private final ItemRepository itemRepository;

    public ItemMapper(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item itemDTOToItem(ItemDTO itemDTO) throws ItemNotFoundException {
        Item item = new Item();
        item.setId(itemRepository.findIdByTitle(itemDTO.getTitle()));
        if (item.getId() == -1) throw new ItemNotFoundException("Item not found...");
        item.setOwner(itemDTO.getOwner());
        item.setTitle(itemDTO.getTitle());
        item.setDescription(itemDTO.getDescription());
        item.setItemStatus(itemDTO.getItemStatus());
        return item;
    }

    public ItemDTO itemToItemDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setOwner(item.getOwner());
        itemDTO.setTitle(item.getTitle());
        itemDTO.setDescription(item.getDescription());
        itemDTO.setItemStatus(item.getItemStatus());
        return itemDTO;
    }
}
