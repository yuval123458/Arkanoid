package arkanoid.game.gamePlay;
import biuoop.DrawSurface;

/**
 * Drawings interface is used to control all drawings,
 * the backgrounds of the levels.
 */
public interface Drawings {

    /**
     * the method is used to draw a drawing on the draw surface.
     * @param d the surface to draw on.
     */
    void drawOn(DrawSurface d);
}
