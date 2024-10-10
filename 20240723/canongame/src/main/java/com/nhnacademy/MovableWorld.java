package com.nhnacademy;


public class MovableWorld extends World {

    public static final int MAX_MOVE_COUNT = 100;
    int moveCount;
    int maxMoveCount;
    int dt;

    public void reset(){
        moveCount = 0;
    }
    
    public void move(){
        for(int i = 0; i < getBallCount(); i++){
            Ball ball = getBall(i);
            if(ball instanceof MovableBall){
                ((MovableBall) ball).move();
            }
        }
        repaint();
        moveCount++;
    }

    public void run(){
        while(maxMoveCount == 0 || moveCount < maxMoveCount){
            move();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }

    public int getMovementCount(){
        return moveCount;
    }

    public int getMaxMoveCount(){
        return maxMoveCount;
    }

    public void setMaxMoveCount(int count){ 
        maxMoveCount = count;
    }

    public void setDT(int dt){
        this.dt = dt;
    }
}
