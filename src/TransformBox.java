import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransformBox implements ActionListener {

    JFrame transformBox;

    JTextField xCoordinateEntry;
    JButton applyCoordsChangeButton;
    JTextField yCoordinateEntry;

    JTextField rotationEntry;
    JButton applyRotationChangeButton;

    JTextField scaleEntry;
    JButton applyScaleChangeButton;

    JPanel background;



    Window parent;

    TransformBox(Window p) {
        this.parent = p;

        transformBox = new JFrame("transformBox");
        transformBox.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        transformBox.setUndecorated(false);
        transformBox.setAlwaysOnTop(true);
        transformBox.setSize(250, 500);
        transformBox.setLocation(parent.frame.getX() + parent.frame.getWidth() - this.transformBox.getWidth() - 25, parent.frame.getY() + 50);

        xCoordinateEntry = new JTextField();
        xCoordinateEntry.setBackground(Color.DARK_GRAY);
        xCoordinateEntry.setForeground(Color.WHITE);
        xCoordinateEntry.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        applyCoordsChangeButton = new JButton("Apply");
        applyCoordsChangeButton.setBackground(Color.DARK_GRAY);
        applyCoordsChangeButton.setForeground(Color.WHITE);
        applyCoordsChangeButton.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.DARK_GRAY));
        applyCoordsChangeButton.addActionListener(this);
        applyCoordsChangeButton.setActionCommand("CoordsChange");
        yCoordinateEntry = new JTextField();
        yCoordinateEntry.setBackground(Color.DARK_GRAY);
        yCoordinateEntry.setForeground(Color.WHITE);
        yCoordinateEntry.setBorder(BorderFactory.createMatteBorder(0, 0,0 ,0, Color.BLACK));

        rotationEntry = new JTextField();
        rotationEntry.setBackground(Color.DARK_GRAY);
        rotationEntry.setForeground(Color.WHITE);
        rotationEntry.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        applyRotationChangeButton = new JButton("Apply");
        applyRotationChangeButton.addActionListener(this);
        applyRotationChangeButton.setActionCommand("RotationChange");
        applyRotationChangeButton.setBackground(Color.DARK_GRAY);
        applyRotationChangeButton.setForeground(Color.WHITE);
        applyRotationChangeButton.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.DARK_GRAY));

        scaleEntry = new JTextField();
        scaleEntry.setBackground(Color.DARK_GRAY);
        scaleEntry.setForeground(Color.WHITE);
        scaleEntry.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        applyScaleChangeButton = new JButton("Apply");
        applyScaleChangeButton.addActionListener(this);
        applyScaleChangeButton.setActionCommand("ScaleChange");
        applyScaleChangeButton.setBackground(Color.DARK_GRAY);
        applyScaleChangeButton.setForeground(Color.WHITE);
        applyScaleChangeButton.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.DARK_GRAY));

        background = new JPanel();
        transformBox.add(background);

        GridLayout gridLayout = new GridLayout(5, 3, 10, 20);
        background.setLayout(gridLayout);

        JLabel xCoordLabel = new JLabel("X: ");
        xCoordLabel.setForeground(Color.WHITE);
        background.add(xCoordLabel);
        background.add(xCoordinateEntry);
        background.add(applyCoordsChangeButton);

        JLabel yCoordLabel = new JLabel("Y: ");
        yCoordLabel.setForeground(Color.WHITE);
        background.add(yCoordLabel);
        background.add(yCoordinateEntry);
        background.add(new JLabel());

        JLabel rotationLabel = new JLabel("Rotation: ");
        rotationLabel.setForeground(Color.WHITE);
        background.add(rotationLabel);
        background.add(rotationEntry);
        background.add(applyRotationChangeButton);

        JLabel scaleLabel = new JLabel("Scale: ");
        scaleLabel.setForeground(Color.WHITE);
        background.add(scaleLabel);
        background.add(scaleEntry);
        background.add(applyScaleChangeButton);

        background.setBackground(Color.BLACK);

        transformBox.pack();








        transformBox.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("CoordsChange")) {
            if(xCoordinateEntry.getText().equals("")) xCoordinateEntry.setText("0");
            if(yCoordinateEntry.getText().equals("")) yCoordinateEntry.setText("0");
            parent.graphicsQueue.get(parent.selectedShape).translateShape((Integer.parseInt(this.xCoordinateEntry.getText())), Integer.parseInt(this.yCoordinateEntry.getText()));
            parent.infoBox.updateText();
            parent.drawGraphics();
            return;
        }

        if(e.getActionCommand().equals("RotationChange")) {
            if(rotationEntry.getText().equals("")) rotationEntry.setText("0");
            parent.graphicsQueue.get(parent.selectedShape).rotateShape(Double.parseDouble(this.rotationEntry.getText()));
            parent.infoBox.updateText();
            parent.drawGraphics();
            return;
        }

        if(e.getActionCommand().equals("ScaleChange")) {
            if(scaleEntry.getText().equals("")) scaleEntry.setText("0");
            parent.graphicsQueue.get(parent.selectedShape).scaleShape(Double.parseDouble((this.scaleEntry.getText())));
            parent.infoBox.updateText();
            parent.drawGraphics();
            return;
        }

    }

}
