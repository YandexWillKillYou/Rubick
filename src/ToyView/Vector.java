package ToyView;

/**
 * Created by artmmslv on 14.06.16.
 */
public class Vector {
        private int x;
        private int y;
        public Vector(){}
        public Vector(int x, int y){
            this.x = x;
            this.y = y;
        }
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
