package ToyStructure;

import java.awt.*;

/**
 * Created by artmmslv on 14.06.16.
 */
public abstract class ToyStructure {

    //these integers and arrays define how toy looks and how it turns
    public static int N;    //number of faces
    public static int K;    //number of edges of one face
    public static int P;    //number of parts of one edge
    public static int Q;    //number of parts of one corner
                                //corner is a part of face turned
    public static int T;    //number of axis
    public static int M;    //number of turns restoring the figure

    public static int[][] facePartFromCornerAndCornerPart = new int[K][Q];
    public static int[][] faceFromTurnAndIndex = new int[T][M];
    public static int[][] cornerFromTurnAndIndex = new int[T][M];


    //cubes with same mechanics may look in different ways
    public double[] faceSizeFromVectorA = new double[K];
    public double[] faceSizeFromVectorB = new double[K];
    public double[][] facePartSizeFromVectorA = new double[P][];
    public double[][] facePartSizeFromVectorB = new double[P][];
    public Color[] colorOfFace = new Color[N];
}
