

package arkanoid.game.gamePlay;
import arkanoid.game.geometry.Point;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import arkanoid.game.geometry.Velocity;

/**
 * GameLevel class, is responsible for handling all lists of sprites and
 * collidables, creates and runs a new game.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter remainingBlocks;
    private Counter remainingBalls;
    private Counter scoreTracker;
    private boolean running;
    private AnimationRunner runner;
    private KeyboardSensor keyboard;
    private LevelInformation level;

    /**
     * @param level a given level to play, with all required information.
     * @param ks keyboard sensor to sense key pressing.
     * @param ar Animation runner object to run the animation with.
     * @param scoreTracker current game score, to modify.
     */
    public GameLevel(LevelInformation level, KeyboardSensor ks, AnimationRunner ar, Counter scoreTracker) {
        this.sprites = new SpriteCollection();
        List<Collidable> list = new ArrayList<>();
        this.environment = new GameEnvironment(list);
        this.level = level;
        this.keyboard = ks;
        this.runner = ar;
        this.scoreTracker = scoreTracker;
    }

    /**
     * adds new collidabble to collidables list.
     * @param c a collidable to be added.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * adds a new sprite to sprite's list.
     * @param s new sprite to be added.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }


    /**
     * initialize a new game, create a new board walls and a default blocks,
     * and two balls. a new screen that is 800x600 with blue background.
     * two white balls, and four walls that surround the game screen.
     */
    public void initialize() {
        this.sprites.addSprite(this.level.getBackground());
        this.remainingBalls = new Counter(this.level.numberOfBalls());
        HitListener bl = new BallRemover(this, this.remainingBalls);
        HitListener sl = new ScoreTrackingListener(this.scoreTracker);

        Block b = new Block(new Rectangle(new Point(this.level.paddleStartingX(), 560),
                    this.level.paddleWidth(), 10), Color.GREEN);
        Paddle paddle = new Paddle(b, this.keyboard, this, this.level.paddleSpeed());
        paddle.addToGame(this);

        Sprite scoreIndicator = new ScoreIndicator(this.scoreTracker);
        this.sprites.addSprite(scoreIndicator);
        Sprite levelIndicator = new LevelIndicator(this.level.levelName());
        this.sprites.addSprite(levelIndicator);

        Block topWall = new Block(new Rectangle(new Point(0, 20), 800, 20), Color.GRAY);
        Block leftWall = new Block(new Rectangle(new Point(0, 40), 20, 560), Color.GRAY);
        Block rightWall = new Block(new Rectangle(new Point(780, 40), 20, 560), Color.GRAY);
        Block bottomWall = new Block(new Rectangle(new Point(0, 600), 800, 20), Color.GRAY);

        bottomWall.addHitListener(bl);

        topWall.addToGame(this);
        leftWall.addToGame(this);
        rightWall.addToGame(this);
        bottomWall.addToGame(this);
        this.remainingBlocks = new Counter(this.level.numberOfBlocksToRemove());
        HitListener hl = new BlockRemover(this, this.remainingBlocks);
        List<Block> levelBlocks = this.level.blocks();
        for (Block block : levelBlocks) {
            //add each block.
            block.addHitListener(hl);
            block.addHitListener(sl);
            block.addToGame(this);
        }
    }


    /**
     * The method is used to create all balls from the level information,
     * with the velocities received, on top of the paddle.
     */
    public void createBallsOnTopOfPaddle() {

        Point topCenterOfPaddle = new Point(380, 540);

        List<Velocity> ballVelocities = this.level.initialBallVelocities();
        for (Velocity v : ballVelocities) {
            Ball ball = new Ball(topCenterOfPaddle, 5, Color.WHITE, this.environment);
            ball.setVelocity(v);
            ball.addToGame(this);
        }
    }

    /**
     * run method loops through all lists of objects and add
     * draws them all and notify's them for each iteration.
     */
    public void run() {

        this.createBallsOnTopOfPaddle();

        this.runner.run(new CountdownAnimation(2, 3, this.sprites));

        this.running = true;
        this.runner.run(this);
    }

    /**
     * the method removes the collidable from collidable list.
     * @param c collidable to be removed.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * the method removes the sprite from sprite list.
     * @param s sprite to be removed.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }


    @Override
    public void doOneFrame(DrawSurface d) {

            this.sprites.drawAllOn(d);
            this.sprites.notifyAllTimePassed();

        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard,
                    KeyboardSensor.SPACE_KEY, new PauseScreen(this.keyboard)));
        }
            if (this.remainingBlocks.getValue() == 0) {
                this.scoreTracker.increase(100);
                this.running = false;
            }
            if (this.remainingBalls.getValue() == 0) {
                this.running = false;
            }
    }

    /**
     * @return number of remaining balls in the level.
     */
    public int getRemainingBalls() {
        return this.remainingBalls.getValue();
    }

    /**
     * @return number of remaining blocks on this level.
     */
    public int getRemainingBlocks() {
        return this.remainingBlocks.getValue();
    }
    @Override
    public boolean shouldStop() {
            return !this.running;
    }
}