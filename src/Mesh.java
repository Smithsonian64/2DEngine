import java.util.ArrayList;

public class Mesh implements Render{

    ArrayList<Triangle> sections;

    double rotation;
    double scale;

    double[] xCoordinates;
    double[] yCoordinates;
    int[] xGraphingCoordinates;
    int[] yGraphingCoordinates;
    int numPoints;

    String name;

    Mesh(Triangle[] triangles, String name) {
        sections = new ArrayList<>();

        for(int i = 0; i < triangles.length; i++) {
            sections.add(triangles[i]);
        }

        this.name = name;

        rotation = 0;
        scale = 1;

    }

    Mesh(String name) {
        sections = new ArrayList<>();

        this.name = name;

        rotation = 0;
        scale = 1;
    }

    public void addTriangle(Triangle t) {
        sections.add(t);
    }

    @Override
    public void draw() {
        for(int i = 0; i < sections.size(); i++) {
            sections.get(i).draw();
        }
    }

    public void translateShape(int xAmount, int yAmount) {
        for(int i = 0; i < sections.size(); i++) {
            for(int j = 0; j < 3; j++) {
                sections.get(i).xGraphingCoordinates[j] += xAmount;
                sections.get(i).yGraphingCoordinates[j] += -yAmount;
                sections.get(i).xCoordinates[j] += xAmount;
                sections.get(i).yCoordinates[j] += -yAmount;
            }
        }
    }

    public void scaleShape(double scaleAmount) {

        double centroidX = 0;
        double centroidY = 0;

        double tempx[][] = new double[sections.size()][3];
        double tempy[][] = new double[sections.size()][3];

        for(int i = 0; i < sections.size(); i++) {
            for(int j = 0; j < 3; j++) {
                centroidX += sections.get(i).xCoordinates[j];
                centroidY += sections.get(i).yCoordinates[j];
            }
        }

        centroidX = centroidX / (sections.size()*3);
        centroidY = centroidY / (sections.size()*3);

        for(int i = 0; i < sections.size(); i++) {
            for(int j = 0; j < 3; j++) {
                tempx[i][j] = sections.get(i).xCoordinates[j] - centroidX;
                tempy[i][j] = sections.get(i).yCoordinates[j] - centroidY;
            }
        }

        for(int i = 0; i < sections.size(); i++) {
            for(int j = 0; j < 3; j++) {
                sections.get(i).xCoordinates[j] = tempx[i][j]*scaleAmount + centroidX;
                sections.get(i).xGraphingCoordinates[j] = (int)Math.round(sections.get(i).xCoordinates[j]);
                sections.get(i).yCoordinates[j] = tempy[i][j]*scaleAmount + centroidY;
                sections.get(i).yGraphingCoordinates[j] = (int)Math.round(sections.get(i).yCoordinates[j]);
            }
        }

        scale *= scaleAmount;

    }

    public void rotateShape(double angle) {

        double centroidX = 0;
        double centroidY = 0;

        double tempx[][] = new double[sections.size()][3];
        double tempy[][] = new double[sections.size()][3];

        for(int i = 0; i < sections.size(); i++) {
            for(int j = 0; j < 3; j++) {
                centroidX += sections.get(i).xCoordinates[j];
                centroidY += sections.get(i).yCoordinates[j];
            }
        }

        centroidX = centroidX / (sections.size()*3);
        centroidY = centroidY / (sections.size()*3);

        for(int i = 0; i < sections.size(); i++) {
            for(int j = 0; j < 3; j++) {
                tempx[i][j] = sections.get(i).xCoordinates[j] - centroidX;
                tempy[i][j] = sections.get(i).yCoordinates[j] - centroidY;
            }
        }

        for(int i = 0; i < sections.size(); i++) {
            for(int j = 0; j < 3; j++) {
                sections.get(i).xCoordinates[j] = (tempx[i][j]*Math.cos(angle) - tempy[i][j]*Math.sin(angle)) + centroidX;
                sections.get(i).xGraphingCoordinates[j] = (int)Math.round(sections.get(i).xCoordinates[j]);
                sections.get(i).yCoordinates[j] = (tempy[i][j]*Math.cos(angle) + tempx[i][j]*Math.sin(angle)) + centroidY;
                sections.get(i).yGraphingCoordinates[j] = (int)Math.round(sections.get(i).yCoordinates[j]);
            }
        }

        rotation += angle;




        //x′=xcosθ−ysinθ
        //y′=ycosθ+xsinθ

    }

    public double getRotation() {
        return rotation;
    }

    public double getXPosition() {
        double centroidX = 0;

        double tempx[][] = new double[sections.size()][3];
        double tempy[][] = new double[sections.size()][3];

        for(int i = 0; i < sections.size(); i++) {
            for(int j = 0; j < 3; j++) {
                centroidX += sections.get(i).xCoordinates[j];
            }
        }

        centroidX = centroidX / (sections.size()*3);

        return centroidX;

    }

    public double getYPosition() {
        double centroidY = 0;

        double tempy[][] = new double[sections.size()][3];

        for(int i = 0; i < sections.size(); i++) {
            for(int j = 0; j < 3; j++) {
                centroidY += sections.get(i).yCoordinates[j];
            }
        }

        centroidY = centroidY / (sections.size()*3);

        return centroidY;

    }

    public double getScale() {
        return scale;
    }

}
