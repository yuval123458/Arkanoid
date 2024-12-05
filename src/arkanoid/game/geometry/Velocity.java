
package arkanoid.game.geometry;

/**
 * The velocity class has two attributes, the change in x,
 * and the change in y. the class can add that velocity to a point.
 */
public class Velocity {

    private double dx;
    private double dy;

    /**
     * constructor method for velocity class.
     * @param dx dx - change in x.
     * @param dy dy - change in y.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    };

    /**
     * the method takes a point and add the delta, the change to that point.
     * @param p the point to add the velocity to.
     * @return the changed point.
     */
//    public Point applyToPoint(Point p) {
//        p.setX(p.getX() + this.dx);
//        p.setY(p.getY() + this.dy);
//        return p;
//    };

    public Point applyToPoint(Point p) {
        Point point = new Point(p.getX() + this.dx, p.getY() + this.dy);
//        p.setX(p.getX() + this.dx);
//        p.setY(p.getY() + this.dy);
        return point;
    };
    /**
     * @param dx new dx to set.
     * set new dx.
     */
    public void setDx(double dx) {
        this.dx = dx;
    }

    /**
     * @param dy new dy to set.
     * set new dy.
     */
    public void setDy(double dy) {
        this.dy = dy;
    }

    /**
     * create new velocity from dx, dy.
     * @return a new velocity.
     */
    public Velocity getVelocity() {
        return new Velocity(this.dx, this.dy);
    };

    /**
     * @return the dx attribute.
     */
    public double getDx() {
        return this.dx;
    }
    /**
     * @return the dy attribute.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * the method takes an angle to move a point to. and a new speed.
     * depends on the spot of the angle the method calculates the changes to apply
     * on the velocity.
     * @param angle angle to move to.
     * @param speed speed of the movement.
     * @return new Velocity accordingly.
     */

    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double radians = Math.toRadians(angle);
        double dx = Math.cos(radians) * speed;
        double dy = -Math.sin(radians) * speed;
        return new Velocity(dx, dy);
    }

    /**
     * calculate the speed of the object and return it.
     * @return the speed of this velocity object.
     */
    public double getSpeed() {
        return Math.sqrt(this.dx * this.dx + this.dy * this.dy);
    }
}