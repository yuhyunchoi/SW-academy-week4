package com.nhnacademy;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    static final int FRAME_WIDTH = 1000;
    static final int FRAME_HEIGHT = 600;
    static final int DT = 10;
    static final int STATIC_BOX_COUNT = 7;
    static final int BOX_MIN_WIDTH = 10;
    static final int BOX_MAX_WIDTH = 100;
    static final int BOX_MIN_HEIGHT = 10;
    static final int BOX_MAX_HEIGHT = 100;
    static final int MOVABLE_BALL_COUNT = 2;
    static final int BALL_MIN_RADIUS = 5;
    static final int BALL_MAX_RADIUS = 30;
    static final int BALL_MIN_SPEED = 1;
    static final int BALL_MAX_SPEED = 5;
    public static void main(String[] args) {
        Logger log = LogManager.getLogger("main");

        Random random = new Random();

        JFrame frame = new JFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        BoundedWorld world = new BoundedWorld();
        frame.add(world);
        frame.setVisible(true);

        world.setDT(DT);
        world.setMaxMoveCount(0);
       
        int createdBoxCount = 0;
        while(createdBoxCount < STATIC_BOX_COUNT) {
            int width = BOX_MIN_WIDTH + random.nextInt(BOX_MAX_WIDTH - BOX_MIN_WIDTH);
            int height = BOX_MIN_HEIGHT + random.nextInt(BOX_MAX_HEIGHT - BOX_MIN_HEIGHT);
            int x = width / 2 + random.nextInt(world.getWidth() - width);
            int y = height / 2 + random.nextInt(world.getHeight() - height);

            PaintableBox paintableBox = new PaintableBox(x, y, width, height, Color.RED, world);
            
            world.add(paintableBox);
            Thread threadBox = new Thread(paintableBox);
            threadBox.start();
            createdBoxCount++;
            
        }
        System.out.println(STATIC_BOX_COUNT + "개의 박스 생성완료");

   
        int createdBallCount = 0;
        while (createdBallCount < MOVABLE_BALL_COUNT) {
            int radius = BALL_MIN_RADIUS + random.nextInt(BALL_MAX_RADIUS - BALL_MIN_RADIUS);
            int x1 = radius + random.nextInt(world.getWidth() - 2 * radius);
            int y1 = radius + random.nextInt(world.getHeight() - 2 * radius);

            MovableBall ball = new MovableBall(x1, y1, radius, Color.GREEN, world);

            int dx = (random.nextInt() % 2 == 0 ? -1 : 1)
                    * (BALL_MIN_SPEED + random.nextInt(BALL_MAX_SPEED - BALL_MIN_SPEED));
            int dy = (random.nextInt() % 2 == 0 ? -1 : 1)
                    * (BALL_MIN_SPEED + random.nextInt(BALL_MAX_SPEED - BALL_MIN_SPEED));
            ball.setMotion(new PositionalVector(dx, dy));
            world.add(ball);

            createdBallCount++;
        }
        

       
        world.run();
    }
}