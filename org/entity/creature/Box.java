package org.entity.creature;

import java.awt.Color;
import java.util.Random;

import org.dimensions.Dimensions;

public class Box extends Creature {
    private Random random;

    public Box(float x, float y, float width, float height, Color color, boolean visible) {
        super(x, y, width, height, color, visible);
        random = new Random();
        direction = CreatureDirection.getValue(random.nextInt(CreatureDirection.values().length - 2) + 1);
    }

    @Override
    public void update() {
        if (isOutOfScreen()) {
            reset();
        } else {
            move();
            x += dx;
            y += dy;
        }
    }

    private void reset() {
        x = random.nextInt(Dimensions.SCREEN_WIDTH - (int)Dimensions.BOX_WIDTH);
        y = random.nextInt(Dimensions.SCREEN_HEIGHT - (int)Dimensions.BOX_HEIGHT);
        direction = CreatureDirection.getValue(random.nextInt(CreatureDirection.values().length - 2) + 1);
    }

    private void move() {
        switch (direction) {
        case UP:
            dy = -0.5f;
            break;

        case DOWN:
            dy = 0.5f;
            break;

        case LEFT:
            dx = -0.5f;
            break;

        case RIGHT:
            dx = 0.5f;
            break;

        case UP_LEFT:
            dy = -0.5f;
            dx = -0.5f;
            break;

        case UP_RIGHT:
            dy = -0.5f;
            dx = 0.5f;
            break;

        case DOWN_LEFT:
            dy = 0.5f;
            dx = -0.5f;
            break;

        case DOWN_RIGHT:
            dy = 0.5f;
            dx = 0.5f;
            break;
        }
    }
}
