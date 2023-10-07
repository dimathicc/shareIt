package com.dimathicc.shareit.item.dto;

import com.dimathicc.shareit.item.model.ItemStatus;
import lombok.Data;

@Data
public class ItemDTO {
    private String title;
    private String description;
    private ItemStatus itemStatus;
}
