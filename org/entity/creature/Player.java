package org.entity.creature;

import java.awt.Color;

import org.event.KeyManager;

public class Player extends Creature {
    public Player(float x, float y, float width, float height, Color color, boolean visible) {
        super(x, y, width, height, color, visible);
    }

    @Override
    public void update() {
        changeDirection();
        move();
        x += dx;
        y += dy;
    }

    private void move() {
        switch (direction) {
        case UP:
            dy -= 0.05;
            break;

        case DOWN:
            dy += 0.05;
            break;

        case LEFT:
            dx -= 0.05;
            break;

        case RIGHT:
            dx += 0.05;
            break;
        }
    }

    private void changeDirection() {
        if (KeyManager.isPressUpKey()) {
            direction = CreatureDirection.UP;
        }
        if (KeyManager.isPressDownKey()) {
            direction = CreatureDirection.DOWN;
        }
        if (KeyManager.isPressLeftKey()) {
            direction = CreatureDirection.LEFT;
        }
        if (KeyManager.isPressRightKey()) {
            direction = CreatureDirection.RIGHT;
        }
    }
}
