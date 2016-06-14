package Toy;

import ToyStructure.*;

/**
 * Created by artmmslv on 14.06.16.
 */
public class Toy {
    ToyStructure ts;
    public volatile int[][] colorFromFaceAndPart;
    int[][] colorCopy;
    public Toy(ToyStructure ts){
        this.ts = ts;
        //initialisation of arrays and painting the cube
        colorFromFaceAndPart = new int[ts.N][];
        colorCopy = new int[ts.N][];
        for (int i = 0; i < ts.N; i++) {
            colorFromFaceAndPart[i] = new int[ts.P];
            colorCopy[i] = new int[ts.P];
            //painting
            for (int j = 0; j < ts.P; j++) {
                colorFromFaceAndPart[i][j] = i;
            }
        }
    }
    
    public void turn(int t){
        copy();//we are going to overwrite a lot
        System.out.println("turning " + t);
        for (int i = 0; i < ts.M; i++) {
            //we find M corners and replace them one by one
            int newI = (i+1)%ts.M;
            moveCorner(   ts.faceFromTurnAndIndex[t][i],
                          ts.cornerFromTurnAndIndex[t][i],
                          ts.faceFromTurnAndIndex[t][newI],
                          ts.cornerFromTurnAndIndex[t][newI]);
        }

    }
    void moveCorner(int faceSource, int cornSource, int faceDestin, int cornDestin){
        for (int i = 0; i < ts.Q; i++) {
            //getting color
            int sourcePartOnSideNumber = ts.facePartFromCornerAndCornerPart[cornSource][i];
            int color = colorCopy[faceSource][sourcePartOnSideNumber];
            //setting color
            int destinPartOnSideNumber = ts.facePartFromCornerAndCornerPart[cornDestin][i];
            colorFromFaceAndPart[faceDestin][destinPartOnSideNumber] = color;
        }
    }
    void copy(){
        for (int i = 0; i < ts.N; i++) {
            for (int j = 0; j < ts.P; j++) {
                colorCopy[i][j] = colorFromFaceAndPart[i][j];
            }
        }
    }
    public void turnBack(int t){
        for (int i = 0; i < ts.M-1; i++) {
            turn(t);
        }
    }
    public ToyStructure getStructure(){return ts;}
}
