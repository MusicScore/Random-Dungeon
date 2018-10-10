package com.github.musicscore.randomdungeon.item;

import com.github.musicscore.randomdungeon.item.util.ItemType;

public class Item {

    private ItemType item;
    private int quantity;

    // TODO[#0006]
    // Write a functional item class.

    public Item(ItemType type, int amount) {
        item = type;
        quantity = amount;
    }

}
