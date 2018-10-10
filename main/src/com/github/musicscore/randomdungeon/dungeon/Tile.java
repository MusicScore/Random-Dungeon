package com.github.musicscore.randomdungeon.dungeon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import com.github.musicscore.randomdungeon.dungeon.util.TilePropType;
import com.github.musicscore.randomdungeon.dungeon.util.TileType;
import com.github.musicscore.randomdungeon.item.Item;

// TODO[#0004]
// Refine the tile data processing. More methods/instancing fields as needed.

public class Tile {

    private int tileX, tileY;
    private TileType tileType;

    public Tile(int[] id) {
        this(id, TileType.VOID);
    }

    public Tile(int[] id, TileType type) {
        this.tileX = (id.length == 2 ? id[0] : -1);
        this.tileY = (id.length == 2 ? id[1] : -1);
        this.tileType = type;
    }

    public void setTileType(TileType type) {
        tileType = type;
    }

    public int[] getTileID() {
        if (tileX == -1 || tileY == -1) {
            return null;
        }
        return new int[]{tileX, tileY};
    }

    public int getTileX() {
        return tileX >= 0 ? tileX : -1;
    }

    public int getTileY() {
        return tileY >= 0 ? tileY : -1;
    }

    public TileType getTileType() {
        return tileType;
    }

    private TileProp tileProperty = null;
    private String propType = null;
    private ArrayList<Item> containerContentsList = new ArrayList<>();
    private HashSet<String> propertyList = new HashSet<>();

    public void setContainerContents(ArrayList<Item> itemList) {
        containerContentsList.addAll(itemList);
    }

    public void setProperty(TileProp prop) {
        tileProperty = prop;
    }

    public ArrayList<Item> listContents() {
        return tileProperty.getType() == TilePropType.TREASURE || tileProperty.getType() == TilePropType.CHEST ? containerContentsList : null;
    }

    public String getTrapType() {
        return tileProperty.getType() == TilePropType.TRAP ? propType : null;
    }

    public boolean isExit() {
        return tileProperty.getType() == TilePropType.TO_NEXT_FLOOR;
    }

    public String getDecorationType() {
        return tileProperty.getType() == TilePropType.DECORATION ? propType : null;
    }

    public Tile addNewProperty(String newProp) {
        propertyList.add(newProp);
        return this;
    }

    public Tile addNewProperty(Collection<String> newPropList) {
        propertyList.addAll(newPropList);
        return this;
    }

    public Tile removeProperty(String removeProp) {
        propertyList.remove(removeProp);
        return this;
    }

    public Tile removeProperty(Collection<String> removeProp) {
        propertyList.removeAll(removeProp);
        return this;
    }

    public boolean hasProperty(String prop) {
        return propertyList.contains(prop);
    }

    public boolean isEmpty() {
        return propertyList.isEmpty();
    }

    public HashSet listProperties() {
        return propertyList;
    }

}
