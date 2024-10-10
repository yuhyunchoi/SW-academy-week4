package com.nhnacademy;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ball {
    static final Color DEFAULT_COLOR = Color.BLACK;
    static Logger log = LogManager.getLogger(Ball.class);
  
    Rectangle region;
    Color color;

    public Ball(int x, int y, int radius){
        this(x, y, radius, DEFAULT_COLOR);
    }
    public Ball(int x, int y, int radius, Color color){
        if(radius < 0){
            throw new IllegalArgumentException();
        }

        this.region = new Rectangle(x - radius, y - radius, 2*radius,2*radius);
        this.color = color;
    }    

    public Point getLocation(){
        return new Point((int) region.getCenterX(), (int) region.getCenterY());
    }

    public int getX(){
        return (int) region.getCenterX();
    }

    public int getY(){
        return (int) region.getCenterY();
    }

    public int getRadius(){
        return (int)(region.getWidth()/2);
    }
    public int getMaxX(){
        return (int)region.getMaxX();
    }

    public int getMinX(){
        return (int)region.getMinX();
    }

    public int getMaxY(){
        return (int)region.getMaxY();
    }

    public int getMinY(){
        return (int)region.getMinY();
    }

    public Color getColor(){
        return color;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(getX() - getRadius(), getY() - getRadius(), 2*getRadius(), 2*getRadius());
    }

  
}
