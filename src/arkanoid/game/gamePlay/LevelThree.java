package arkanoid.game.gamePlay;

import arkanoid.game.geometry.Point;
import arkanoid.game.geometry.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * LevelThree class is responnswible for the first level of the game,
 * initializing number of balls velocities, backGround drawing,
 * and paddle information.
 */
public class LevelThree implements LevelInformation {
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
     * COnstructor method for this level.
     */
    public LevelThree() {
        this.numberOfBalls = 2;
        List<Velocity> velocityList = new ArrayList<>();
        velocityList.add(new Velocity(-4, -4));
        velocityList.add(new Velocity(4, -5));
        this.initialBallVelocities = velocityList;
        this.paddleWidth = 70;
        this.levelName = "Green 3";
        this.paddleSpeed = 10;
        Sprite background = new BackgroundSprite(new Color(69, 128, 42), new TowerDrawing());
        this.backGround = background;
        List<Block> blockList = new ArrayList<>();
        this.blocks = blockList;


        int numRows = 5;
        int numCols = 10;

        int blockWidth = 40;
        int blockHeight = 20;
        int xSpacing = 1;
        int ySpacing = 1;

        for (int i = 0; i < numRows; i++) {
            for (int j = numCols - i; j > 0; j--) {
                int x = 800 - 20 - (numCols - i) * (blockWidth + xSpacing) + (j - 1) * (blockWidth + xSpacing);
                int y = 120 + i * (blockHeight + ySpacing);
                Color color = Color.BLACK;
                Rectangle rect = new Rectangle(new Point(x, y), blockWidth, blockHeight);
                // different color for each row of blocks.
                if (i == 0) {
                    color = Color.GRAY;
                }
                if (i == 1) {
                    color = Color.RED;
                }
                if (i == 2) {
                    color = Color.YELLOW;
                }
                if (i == 3) {
                    color = Color.BLUE;
                }
                if (i == 4) {
                    color = Color.GREEN;
                }
                if (i == 5) {
                    color = Color.PINK;
                }
                Block block = new Block(rect, color);
                this.blocks.add(block);
            }
        }
        this.numberOfBlocksToRemove = 40;
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


