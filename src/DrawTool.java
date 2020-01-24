import javax.swing.*;

public class DrawTool {

    int[] xCoordinates;
    int[] yCoordinates;

    Triangle triangle;
    int level;
    ToolBox parent;

    boolean toolSelected;

    DrawTool(ToolBox p) {
        parent = p;

        xCoordinates = new int[3];
        yCoordinates = new int[3];

        triangle = new Triangle(0, 0, 0, 0, 0, 0);

        level = 0;

        toolSelected = false;


    }

    public void addPoint(int x, int y) {
        if (parent.drawToolButton.isSelected()) {
            xCoordinates[level] = x;
            yCoordinates[level] = y;
            level++;
            System.out.println("adding point at (" + x + ", " + y + ")");
            if (level == 3) {
                triangle = new Triangle(this);
                parent.parent.graphicsQueue.get(parent.parent.selectedShape).sections.add(triangle);
                parent.parent.drawGraphics();
                parent.parent.infoBox.updateText();
                level = 0;
                System.out.println("Added a triangle to " + parent.parent.graphicsQueue.get(parent.parent.selectedShape).name);
                return;
            }
        }
    }


}
