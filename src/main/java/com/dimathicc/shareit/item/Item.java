package com.dimathicc.shareit.item;

import lombok.Data;

@Data
public class Item {
    private long id;
    private long ownerId;
    private String title;
    private String description;
    private ItemStatus itemStatus;
}
