package com.nhnacademy;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Canvas;

public class Main {
    static class MyCanvas extends Canvas{
        @Override
        public void paint(Graphics g){
            int x = 10;
            int y = 10;
            int count = 0;
            int recWidth = 5;
            int recHeight = 5;
            while(count < 10){
                g.drawRect(x,y,recWidth,recHeight);
                x += 20;
                y += 20;
                recWidth += 5;
                recHeight += 5;
    
                count++;
            }

        }
    }
    public static void main(String[] args) throws Exception {
        Frame frame = new Frame("Frame demo 1");
        int width = 400;
        int height = 300;
        
        frame.setSize(width,height);
        frame.add(new MyCanvas());
        frame.setVisible(true);

        
        
    }
}