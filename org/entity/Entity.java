package org.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public abstract class Entity {
    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected float dx;
    protected float dy;
    protected Rectangle2D.Float bounds;
    protected Color color;
    protected boolean visible;

    public Entity(float x, float y, float width, float height, Color color, boolean visible) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dx = 0;
        this.dy = 0;
        this.bounds = new Rectangle2D.Float(x, y, width, height);
        this.color = color;
        this.visible = visible;
    }

    public abstract void render(Graphics2D g);

    public abstract void update();

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getWidth() {
        return width;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isCollision(Rectangle2D r) {
        return bounds.intersects(r);
    }
}
