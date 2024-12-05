package arkanoid.game.gamePlay;
import arkanoid.game.geometry.Velocity;
import java.util.List;

/**
 * LevelInformation interface is used to to conntrol differennt levels and,
 * their specif information for their level, such as number of balls, blocks,
 * size of the paddle and more.
 */
public interface LevelInformation {

    /**
     * @return the number of balls.
     */
    int numberOfBalls();

    /**
     * @return the ball's velocites.
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return the paddle speed of the level.
     */
    int paddleSpeed();

    /**
     * @return paddle's width of the level.
     */
    int paddleWidth();

    /**
     * @return starting position of the paddle.
     */
    int paddleStartingX();

    /**
     * @return the level's name.
     */
    String levelName();

    /**
     * @return the background drawing of a level.
     */
    Sprite getBackground();

    /**
     * @return list of all blocks in the level.
     */
    List<Block> blocks();

    /**
     * @return number of blocks to remove and to listenn too for a changinng
     * of levels.
     */
    int numberOfBlocksToRemove();
}
