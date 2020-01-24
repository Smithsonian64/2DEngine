public class Polygon {

    double[] xCoordinates;
    double[] yCoordinates;
    int[] xGraphingCoordinates;
    int[] yGraphingCoordinates;
    int numPoints;

    Polygon(int sides) {
        xCoordinates = new double[sides];
        yCoordinates = new double[sides];
        xGraphingCoordinates = new int[sides];
        yGraphingCoordinates = new int[sides];
        numPoints = sides;
    }

    public void translateShape(int xAmount, int yAmount) {
        for(int i = 0; i < numPoints; i++) {
            xGraphingCoordinates[i] += -xAmount;
            xCoordinates[i] += -xAmount;
            yGraphingCoordinates[i] += -yAmount;
            yCoordinates[i] += -yAmount;
        }
    }

    public void scaleShape(double scaleAmount) {
        double[] tempX = new double[3];
        tempX[0] = xCoordinates[0];
        tempX[1] = xCoordinates[1];
        tempX[2] = xCoordinates[2];
        double[] tempY = new double[3];
        tempY[0] = yCoordinates[0];
        tempY[1] = yCoordinates[1];
        tempY[2] = yCoordinates[2];

        double centroidX = (xCoordinates[0] + xCoordinates[1] + xCoordinates[2]) / 3;
        double centroidY = (yCoordinates[0] + yCoordinates[1] + yCoordinates[2]) / 3;

        double tempx1 = xCoordinates[0] - centroidX;
        double tempx2 = xCoordinates[1] - centroidX;
        double tempx3 = xCoordinates[2] - centroidX;

        double tempy1 = yCoordinates[0] - centroidY;
        double tempy2 = yCoordinates[1] - centroidY;
        double tempy3 = yCoordinates[2] - centroidY;

        xCoordinates[0] = tempx1*scaleAmount + centroidX;
        xCoordinates[1] = tempx2*scaleAmount + centroidX;
        xCoordinates[2] = tempx3*scaleAmount + centroidX;

        yCoordinates[0] = tempy1*scaleAmount + centroidY;
        yCoordinates[1] = tempy2*scaleAmount + centroidY;
        yCoordinates[2] = tempy3*scaleAmount + centroidY;

        xGraphingCoordinates[0] = (int)Math.round(xCoordinates[0]);
        xGraphingCoordinates[1] = (int)Math.round(xCoordinates[1]);
        xGraphingCoordinates[2] = (int)Math.round(xCoordinates[2]);

        yGraphingCoordinates[0] = (int)Math.round(yCoordinates[0]);
        yGraphingCoordinates[1] = (int)Math.round(yCoordinates[1]);
        yGraphingCoordinates[2] = (int)Math.round(yCoordinates[2]);
    }

    public void rotateShape(double angle) {

        double centroidX = (xCoordinates[0] + xCoordinates[1] + xCoordinates[2]) / 3;
        double centroidY = (yCoordinates[0] + yCoordinates[1] + yCoordinates[2]) / 3;

        double tempx1 = xCoordinates[0] - centroidX;
        double tempx2 = xCoordinates[1] - centroidX;
        double tempx3 = xCoordinates[2] - centroidX;

        double tempy1 = yCoordinates[0] - centroidY;
        double tempy2 = yCoordinates[1] - centroidY;
        double tempy3 = yCoordinates[2] - centroidY;

        xCoordinates[0] = (tempx1*Math.cos(angle) - tempy1*Math.sin(angle)) + centroidX;
        xCoordinates[1] = (tempx2*Math.cos(angle) - tempy2*Math.sin(angle)) + centroidX;
        xCoordinates[2] = (tempx3*Math.cos(angle) - tempy3*Math.sin(angle)) + centroidX;

        yCoordinates[0] = (tempy1*Math.cos(angle) + tempx1*Math.sin(angle)) + centroidY;
        yCoordinates[1] = (tempy2*Math.cos(angle) + tempx2*Math.sin(angle)) + centroidY;
        yCoordinates[2] = (tempy3*Math.cos(angle) + tempx3*Math.sin(angle)) + centroidY;

        xGraphingCoordinates[0] = (int)Math.round(xCoordinates[0]);
        xGraphingCoordinates[1] = (int)Math.round(xCoordinates[1]);
        xGraphingCoordinates[2] = (int)Math.round(xCoordinates[2]);

        yGraphingCoordinates[0] = (int)Math.round(yCoordinates[0]);
        yGraphingCoordinates[1] = (int)Math.round(yCoordinates[1]);
        yGraphingCoordinates[2] = (int)Math.round(yCoordinates[2]);

        //x′=xcosθ−ysinθ
        //y′=ycosθ+xsinθ

    }

}
