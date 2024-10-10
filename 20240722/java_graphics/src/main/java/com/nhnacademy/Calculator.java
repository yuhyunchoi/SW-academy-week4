package com.nhnacademy;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculator {
    class ButtonConfig{
        String title;
        int x;
        int y;
        int width;
        int height;

        public ButtonConfig(String title, int x, int y){
            this.title = title;
            this.x = x;
            this.y = y;
            width = 1;
            height = 1;
        }
        
    }
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;

        frame.setTitle("Calculator");
        frame.setSize(500,500);

        frame.setLayout(new GridBagLayout());

        JTextField textField = new JTextField();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        frame.add(textField, constraints);

        constraints.gridwidth = 1;
        JButton button7 = new JButton("7");
        constraints.gridx = 0;
        constraints.gridy = 1;
        frame.add(button7, constraints);
        button7.addActionListener(e -> {
            System.out.println( ((JButton) e.getSource()).getText() );
            textField.setText(textField.getText() + "7");
        });

        JButton button8 = new JButton("8");
        constraints.gridx = 1;
        constraints.gridy = 1;
        frame.add(button8, constraints);
        button8.addActionListener(e -> {
            System.out.println( ((JButton) e.getSource()).getText() );
            textField.setText(textField.getText() + "8");
        });
        
        JButton button9 = new JButton("9");
        constraints.gridx = 2;
        constraints.gridy = 1;
        frame.add(button9, constraints);
        button9.addActionListener(e -> {
            System.out.println( ((JButton) e.getSource()).getText() );
            textField.setText(textField.getText() + "9");
        });

        JButton buttonPlus = new JButton("+");
        constraints.gridx = 3;
        constraints.gridy = 1;
        frame.add(buttonPlus, constraints);  

        JButton button4 = new JButton("4");
        constraints.gridx = 0;
        constraints.gridy = 2;
        frame.add(button4, constraints);
        button4.addActionListener(e -> {
            System.out.println( ((JButton) e.getSource()).getText() );
            textField.setText(textField.getText() + "4");
        });

        JButton button5 = new JButton("5");
        constraints.gridx = 1;
        constraints.gridy = 2;
        frame.add(button5, constraints);
        button5.addActionListener(e -> {
            System.out.println( ((JButton) e.getSource()).getText() );
            textField.setText(textField.getText() + "5");
        });

        JButton button6 = new JButton("6");
        constraints.gridx = 2;
        constraints.gridy = 2;
        frame.add(button6, constraints);
        button6.addActionListener(e -> {
            System.out.println( ((JButton) e.getSource()).getText() );
            textField.setText(textField.getText() + "6");
        });

        JButton buttonMinus = new JButton("-");
        constraints.gridx = 3;
        constraints.gridy = 2;
        frame.add(buttonMinus, constraints);


        JButton button1 = new JButton("1");
        constraints.gridx = 0;
        constraints.gridy = 3;
        frame.add(button1, constraints);
        button1.addActionListener(e -> {
            System.out.println( ((JButton) e.getSource()).getText() );
            textField.setText(textField.getText() + "1");
        });

        JButton button2 = new JButton("2");
        constraints.gridx = 1;
        constraints.gridy = 3;
        frame.add(button2, constraints);
        button2.addActionListener(e -> {
            System.out.println( ((JButton) e.getSource()).getText() );
            textField.setText(textField.getText() + "2");
        });

        JButton button3 = new JButton("3");
        constraints.gridx = 2;
        constraints.gridy = 3;
        frame.add(button3, constraints);
        button3.addActionListener(e -> {
            System.out.println( ((JButton) e.getSource()).getText() );
            textField.setText(textField.getText() + "3");
        });

        JButton buttonMultiply = new JButton("*");
        constraints.gridx = 3;
        constraints.gridy = 3;
        frame.add(buttonMultiply, constraints);

        JButton button0 = new JButton("0");
        constraints.gridx = 0;
        constraints.gridy = 4;
        frame.add(button0, constraints);
        button0.addActionListener(e -> {
            System.out.println( ((JButton) e.getSource()).getText() );
            textField.setText(textField.getText() + "0");
        });

        JButton buttonAC = new JButton("AC");
        constraints.gridx = 1;
        constraints.gridy = 4;
        frame.add(buttonAC, constraints);


        JButton buttonEqual = new JButton("=");
        constraints.gridx = 2;
        constraints.gridy = 4;
        frame.add(buttonEqual, constraints);

        JButton buttonDivide = new JButton("/");
        constraints.gridx = 3;
        constraints.gridy = 4;
        frame.add(buttonDivide, constraints);

        

        frame.setVisible(true);
    }
}
