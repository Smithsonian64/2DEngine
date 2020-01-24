import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class PlanePanel extends JPanel {

    BufferedImage plane;
    Window parent;

    public PlanePanel(BufferedImage image, Window p) {
        plane = image;
        this.parent = p;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e);
                if(parent.toolBox.drawToolButton.isSelected()) {
                    parent.toolBox.drawTool.addPoint(e.getX(), e.getY());
                    return;
                }

                if(parent.toolBox.removeToolButton.isSelected()) {
                    parent.toolBox.removeTriangle(e.getX(), e.getY());
                    return;
                }

            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(plane, 0, 0, null);

    }

    public void refreshGraph(BufferedImage g) {
        plane = g;
        this.repaint();
    }

}
