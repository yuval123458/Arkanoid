
package arkanoid.game.gamePlay;

import arkanoid.game.geometry.Line;
import arkanoid.game.geometry.Point;

import java.util.ArrayList;
import java.util.List;


/**
 * Rectangle class that builds and handles new and existing rectangles.
 */
    public class Rectangle {

        private Point upperLeft;
        private double width;
        private double height;


    /**
     * constructor method.
     * @param upperLeft upperleft defines upper left corner of the rectangle.
     * @param width the width of the rectangle.
     * @param height the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
            this.upperLeft = upperLeft;
            this.height = height;
            this.width = width;
        };

    /**
     *
     * @return the upper right corner.
     */

        public Point getUpperRight() {
            double x = upperLeft.getX() + width;
            double y = upperLeft.getY();
            return new Point(x, y);
        }

    /**
     *
     * @return bottom left corner.
     */
    public Point getBottomLeft() {
            double x = this.upperLeft.getX();
            double y = this.upperLeft.getY() + this.height;
            return new Point(x, y);
        }

    /**
     *
     * @return bottom right corner.
     */
    public Point getBottomRight() {
            double x = this.upperLeft.getX() + this.width;
            double y = this.upperLeft.getY() + this.height;
            return new Point(x, y);
        }


    /**
     * method calculates based on a given line all
     * the collision poinnts with the rectangle.
     * @param line a line to get all intersection points with.
     * @return a list of all intersection points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
            List<Point> l = new ArrayList<Point>();

            Line topLine = new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                    this.upperLeft.getX() + this.width, this.upperLeft.getY());
            if (line.intersectionWith(topLine) != null) {
                l.add(line.intersectionWith(topLine));
            }

            Line bottomLine = new Line(this.upperLeft.getX(), this.upperLeft.getY() + height,
                    this.upperLeft.getX() + this.width, this.upperLeft.getY() + height);
            if (line.intersectionWith(bottomLine) != null) {
                l.add(line.intersectionWith(bottomLine));
            }

            Line leftLine = new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                    this.upperLeft.getX(), this.upperLeft.getY() + height);
            if (line.intersectionWith(leftLine) != null) {
                l.add(line.intersectionWith(leftLine));
            }

            Line rightLine = new Line(this.upperLeft.getX() + width, this.upperLeft.getY(),
                    this.upperLeft.getX() + width, this.upperLeft.getY() + height);
            if (line.intersectionWith(rightLine) != null) {
                l.add(line.intersectionWith(rightLine));
            }
            return l;
        }

    /**
     *
     * @return the width of the rectangle.
     */
    public double getWidth() {
            return this.width;
        };

    /**
     *
     * @return the height of the rectangle.
     */
        public double getHeight() {
            return this.height;
        };

    /**
     *
     * @return upper left corner of the rectangle.
     */

    public Point getUpperLeft() {
            return this.upperLeft;
        };

    /**
     * @return top wall of the rectangle.
     */
    public Line getTopWall() {
        return new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                this.upperLeft.getX() + this.width, this.upperLeft.getY());
    }

    /**
     * @return bottom wall of the rectangle.
     */
    public Line getBottomWall() {
        return new Line(this.upperLeft.getX(), this.upperLeft.getY() + this.height,
                this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
    }


    /**
     * @return left wall of the rectangle.
     */
    public Line getLeftWall() {
        return new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                this.upperLeft.getX(), this.upperLeft.getY() + this.height);
    }

    /**
     * @return right wall of the rectangle.
     */
    public Line getRightWall() {
        return new Line(this.upperLeft.getX() + this.width, this.upperLeft.getY(),
                this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
    }

}
