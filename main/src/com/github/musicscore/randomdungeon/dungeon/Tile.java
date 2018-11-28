package com.github.musicscore.randomdungeon.dungeon;

import java.util.ArrayList;
import java.util.List;

// TODO: Refine this class in general. It's a mess.

public class Tile {

    public enum Type {
        VOID,
        WALL,
        FLOOR
    }

    public enum Property {
        TO_PREVIOUS_FLOOR,
        TO_NEXT_FLOOR,
        DOOR_NORTH,
        DOOR_SOUTH,
        DOOR_EAST,
        DOOR_WEST,
        POISON_TRAP,
        CONFUSION_TRAP
    }

    // TODO: Figure out how to include obstacles without bloating the Tile class
    private ArrayList<String> specialProperties;
    private Type type;
    private Property property;
    // 0 = no walls
    // TODO: Figure out a way to calculate the sides of the tile and its various properties.
    //   For FLOOR tiles: denote which sides are walls and whether or not the walls are breakable
    //   For WALL tiles: denote which sides are visible and should be rendered. Should not be breakable.
    private byte faces = 0;

    //==============================================
    // Constructors
    //==============================================

    /**
     * Creates a new Tile object with a specific Type.
     * @param type The Type of the tile.
     */
    public Tile(Type type) {
        this.type = type;
    }


    //==============================================
    // Instance methods
    //==============================================

    /**
     * Sets the tile's Type.
     * @param type The new Type.
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Returns the Type of the Tile object.
     * @return The Type of the Tile object.
     */
    public Type getType() {
        return type;
    }

    /**
     * Returns the Property of the Tile.
     * @return Returns the Property of the Tile.
     */
    public Property getProperty() {
        return property;
    }

    /**
     * Assigns a TileProp object to the tile.
     * @param newProp The TileProp object to add to the tile.
     */
    public void setTileProp(Property newProp) {
        property = newProp;
    }

    /**
     * Returns a List of special properties assigned to the Tile.
     * @return A List of the Tile's properties.
     */
    public List<String> getSpecialProperties() {
        return specialProperties;
    }

    /**
     * Adds a special property to the Tile. This does not guarantee a change in the Tile's behavior.
     * @param property The property to add to the Tile.
     * @return Returns true if the property was successfully added, or false if the property could not be added.
     */
    public boolean addSpecialProperty(String property) {
        return specialProperties.add(property);
    }

    /**
     * Removes a special property from the Tile. This does not guarantee a change in the Tile's behavior.
     * @param property The property to remove from the Tile.
     * @return Returns true if the property was successfully removed, or false if the property could not be removed.
     */
    public boolean removeSpecialProperty(String property) {
        return specialProperties.remove(property);
    }

}
