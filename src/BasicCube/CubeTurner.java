package BasicCube;

import java.applet.Applet;
import java.awt.*;
import java.awt.image.DataBuffer;
import java.util.Date;

/**
 * Created by artmmslv on 07.06.16.
 */

public class CubeTurner extends Applet{
    Cube cube;
    public void init(){
        setName("BasicCube.CubeTurner");
        setSize(1000, 800);
        cube = new Cube();
        repaint();
        Shell s = new Shell();
        s.ct = this;
        s.start();

    }
    public void paint(Graphics g){
        drawSquare(100, 270, 5, g);
        drawSquare(270, 100, 4, g);
        drawSquare(270, 270, 0, g);
        drawSquare(440, 270, 2, g);
        drawSquare(610, 270, 3, g);
        drawSquare(270, 440, 1, g);
    }
    public void drawSquare(int x, int y, int which, Graphics g){
        g.setColor(Color.black);
        g.fillRect(x,y,150,150);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int newColor = cube.color[which][i][j];
                g.setColor(sideColor(newColor));
                g.fillRect(x + 5 + 50 * i, y + 5 + 50 * j, 40, 40);
            }
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

}
