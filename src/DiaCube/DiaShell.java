package DiaCube;

import java.util.Scanner;

/**
 * Created by artmmslv on 07.06.16.
 */
public class DiaShell extends Thread{
    DiaCubeTurner ct;
    public void run(){
        Scanner in = new Scanner(System.in);
        while (true)
            try{
                String s = in.next().toLowerCase();
                for (int i = 0; i < s.length(); i++) {
                    int n = side(s.charAt(i));
                    if(n>=0&&n<8){
                        ct.diaCube.turn(n);
                        ct.repaint();
                    }else
                        throw new IllegalArgumentException();
                }
            }catch (IllegalArgumentException e){
                System.out.println("illegal argument");
            }catch (Exception e){}
    }
 public int side(char c){
     int ans = -1;
     switch (c){
         case '0':{ans = 0; break;}
         case '1':{ans = 1; break;}
         case '2':{ans = 2; break;}
         case '3':{ans = 3; break;}
         case '4':{ans = 4; break;}
         case '5':{ans = 5; break;}
         case '6':{ans = 6; break;}
         case '7':{ans = 7; break;}
     }
     return ans;
 }

}
