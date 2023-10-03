package com.dimathicc.shareit.item;

import lombok.Data;

@Data
public class ItemDTO {
    private String title;
    private String description;
    private ItemStatus itemStatus;
}
