
package arkanoid.game.gamePlay;

import biuoop.DrawSurface;


/**
 * the sprite interface is responsible for all moving objects of the game.
 */
public interface Sprite {
    /**
     * the method draws the sprite on the board.
     * @param d the surface to draw on.
     */
    void drawOn(DrawSurface d);

    /**
     * A method to notify all sprites to move on.
     */
    void timePassed();
}
