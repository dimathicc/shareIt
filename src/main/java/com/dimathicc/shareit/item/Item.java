package com.dimathicc.shareit.item;

import com.dimathicc.shareit.user.User;
import lombok.Data;

@Data
public class Item {
    private long id;
    private User owner;
    private String title;
    private String description;
    private ItemStatus itemStatus;
}
