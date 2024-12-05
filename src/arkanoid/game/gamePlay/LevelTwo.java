package arkanoid.game.gamePlay;

import arkanoid.game.geometry.Point;
import arkanoid.game.geometry.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * LevelTwo class is responnswible for the first level of the game,
 * initializing number of balls velocities, backGround drawing,
 * and paddle information.
 */
public class LevelTwo implements LevelInformation {
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
     * Constructor method for the level.
     */
    public LevelTwo() {
        this.numberOfBalls = 10;
        List<Velocity> velocityList = new ArrayList<>();
        velocityList.add(new Velocity(-5, -3));
        velocityList.add(new Velocity(-5, -4));
        velocityList.add(new Velocity(-5, -5));
        velocityList.add(new Velocity(-4, -5));
        velocityList.add(new Velocity(-3, -5));
        velocityList.add(new Velocity(3, -5));
        velocityList.add(new Velocity(4, -5));
        velocityList.add(new Velocity(5, -5));
        velocityList.add(new Velocity(5, -4));
        velocityList.add(new Velocity(5, -3));
        this.initialBallVelocities = velocityList;
        this.paddleWidth = 700;
        this.levelName = "Wide Easy";
        this.paddleSpeed = 2;
        Sprite background = new BackgroundSprite(Color.WHITE, new SunsetDrawing());
        this.backGround = background;
        List<Block> blockList = new ArrayList<>();
        this.blocks = blockList;

        int screenWidth = 760;
        int blockWidth = 40;
        int blockHeight = 20;
        int numCols = screenWidth / blockWidth;
        Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.BLACK};

        for (int j = 0; j < numCols; j++) {
            int x = 20 + j * blockWidth;
            int y = 260;

            Color color = colors[(j / 2) % colors.length];

            Rectangle rect = new Rectangle(new Point(x, y), blockWidth, blockHeight);
            Block block = new Block(rect, color);
            this.blocks.add(block);
        }
        this.numberOfBlocksToRemove = 19;
        this.paddleStartingX = 50;
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

