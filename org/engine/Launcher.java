package org.engine;

import org.dimensions.Dimensions;

public class Launcher {
    public static final String GAME_TITLE = "Escape Game";

    public static void main(String... args) {
        GameManager game = new GameManager(Dimensions.SCREEN_WIDTH, Dimensions.SCREEN_HEIGHT, GAME_TITLE);
        game.start();
    }
}
