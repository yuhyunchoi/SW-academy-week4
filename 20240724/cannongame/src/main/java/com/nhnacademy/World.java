package com.nhnacademy;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class World extends JPanel {
    
    List<Ball> ballList;
    static Logger log = LogManager.getLogger(Ball.class);

    public World(){
        super();
        ballList = new LinkedList<>();
        log.debug("World가 생성되었습니다.");

    }

    public void add(Ball ball){
        if(ball == null){
            throw new NullPointerException();
        }
        ballList.add(ball);
    }

    public void remove(Ball ball){
        if(ball == null){
            throw new NullPointerException();
        }
        ballList.remove(ball);
    }

    public void removeBall(int index){
        ballList.remove(index);
    }

    public int getBallCount(){
        return ballList.size();
    }

    public Ball getBall(int index){
        return ballList.get(index);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        for(Ball ball : ballList){
            if(ball instanceof PaintableBall){
                ((PaintableBall) ball).paint(g);
            }
            else{
                log.debug("{}은 그릴 수 없습니다.", ball);
            }
        }

    }




}
