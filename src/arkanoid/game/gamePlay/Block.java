
package arkanoid.game.gamePlay;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import arkanoid.game.geometry.Point;
import arkanoid.game.geometry.Velocity;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Block class that implements Collidable and Sprite
 * interfaces represents a collidale object in
 * the game.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle r;
    private Color color;
    private List<HitListener> hitListeners;


    /**
     * constructor for new block.
     * @param r the rectangle to shape the block.
     * @param c blocks color.
     */
    public Block(Rectangle r, Color c) {
        this.r = r;
        this.color = c;
        this.hitListeners = new LinkedList<>();
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.r;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();

        if (this.r.getRightWall().containsPoint(collisionPoint)
                || this.r.getLeftWall().containsPoint(collisionPoint)) {
            dx = -1 * dx;
        }
        if (this.r.getTopWall().containsPoint(collisionPoint)
                || this.r.getBottomWall().containsPoint(collisionPoint)) {
            dy = -1 * dy;
        }
        this.notifyHit(hitter);
        return new Velocity(dx, dy);
    }
    @Override
    public void timePassed() { }


    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.r.getUpperLeft().getX(), (int) this.r.getUpperLeft().getY(),
                (int) this.r.getWidth(), (int) this.r.getHeight());

        // draw the black border
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.r.getUpperLeft().getX(), (int) this.r.getUpperLeft().getY(),
                (int) this.r.getWidth(), (int) this.r.getHeight());
    }


    /**
     * add this block to the list of collidables and sprites.
     * @param g the game object to be added to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }


    /**
     * the method notifies all listeners of a hit event.
     * @param hitter the hitting ball.
     */
    private void notifyHit(Ball hitter) {
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);

        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * the method removes the block from sprites and collidable lists.
     * @param gameLevel gameLevel to be removed from.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
    }


    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    };
}
