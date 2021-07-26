package com.margin.se.LambdaExpressions;

import javax.swing.*;
import java.awt.*;

public class EventListener {
    public static void main(String[] args) {
        JTextField tf = new JTextField();
        tf.setBounds(50, 50, 150, 20);
        JButton button = new JButton("Click");
        button.setBounds(80, 100, 70, 30);

        button.addActionListener(e -> {
            tf.setText("Hello Swing");
        });
        JFrame frame = new JFrame();
        frame.add(tf);
        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(300, 200);

    }
}
