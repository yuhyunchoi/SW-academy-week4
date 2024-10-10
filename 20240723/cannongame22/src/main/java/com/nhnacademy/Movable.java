package com.nhnacademy;

public interface Movable extends Regionable, Runnable {
    void setMotion(Vector motion);
    Vector getMotion();
    void move();
    @Override
    void run();
}
