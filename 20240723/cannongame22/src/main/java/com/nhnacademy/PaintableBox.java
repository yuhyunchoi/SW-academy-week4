package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableBox extends Box implements Runnable {
    private BoundedWorld world;

    public PaintableBox(int x, int y, int width, int height, Color color, BoundedWorld world){
        super(x, y, width, height, color);
        this.world = world;
    }
    public PaintableBox(int x, int y, int width, int height){
        super(x,y,width,height);
    }

    @Override
    public void paint(Graphics g){
        if(g == null){
            throw new NullPointerException();
        }

        Color oldColor = g.getColor();
        
        g.setColor(getColor());
        g.fillRect(getMinX(), getMinY(), getWidth(), getHeight());
        g.setColor(oldColor);

    }
    @Override
    public void run() {
        System.out.printf("PaintableBox : (%d, %d) %n", getRegion().getCenterX(), getRegion().getCenterY());
    }

    @Override
    public void remove(){
        world.remove(this);
    }

}
