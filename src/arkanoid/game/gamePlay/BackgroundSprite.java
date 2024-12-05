package arkanoid.game.gamePlay;
import java.awt.Color;
import biuoop.DrawSurface;


/**
 * BackGround sprite class is used to draw a background sprite drawing.
 */
public class BackgroundSprite implements Sprite {
    private Color color;
    private Drawings drawings;

    /**
     * constructor method.
     * @param color color of the background.
     * @param drawings a drawing object.
     */
    public BackgroundSprite(Color color, Drawings drawings) {
        this.color = color;
        this.drawings = drawings;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());

        drawings.drawOn(d);
    }

    @Override
    public void timePassed() {
    }
}

