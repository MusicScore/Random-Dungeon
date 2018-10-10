package com.mysteryclive.gmail.randomdungeon.item;

import com.mysteryclive.gmail.randomdungeon.item.util.ItemType;

public class ItemClass {

    private ItemType item;
    private int quantity;

    // TODO[#0006]
    // Write a functional item class.

    public ItemClass(ItemType type, int amount) {
        item = type;
        quantity = amount;
    }

}
