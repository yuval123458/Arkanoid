package arkanoid.game.gamePlay;

import biuoop.KeyboardSensor;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * YouWinScreen class is responsible for
 * the winning screen with the players score.
 */
public class YouWinScreen implements Animation {
    private KeyboardSensor keyboard;
    private Counter score;
    private boolean stop;

    /**
     * @param k keyboardSensor to detect pressing with.
     * @param score current players score.
     */
    public YouWinScreen(KeyboardSensor k, Counter score) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.BLACK);
        d.drawText(10, d.getHeight() / 2, "You Win!. Your score is " + this.score.getValue(), 32);
    }
    @Override
    public boolean shouldStop() {
        return this.stop; }
}


