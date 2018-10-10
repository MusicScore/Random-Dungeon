package com.github.musicscore.randomdungeon.item;

import com.github.musicscore.randomdungeon.item.util.ItemType;

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
