package com.nhnacademy;

import java.awt.Color;
import java.awt.Point;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Box implements Regionable {
    static Logger log = LogManager.getLogger(Ball.class);
    
    Region region;
    Color color;
    
    public Box(Point location, int width, int height){
        if((width <= 0) || (height <= 0)
        || ((location.getX() - width / 2.0) > location.getX())
        || ((location.getX() + width / 2.0) < location.getX())
        || ((location.getY() - height / 2.0) > location.getY())
        || ((location.getY() + height / 2.0) < location.getY())){
            throw new IllegalArgumentException();
        }

        region = new Region(location, width, height);
    }    

    public Box(Point location, int width, int height, Color color){
        if((width <= 0) || (height <= 0)
        || ((location.getX() - width / 2.0) > location.getX())
        || ((location.getX() + width / 2.0) < location.getX())
        || ((location.getY() - height / 2.0) > location.getY())
        || ((location.getY() + height / 2.0) < location.getY())){
            throw new IllegalArgumentException();
        }
        region = new Region(location, width, height);
        this.color = color;
        }  

    public boolean isCollision(Region other) {
        return intersects(other);
    }

    public Logger getLogger() {
        return log;
    }

    public Region getRegion() {
        return region;
    }

    @Override
    public Point getLocation() {
        return getRegion().getLocation();
    }

    @Override
    public int getWidth() {
        return getRegion().getWidth();
    }

    @Override
    public int getHeight() {
        return getRegion().getHeight();
    }

    @Override
    public int getMinX() {
        return getRegion().getMinX();
    }

    @Override
    public int getMaxX() {
        return getRegion().getMaxX();
    }

    @Override
    public int getMinY() {
        return getRegion().getMinY();
    }

    @Override
    public int getMaxY() {
        return getRegion().getMaxY();
    }

    @Override
    public boolean intersects(Regionable other) {
        return getRegion().intersects(other);
    }

    @Override
    public Regionable intersection(Regionable other) {
        return getRegion().intersection(other);
    }

}
