package BasicCube;

import java.awt.*;

/**
 * Created by artmmslv on 07.06.16.
 */
public class Cube {
    volatile int[][][] color;
    final static int sideAttached[] = new int[12];
    int[][][] copy;
    {
        color = new int[6][3][3];
        copy  = new int[6][3][3];
        for (int i = 0; i < 6; i++) {
            color[i] = new int[3][3];
            copy [i] = new int[3][3];
            for (int j = 0; j < 3; j++) {
                color[i][j] = new int[3];
                copy [i][j] = new int[3];
            }
        }
    }
    static int[][] bound;
    static int[] plainBound;
    static {
        bound = new int[6][12];
        bound[0] = new int[]{100,110,120, 202,201,200, 422,412,402, 520,521,522};
        bound[1] = new int[]{ 22, 12,  2, 522,512,502, 322,312,302, 222,212,202};
        bound[2] = new int[]{ 20, 21, 22, 120,121,122, 302,301,300, 420,421,422};
        bound[3] = new int[]{220,221,222, 122,112,102, 502,501,500, 400,410,420};
        bound[4] = new int[]{  0, 10, 20, 200,210,220, 300,310,320, 500,510,520};
        bound[5] = new int[]{  2,  1,  0, 402,401,400, 320,321,322, 102,101,100};
        plainBound = new int[]{  0,  1,  2, 12,  22, 21, 20, 10};

    }
    public Cube(){
        fillSide(0);
        fillSide(1);
        fillSide(2);
        fillSide(3);
        fillSide(4);
        fillSide(5);
    }
    protected void fillSide(int which){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                color[which][i][j] = which;
            }
        }
    }
    public void turn(int side){
        copy();
        int[] addedPlainBound = new int[8];

        for (int i = 0; i < 8; i++)
            addedPlainBound[i] = side*100+plainBound[i];
        for (int i = 0; i < 8; i++)
            cc(addedPlainBound[i],addedPlainBound[(i + 2 ) %8]);
        for (int i = 0; i < 12; i++)
            cc(bound[side][i],bound[side][(i + 3)%12]);
    }
    public void turnBack(int side){
        turn(side);
        turn(side);
        turn(side);
    }
    public void cc(String from, String to){
        int f0 = from.charAt(0) - '0';
        int f1 = from.charAt(1) - '0';
        int f2 = from.charAt(2) - '0';
        int t0 = to.charAt(0) - '0';
        int t1 = to.charAt(1) - '0';
        int t2 = to.charAt(2) - '0';
        color[t0][t1][t2] = copy[f0][f1][f2];
    }
    public void cc(int from, int to){
        int f0 = from / 100;
        int f1 = (from % 100) / 10;
        int f2 = from % 10;
        int t0 = to / 100;
        int t1 = (to % 100) / 10;
        int t2 = to % 10;
        color[t0][t1][t2] = copy[f0][f1][f2];
    }
    public void copy(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    copy[i][j][k] = color[i][j][k];
                }
            }
        }
    }
}
