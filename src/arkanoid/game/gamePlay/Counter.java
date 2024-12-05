package arkanoid.game.gamePlay;


/**
 * Counter class is responsible oh holding counts for different aspects
 * of the game.
 */
public class Counter {

    private int remainingBlocks;

    /**
     * @param remainingBlocks of the game.
     */
    public Counter(int remainingBlocks) {
        this.remainingBlocks = remainingBlocks;
    }

    /**
     *
     * @param number number to add to current counter.
     */
    void increase(int number) {
        this.remainingBlocks += number;
    }

    /**
     *
     * @param number to subtract from current counter.
     */
    void decrease(int number) {
        this.remainingBlocks -= number;
    }

    /**
     *
     * @return the remaining amount in counter.
     */
    int getValue() {
        return this.remainingBlocks;
    }
}