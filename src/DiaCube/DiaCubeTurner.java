package DiaCube;

import java.applet.Applet;
import java.awt.*;
public class DiaCubeTurner extends Applet {
    DiaCube diaCube;
    public void init(){
        setName("BasicCube.CubeTurner");
        setSize(1000, 800);
        diaCube = new DiaCube();
        repaint();
        DiaShell s = new DiaShell();
        s.ct = this;
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

        drawSquare(Offset0,B,A,0,g);//0
        drawSquare(Offset1,B,E,1,g);//1
        drawSquare(Offset2,E,A,2,g);//2
        drawSquare(Offset3,E,A,3,g);//3
        drawSquare(Offset4,C,B,4,g);//4
        drawSquare(Offset5,B,A,5,g);//5
    }
    public void drawSquare(Vector Of, Vector A, Vector B, int which, Graphics g){
        Vector[] v = new Vector[3];
        v[0] = Of;
        v[1] = A;
        v[2] = B;
        int[] x;
        int[] y;
        //0
        g.setColor(sideColor(diaCube.sideColor[which][0]));
        x = new int[]{2,3,2,1};
        y = new int[]{1,2,3,2};
        drawSquare(v, x, y, g);
        //1
        g.setColor(sideColor(diaCube.sideColor[which][1]));
        x = new int[]{0,1,2,1};
        y = new int[]{1,0,1,2};
        drawSquare(v, x, y, g);
        //2
        g.setColor(sideColor(diaCube.sideColor[which][2]));
        x = new int[]{2,3,4,3};
        y = new int[]{1,0,1,2};
        drawSquare(v, x, y, g);
        //3
        g.setColor(sideColor(diaCube.sideColor[which][3]));
        x = new int[]{3,4,3,2};
        y = new int[]{2,3,4,3};
        drawSquare(v, x, y, g);
        //4
        g.setColor(sideColor(diaCube.sideColor[which][4]));
        x = new int[]{1,2,1,0};
        y = new int[]{2,3,4,3};
        drawSquare(v, x, y, g);
        //5
        g.setColor(sideColor(diaCube.sideColor[which][5]));
        x = new int[]{0,1,0};
        y = new int[]{1,2,3};
        drawSquare(v, x, y, g);
        //6
        g.setColor(sideColor(diaCube.sideColor[which][6]));
        x = new int[]{1,2,3};
        y = new int[]{0,1,0};
        drawSquare(v, x, y, g);
        //7
        g.setColor(sideColor(diaCube.sideColor[which][7]));
        x = new int[]{4,3,4};
        y = new int[]{1,2,3};
        drawSquare(v, x, y, g);
        //8
        g.setColor(sideColor(diaCube.sideColor[which][8]));
        x = new int[]{1,2,3};
        y = new int[]{4,3,4};
        drawSquare(v, x, y, g);
        //9
        g.setColor(sideColor(diaCube.sideColor[which][9]));
        x = new int[]{0,0,1};
        y = new int[]{4,3,4};
        drawSquare(v, x, y, g);
        //10
        g.setColor(sideColor(diaCube.sideColor[which][10]));
        x = new int[]{0,1,0};
        y = new int[]{0,0,1};
        drawSquare(v, x, y, g);
        //11
        g.setColor(sideColor(diaCube.sideColor[which][11]));
        x = new int[]{3,4,4};
        y = new int[]{0,0,1};
        drawSquare(v, x, y, g);
        //12
        g.setColor(sideColor(diaCube.sideColor[which][12]));
        x = new int[]{3,4,4};
        y = new int[]{4,3,4};
        drawSquare(v, x, y, g);

        //lines
        g.setColor(Color.black);
        //top
        x = new int[]{0,4};
        y = new int[]{0,0};
        drawLine(v,x,y,g);
        //left
        x = new int[]{0,0};
        y = new int[]{0,4};
        drawLine(v,x,y,g);
        //right
        x = new int[]{4,4};
        y = new int[]{0,4};
        drawLine(v,x,y,g);
        //bot
        x = new int[]{0,4};
        y = new int[]{4,4};
        drawLine(v,x,y,g);
        //diag1
        x = new int[]{1,4};
        y = new int[]{0,3};
        drawLine(v,x,y,g);
        //diag2
        x = new int[]{0,3};
        y = new int[]{1,4};
        drawLine(v,x,y,g);
        //diag3
        x = new int[]{0,3};
        y = new int[]{3,0};
        drawLine(v,x,y,g);
        //diag4
        x = new int[]{1,4};
        y = new int[]{4,1};
        drawLine(v,x,y,g);
        //small0
        x = new int[]{0,1};
        y = new int[]{1,0};
        drawLine(v,x,y,g);
        //small1
        x = new int[]{3,4};
        y = new int[]{0,1};
        drawLine(v,x,y,g);
        //small2
        x = new int[]{3,4};
        y = new int[]{4,3};
        drawLine(v,x,y,g);
        //small3
        x = new int[]{0,1};
        y = new int[]{3,4};
        drawLine(v,x,y,g);
    }
    public void drawLine(Vector[] v, int[] c1, int[]c2, Graphics g){
        int x[] = new int[c1.length];
        int y[] = new int[c1.length];
        for (int i = 0; i < c1.length; i++) {
            x[i] = v[0].X()  +  v[1].X() * c1[i] / 4  +  v[2].X() * c2[i] / 4;
            y[i] = v[0].Y()  +  v[1].Y() * c1[i] / 4  +  v[2].Y() * c2[i] / 4;
        }
        g.drawLine(x[0],y[0],x[1],y[1]);
    }
    public void drawSquare(Vector[] v, int[] c1, int[] c2, Graphics g){
        int x[] = new int[c1.length];
        int y[] = new int[c1.length];
        for (int i = 0; i < c1.length; i++) {
            x[i] = v[0].X()  +  v[1].X() * c1[i] / 4  +  v[2].X() * c2[i] / 4;
            y[i] = v[0].Y()  +  v[1].Y() * c1[i] / 4  +  v[2].Y() * c2[i] / 4;
        }
        g.fillPolygon(x, y, c1.length);
    }
    public void drawPolygon(Vector v1, Vector v2, Vector v3, Vector v4, Graphics g){
        if(v4.X() ==0&&v4.Y()==0){
            int[] xs = new int[]{v1.X(), v2.X(), v3.X()};
            int[] ys = new int[]{v1.Y(), v2.Y(), v3.Y()};
            g.fillPolygon(xs,ys,3);
        }else{
            int[] xs = new int[]{v1.X(), v2.X(), v3.X(), v4.X()};
            int[] ys = new int[]{v1.Y(), v2.Y(), v3.Y(), v4.Y()};
            g.fillPolygon(xs,ys,4);
        }
    }
    protected Color sideColor(int i){
        Color color = Color.black;
        switch (i){
            case 0: {color = Color.getHSBColor(0f,0f,350/360f); break;}           //white
            case 1: {color = Color.getHSBColor(240/360f,180/360f,190/360f); break;}            //blue
            case 2: {color = Color.getHSBColor(0f,330/360f,220/360f); break;}             //red
            case 3: {color = Color.getHSBColor(50/360f,320/360f,320/360f); break;}          //yellow
            case 4: {color = Color.getHSBColor(120/360f,172/360f,90/360f); break;}           //green
            case 5: {color = Color.getHSBColor(22/360f,290/360f,300/360f); break;}   //orange
            default: color = Color.magenta;
        }
        return color;
    }
    static class Vector{
        private int x;
        private int y;
        public void set(int x, int y){
            this.x = x;
            this.y = y;
        }
        public static Vector zero(){
            Vector ans = new Vector();
            ans.set(0,0);
            return ans;
        }
        public static Vector copy(Vector arg){
            Vector ans = new Vector();
            ans.set(arg.X(),arg.Y());
            return ans;
        }
        public static Vector add(Vector arg1, Vector arg2){
            Vector ans = new Vector();
            ans.set(arg1.X()+arg2.X(),arg1.Y()+arg2.Y());
           return ans;
        }
        public static Vector minus(Vector arg){
            Vector ans = new Vector();
            ans.set(-arg.X(),-arg.Y());
            return ans;
        }
        public static Vector mul(Vector arg, double mul){
            Vector ans = new Vector();
            ans.set((int)(arg.X()*mul),(int)(arg.Y()*mul));
            return ans;
        }
        public int X(){return x;}
        public int Y(){return y;}
    }
}
