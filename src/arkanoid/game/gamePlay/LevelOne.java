package arkanoid.game.gamePlay;

import arkanoid.game.geometry.Point;
import arkanoid.game.geometry.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * LevelOne class is responnswible for the first level of the game,
 * initializing number of balls velocities, backGround drawing,
 * and paddle information.
 */
public class LevelOne implements LevelInformation {
    private int numberOfBalls;
    private List<Velocity> initialBallVelocities;
    private int paddleWidth;
    private String levelName;
    private Sprite backGround;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;
    private int paddleSpeed;
    private int paddleStartingX;


    /**
     * Constructor method for this level.
     */
    public LevelOne() {
        this.numberOfBalls = 1;
        Velocity v = new Velocity(0, -5);
        List<Velocity> velocityList = new ArrayList<>();
        this.initialBallVelocities = velocityList;
        this.initialBallVelocities.add(v);
        this.paddleWidth = 70;
        this.levelName = "Direct Hit";
        this.paddleSpeed = 10;
        Sprite background = new BackgroundSprite(Color.BLACK, new TargetDrawing());
        this.backGround = background;
        List<Block> blockList = new ArrayList<>();
        this.blocks = blockList;
        Block b = new Block(new Rectangle(new Point(365, 200), 30, 30), Color.RED);
        blockList.add(b);
        this.numberOfBlocksToRemove = 1;
        this.paddleStartingX = 345;
    }

    @Override
    public int numberOfBalls() {
        return this.numberOfBalls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        return this.initialBallVelocities;
    }
    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }
    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }
    @Override
    public String levelName() {
        return this.levelName;
    }
    @Override
    public Sprite getBackground() {
        return this.backGround;
    }
    @Override
    public List<Block> blocks() {
        return this.blocks;
    }
    @Override
    public int numberOfBlocksToRemove() {
        return this.numberOfBlocksToRemove;
    }

    @Override
    public int paddleStartingX() {
        return this.paddleStartingX;
    }
}
