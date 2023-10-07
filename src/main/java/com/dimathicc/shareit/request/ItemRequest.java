package com.dimathicc.shareit.request;

import com.dimathicc.shareit.item.model.Item;
import com.dimathicc.shareit.user.model.User;
import lombok.Data;

@Data
public class ItemRequest {
    private long id;
    private Item requestedItem;
    private User requestOwner;
}
