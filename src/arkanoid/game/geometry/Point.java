
package arkanoid.game.geometry;


/**
 * Point class is creating and handling points the are defined by
 * x and y location.
 */
public class Point {

    private double x;
    private double y;

    /**
     * Constructor method for a new point.
     * @param x x location for the point.
     * @param y y location for the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * the method use's distance formula between points and returns it.
     * @param other another point to check distance to.
     * @return distance between two points.
     */
    public double distance(Point other) {
        double deltaX = Math.pow((other.getX()) - this.x, 2);
        double deltaY = Math.pow((other.getY()) - this.y, 2);
        return Math.sqrt((deltaX + deltaY));
    }

    /**
     * the method compares between the x and y of the two points.
     * @param other other point to check equality with.
     * @return true for equal points. false otherwise.
     */
    public boolean equals(Point other) {
        return other.getX() == this.x && other.getY() == this.y;
    }

    /**
     * @return the x location of the point.
     */
    public double getX() {
        return this.x;
    }
    /**
     * @return the y location of the point.
     */
    public double getY() {
        return this.y;
    }

    /**
     * set the x attribute of the obbject.
     * @param x a new x location to set the point to.
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * set the y attribute of the obbject.
     * @param y a new y location to set the point to.
     */
    public void setY(double y) {
        this.y = y;
    }
}