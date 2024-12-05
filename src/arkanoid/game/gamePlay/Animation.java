package arkanoid.game.gamePlay;
import biuoop.DrawSurface;


/**
 * Animation interface is responsible for all animations,
 * and their two main method of should stop the animation
 * and do one frame of the animation.
 */
public interface Animation {

    /**
     * draw a single frame of the given animation.
     * @param d the draw surface to draw the frame one.
     */
    void doOneFrame(DrawSurface d);


    /**
     * @return true - if the animation should stop
     * false - otherwise.
     */
    boolean shouldStop();
}
