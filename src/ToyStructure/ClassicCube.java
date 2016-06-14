package ToyStructure;

import java.awt.*;

/**
 * Created by artmmslv on 14.06.16.
 */
public class ClassicCube extends ToyStructure {
    static {
        N = 6;
        K = 4;
        P = 9;
        Q = 3;
        T = 6;
        M = 4;

        facePartFromCornerAndCornerPart = new int[4][3];
        faceFromTurnAndIndex = new int[6][4];
        cornerFromTurnAndIndex = new int[6][4];

        facePartFromCornerAndCornerPart[0] = new int[]{0,1,2};
        facePartFromCornerAndCornerPart[1] = new int[]{2,5,8};
        facePartFromCornerAndCornerPart[2] = new int[]{8,7,6};
        facePartFromCornerAndCornerPart[3] = new int[]{6,3,0};

        faceFromTurnAndIndex[0] = new int[]{1,2,4,5};
        faceFromTurnAndIndex[1] = new int[]{0,5,3,2};
        faceFromTurnAndIndex[2] = new int[]{0,1,3,4};
        faceFromTurnAndIndex[3] = new int[]{2,1,5,4};
        faceFromTurnAndIndex[4] = new int[]{0,2,3,5};
        faceFromTurnAndIndex[5] = new int[]{0,4,3,1};

        cornerFromTurnAndIndex[0] = new int[]{0,3,2,1};
        cornerFromTurnAndIndex[1] = new int[]{2,2,2,2};
        cornerFromTurnAndIndex[2] = new int[]{1,1,3,1};
        cornerFromTurnAndIndex[3] = new int[]{1,2,3,0};
        cornerFromTurnAndIndex[4] = new int[]{0,0,0,0};
        cornerFromTurnAndIndex[5] = new int[]{3,3,1,3};

    }
    public ClassicCube(){
        colorOfFace = new Color[]{
                Color.getHSBColor(0/360f,0/360f,350/360f),          //white
                Color.getHSBColor(240/360f,180/360f,190/360f),      //blue
                Color.getHSBColor(0f,330/360f,220/360f),            //red
                Color.getHSBColor(50/360f,320/360f,320/360f),       //yellow
                Color.getHSBColor(120/360f,172/360f,90/360f),       //green
                Color.getHSBColor(22/360f,290/360f,300/360f)        //orange
                };
                            //A
        facePartSizeFromVectorA[0] = new double[]{ 1/22d, 7/22d, 7/22d, 1/22d};
        facePartSizeFromVectorA[1] = new double[]{ 8/22d,14/22d,14/22d, 8/22d};
        facePartSizeFromVectorA[2] = new double[]{15/22d,21/22d,21/22d,15/22d};
        facePartSizeFromVectorA[3] = new double[]{ 1/22d, 7/22d, 7/22d, 1/22d};
        facePartSizeFromVectorA[4] = new double[]{ 8/22d,14/22d,14/22d, 8/22d};
        facePartSizeFromVectorA[5] = new double[]{15/22d,21/22d,21/22d,15/22d};
        facePartSizeFromVectorA[6] = new double[]{ 1/22d, 7/22d, 7/22d, 1/22d};
        facePartSizeFromVectorA[7] = new double[]{ 8/22d,14/22d,14/22d, 8/22d};
        facePartSizeFromVectorA[8] = new double[]{15/22d,21/22d,21/22d,15/22d};
                            //B
        facePartSizeFromVectorB[0] = new double[]{ 1/22d, 1/22d, 7/22d, 7/22d};
        facePartSizeFromVectorB[1] = new double[]{ 1/22d, 1/22d, 7/22d, 7/22d};
        facePartSizeFromVectorB[2] = new double[]{ 1/22d, 1/22d, 7/22d, 7/22d};
        facePartSizeFromVectorB[3] = new double[]{ 8/22d, 8/22d,14/22d,14/22d};
        facePartSizeFromVectorB[4] = new double[]{ 8/22d, 8/22d,14/22d,14/22d};
        facePartSizeFromVectorB[5] = new double[]{ 8/22d, 8/22d,14/22d,14/22d};
        facePartSizeFromVectorB[6] = new double[]{15/22d,15/22d,21/22d,21/22d};
        facePartSizeFromVectorB[7] = new double[]{15/22d,15/22d,21/22d,21/22d};
        facePartSizeFromVectorB[8] = new double[]{15/22d,15/22d,21/22d,21/22d};

        faceSizeFromVectorA = new double[]{0,1,1,0};
        faceSizeFromVectorB = new double[]{0,0,1,1};

    }

}
