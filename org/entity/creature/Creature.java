package org.entity.creature;

import java.awt.Graphics2D;
import java.awt.Color;

import org.entity.Entity;
import org.dimensions.Dimensions;

public class Creature extends Entity {
    protected CreatureDirection direction;

    public Creature(float x, float y, float width, float height, Color color, boolean visible) {
        super(x, y, width, height, color, visible);
        direction = CreatureDirection.STOP;
    }

    @Override
    public void render(Graphics2D g) {
        if (visible) {
            g.setColor(color);
            g.fillRect((int)x, (int)y, (int)width, (int)height);
        }
    }

    @Override
    public void update() {
        x += dx;
        y += dy;
    }

    public void setDirectionNum(int value) {
        this.direction = CreatureDirection.getValue(value);
    }

    public int getDirectionNum() {
        return direction.getValue();
    }

    public void setDirection(CreatureDirection direction) {
        this.direction = direction;
    }

    public CreatureDirection getDirection() {
        return direction;
    }

    public boolean isOutOfScreen() {
        return (x < 0 || x >= Dimensions.SCREEN_WIDTH) ||
               (y < 0 || y >= Dimensions.SCREEN_HEIGHT);
    }
}
