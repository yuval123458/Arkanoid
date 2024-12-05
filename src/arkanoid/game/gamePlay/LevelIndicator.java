package arkanoid.game.gamePlay;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Score indicator class is responsible of keeping score of the player.
 */
public class LevelIndicator implements Sprite {

    private String name;


    /**
     * constructor method.
     * @param name the name of the level.
     */
    public LevelIndicator(String name) {
        this.name = name;
    }

    @Override
    public void drawOn(DrawSurface d) {

//        d.setColor(Color.WHITE);

//        d.fillRectangle(0, 0, 800, 20);

        d.setColor(Color.BLACK);

        int x = 550;
        int y = 15;
        String text = "Level Name: " + name;
        d.drawText(x, y, text, 15);
    }

    @Override
    public void timePassed() { }
}

