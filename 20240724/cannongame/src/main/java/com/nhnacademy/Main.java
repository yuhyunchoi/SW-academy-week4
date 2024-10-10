package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 600); // 프레임 크기를 800x600으로 설정합니다.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 클릭 시 프로그램 종료

        BoundedWorld world = new BoundedWorld();
        world.setBounds(new Rectangle(0, 0, 800, 600)); // 월드 경계를 프레임 크기에 맞게 설정

        // PaintableBall 객체 5개 생성 및 추가
        for (int i = 0; i < 5; i++) {
            PaintableBall paintableBall = new PaintableBall(50 + i * 100, 100 + i * 50, 30, Color.BLUE);
            world.add(paintableBall);
        }

        // MovableBall 객체 5개 생성 및 추가
        for (int i = 0; i < 5; i++) {
            MovableBall movableBall = new MovableBall(20 + i * 150, 20 + i * 50, 20, Color.GREEN);
            movableBall.setDX(5 + i * 2);
            movableBall.setDY(3 + i);
            world.add(movableBall);
        }

        // MovableBox 객체 5개 생성 및 추가
        for (int i = 0; i < 5; i++) {
            Point location = new Point(100 + i * 100, 300 + i * 50);
            MovableBox movableBox = new MovableBox(location, 50, 50, Color.RED);
            movableBox.setMotion(new Motion(5 + i, 3 + i * 2));
            world.add(movableBox);
        }

        frame.add(world);
        frame.setVisible(true);

        world.setDT(50); // 움직임의 시간 간격 설정 (밀리초 단위)
        world.setMaxMoveCount(1000); // 최대 움직임 횟수 설정

        world.run(); // 월드 실행
    }
    
}
