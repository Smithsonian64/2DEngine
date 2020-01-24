import javax.swing.*;
import java.awt.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class InfoBox {

    JFrame infoBox;
    JTextArea infoText;


    Window parent;

    InfoBox(Window p) {

        this.parent = p;

        infoBox = new JFrame("infoBox");
        infoBox.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        infoBox.setSize(new Dimension(250, 1000));
        infoBox.setLocation(parent.frame.getLocation().x + 25, parent.frame.getLocation().y + 25);
        infoBox.setUndecorated(false);
        infoBox.setAlwaysOnTop(true);
        infoBox.setVisible(true);

        Font infoBoxFont = new Font("infoBoxFont", Font.PLAIN, 12);

        infoText = new JTextArea();
        infoText.setEditable(false);
        infoText.setBackground(Color.BLACK);
        infoText.setFont(infoBoxFont);
        infoText.setForeground(Color.WHITE);
        infoBox.add(infoText);

        infoText.setText("");
        for(int i = 0; i < parent.graphicsQueue.size(); i++) {
            infoText.append(i + ": " + parent.graphicsQueue.get(i).getClass().getName() + " with " + parent.graphicsQueue.get(i).sections.size() + " triangles");
        }

    }

    public void updateText() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        infoText.setText("");
        infoText.append("Currently selected shape: " + parent.graphicsQueue.get(parent.selectedShape).name + "\n\n");
        for(int i = 0; i < parent.graphicsQueue.size(); i++) {
            infoText.append("Shape " + i + ": " + "\"" + parent.graphicsQueue.get(i).name + "\"" + " with " + parent.graphicsQueue.get(i).sections.size() + " triangles\n");
            infoText.append("X Pos: " + df.format(parent.graphicsQueue.get(i).getXPosition()) + "\n");
            infoText.append("Y Pos: " + df.format(parent.graphicsQueue.get(i).getYPosition()) + "\n");
            infoText.append("Rotation: " + df.format(parent.graphicsQueue.get(i).getRotation() / 2*Math.PI) + " radians\n");
            infoText.append("Scale: " + df.format(parent.graphicsQueue.get(i).getScale()) + "\n");
            infoText.append("\n");
        }
    }

}
