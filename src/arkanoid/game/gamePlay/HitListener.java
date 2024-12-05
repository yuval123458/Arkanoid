package arkanoid.game.gamePlay;


/**
 * hit listener interface is responsible for all listeners in the game.
 */
public interface HitListener {

    /**
     * the method is responsible to notify the listeners of a hit event.
     * @param beingHit the block that is being hit.
     * @param hitter the hitting ball.
     */
    void hitEvent(Block beingHit, Ball hitter);
}

