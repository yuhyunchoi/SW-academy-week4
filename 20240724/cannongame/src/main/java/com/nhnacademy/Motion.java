package com.nhnacademy;

public class Motion {
    
    int dx;
    int dy;

    Motion(int dx, int dy){
        this.dx = dx;
        this.dy = dy;
    }

    public static Motion createPosition(int x, int y){
        return new Motion(x,y);
    }

    public static Motion createDisplacement(int magnitude, int angle){
        return new Motion(
            (int) (magnitude*Math.cos(Math.toRadians(angle))),
            (int) (magnitude*Math.sin(Math.toRadians(angle)))
        );
    }

    public int getDX(){
        return dx;
    }

    public void setDX(int dx){
        this.dx = dx;
    }

    public int getDY(){
        return dy;
    }

    public void setDY(int dy){
        this.dy = dy;
    }

    public void turnDX(){
        dx = -dx;
    }

    public void turnDY(){
        dy = -dy;
    }

    public int getMagnitude(){
        return (int) Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public int getAngle(){
        if(dx == 0){
            if(dy > 0){
                return 90;
            } else if(dy < 0){
                return -90;
            } else{
                return 0;
            }
        }else if(dy == 0){
            if(dx < 0){
                return 0;
            }
            else if (dx > 0){
                return 180;
            }
        }
        return (int) Math.toDegrees(Math.atan(dy/dx));    
    }

    public void add(Motion other){
        setDX(getDX() + other.getDX());
        setDY(getDY() + other.getDY());
    }

    public void sub(Motion other){
        setDX(getDX() - other.getDX());
        setDY(getDY() - other.getDY());
    }

}
