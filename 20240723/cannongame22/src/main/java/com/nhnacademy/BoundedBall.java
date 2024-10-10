package com.nhnacademy;

import java.awt.Rectangle;
import java.awt.Color;

public class BoundedBall extends MovableBall {
    private Rectangle bounds;

    public BoundedBall(int x, int y, int radius, Color color, Rectangle bounds, BoundedWorld world){
        super(x, y, radius, color, world);
        this.bounds = bounds;
    }

    public BoundedBall(int x, int y, int radius, BoundedWorld world){
        super(x, y, radius, world);
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public void setBounds(Rectangle bounds){
        this.bounds = new Rectangle();
    }

    public boolean isOutOfBounds(){
        return getMinX() < bounds.getMinX()
            || getMaxX() > bounds.getMaxX()
            || getMinY() < bounds.getMinY()
            || getMaxY() > bounds.getMaxY();
    }

    @Override
    public void move(){
        super.move();

        if(isOutOfBounds()){
            if( (getMinX() < bounds.getMinX()) || (getMaxX() > bounds.getMaxX())){
                setDX(-getDX());
            }
            if( (getMinY() < bounds.getMinY()) || (getMaxY() > bounds.getMaxY())){
                setDY(-getDY());
            }
        }
    }
}
