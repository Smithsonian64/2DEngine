import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBox implements ActionListener {

    Window parent;
    DrawTool drawTool;

    boolean removeEnabled;

    JTextField meshNameEntry;
    JButton addMeshButton;

    JFrame toolBox;

    JPanel background;

    JRadioButton drawToolButton;
    JRadioButton removeToolButton;

    ToolBox(Window p) {
        this.parent = p;

        removeEnabled = false;

        toolBox = new JFrame("ToolBox");
        toolBox.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        toolBox.setSize(750, 100);
        toolBox.setAlwaysOnTop(true);
        toolBox.setLocation(parent.frame.getX() + parent.frame.getWidth()/2 - this.toolBox.getWidth()/2, parent.frame.getHeight() - this.toolBox.getHeight() - 50);

        background = new JPanel();
        background.setBackground(Color.BLACK);

        toolBox.add(background);

        GridLayout gridLayout = new GridLayout(2, 2, 10, 10);
        background.setLayout(gridLayout);

        meshNameEntry = new JTextField();
        meshNameEntry.setBackground(Color.DARK_GRAY);
        meshNameEntry.setForeground(Color.WHITE);
        meshNameEntry.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        background.add(meshNameEntry);

        drawToolButton = new JRadioButton();
        drawToolButton.setText("Draw");
        drawToolButton.setBackground(Color.BLACK);
        drawToolButton.setForeground(Color.WHITE);
        drawToolButton.addActionListener(this);
        drawToolButton.setActionCommand("EnableDraw");
        background.add(drawToolButton);




        addMeshButton = new JButton("Add");
        addMeshButton.setBackground(Color.DARK_GRAY);
        addMeshButton.setForeground(Color.WHITE);
        addMeshButton.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.DARK_GRAY));
        addMeshButton.addActionListener(this);
        addMeshButton.setActionCommand("AddMesh");


        background.add(addMeshButton);


        removeToolButton = new JRadioButton();
        removeToolButton.setBackground(Color.BLACK);
        removeToolButton.setForeground(Color.WHITE);
        removeToolButton.setText("Remove");
        removeToolButton.addActionListener(this);
        removeToolButton.setActionCommand("EnableRemove");
        background.add(removeToolButton);


        toolBox.setVisible(true);


        drawTool = new DrawTool(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("AddMesh")) {
            parent.graphicsQueue.add(new Mesh(meshNameEntry.getText()));
            parent.drawGraphics();
            parent.infoBox.updateText();
            return;
        }
/*
        if(e.getActionCommand().equals("EnableDraw")) {

            if(drawTool.toolSelected == false) {
                removeEnabled = false;
                drawTool.toolSelected = true;
                removeToolButton.setEnabled(false);
            }
            else drawTool.toolSelected = false;
            return;
        }

        if(e.getActionCommand().equals("EnableRemove")) {

            if(removeEnabled == false) {
                removeEnabled = true;
                drawTool.toolSelected = false;
            }
            else removeEnabled = false;

            return;
        }

 */
    }

    public void removeTriangle(int x, int y) {


        double totalArea;
        double A1;
        double A2;
        double A3;

        for(int i = 0; i < parent.graphicsQueue.get(parent.selectedShape).sections.size(); i++) {
            totalArea = triangleArea(getXcoord(i, 0), getYcoord(i, 0), getXcoord(i, 1), getYcoord(i, 1), getXcoord(i, 2), getYcoord(i, 2));
            A1 = triangleArea(x, y, getXcoord(i, 1), getYcoord(i, 1), getXcoord(i, 2), getYcoord(i, 2));
            A2 = triangleArea(getXcoord(i, 0), getYcoord(i, 0), x, y, getXcoord(i, 2), getYcoord(i, 2));
            A3 = triangleArea(getXcoord(i, 0), getYcoord(i, 0), getXcoord(i, 1), getYcoord(i, 1), x, y);

            System.out.println("x1: " + getXcoord(i, 0) + ", y1: " + getYcoord(i, 0));
            System.out.println("x2: " + getXcoord(i, 1) + ", y2: " + getYcoord(i, 1));
            System.out.println("x3: " + getXcoord(i, 2) + ", y3: " + getYcoord(i, 2));
            System.out.println(Math.round(totalArea) + " =? " + Math.round(A1) + " + " + Math.round(A2) + " + " + Math.round(A3));
            System.out.println(Math.round(A1 + A2 + A3));

            if(Math.round(totalArea) == Math.round(A1 + A2 + A3)) {
                parent.graphicsQueue.get(parent.selectedShape).sections.remove(i);
                parent.drawGraphics();
                parent.infoBox.updateText();
                System.out.println("removing");
                return;
            }


        }



        //Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0);

    }

    public double getXcoord(int triangle, int coordNumber) {
        return parent.graphicsQueue.get(parent.selectedShape).sections.get(triangle).xCoordinates[coordNumber];
    }

    public double getYcoord(int triangle, int coordNumber) {
        return parent.graphicsQueue.get(parent.selectedShape).sections.get(triangle).yCoordinates[coordNumber];
    }

    public double triangleArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        return Math.abs((x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2))/2.0);
    }


}
