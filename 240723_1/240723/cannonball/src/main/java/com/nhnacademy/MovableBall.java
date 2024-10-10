package com.nhnacademy;

import java.awt.Color;

public class MovableBall extends PaintableBall implements Movable {
    Vector motion = new PositionalVector(0, 0);

    public MovableBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    public MovableBall(int x, int y, int radius) {
        super(x, y, radius);
    }

    public int getDX() {
        return motion.getDX();
    }

    public int getDY() {
        return motion.getDY();
    }

    public void setDX(int dx) {
        motion = new PositionalVector(dx, motion.getDY());
    }

    public void setDY(int dy) {
        motion = new PositionalVector(motion.getDX(), dy);
    }

    public Vector getMotion() {
        return motion;
    }

    public void setMotion(Vector motion) {
        this.motion = motion;
    }

    public void move() {
        region.translate(motion.getDX(), motion.getDY());
    }

    public void moveTo(int x, int y) {
        region.setLocation(x, y);
        log.debug("Move to {}, {}", x, y);
    }
}
