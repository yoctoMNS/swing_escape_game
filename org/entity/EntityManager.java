package org.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import org.dimensions.Dimensions;
import org.entity.creature.Player;
import org.entity.creature.Box;

public class EntityManager {
    private ArrayList<Entity> entities;
    private Random r;

    public EntityManager() {
        r = new Random();
        entities = new ArrayList<>();
        init();
    }

    public void init() {
        addEntity(new Player(Dimensions.SCREEN_WIDTH / 2 - Dimensions.PLAYER_WIDTH / 2,
                             Dimensions.SCREEN_HEIGHT / 2 - Dimensions.PLAYER_HEIGHT / 2,
                             Dimensions.PLAYER_WIDTH, Dimensions.PLAYER_HEIGHT,
                             Color.red, true));

        for (int i = 0; i < 50; ++i) {
            addEntity(new Box(r.nextInt(Dimensions.SCREEN_WIDTH - (int)Dimensions.BOX_WIDTH),
                              r.nextInt(Dimensions.SCREEN_HEIGHT - (int)Dimensions.BOX_HEIGHT),
                              Dimensions.BOX_WIDTH, Dimensions.BOX_HEIGHT,
                              Color.white, true));
        }
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void render(Graphics2D g) {
        for (Entity e : entities) {
            e.render(g);
        }
    }

    public void update() {
        for (Entity e : entities) {
            e.update();
        }
    }
}
