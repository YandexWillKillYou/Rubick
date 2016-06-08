package DiaCube;

/**
 * Created by artmmslv on 07.06.16.
 */
public class DiaCube{
    int[][] corner = new int[4][9];
    {
        corner[0] = new int[]{11,2,0,4,9,6,1,5,10};
        corner[1] = new int[]{12,3,0,1,10,7,2,6,11};
        corner[2] = new int[]{9,4,0,2,11,8,3,7,12};
        corner[3] = new int[]{10,1,0,3,12,5,4,8,9};
    }
    int small[][]= new int[8][3];
    {
        small[0] = new int[]{311,110,210};
        small[1] = new int[]{310,511,111};
        small[2] = new int[]{309,412,512};
        small[3] = new int[]{312,209,409};
        small[4] = new int[]{509,411, 12};
        small[5] = new int[]{112,510, 11};
        small[6] = new int[]{211,109, 10};
        small[7] = new int[]{410,212,  9};
    }
    int[][] sideColor = new int[6][13];
    int[][] sideColorCopy = new int[6][13];
    {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 13; j++) {
                sideColor[i][j] = i;
            }
        }
    }
    int[][] pikePlains = new int[8][3];
    int[][] pikeCorner = new int[8][3];
    {
        pikePlains[0] = new int[]{0,4,5};
        pikeCorner[0] = new int[]{0,3,1};

        pikePlains[1] = new int[]{0,2,4};
        pikeCorner[1] = new int[]{1,0,2};

        pikePlains[2] = new int[]{0,1,2};
        pikeCorner[2] = new int[]{2,1,3};

        pikePlains[3] = new int[]{0,5,1};
        pikeCorner[3] = new int[]{3,2,0};

        pikePlains[4] = new int[]{1,3,2};
        pikeCorner[4] = new int[]{2,3,2};

        pikePlains[5] = new int[]{2,3,4};
        pikeCorner[5] = new int[]{1,0,1};

        pikePlains[6] = new int[]{3,5,4};
        pikeCorner[6] = new int[]{1,0,0};

        pikePlains[7] = new int[]{1,5,3};
        pikeCorner[7] = new int[]{3,3,2};

    }
    void turn(int pike){
        copy();
        int[] plains = pikePlains[pike];
        int[] corners= pikeCorner[pike];
        for (int i = 0; i < 3; i++) {
            int[] cornColors = getCornerColors(plains[i], corners[i]);
            setCornerColors(plains[(i+1)%3],corners[(i+1)%3], cornColors);

            //small
            int oldSide = small[pike][i]/100;
            int newSide = small[pike][(i+1)%3]/100;
            int oldPart = small[pike][i]%100;
            int newPart = small[pike][(i+1)%3]%100;
            sideColor[newSide][newPart] = sideColorCopy[oldSide][oldPart];
        }
    }
    int[] getCornerColors(int side, int wcorner){
        int[] cornerColors = new int[9];
        for (int i = 0; i < 9; i++) {
            int index_in_side = corner[wcorner][i];
            cornerColors[i] = sideColorCopy[side][index_in_side];
        }
        return cornerColors;
    }
    void setCornerColors(int side, int wcorner, int[] newColors){

        for (int i = 0; i < 9; i++) {
            int index_in_side = corner[wcorner][i];
            sideColor[side][index_in_side] = newColors[i];

        }
    }
    void copy(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 13; j++) {
                sideColorCopy[i][j] = sideColor[i][j];
            }
        }
    }
}