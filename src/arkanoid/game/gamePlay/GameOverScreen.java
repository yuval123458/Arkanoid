package arkanoid.game.gamePlay;

import biuoop.KeyboardSensor;
import biuoop.DrawSurface;

import java.awt.Color;


/**
 * GameOverScreen is handling the game over annimation with the score.
 */
public class GameOverScreen implements Animation {
    private KeyboardSensor keyboard;
    private Counter score;
    private boolean stop;

    /**
     * @param k keyboard sensor
     * @param score the current score.
     */
    public GameOverScreen(KeyboardSensor k, Counter score) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.BLACK);
        d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + this.score.getValue(), 32);
    }
    @Override
    public boolean shouldStop() {
        return this.stop; }
}

