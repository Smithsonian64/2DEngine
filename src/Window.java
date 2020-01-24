import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Window {

    JFrame frame;

    InfoBox infoBox;
    TransformBox transformBox;
    ToolBox toolBox;

    static PlanePanel planePanel;

    static int selectedShape;

    final static int WINDOW_HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    final static int WINDOW_WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();

    static ArrayList<Mesh> graphicsQueue;



    BufferedImage plane;

    public Window() {
        frame = new JFrame("2DEngine");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(false);

        plane = new BufferedImage(WINDOW_WIDTH, WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB);
        planePanel = new PlanePanel(plane, this);
        frame.add(planePanel);

        selectedShape = 0;

        graphicsQueue  = new ArrayList<>();

        infoBox = new InfoBox(this);
        transformBox = new TransformBox(this);
        toolBox = new ToolBox(this);

        frame.setVisible(true);


        this.frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == 16) {
                    graphicsQueue.get(selectedShape).scaleShape(1.1);
                    drawGraphics();
                    infoBox.updateText();
                    return;
                }
                if(e.getKeyCode() == 17) {
                    graphicsQueue.get(selectedShape).scaleShape(0.9);
                    drawGraphics();
                    infoBox.updateText();
                    return;
                }
                if(e.getKeyChar() == 'e') {
                    graphicsQueue.get(selectedShape).rotateShape(Math.PI/64);
                    drawGraphics();
                    infoBox.updateText();
                    return;
                }
                if(e.getKeyChar() == 'q') {
                    graphicsQueue.get(selectedShape).rotateShape((-1)*Math.PI/64);
                    drawGraphics();
                    infoBox.updateText();
                    return;
                }
                if(e.getKeyChar() == 'a') { //left
                    graphicsQueue.get(selectedShape).translateShape(-10, 0);
                    drawGraphics();
                    infoBox.updateText();
                    return;
                }
                if(e.getKeyChar() == 'd') { //right
                    graphicsQueue.get(selectedShape).translateShape(10, 0);
                    drawGraphics();
                    infoBox.updateText();
                    return;
                }
                if(e.getKeyChar() == 'w') { //up
                    graphicsQueue.get(selectedShape).translateShape(0, 10);
                    drawGraphics();
                    infoBox.updateText();
                    return;
                }
                if(e.getKeyChar() == 's') { //down
                    graphicsQueue.get(selectedShape).translateShape(0, -10);
                    drawGraphics();
                    infoBox.updateText();
                    return;
                }
                if(e.getKeyChar() == ' ') { //change
                    selectedShape++;
                    if(selectedShape >= graphicsQueue.size()) selectedShape = 0;
                    infoBox.updateText();
                    return;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

    public static int getAbsoluteX(int x){
        return x + (WINDOW_WIDTH / 2);
    }

    public static int getAbsoluteY(int y){
        return (WINDOW_HEIGHT / 2) - y;
    }

    public void addMesh(Triangle[] ts, String name) {
        Mesh mesh = new Mesh(ts, name);
        graphicsQueue.add(mesh);
        drawGraphics();
    }

    public void drawGraphics() {
        BufferedImage tempImage = new BufferedImage(WINDOW_WIDTH, WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB);
        planePanel.refreshGraph(tempImage);
        for(int i = 0; i < graphicsQueue.size(); i++) {
            graphicsQueue.get(i).draw();
        }
        frame.repaint();
    }

    public void paint(Graphics g) {
        g.drawImage(plane, 0, 0, null);
    }

}
