
package arkanoid.game.gamePlay;
import arkanoid.game.geometry.Line;
import arkanoid.game.geometry.Point;

import java.util.ArrayList;
import java.util.List;


/**
 * GameEnvironment class is responsible for
 * handling all collidable objects.
 */
public class GameEnvironment {

    private List<Collidable> list;

    /**
     * constructor method.
     * @param list initial list for constructor.
     */
    public GameEnvironment(List<Collidable> list) {
        this.list = list;
    }

    /**
     *
     * @return the list of collidable objects.
     */
    public List<Collidable> getList() {
        return this.list;
    }

    /**
     * adds a new collidable.
     * @param c the collidable to add to the list.
     */
    public void addCollidable(Collidable c) {
        this.list.add(c);
    };


    /**
     * remove c from collidable list.
     * @param c collidale to remove.
     */
    public void removeCollidable(Collidable c) {
        this.list.remove(c);
    }


    /**
     * the method calculates the closest collision point that is about to occur.
     * returns point of nearest collision and the object that has been
     * collided with.
     * @param trajectory the line of movement of a ball.
     * @return CollisionInfo object with information of collision.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Point> l = new ArrayList<>();
        List<Collidable> coll = new ArrayList<>();
        // iterate on all collidables and add them to a given list.
        for (Collidable c: this.list) {
            Rectangle rec = c.getCollisionRectangle();
            Point intersection = trajectory.closestIntersectionToStartOfLine(rec);
            if (intersection != null) {
                l.add(intersection);
                coll.add(c);
            }
        }
        if (l.size() == 0) {
            return null;
        }
        Point firstPoint = l.get(0);
        int index = 0;
        // go through on all collision points and get the closest one.
        for (Point p:l) {
            if (trajectory.start().distance(p) < trajectory.start().distance(firstPoint)) {
                firstPoint = p;
                index = l.indexOf(p);
            }
        }
        Collidable c = coll.get(index);
        return new CollisionInfo(firstPoint, c);
    }
}
