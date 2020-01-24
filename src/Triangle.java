import java.awt.*;

public class Triangle implements Render{

    double[] xCoordinates;
    double[] yCoordinates;
    int[] xGraphingCoordinates;
    int[] yGraphingCoordinates;
    int numPoints;



    Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {



        numPoints = 3;

        xCoordinates = new double[3];
        yCoordinates = new double[3];

        xGraphingCoordinates = new int[3];
        yGraphingCoordinates = new int[3];

        xCoordinates[0] = Window.getAbsoluteX((int)Math.round(x1));
        xCoordinates[1] = Window.getAbsoluteX((int)Math.round(x2));
        xCoordinates[2] = Window.getAbsoluteX((int)Math.round(x3));

        yCoordinates[0] = Window.getAbsoluteY((int)Math.round(y1));
        yCoordinates[1] = Window.getAbsoluteY((int)Math.round(y2));
        yCoordinates[2] = Window.getAbsoluteY((int)Math.round(y3));

        xGraphingCoordinates[0] = (int)Math.round(xCoordinates[0]);
        xGraphingCoordinates[1] = (int)Math.round(xCoordinates[1]);
        xGraphingCoordinates[2] = (int)Math.round(xCoordinates[2]);

        yGraphingCoordinates[0] = (int)Math.round(yCoordinates[0]);
        yGraphingCoordinates[1] = (int)Math.round(yCoordinates[1]);
        yGraphingCoordinates[2] = (int)Math.round(yCoordinates[2]);

    }

    Triangle(DrawTool drawTool) {
        numPoints = 3;

        xCoordinates = new double[3];
        yCoordinates = new double[3];

        xGraphingCoordinates = new int[3];
        yGraphingCoordinates = new int[3];

        xCoordinates[0] = drawTool.xCoordinates[0];
        xCoordinates[1] = drawTool.xCoordinates[1];
        xCoordinates[2] = drawTool.xCoordinates[2];

        yCoordinates[0] = drawTool.yCoordinates[0];
        yCoordinates[1] = drawTool.yCoordinates[1];
        yCoordinates[2] = drawTool.yCoordinates[2];

        xGraphingCoordinates[0] = (int)Math.round(xCoordinates[0]);
        xGraphingCoordinates[1] = (int)Math.round(xCoordinates[1]);
        xGraphingCoordinates[2] = (int)Math.round(xCoordinates[2]);

        yGraphingCoordinates[0] = (int)Math.round(yCoordinates[0]);
        yGraphingCoordinates[1] = (int)Math.round(yCoordinates[1]);
        yGraphingCoordinates[2] = (int)Math.round(yCoordinates[2]);
    }

    public void draw(){
        Graphics2D g2d = Window.planePanel.plane.createGraphics();
        g2d.drawPolygon(xGraphingCoordinates, yGraphingCoordinates, numPoints);
    };

}
