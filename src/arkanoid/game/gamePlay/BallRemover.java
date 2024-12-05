package arkanoid.game.gamePlay;

/**
 * Ball remover class is responsible for removing a ball from the gameLevel,
 * when the ball hits "danger zone" it will be removed from the gameLevel.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;


    /**
     * @param gameLevel gameLevel to remove the ball from.
     * @param remainingBalls remaining balls in the gameLevel.
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;
    }


    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBalls.decrease(1);
        hitter.removeFromGame(gameLevel);
    }
}
