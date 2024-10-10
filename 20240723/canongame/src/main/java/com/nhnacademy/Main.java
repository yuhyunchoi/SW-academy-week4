package com.nhnacademy;


import java.awt.Color;

import javax.swing.JFrame;

public class Main{

    public static void main(String[] args)  {
        JFrame frame = new JFrame();
        frame.setSize(400,300);
        
        BoundedWorld world = new BoundedWorld();
        world.add(new PaintableBall(250,100,40,Color.BLUE));
        
        MovableBall MovableBall = new MovableBall(20,20,20,Color.GREEN);
        MovableBall.setDX(20);
        MovableBall.setDY(10);
    
        frame.add(world);
        frame.setVisible(true);
    
        world.add(MovableBall);
        world.setDT(100);
        world.setMaxMoveCount(1000);

        world.run();
    }   
}