import javax.swing.*;

public class Actions {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable(){
                    public void run(){
                        Window window1 = new Window();

                        Triangle[] triforce = new Triangle[3];
                        triforce[0] = new Triangle(0, 0, 50, 0, 25, 43);
                        triforce[1] = new Triangle(50, 0, 100, 0, 75, 43);
                        triforce[2] = new Triangle(25, 43, 75, 43, 50, 86);

                        window1.addMesh(triforce, "triforce");

                        Triangle[] star = new Triangle[3];
                        star[0] = new Triangle(0, 0, 25, 50, 25, 17);
                        star[1] = new Triangle(50, 0, 25, 50, 25, 17);
                        star[2] = new Triangle(0, 34, 50, 34, 25, 17);

                        window1.addMesh(star, "star");

                        Triangle[] f = new Triangle[6];
                        f[0] = new Triangle(0, 0, 20, 0, 0, 80);
                        f[1] = new Triangle(20, 0, 20, 80, 0, 80);
                        f[2] = new Triangle(20, 60, 20, 80, 60, 60);
                        f[3] = new Triangle(20, 80, 60, 80, 60, 60);
                        f[4] = new Triangle(20, 20, 20, 40, 40, 20);
                        f[5] = new Triangle(40, 20, 20, 40, 40, 40);

                        window1.addMesh(f, "f");

                        Triangle[] pentagon = new Triangle[3];
                        pentagon[0] = new Triangle(10, 0, 0, 30, 30, 60);
                        pentagon[1] = new Triangle(10, 0, 30, 60, 50, 0);
                        pentagon[2] = new Triangle(50, 0, 30, 60, 60, 30);

                        window1.addMesh(pentagon, "pentagon");

                        Triangle[] pinwheel = new Triangle[20];
                        pinwheel[0] = new Triangle(20, 0, 50, 0, 35, 35);
                        pinwheel[1] = new Triangle(50, 0, 70, 20, 35, 35);
                        pinwheel[2] = new Triangle(70, 20, 70, 50, 35, 35);
                        pinwheel[3] = new Triangle(70, 50, 50, 70, 35, 35);
                        pinwheel[4] = new Triangle(50, 70, 20, 70, 35, 35);
                        pinwheel[5] = new Triangle(20, 70, 0, 50, 35, 35);
                        pinwheel[6] = new Triangle(0, 50, 0, 20, 35, 35);
                        pinwheel[7] = new Triangle(0, 20, 20, 0, 35, 35);
                        pinwheel[8] = new Triangle(20, 0, 50, 0, 50, -50);
                        pinwheel[9] = new Triangle(50, -50, 80, -60, 50, -30);
                        pinwheel[10] = new Triangle(70, 20, 70, 50, 120, 50);
                        pinwheel[11] = new Triangle(120, 50, 100, 50, 130, 80);
                        pinwheel[12] = new Triangle(20, 120, 50, 70, 20, 70);
                        pinwheel[13] = new Triangle(20, 100, 20, 120, -10, 130);
                        pinwheel[14] = new Triangle(0, 20, 0, 50, -50, 20);
                        pinwheel[15] = new Triangle(-50, 20, -30, 20, -60, -10);
                        pinwheel[16] = new Triangle(50, 70, 70, 50, 95.35533906, 95.3553391);
                        pinwheel[17] = new Triangle(0, 50, 20, 70, -25.35533906, 95.3553391);
                        pinwheel[18] = new Triangle(20, 0, 0, 20, -25.35533906, -25.35533906);
                        pinwheel[19] = new Triangle(50, 0, 70, 20, 95.35533906, -25.35533906);

                        window1.addMesh(pinwheel, "pinwheel");

                        window1.infoBox.updateText();

                    }
                });
    }

}
