
package arkanoid.game.gamePlay;

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The countdownnAnimation class is used to count three seconds backwards,
 * before a given level starts.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private boolean stop;
    private long startTime;
    private SpriteCollection gameScreen;

    /**
     * Constructor method.
     * @param numOfSeconds number of seconds of the count.
     * @param countFrom number to count from.
     * @param gameScreen a gameScreen to count on.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.stop = false;
        this.startTime = System.currentTimeMillis();
        this.gameScreen = gameScreen;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);

        d.setColor(Color.WHITE);
        long t = System.currentTimeMillis() - this.startTime;
        int currentCount = (int) ((this.countFrom + 1)  - (t / (this.numOfSeconds * 1000)));

        // Display count down only when current count is greater than 0
        if (currentCount > 0) {
            d.drawText((d.getWidth() - 40) / 2, d.getHeight() / 2, Integer.toString(currentCount), 32);
        } else {
            this.stop = true;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
