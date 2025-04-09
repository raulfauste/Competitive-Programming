import java.util.*;

public class D {

    static double dist(Point a, Point b) {
        return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }

    public static double distTotal(ArrayList<Point> a, Point[] f) {
        double max = 0.0;
        for(int i = 0; i < a.size(); i++) {
            double maxAux = Double.POSITIVE_INFINITY;
            for(int j = 0; j < 3; j++) {
                maxAux = Math.min(maxAux, dist(a.get(i),f[j]));
            }
            max = Math.max(max, maxAux);
        }
        return max;
    }

    public static class Point {
        double x,y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //sc.useLocale(new Locale("en", "US"));
        int t = sc.nextInt();
        for(;t>0;t--) {
            Point[] puntos = new Point[3];
            ArrayList<Point> puntosC = new ArrayList();
            for(int i=0;i<3;i++) {
                puntos[i] = new Point(sc.nextDouble(),sc.nextDouble());
            }
            Point pM01 =  new Point((puntos[0].x + puntos[1].x)/2,(puntos[0].y + puntos[1].y)/2);
            Point pM02 =  new Point((puntos[0].x + puntos[2].x)/2,(puntos[0].y + puntos[2].y)/2);
            Point pM12 =  new Point((puntos[1].x + puntos[2].x)/2,(puntos[1].y + puntos[2].y)/2);


            Point v01 = new Point(-(puntos[1].y - puntos[0].y), puntos[1].x - puntos[0].x);
            Point v02 = new Point(-(puntos[2].y - puntos[0].y), puntos[2].x - puntos[0].x);
            Point v12 = new Point(-(puntos[2].y - puntos[1].y), puntos[2].x - puntos[1].x);

            // Interseccion x = 0

            if(v01.x !=0) {
                double a = (0 - pM01.x) / v01.x;
                double y = pM01.y + a * v01.y;
                if(y<=100.0 && y>=0.0) {
                    puntosC.add(new Point(0.0,y));
                }
            }
            if(v02.x !=0) {
                double a = (0 - pM02.x) / v02.x;
                double y = pM02.y + a * v02.y;
                if(y<=100.0 && y>=0.0) {
                    puntosC.add(new Point(0.0,y));
                }
            }
            if(v12.x !=0) {
                double a = (0 - pM12.x) / v12.x;
                double y = pM12.y + a * v12.y;
                if(y<=100.0 && y>=0.0) {
                    puntosC.add(new Point(0.0,y));
                }
            }

            // Interseccion x = 100

            if(v01.x !=0) {
                double a = (100 - pM01.x) / v01.x;
                double y = pM01.y + a * v01.y;
                if(y<=100.0 && y>=0.0) {
                    puntosC.add(new Point(100.0,y));
                }
            }
            if(v02.x !=0) {
                double a = (100 - pM02.x) / v02.x;
                double y = pM02.y + a * v02.y;
                if(y<=100.0 && y>=0.0) {
                    puntosC.add(new Point(100.0,y));
                }
            }
            if(v12.x !=0) {
                double a = (100 - pM12.x) / v12.x;
                double y = pM12.y + a * v12.y;
                if(y<=100.0 && y>=0.0) {
                    puntosC.add(new Point(100.0,y));
                }
            }

            // Interseccion y = 0

            if(v01.y !=0) {
                double a = (0 - pM01.y) / v01.y;
                double x = pM01.x + a * v01.x;
                if(x>=0 && x<=100.0) {
                    puntosC.add(new Point(x,0.0));
                }
            }
            if(v02.y !=0) {
                double a = (0 - pM02.y) / v02.y;
                double x = pM02.x + a * v02.x;
                if(x>=0 && x<=100.0) {
                    puntosC.add(new Point(x,0.0));
                }
            }
            if(v12.y !=0) {
                double a = (0 - pM12.y) / v12.y;
                double x = pM12.x + a * v12.x;
                if(x>=0 && x<=100.0) {
                    puntosC.add(new Point(x,0.0));
                }
            }

            // Interseccion y = 100

            if(v01.y !=0) {
                double a = (100 - pM01.y) / v01.y;
                double x = pM01.x + a * v01.x;
                if(x>=0 && x<=100.0) {
                    puntosC.add(new Point(x,100.0));
                }
            }
            if(v02.y !=0) {
                double a = (100 - pM02.y) / v02.y;
                double x = pM02.x + a * v02.x;
                if(x>=0 && x<=100.0) {
                    puntosC.add(new Point(x,100.0));
                }
            }
            if(v12.y !=0) {
                double a = (100 - pM12.y) / v12.y;
                double x = pM12.x + a * v12.x;
                if(x>=0 && x<=100.0) {
                    puntosC.add(new Point(x,100.0));
                }
            }
            puntosC.add(new Point(0.0,0.0));
            puntosC.add(new Point(0.0,100.0));
            puntosC.add(new Point(100.0,0.0));
            puntosC.add(new Point(100.0,100.0));

            double solu = distTotal(puntosC,puntos);
            String soluFormat = String.format("%.3f",solu);
            System.out.println(soluFormat);
        }
    }
}