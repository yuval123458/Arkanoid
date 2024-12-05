package arkanoid.game.gamePlay;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;


/**
 * KeyPressStoppableAnimation is responsible for handling a key press
 * on some animation screens. such as game over, you win and pause scree.
 */
public class KeyPressStoppableAnimation implements Animation {
    private Animation animation;
    private KeyboardSensor sensor;
    private String key;
    private boolean isAlreadyPressed;
    private boolean stop;

    /**
     * @param sensor keyboard sensor to check key pressig on.
     * @param key given key to listen to a press to.
     * @param animation animation object to run when a key is nnot pressed.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.sensor.isPressed(key)) {
            if (!isAlreadyPressed) {
                this.stop = true;
            }
        } else {
            this.isAlreadyPressed = false;
        }
            this.animation.doOneFrame(d);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
