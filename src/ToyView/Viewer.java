package ToyView;


import Toy.*;
import ToyStructure.*;
import java.applet.Applet;
import java.awt.*;

/**
 * Created by artmmslv on 14.06.16.
 */
public class Viewer extends Applet{
    Toy toy;
    public void init(){
        setName("Turner");
        setSize(1000, 800);
        toy = new Toy(new ClassicCube());
        repaint();
        Shell s = new Shell();
        s.viewer = this;
        s.toy = toy;
        s.start();
    }
    public void paint(Graphics g){
        int a = 150;
        int b = (int)(a * Math.sqrt(3/4d));

        Vector Offset012 = new Vector();
        Vector Offset345 = new Vector();
        Offset345.set(500,300);
        Offset012.set(200,300);
        Vector A = new Vector();
        Vector B = new Vector();
        Vector C = new Vector();
        Vector D,E,F;

        A.set(0,-a);
        B.set(b,a/2);
        C.set(-b,a/2);
        D = Vector.minus(B);
        E = Vector.minus(C);
        F = Vector.minus(A);

        Vector Offset0 = Vector.add(Offset012, C);
        Vector Offset1 = Vector.add(Offset012,D);
        Vector Offset2 = Vector.add(Offset012,F);
        Vector Offset3 = Vector.add(Offset345,C);
        Vector Offset4 = Vector.copy(Offset345);
        Vector Offset5 = Vector.copy(Offset345);

        drawFace(Offset0,B,A,0,g);//0
        drawFace(Offset1,B,E,1,g);//1
        drawFace(Offset2,E,A,2,g);//2
        drawFace(Offset3,E,A,3,g);//3
        drawFace(Offset4,C,B,4,g);//4
        drawFace(Offset5,B,A,5,g);//5
    }
    public void drawFace(Vector Of, Vector A, Vector B, int face, Graphics g){
        ToyStructure ts = toy.getStructure();
        Vector[] v = new Vector[]{Of,A,B};
        //drawing black underlawyer
        g.setColor(Color.black);
        drawPolygon(v, ts.faceSizeFromVectorA, ts.faceSizeFromVectorB,g);
        //
        for (int i = 0; i < ts.P; i++) {
            //find color of next part
            int intColor = toy.colorFromFaceAndPart[face][i];
            g.setColor(ts.colorOfFace[intColor]);
            //drawing next part
            drawPolygon(v,ts.facePartSizeFromVectorA[i], ts.facePartSizeFromVectorB[i], g);
        }
    }
    public void drawPolygon(Vector[] v, double[] c1, double[] c2, Graphics g){
        int[] x = new int[c1.length];
        int[] y = new int[c1.length];
        for (int i = 0; i < c1.length; i++) {
            x[i] = v[0].X() + (int)(v[1].X()*c1[i]) + (int)(v[2].X()*c2[i]);
            y[i] = v[0].Y() + (int)(v[1].Y()*c1[i]) + (int)(v[2].Y()*c2[i]);
        }
        g.fillPolygon(x,y,c1.length);
    }
}
