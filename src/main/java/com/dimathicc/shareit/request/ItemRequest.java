package com.dimathicc.shareit.request;

import com.dimathicc.shareit.item.Item;
import com.dimathicc.shareit.user.User;
import lombok.Data;

@Data
public class ItemRequest {
    private long id;
    private Item requestedItem;
    private User requestOwner;
}
