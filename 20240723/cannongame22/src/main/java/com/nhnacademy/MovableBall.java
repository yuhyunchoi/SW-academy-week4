package com.nhnacademy;

import java.awt.Color;
import java.util.List;

public class MovableBall extends PaintableBall implements Movable {
    private Vector motion = new PositionalVector(0,0);
    private BoundedWorld world = new BoundedWorld();

    public MovableBall(int x, int y, int radius, Color color, BoundedWorld world){
        super(x, y, radius, color);
        this.world = world;
    }
    public MovableBall(int x, int y, int radius, BoundedWorld world){
        super(x, y, radius);
        this.world = world;
    }

    public int getDX(){
        return motion.getDX();
    }

    public int getDY(){
        return motion.getDY();
    }

    public void setDX(int dx){
        motion = new PositionalVector(dx, motion.getDY());
    }

    public void setDY(int dy){
        motion = new PositionalVector(motion.getDX(), dy);
    }

    public Vector getMotion(){
        return motion;
    }
    public void setMotion(Vector motion){
        this.motion = motion;
    }
    
    public void move(){
        region.translate(motion.getDX(), motion.getDY());
    }

    public void moveTo(int x, int y){
        region.setLocation(x,y);
        log.debug("Move to {}, {}", x,y);
    }

    @Override
    public void run() {
        while (true) {
            move();
            checkCollision();
            System.out.printf("MovableBall at (%d, %d) - Thread ID: %d%n", getLocation().getX(), getLocation().getY(), Thread.currentThread().getId());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
        }
    }

    private void checkCollision(){
        List<Regionable> objects = world.getRegionables();
        for(Regionable other : objects){
            if(this != other && intersects(other)){
                handleCollision(other);
            }
        }

    }
    private void handleCollision(Regionable other){
        if(other instanceof PaintableBox){
            other.remove();
        }
        else{
            Vector motion = getMotion();
            motion.turnDX();
            motion.turnDY();
            setMotion(motion);
        }
        
    }
}

