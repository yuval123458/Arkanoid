
package arkanoid.game.gamePlay;
import arkanoid.game.geometry.Point;


/**
 * the CollisionInfo class holds the info for a collision.
 * it holds the object that was collided with,
 * and the x and y of the collision.
 */
public class CollisionInfo {

    private Point collision;
    private Collidable object;


    /**
     * constructor function for the class.
     * @param collision point of collision.
     * @param object object that was collided with.
     */
    public CollisionInfo(Point collision, Collidable object) {
        this.collision = collision;
        this.object = object;
    }

    /**
     *
     * @return point of collision.
     */
    public Point getCollision() {
        return this.collision;
    }

    /**
     *
     * @return object that was collided.
     */
    public Collidable getObject() {
        return this.object;
    }
}
