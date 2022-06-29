package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Instructions implements ActionListener {
    JFrame frame;
    BackgroundForInstructionsPanel backgroundForInstructionsPanel;
    JButton startButton;
    JLabel instructionsLabel;
    JLabel startLabel;
    JLabel pauseLabel;
    JLabel playLabel;
    protected final int WIDTH = 525;
    protected final int HEIGHT = 550;
    Instructions(){

        frame = new JFrame();
        frame.setTitle("Flappy Shark");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        backgroundForInstructionsPanel = new BackgroundForInstructionsPanel(new ImageIcon("C:\\Users\\IVO\\IdeaProjects\\IdeaProjects\\FlappyShark\\src\\main\\resources\\backGroundImage.png"));

        instructionsLabel = new JLabel("Welcome to Flappy shark");
        instructionsLabel.setForeground(new Color(255, 135, 10));
        instructionsLabel.setFont(new Font("Ink Free", Font.BOLD, 33));
        instructionsLabel.setBounds(60,35,450,50);

        startLabel = new JLabel("Press \"S\" to start the game, if paused");
        startLabel.setForeground(new Color(255,135,10));
        startLabel.setFont(new Font("Ink Free",Font.BOLD,25));
        startLabel.setBounds(33,107,450,50);

        pauseLabel = new JLabel("Press \"P\" to pause the game");
        pauseLabel.setForeground(new Color(255,135,10));
        pauseLabel.setFont(new Font("Ink Free",Font.BOLD,28));
        pauseLabel.setBounds(60,165,450,50);

        playLabel = new JLabel("Press \"SPACE\" to jump");
        playLabel.setForeground(new Color(255,135,10));
        playLabel.setFont(new Font("Ink Free",Font.BOLD,31));
        playLabel.setBounds(77,235,450,50);

        startButton = new JButton("Start the game");
        startButton.setBounds(175,325,160,70);
        startButton.setFocusable(false);
        startButton.setFont(new Font("Comic Sans",Font.BOLD,18));
        startButton.setForeground(new Color(255, 135, 10));
        startButton.setBackground(new Color(10,120,150));
        startButton.setBorder(BorderFactory.createBevelBorder(0));
        startButton.addActionListener(this);

        ImageIcon icon = new ImageIcon("C:\\Users\\IVO\\IdeaProjects\\IdeaProjects\\FlappyShark\\src\\main\\resources\\icon.png");
        frame.setIconImage(icon.getImage());

        frame.add(instructionsLabel);
        frame.add(startLabel);
        frame.add(pauseLabel);
        frame.add(playLabel);

        frame.add(startButton);
        frame.add(backgroundForInstructionsPanel);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==startButton){
            FlappyShark flappyShark = new FlappyShark();
            frame.setVisible(false);
        }
    }
}
