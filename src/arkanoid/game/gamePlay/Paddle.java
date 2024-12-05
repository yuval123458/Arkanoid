
package arkanoid.game.gamePlay;

import arkanoid.game.geometry.Point;
import arkanoid.game.geometry.Velocity;

import biuoop.KeyboardSensor;
import biuoop.DrawSurface;

import java.awt.Color;


/**
 * Paddle class is responsile for all attributes of the
 * controllable paddle of the gameLevel.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Block b;
    private GameLevel gameLevel;
    private int paddleSpeed;
    private static final double EPSILON = 0.0000001;


    /**
     * constructor method for this class.
     * @param b the block that defined the paddle.
     * @param keyboard keyboard sensor.
     * @param gameLevel the gameLevel that holds all objects.
     * @param paddleSpeed the paddles speed.
     */
    public Paddle(Block b, KeyboardSensor keyboard, GameLevel gameLevel, int paddleSpeed) {
        this.b = b;
        this.keyboard = keyboard;
        this.gameLevel = gameLevel;
        this.paddleSpeed = paddleSpeed;
    }

    /**
     * method that is responsible to move the paddle to the left.
     */
    public void moveLeft() {
        Rectangle collision = this.b.getCollisionRectangle();
        double upperLeftX = collision.getUpperLeft().getX();
        if (upperLeftX - this.paddleSpeed >= 20) {
            this.b = new Block(new Rectangle(new Point(upperLeftX - this.paddleSpeed,
                    this.b.getCollisionRectangle().getUpperLeft().getY()),
                            collision.getWidth(), collision.getHeight()), Color.BLACK);
        }
    };


    /**
     * method that is responsible to move the paddle to the right.
     */
    public void moveRight() {

        Rectangle collision = this.b.getCollisionRectangle();
        double upperRightX = collision.getUpperLeft().getX() + collision.getWidth();
        if (upperRightX + this.paddleSpeed <= 780) {
            this.b = new Block(new Rectangle(new Point(collision.getUpperLeft().getX() + this.paddleSpeed,
                    collision.getUpperLeft().getY()), collision.getWidth(), collision.getHeight()), Color.BLACK);
        }
    };

    @Override
    public void timePassed() {
        if (keyboard.isPressed(keyboard.LEFT_KEY)) {
            this.moveLeft();
        }
        if (keyboard.isPressed(keyboard.RIGHT_KEY)) {
            this.moveRight();
        }
    };


    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.GREEN);
        Rectangle rec = this.b.getCollisionRectangle();
        d.drawRectangle((int) rec.getUpperLeft().getX(), (int) rec.getUpperLeft().getY(),
                (int) rec.getWidth(), (int) rec.getHeight());
        d.fillRectangle((int) rec.getUpperLeft().getX(), (int) rec.getUpperLeft().getY(),
                (int) rec.getWidth(), (int) rec.getHeight());
    };


    @Override
    public Rectangle getCollisionRectangle() {
        return this.b.getCollisionRectangle();
    };


    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double topLeftX = this.b.getCollisionRectangle().getUpperLeft().getX();
        double topLeftY = this.b.getCollisionRectangle().getUpperLeft().getY();
        double bottomRightX = topLeftX + this.b.getCollisionRectangle().getWidth();
        double bottomRightY = topLeftY + this.b.getCollisionRectangle().getHeight();

        if (this.b.getCollisionRectangle().getTopWall().containsPoint(collisionPoint)) {


            double width = this.b.getCollisionRectangle().getWidth();
            double area = width / 5;
            int areaOnBoard = (int) ((collisionPoint.getX() - topLeftX) / area) + 1;

            double angle;

            switch (areaOnBoard) {
                case 1:
                    angle = 300;
                    break;
                case 2:
                    angle = 330;
                    break;
                case 3:
                    Velocity v = new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
                    return v;
                case 4:
                    angle = 30;
                    break;
                case 5:
                    angle = 60;
                    break;
                default:
                    // Angle remains the same (to handle potential edge cases)
                    currentVelocity.setDy(-1 * currentVelocity.getDy());
                    return currentVelocity;
            }
            double speed = currentVelocity.getSpeed();
            Velocity v = Velocity.fromAngleAndSpeed(angle, speed);
            if (Math.signum(v.getDy()) > 0) {
                v.setDy(-1 * v.getDy());
            }
            return v;
        }

        if ((Math.abs(collisionPoint.getX() - topLeftX) <= EPSILON
                || Math.abs(collisionPoint.getX() - bottomRightX) <= EPSILON)
                && collisionPoint.getY() >= topLeftY
                && collisionPoint.getY() <= bottomRightY) {
            currentVelocity.setDx(-1 * currentVelocity.getDx());
        }

        return currentVelocity;
    }

    /**
     * adds the paddle to list of collidables and sprites.
     * @param g the gameLevel to add the paddle to.
     */
        public void addToGame(GameLevel g) {
            g.addSprite(this);
            g.addCollidable(this);
        };
    }