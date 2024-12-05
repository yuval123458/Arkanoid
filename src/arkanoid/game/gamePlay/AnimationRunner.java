package arkanoid.game.gamePlay;

import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;


/**
 * AnimationRunner class is responsible for handling
 * the specific details of running an animation.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;


    /**
     * @param framesPerSecond number of frames to run per second
     * @param gui a GUI object to run the animation on.
     */
    public AnimationRunner(int framesPerSecond, GUI gui) {
        this.framesPerSecond = framesPerSecond;
        this.gui = gui;
    }

    /**
     * run a specific animation on a gui screen.
     * @param animation the animation to run.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            this.sleeper = new Sleeper();
            DrawSurface d = this.gui.getDrawSurface();

            animation.doOneFrame(d);
            gui.show(d);

            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * closeGUI method is used to close a given GUI object.
     */
    public void closeGUI() {
        this.gui.close();
    }
}
