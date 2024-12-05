
package arkanoid.game.gamePlay;
import arkanoid.game.geometry.Point;
import arkanoid.game.geometry.Velocity;

/**
 * the Collidable interface in in charge of all ojects
 * that can be collided with.
 */
public interface Collidable {
    // Return the "collision shape" of the object.

    /**
     *
     * @return the rectangle that shapes the collidable.
     */
    Rectangle getCollisionRectangle();

    /**
     * the method calcualtes the new velocity for the ball.
     * @param collisionPoint point of collision.
     * @param currentVelocity current ball's velocity.
     * @param hitter the hittign ball.
     * @return updated velocity.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
