package arkanoid.game.gamePlay;

import biuoop.KeyboardSensor;
import biuoop.DrawSurface;

import java.awt.Color;


/**
 * PauseScreen class is responsible of showing a pause screen when the player is pressing p
 * the player can continue playing by pressing space.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * @param k keyboard sensor object for key detection.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.BLACK);
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }
    @Override
    public boolean shouldStop() {
        return this.stop; }
}
