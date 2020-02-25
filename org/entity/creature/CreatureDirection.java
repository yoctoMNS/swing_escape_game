package org.entity.creature;

public enum CreatureDirection {
    STOP(0),
    UP(1),
    DOWN(2),
    LEFT(3),
    RIGHT(4),
    UP_LEFT(5),
    UP_RIGHT(6),
    DOWN_LEFT(7),
    DOWN_RIGHT(8);

    private int value;

    private CreatureDirection(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CreatureDirection getValue(int value) {
        CreatureDirection[] elements = CreatureDirection.values();

        for (CreatureDirection element : elements) {
            if (element.value == value) {
                return element;
            }
        }

        return null;
    }
}
