package com.nhnacademy;

public class Point {
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point(Point other){
        x = other.getX();
        y = other.getY();
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    void setX(int x){
        this.x = x;
    }

    void setY(int y){
        this.y = y;
    }

    public void move(Motion motion){
        moveTo(getX() + motion.getDX(), getY() + motion.getDY());
    }

    public void moveTo(int x, int y){
        setX(x);
        setY(y);
    }

    public static int distance (Point point1, Point point2){
        return (int) Math.sqrt(Math.pow((double) point1.getX() - point2.getX(), 2)
            + Math.pow((double) point1.getY() - point2.getY(), 2));

    }
    @Override
    public String toString(){
        return "[" + x + ", " + y + "]";
    }
}
