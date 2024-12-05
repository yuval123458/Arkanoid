package arkanoid.game.gamePlay;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Score indicator class is responsible of keeping score of the player.
 */
public class ScoreIndicator implements Sprite {

    private Counter score;

    /**
     * constructor method.
     * @param score initial score counter.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    @Override
    public void drawOn(DrawSurface d) {

        d.setColor(Color.WHITE);

        d.fillRectangle(0, 0, 800, 20);

        d.setColor(Color.BLACK);

        int x = 400;
        int y = 15;
        String text = "Score: " + score.getValue();
        d.drawText(x, y, text, 15);
    }

    @Override
    public void timePassed() { }
}
