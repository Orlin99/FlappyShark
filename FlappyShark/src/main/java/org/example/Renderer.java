package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Renderer extends JPanel implements KeyListener, ActionListener {
    Image backGround;
    Image theFish;
    Image theBarrier;
    Image theVoid;
    protected final int WIDTH = 525;
    protected final int HEIGHT = 550;
    final int WALLXVELOCITY = 5;
    final int WALLWIDTH = 50;
    int flappyHeight = HEIGHT / 4;
    int flappyVelocity = 0;
    int flappyAcceleration = 8;
    int flappyImpulse = 1;
    int[] wallX = {WIDTH, WIDTH + WIDTH / 2};
    int[] gapBetweenWalls = {(int) (Math.random() * (HEIGHT - 150)), (int) (Math.random() * (HEIGHT - 100))};
    boolean gameOver = false;
    int score = 0;
    Timer timer = new Timer(40, this);

    public Renderer() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.cyan);
        backGround = new ImageIcon("C:\\Users\\IVO\\IdeaProjects\\IdeaProjects\\FlappyShark\\src\\main\\resources\\backGround.png").getImage();
        theFish = new ImageIcon("C:\\Users\\IVO\\IdeaProjects\\IdeaProjects\\FlappyShark\\src\\main\\resources\\theFish.png").getImage();
        theBarrier = new ImageIcon("C:\\Users\\IVO\\IdeaProjects\\IdeaProjects\\FlappyShark\\src\\main\\resources\\theBarrier.png").getImage();
        theVoid = new ImageIcon("C:\\Users\\IVO\\IdeaProjects\\IdeaProjects\\FlappyShark\\src\\main\\resources\\theVoid.png").getImage();

        this.setFocusable(true);
        this.addKeyListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics g2D = (Graphics) g;
        g2D.drawImage(backGround, 0, 0, null);

        if (!gameOver) {

            drawWall(g);

            g.setColor(new Color(255, 135, 10));
            g.setFont(new Font("Ink Free", Font.BOLD, 20));
            FontMetrics metricsForScore1 = getFontMetrics(g.getFont());
            g.drawString("SCORE: " + score, ((WIDTH - metricsForScore1.stringWidth("SCORE: " + score)) / 2) - 10, g.getFont().getSize()+8);

            logic();
            drawFlappy(g);

        } else {
            g.setColor(new Color(255, 135, 10));
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metricsForScore2 = getFontMetrics(g.getFont());
            g.drawString("SCORE: " + score, (WIDTH - metricsForScore2.stringWidth("SCORE: " + score)) / 2, g.getFont().getSize() + 100);

            g.setColor(new Color(255, 135, 10));
            g.setFont(new Font("Ink Free", Font.BOLD, 55));
            FontMetrics metricsForGameOver = getFontMetrics(g.getFont());
            g.drawString("GAME OVER !", (WIDTH - metricsForGameOver.stringWidth("GAME OVER !")) / 2, HEIGHT - 300);

            g.setColor(new Color(255, 135, 10));
            g.setFont(new Font("Ink Free", Font.BOLD, 31));
            FontMetrics metricsForPressR = getFontMetrics(g.getFont());
            g.drawString("Press \"R\" to restart the game", (WIDTH - metricsForPressR.stringWidth("Press \"R\" to restart the game")) / 2, HEIGHT - 205);
        }
    }

    private void drawFlappy(Graphics g) {
        g.drawImage(theFish, 75, flappyHeight + flappyVelocity, null);
    }

    private void drawWall(Graphics g) {

        for (int i = 0; i < 2; i++) {

            g.drawImage(theBarrier, wallX[i], 0, null);
            g.clearRect(wallX[i], gapBetweenWalls[i], WALLWIDTH, 100);
            g.drawImage(theVoid, wallX[i], gapBetweenWalls[i], null);
        }
    }

    private void logic() {
        for (int i = 0; i < 2; i++) {

            if (wallX[i] <= 100 && wallX[i] + WALLWIDTH >= 100 || wallX[i] <= 75 && wallX[i] + WALLWIDTH >= 75) {
                if ((flappyHeight + flappyVelocity) >= 0 && (flappyHeight + flappyVelocity) <= gapBetweenWalls[i]
                        || (flappyHeight + flappyVelocity + 25) >= gapBetweenWalls[i] + 100 &&
                        (flappyVelocity + flappyVelocity + 25) <= HEIGHT) {
                    gameOver = true;
                }
            }
            if (flappyHeight + flappyVelocity <= 0 || flappyHeight + flappyVelocity + 25 >= HEIGHT) {
                gameOver = true;
            }
            if (1 > wallX[i] + WALLWIDTH) {
                score++;
            }
            if (wallX[i] + WALLWIDTH <= 0) {
                wallX[i] = WIDTH;
                gapBetweenWalls[i] = (int) (Math.random() * (HEIGHT - 150));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        flappyAcceleration += flappyImpulse;
        flappyVelocity += flappyAcceleration;
        wallX[0] -= WALLXVELOCITY;
        wallX[1] -= WALLXVELOCITY;

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == e.VK_SPACE) {
            flappyAcceleration = -10;
        }
        if (code == e.VK_S) {
            timer.start();
        }
        if (code == e.VK_R) {
            timer.stop();
            flappyHeight = HEIGHT / 4;
            flappyVelocity = 0;
            flappyAcceleration = 8;
            wallX[0] = WIDTH;
            wallX[1] = WIDTH + WIDTH / 2;
            gapBetweenWalls[0] = (int) (Math.random() * (HEIGHT - 150));
            gapBetweenWalls[1] = (int) (Math.random() * (HEIGHT - 150));
            gameOver = false;
            score = 0;
            repaint();
        }
        if (code == e.VK_P) {
            timer.stop();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}