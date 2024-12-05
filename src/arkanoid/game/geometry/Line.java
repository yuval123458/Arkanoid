
package arkanoid.game.geometry;
import arkanoid.game.gamePlay.Rectangle;
import java.util.List;

/**
 * Line class creates a new line that is defined by
 * a starting and ending point. the class can check for intersections
 * between lines and return that point of intersection.
 */
public class Line {
    private Point start;
    private Point end;
private static final double THRESHOLD = 0.000000000001;

    /**
     * Constructor method for class Line.
     * @param start the line's starting point.
     * @param end the line's ending point.
     */
    public Line(Point start, Point end) {

        if (end.getX() < start.getX()) {
            this.start = end;
            this.end = start;
        } else {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * Constructor method for a new line.
     * @param x1 x for the starting point
     * @param y1 y for the starting point
     * @param x2 x for ending point
     * @param y2 y for ending point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * the method returns the line's length.
     * @return return the lines length.
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * The method returns the middle point of the line.
     * @return middle point of the line.
     */
    public Point middle() {
        double middleX = (this.start.getX() + this.end.getX()) / 2;
        double middleY = (this.start.getY() + this.end.getY()) / 2;
        return new Point(middleX, middleY);
    }

    /**
     * @return the starting point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * @return the ending point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * isIntersecting method check's if there is a collision between two lines.
     * @param other the line to check the collision with.
     * @return true if the lines collide or false otherwise.
     */


    public boolean overlaps(Line other) {
        double minYThis = Math.min(this.start.getY(), this.end.getY());
        double maxYThis = Math.max(this.start.getY(), this.end.getY());
        double minYOther = Math.min(other.start.getY(), other.end.getY());
        double maxYOther = Math.max(other.start.getY(), other.end.getY());
        double minXThis = Math.min(this.start.getX(), this.end.getX());
        double maxXThis = Math.max(this.start.getX(), this.end.getX());
        double minXOther = Math.min(other.start.getX(), other.end.getX());
        double maxXOther = Math.max(other.start.getX(), other.end.getX());

        // Check if lines overlap in the x-axis
        if (maxXThis < minXOther || minXThis > maxXOther) {
            return false;
        }

        // Check if lines overlap in the y-axis
        if (maxYThis < minYOther || minYThis > maxYOther) {
            return false;
        }

        return true;
    }

    /**
     * the method return true for a intersection or false otherwise.
     * @param other other line to check intersection with.
     * @return true for intersection, false otherwise.
     */
    public boolean isIntersecting(Line other) {

        if (this.equals(other)) {
            return true;
        }
        if (this.start.getX() == other.start.getX()) {
            if (this.start.getY() == other.start.getY()) {
                return true;
            }
        }

        if (this.end.getX() == other.start.getX()) {
            if (this.end.getY() == other.start.getY()) {
                return true;
            }
        }

        if (this.start.getX() == other.end.getX()) {
            if (this.start.getY() == other.end.getY()) {
                return true;
            }
        }
            double slope1 = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
            double slope2 = (other.start.getY() - other.end.getY()) / (other.start.getX() - other.end.getX());

            // check if the slopes are infinite
            if (Double.isInfinite(slope1) || Double.isInfinite(slope2)) {

                double maxYLine = Math.max(this.start.getY(), this.end.getY());
                double maxYOther = Math.max(other.start.getY(), other.end.getY());
                double minYLine = Math.min(this.start.getY(), this.end.getY());
                double minYOther = Math.min(other.start.getY(), other.end.getY());

                if (this.start.getX() < other.start.getX()
                && this.end.getX() > other.end.getX()
                && minYLine < minYOther
                && maxYLine > maxYOther) {
                    return true;
                }

                if (this.start.getX() > other.start.getX()
                        && this.end.getX() < other.end.getX()
                        && minYLine > minYOther
                        && maxYLine < maxYOther) {
                    return true;
                }

                if ((this.start.getX() > other.start.getX()
                        || Math.abs(this.start.getX() - other.start.getX()) < THRESHOLD)
                        && (this.end.getX() < other.end.getX()
                        || Math.abs(this.end.getX() - other.end.getX()) < THRESHOLD)
                        && (minYLine < minYOther || Math.abs(minYLine - minYOther) < THRESHOLD)
                        && (maxYLine > maxYOther || Math.abs(maxYLine - maxYOther) < THRESHOLD)) {
                    return true;
                }
                if (this.overlaps(other)) {
                    return true;
                }
                return false;
            }

            // "treat" the lines as if are infinite, later check for matches in x-axis or y-axis.
            double yIntercept1 = this.start.getY() - slope1 * this.start.getX();
            double yIntercept2 = other.start.getY() - slope2 * other.start.getX();

            double xIntersection = (yIntercept2 - yIntercept1) / (slope1 - slope2);

            double x1 = this.start.getX();
            double x2 = this.end.getX();

            double x3 = other.start.getX();
            double x4 = other.end.getX();


            if ((xIntersection > Math.min(x1, x2)
                    || Math.abs(xIntersection - Math.min(x1, x2)) < THRESHOLD)
                    && (xIntersection < Math.max(x1, x2) || Math.abs(xIntersection - Math.max(x1, x2)) < THRESHOLD)
                    && (xIntersection > Math.min(x3, x4) || Math.abs(xIntersection - Math.min(x3, x4)) < THRESHOLD)
                    && (xIntersection < Math.max(x3, x4)) || Math.abs(xIntersection - Math.max(x3, x4)) < THRESHOLD) {
                return true;
            }
            if (this.inclusive(other)) {
                return true;
            }
        return false;
        }


    /**
     *
     * @param other other line to check inclusion with.
     * @return true if a line is included in another line,
     * or false otherwise.
     */
    public boolean inclusive(Line other) {
            double slope1 = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
            double slope2 = (other.start.getY() - other.end.getY()) / (other.start.getX() - other.end.getX());

            if (slope1 != slope2) {
                return false;
            }
            if (this.start.getX() < other.start.getX()) {
                if (this.end.getY() < other.end.getY()
                && this.end.getY() > other.start.getY()) {
                    return true;
                }
                if (this.end.getY() < other.start.getY()
                && this.end.getY() > other.end.getY()) {
                    return true;
                }
            }
            return false;
        }

    /**
     * intersectionWith method return the point of collision of the is any,
     * if not returns null.
     * @param other the line to return the collision point with.
     * @return point of collision.
     */
    public Point intersectionWith(Line other) {

        if (!this.isIntersecting(other)) {
            return null;
        }
        if (this.inclusive(other)) {
            return null;
        }
        if (this.equals(other)) {
            return null;
        }
        if (this.fullyInclusive(other)) {
            return null;
        }
        if (this.start.equals(other.start) || this.start.equals(other.end)) {
            return this.start;
        }
        if (this.end.equals(other.start) || this.end.equals(other.end)) {
            return this.end;
        }


        double slope1 = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
        double slope2 = (other.start.getY() - other.end.getY()) / (other.start.getX() - other.end.getX());

        if (Math.abs(this.start.getX() - this.end.getX()) < THRESHOLD) {
            double slope = (other.start.getY() - other.end.getY()) / (other.start.getX() - other.end.getX());
            double yIntercept = other.start.getY() - slope * other.start.getX();
            double x = this.start.getX();
            double y = slope * x + yIntercept;
            return new Point(x, y);
        }
        if (Math.abs(other.start.getX() - other.end.getX()) < THRESHOLD) {
            double slope = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
            double yIntercept = this.start.getY() - slope * this.start.getX();
            double x = other.start.getX();
            double y = slope * x + yIntercept;
            return new Point(x, y);
        }

        double yIntercept1 = this.start.getY() - slope1 * this.start.getX();
        double yIntercept2 = other.start.getY() - slope2 * other.start.getX();

        double xIntersection = (yIntercept2 - yIntercept1) / (slope1 - slope2);
        double yIntersection = (slope1 * xIntersection) + yIntercept1;

        return new Point(xIntersection, yIntersection);
    }

    /**
     * calculate if one line completely include the other.
     * @param other other line to check full inclusion with.
     * @return true if one line includes completely the other one.
     */
    public boolean fullyInclusive(Line other) {
        double slope1 = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
        double slope2 = (other.start.getY() - other.end.getY()) / (other.start.getX() - other.end.getX());
        if (slope1 != slope2) {
            return false;
        }
        if (this.start.getX() <= other.start.getX()) {
            if (this.start.getY() <= other.start.getY()) {
                if (this.end.getX() >= other.end.getX()
                && this.end.getY() >= other.end.getY()) {
                    return true;
                }
            }
        }

        if (other.start.getX() <= this.start.getX()) {
            if (other.start.getY() <= this.start.getY()) {
                if (other.end.getX() >= this.end.getX()
                 && other.end.getY() >= this.end.getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * the method checks if two points are equal.
     * @param p1 first point.
     * @param p2 second popint.
     * @return true if are equal or false otherwise.
     */

    static boolean equalPoints(Point p1, Point p2) {
        return Math.abs(p1.getX() - p2.getX()) < THRESHOLD
                && Math.abs(p1.getY() - p2.getY()) < THRESHOLD;
    }

    /**
     * The method checks for two equal lines.
     * @param other the line to check with.
     * @return true if the lines are equal or false otherwise.
     */
    public boolean equals(Line other) {
       if (equalPoints(this.start, other.start)) {
           return equalPoints(this.end, other.end);
       }
       if (equalPoints(this.end, other.start)) {
           return equalPoints(this.start, other.end);
       }
       return false;
    }


    /**
     * if there are couple of intersection points,
     * the method returns the closest one to the start of the line,
     * otherwise returns null.
     * @param rect the rectangle to check intersection with.
     * @return the closest point to the start of line that intersects
     * with the rectangle.
     */
        public Point closestIntersectionToStartOfLine(Rectangle rect) {
            List<Point> list;
            list = rect.intersectionPoints(new Line(this.start, this.end));
            if (list.size() == 0) {
                return null;
            }
            Point point = list.get(0);
            for (Point p : list) {
                if (p.distance(this.start) < point.distance(this.start)) {
                    point = p;
                }
            }
            return point;
        }

    /**
     * Check if the line contains a certain point.
     * @param p the point to check.
     * @return true if the point is on the line, false otherwise.
     */
    public boolean containsPoint(Point p) {

        double startToIntersection = p.distance(this.start);

        double endToIntersection = p.distance(this.end);

        double length = this.length();

        return (Math.abs((startToIntersection + endToIntersection) - length)) < THRESHOLD;
    }

}