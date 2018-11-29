package com.github.musicscore.randomdungeon.dungeon.tiles;

import com.github.musicscore.randomdungeon.dungeon.prop.Prop;
import com.github.musicscore.randomdungeon.dungeon.util.Direction;

public class Exit extends Floor {

    private Direction facing;
    private int destination;

    public Exit(int destination, Direction facing) {
        this.destination = destination;
        this.facing = facing;
    }

    public Prop getProp() {
        return null;
    }

    public void setProp(Prop prop) {
        // TODO: Develop some sort of logger to print out readable messages somewhere
    }
}
