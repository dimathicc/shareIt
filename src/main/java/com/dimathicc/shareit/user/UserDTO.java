package com.dimathicc.shareit.user;

import com.dimathicc.shareit.item.Item;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private String name;
    private List<Item> items;
}
