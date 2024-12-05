

package arkanoid.game.gamePlay;

import java.util.LinkedList;
import java.util.List;
import biuoop.DrawSurface;


/**
 * SpriteCollection is responsile for handling all sprites in the game.
 */
public class SpriteCollection {

    private List<Sprite> list;

    /**
     * constructor method.
     */
    public SpriteCollection() {
        this.list = new LinkedList<>();
    }

    /**
     * add a new sprite to the list.
     * @param s the sprite to add on.
     */
    public void addSprite(Sprite s) {
        this.list.add(s);
    }

    /**
     * the method notifier's all sprites that time passed.
     */
    public void notifyAllTimePassed() {
        List<Sprite> sprites = new LinkedList<>(this.list);
        for (Sprite s: sprites) {
            s.timePassed();
        }
    }

    /**
     * call drawOn on all sprites in the list.
     * @param d surface to draw on.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s: this.list) {
            s.drawOn(d);
        }
    }

    /**
     * remove the sprite from sprite's list.
     * @param s the sprite to remove.
     */
    public void removeSprite(Sprite s) {
        this.list.remove(s);
    }
}
