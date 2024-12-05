package arkanoid.game.gamePlay;
import biuoop.DrawSurface;
import java.awt.Color;


/**
 * TargetDrawing is responsible for the first
 * level drawing, a target drawing.
 */
public class TargetDrawing implements Drawings {


    /**
     * constructor method.
     */
    public TargetDrawing() { }

    @Override
    public void drawOn(DrawSurface d) {

        d.setColor(Color.BLUE);
        int x = 380;
        int y = 215;
        for (int i = 0; i < 3; i++) {
            d.drawCircle(x, y, 140 - i * 40);
        }
        d.drawLine(220, 215, 360, 215);
        d.drawLine(380, 235, 380, 380);
        d.drawLine(220, 215, 540, 215);
        d.drawLine(380, 35, 380, 395);
    }
}

