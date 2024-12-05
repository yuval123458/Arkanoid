package arkanoid.game.gamePlay;


import java.awt.Color;
import biuoop.DrawSurface;

/**
 * TowerDrawing class is responnsible for the third
 * level's drawingn which is tower like.
 */
public class TowerDrawing implements Drawings {

    /**
     * constructor method.
     */
    public TowerDrawing() { }

    @Override
    public void drawOn(DrawSurface d) {

        int towerBaseHeight = 150;
        int towerBaseWidth = 100;

        d.setColor(new Color(45, 42, 41));

        d.fillRectangle(100, 600 - towerBaseHeight, towerBaseWidth, towerBaseHeight);
        d.setColor(new Color(45, 42, 41));
        d.drawRectangle(100, 600 - towerBaseHeight, towerBaseWidth, towerBaseHeight);

        int innerRectangleWidth = 15;
        int innerRectangleHeight = 25;

        int innerRectangleSpacing = 5;

        int numOfRects = (towerBaseWidth - innerRectangleSpacing) / (innerRectangleWidth + innerRectangleSpacing);

        int padding = (towerBaseWidth  - numOfRects * (innerRectangleWidth + innerRectangleSpacing)
                + innerRectangleSpacing) / 2;

        for (int i = 0; i < (towerBaseHeight - 20) / (innerRectangleHeight + innerRectangleSpacing); i++) {
            for (int j = 0; j < numOfRects; j++) {
                d.setColor(Color.WHITE);
                d.fillRectangle(
                        100 + padding + j * (innerRectangleWidth + innerRectangleSpacing),
                        600 - towerBaseHeight + 20 + i * (innerRectangleHeight + innerRectangleSpacing),
                        innerRectangleWidth,
                        innerRectangleHeight
                );
                d.setColor(Color.BLACK);
                d.drawRectangle(
                        100 + padding + j * (innerRectangleWidth + innerRectangleSpacing),
                        600 - towerBaseHeight + 20 + i * (innerRectangleHeight + innerRectangleSpacing),
                        innerRectangleWidth,
                        innerRectangleHeight
                );
            }
        }


        d.setColor(new Color(61, 58, 57));
        d.fillRectangle(135, 400, 30, 50);
        d.drawRectangle(135, 400, 30, 50);

        d.setColor(new Color(77, 74, 73));
        d.fillRectangle(145, 250, 10, 150);
        d.drawRectangle(145, 250, 10, 150);

        d.setColor(new Color(209, 174, 112));

        for (int i = 0; i < 4; i++) {
            d.drawCircle(150, 240, 9 + i);
        }

        d.setColor(Color.WHITE);
        d.fillCircle(150, 240, 3);
        d.drawCircle(150, 240, 3);
    }
}
