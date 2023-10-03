package com.dimathicc.shareit.item;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ItemDTO addItem(@RequestHeader("X-Sharer-User-Id") long userId, @RequestBody ItemDTO itemDTO) throws ItemNotFoundException {
        return itemService.addItem(userId, itemDTO);
    }

    @PatchMapping("/{itemId}")
    public ItemDTO editItem(@RequestHeader("X-Sharer-User-Id") long userId, @PathVariable long itemId, @RequestBody ItemDTO itemDTO) throws ItemNotFoundException, ItemEditException {
        return itemService.editItem(itemId, userId, itemDTO);
    }

    @GetMapping("/{itemId}")
    public ItemDTO showItem(@RequestHeader("X-Sharer-User-Id") long userId, @PathVariable long itemId) {
        return itemService.showItem(userId, itemId);
    }

    @GetMapping
    public List<ItemDTO> showAllMyItems(@RequestHeader("X-Sharer-User-Id") long userId) {
        return itemService.showAllMyItems(userId);
    }

    @GetMapping("/search")
    public List<ItemDTO> searchItems(@RequestHeader("X-Sharer-User-Id") long userId, @PathParam("text") String text) {
        return itemService.searchItems(userId, text);
    }


}
