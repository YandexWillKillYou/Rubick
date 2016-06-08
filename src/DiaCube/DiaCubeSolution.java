package DiaCube;

import java.util.Queue;

/**
 * Created by artmmslv on 08.06.16.
 */
public class DiaCubeSolution {
    private DiaCube diaCube;
    int[][] sideColorCopy;
    String path;
    public DiaCubeSolution(DiaCube cube, String path){
        this.diaCube = cube;
        this.path = path;
        sideColorCopy = new int[6][13];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 13; j++) {
                sideColorCopy[i][j] = diaCube.sideColor[i][j];
            }
        }
    }
    public boolean checkSolution(int[][] colors){
        for (int i = 0; i < 6; i++) {
            int colorOfSide = colors[i][0];
            for (int j = 1; j < 13; j++) {
                if(colors[i][j]!=colorOfSide)return false;
            }
        }
        return true;
    }
    public String findSolution(DiaCubeSolution first, Queue<DiaCubeSolution> queue, String path)throws Exception{
        if(first.checkSolution(first.sideColorCopy))throw new Exception("s");
        for (int i = 0; i < 8; i++) {
            DiaCubeSolution second = new DiaCubeSolution();
            queue.add(second);
        }
        return path;
    }
}
