package arkanoid.game.gamePlay;

import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.List;


/**
 * GameFlow class is used to control all the game from a higher
 * level, control the running of each level, stop running levels,
 * on some occasions.
 */
public class GameFlow {

    private KeyboardSensor ks;
    private AnimationRunner ar;
    private GUI gui;
    private Counter scoreTracker;

    /**
     *
     * @param ar AnimationRunner object to run each level animation.
     * @param ks keyboard sensor
     * @param gui GUI object to play on.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui) {
        this.ks = ks;
        this.ar = ar;
        this.gui = gui;
        this.scoreTracker = new Counter(0);
    }

    /**
     * a method to control the running of the levels.
     * stop the running, and showing different screens for different occasions.
     * @param levels list of all levels to run.
     */
    public void runLevels(List<LevelInformation> levels) {

        int framesPerSecond = 60;
        this.ar = new AnimationRunner(framesPerSecond, gui);

        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.ks, this.ar, this.scoreTracker);
            level.initialize();

            while (level.getRemainingBalls() > 0
            && level.getRemainingBlocks() > 0) {
                level.run();
            }
            if (level.getRemainingBalls() == 0) {
                this.ar.run(new KeyPressStoppableAnimation(this.ks, KeyboardSensor.SPACE_KEY,
                        new GameOverScreen(this.ks, this.scoreTracker)));
                this.gui.close();
                break;
            }
        }
        this.ar.run(new KeyPressStoppableAnimation(this.ks, KeyboardSensor.SPACE_KEY,
                new YouWinScreen(this.ks, this.scoreTracker)));
        this.gui.close();
    }
}
