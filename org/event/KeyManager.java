package org.event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    private static boolean upKey;
    private static boolean downKey;
    private static boolean leftKey;
    private static boolean rightKey;

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            upKey = true;
        } else {
            upKey = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            downKey = true;
        } else {
            downKey = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            leftKey = true;
        } else {
            leftKey = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            rightKey = true;
        } else {
            rightKey = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static boolean isPressUpKey() {
        return upKey;
    }

    public static boolean isPressDownKey() {
        return downKey;
    }

    public static boolean isPressLeftKey() {
        return leftKey;
    }

    public static boolean isPressRightKey() {
        return rightKey;
    }
}
