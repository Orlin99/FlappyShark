package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlappyShark implements ActionListener {

    public static FlappyShark flappyShark;
    protected final int WIDTH = 525;
    protected final int HEIGHT = 550;
    JFrame frame;
    Timer timer;
    public Renderer renderer;
    public FlappyShark() {

        frame = new JFrame();
        timer = new Timer(20,this);
        renderer = new Renderer();

        frame.add(renderer);
        frame.setTitle("Flappy Shark");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ImageIcon icon = new ImageIcon("C:\\Users\\IVO\\IdeaProjects\\IdeaProjects\\FlappyShark\\src\\main\\resources\\icon.png");
        frame.setIconImage(icon.getImage());

        timer.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        renderer.repaint();
    }
}

