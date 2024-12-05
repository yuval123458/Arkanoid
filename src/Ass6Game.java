
import arkanoid.game.gamePlay.LevelOne;
import arkanoid.game.gamePlay.LevelTwo;
import arkanoid.game.gamePlay.LevelThree;
import arkanoid.game.gamePlay.AnimationRunner;
import arkanoid.game.gamePlay.LevelInformation;
import arkanoid.game.gamePlay.GameFlow;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.ArrayList;
import java.util.List;

// ID: 318297264

/**
 * main method to initialize and run a new game.
 */
public class Ass6Game {
    /**
     * start and run a new game.
     * @param args levels to play.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arachnoid", 800, 600);
        KeyboardSensor ks = gui.getKeyboardSensor();
        AnimationRunner ar = new AnimationRunner(60, gui);

        List<LevelInformation> allLevels = new ArrayList<>();
        allLevels.add(new LevelOne());
        allLevels.add(new LevelTwo());
        allLevels.add(new LevelThree());

        List<LevelInformation> levelsToRun = new ArrayList<>();

        if (args.length > 0 && !args[0].equals("${args}")) {
            for (String arg : args) {
                try {
                    int levelNumber = Integer.parseInt(arg);
                    if (levelNumber > 0 && levelNumber <= allLevels.size()) {
                        levelsToRun.add(allLevels.get(levelNumber - 1));
                    }
                } catch (NumberFormatException e) { }
            }
        } else {
            levelsToRun = allLevels;
        }
        GameFlow gameFlow = new GameFlow(ar, ks, gui);
        gameFlow.runLevels(levelsToRun);
    }
}

