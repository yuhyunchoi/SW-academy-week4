package com.nhnacademy;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class BoundedWorld extends MovableWorld {
    private List<Regionable> regionables = new ArrayList<>();
    private Rectangle bounds;
    private List<Thread> threadList = new ArrayList<>();

    public BoundedWorld(){
        this.bounds = new Rectangle(0,0,1000,600);
    }

    public void setBounds(Rectangle bounds){
        this.bounds = bounds;
        setSize(bounds.getSize());
    }



    public Rectangle getBounds(){
        return bounds;
    }

    public boolean outOfBounds(Regionable object){
        return (object.getMinX() < getBounds().getMinX()
            || object.getMaxX() > getBounds().getMaxX()
            || object.getMinY() < getBounds().getMinY()
            || object.getMaxY() > getBounds().getMaxY());
    }

    public void bounce(Movable object){
        if(outOfBounds(object)){
            if( (object.getMinX() < getBounds().getMinX()) || (object.getMaxX() > getBounds().getMaxX())){
                object.getMotion().turnDX();
            }
            
            if( (object.getMinY() < getBounds().getMinY()) || (object.getMaxY() > getBounds().getMaxY())){
                object.getMotion().turnDY();
            }
        }
    }
    @Override
    public void add(Regionable regionable){
        regionables.add(regionable);
        if(regionable instanceof Movable){
            Thread thread = new Thread((Runnable) regionable);
            threadList.add(thread);
            thread.start();
        }
        repaint();
    }
    @Override
    public void remove(Regionable regionable){
        regionables.remove(regionable);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Regionable regionable : regionables){
            regionable.paint(g);
        }
    }

    public List<Regionable> getRegionables(){
        return new ArrayList<>(regionablList);
    }

    public int getCount(){
        return regionables.size();
    }

    public Regionable get(int index){
        return regionables.get(index);
    }
    
    @Override
    public void move(){
        super.move();

        for(int i = 0; i < getCount(); i++){ 
            Regionable object = get(i);

            if(object instanceof Movable){
                for(int j = 0; j < getCount(); j++){
                    Regionable other = get(j);

                    if((object != other) && (object.intersects(other))) {
                        Region intersection = object.intersection(other);

                        if(object instanceof MovableBall && other instanceof PaintableBox){
                            ((PaintableBox) other).remove();
                        }
                        if(object.getWidth() < other.getWidth()){
                            if(intersection.getWidth() < object.getWidth()){
                                ((Movable) object).getMotion().turnDX();
                            }

                            if(intersection.getHeight() < object.getHeight()){
                                ((Movable) object).getMotion().turnDY();
                            }
                        }else{
                            if(intersection.getWidth() < other.getWidth()){
                                ((Movable) object).getMotion().turnDX();
                            }

                            if(intersection.getHeight() < other.getHeight()){
                                ((Movable) object).getMotion().turnDY();
                            }
                        }
                    }

                }
            }
        }
        for(int i = 0 ; i < getCount(); i++){
            Regionable object = get(i);
            if(object instanceof Movable){
                bounce((Movable) object);
            }
        }
    }

   

    
}
