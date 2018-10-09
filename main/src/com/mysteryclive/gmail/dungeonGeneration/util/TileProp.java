package com.mysteryclive.gmail.dungeonGeneration.util;

public enum TileProp {
    TO_PREVIOUS_FLOOR,
    TO_NEXT_FLOOR,
    PLAYER_SPAWN,
    DECORATION,
    CHEST,
    TRAP,
    TREASURE;

    private String propType;

    public String getPropType() {
        return propType;
    }

    public void setPropType(String newPropType) {
        propType = newPropType;
    }

}
