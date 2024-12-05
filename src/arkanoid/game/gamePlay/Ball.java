
package arkanoid.game.gamePlay;

import arkanoid.game.geometry.Point;
import arkanoid.game.geometry.Velocity;
import arkanoid.game.geometry.Line;


import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Ball class creates a ball with a given color, size, speed and
 * a point as the centered location.
 * the class can set all the balls attributes, draw and move the ball.
 */
public class Ball implements Sprite {

    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity v;
    private GameEnvironment g;

    /**
     * Construction method for class ball.
     *
     * @param center the center point of the bball
     * @param r      size of the ball as radius
     * @param color  color of the ball
     * @param g      game environment of the ball
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment g) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.g = g;
    }

    /**
     * @param x     x location of the center
     * @param y     y location of the center
     * @param r     size of ball
     * @param color color of the ball
     * @param g     game environment to associated with.
     */
    public Ball(int x, int y, int r, java.awt.Color color, GameEnvironment g) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.g = g;
    }

    /**
     * @param r new radius to set.
     */
    public void setSize(int r) {
        this.r = r;
    }

    /**
     * @return the x parameter of the center
     */
    public int getX() {
        return (int) this.center.getX();
    };

    /**
     * @return the y parameter of the center
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * @return the size parameter of the center
     */
    public int getSize() {
        return this.r;
    }

    /**
     * @return the color parameter of the center
     */
    public java.awt.Color getColor() {
        return this.color;
    }


    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.BLACK);
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
    }

    @Override
    public void timePassed() {
        this.moveOneStep();
    }
    /**
     * adds the ball to list of sprites.
     * @param g the game to be added to/
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }


    /**
     * set the ball's color.
     *
     * @param color color to set the ball's color.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @param v velocity to set the speed of the ball.
     */
    public void setVelocity(Velocity v) {
        this.v = v;
    }


    /**
     * set the velocity as the delta of x, y.
     *
     * @param dx the delta, change at the x axis.
     * @param dy the delta, change at the y axis.
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * @return the ball velocity attribute.
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * @return center of the ball.
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * the moveOneStep method calc and adjusts the ball
     * movement based on collisions.
     */
    public void moveOneStep() {

        double epsilon = 0.0000000001;

        Point p = new Point(this.center.getX(), this.center.getY());

        Line trajectory = new Line(this.center, this.v.applyToPoint(this.center));
        CollisionInfo c = this.g.getClosestCollision(trajectory);


        if (c == null) {
            this.center = this.v.applyToPoint(this.center);
        } else {

            Point collision = c.getCollision();
            Collidable object = c.getObject();

            double newx = collision.getX() - Math.signum(this.v.getDx()) * epsilon;
            double newy = collision.getY() - Math.signum(this.v.getDy()) * epsilon;

            Velocity v = object.hit(this, collision, this.v);
            this.v = v;

            this.center = new Point(newx, newy);
        }
    }

    /**
     * the method removes the ball from sprites list.
     * @param gameLevel gameLevel to be removed from.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }
}
