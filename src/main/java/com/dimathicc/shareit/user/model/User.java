package com.dimathicc.shareit.user.model;

import com.dimathicc.shareit.item.model.Item;
import lombok.Data;

import java.util.List;

@Data
public class User {
    private long id;
    private String name;
    private List<Item> items;
}
