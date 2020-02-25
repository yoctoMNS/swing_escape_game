package org.engine;

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import org.display.Display;
import org.entity.EntityManager;
import org.event.KeyManager;

public class GameManager implements Runnable {
    private boolean running;
    private String title;
    private int width;
    private int height;
    private int scale;

    private Thread gameThread;
    private Display display;
    private BufferStrategy bs;
    private Graphics2D g;
    private EntityManager entityManager;

    private KeyManager keyManager;

    public GameManager(int width, int height, String title) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    public void init() {
        entityManager = new EntityManager();
        keyManager = new KeyManager();
        display = new Display(title, width, height);
        display.getCanvas().addKeyListener(keyManager);
        display.getFrame().addKeyListener(keyManager);
    }

    public synchronized void start() {
        if (running) {
            return;
        }

        running = true;
        gameThread = new Thread(this);
        gameThread.setName("Game Thread");
        gameThread.start();
    }

    public void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = (Graphics2D)bs.getDrawGraphics();

        g.clearRect(0, 0, width, height);

        entityManager.render(g);

        bs.show();
        g.dispose();
    }

    public void update() {
        entityManager.update();
    }

    public boolean isRunning() {
        return running;
    }

    @Override
    public void run() {
        init();

        int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            
            if(delta >= 1){
                update();
                render();
                ticks++;
                delta--;
            }
        }
    }
}
