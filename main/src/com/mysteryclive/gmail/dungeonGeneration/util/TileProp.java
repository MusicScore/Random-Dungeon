package com.mysteryclive.gmail.dungeonGeneration.util;

public enum TileProp {
    TO_PREVIOUS_FLOOR,
    TO_NEXT_FLOOR,
    PLAYER_SPAWN,
    DECORATION,
    CHEST,
    TRAP,
    TREASURE;

    public enum TREASURE {
        NULL
    }

    public enum CHEST {
        NULL
    }

    public enum TRAP {
        POISON,
        PITFALL
    }

}
