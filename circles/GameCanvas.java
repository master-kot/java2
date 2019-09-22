package circles;

import javax.swing.*;
import java.awt.*;


public class GameCanvas extends JPanel {
    private MainCircles gameWindow;
    private long lastFrameTime;


    GameCanvas(MainCircles gameWindow) {
        this.gameWindow = gameWindow;
    }

    private void backGround(float currentTime) {
        Color color = new Color(
                (int)(currentTime * Math.random() % 255f),
                (int)(currentTime * Math.random() % 255f),
                (int)(currentTime * Math.random() % 255f)
        );
        setBackground(color);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        long currentTime = System.nanoTime();
        float delta = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;

        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        gameWindow.onDrawPanel(this, g, delta);
        backGround(currentTime);
        repaint();
    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }
}