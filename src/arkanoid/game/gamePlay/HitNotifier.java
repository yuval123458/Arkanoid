package arkanoid.game.gamePlay;


/**
 * hit notifier class is responsible for all notifiers in  the game.
 */
public interface HitNotifier {

    /**
     * the method adds the listener to listeners list.
     * @param hl the listener to be added.
     */
    void addHitListener(HitListener hl);

    /**
     * the method removes the listener from listeners list.
     * @param hl the listener to be removed.
     */
    void removeHitListener(HitListener hl);
}
