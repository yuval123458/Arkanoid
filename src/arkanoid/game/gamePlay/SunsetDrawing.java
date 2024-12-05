package arkanoid.game.gamePlay;

import java.awt.Color;
import biuoop.DrawSurface;

/**
 * SunsetDrawing class is responnsible of level's
 * two drawign which is sunset like.
 */
public class SunsetDrawing implements Drawings {

    /**
     * unused constructor method.
     */
    public SunsetDrawing() { }

    @Override
    public void drawOn(DrawSurface d) {

        int x = 140;
        int y = 140;

        d.setColor(new Color(237, 231, 182));
        for (int angle = 0; angle < 720; angle += 5) {
            int endX = angle;
            int endY = 260;
            d.drawLine(x, y, endX, endY);
        }

        d.setColor(new Color(237, 231, 182));
        d.drawCircle(x, y, 50);
        d.fillCircle(x, y, 50);
        Color c = new Color(236, 215, 73);
        d.setColor(c);
        d.drawCircle(x, y, 40);
        d.fillCircle(x, y, 40);
        d.setColor(new Color(250, 226, 80));
        d.drawCircle(x, y, 30);
        d.fillCircle(x, y, 30);

    }
}
