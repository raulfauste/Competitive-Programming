package Uva;

import java.util.*;

public class Uva10242 {

    static class Point{
        double x,y;

        public Point(double _x, double _y) {
            x = _x; y = _y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            Point p1 = new Point(sc.nextDouble(), sc.nextDouble());
            Point p2 = new Point(sc.nextDouble(), sc.nextDouble());
            Point pAux  = new Point(sc.nextDouble(), sc.nextDouble());
            Point p3 = new Point(sc.nextDouble(), sc.nextDouble());
            double x4,y4;
            if(pAux.x == p1.x && pAux.y == p1.y) {
                x4 = p3.x + (p2.x-p1.x);
                y4 = p3.y + (p2.y-p1.y);
            } else if(pAux.x == p2.x && pAux.y == p2.y){
                x4 = p3.x - (p2.x-p1.x);
                y4 = p3.y - (p2.y-p1.y);
            }else {
                if(p3.x == p1.x && p3.y == p1.y) {
                    x4 = pAux.x + (p2.x-p1.x);
                    y4 = pAux.y + (p2.y-p1.y);
                } else {
                    x4 = pAux.x - (p2.x-p1.x);
                    y4 = pAux.y - (p2.y-p1.y);
                }
            }
            String solX = String.format("%.3f",x4);
            String solY = String.format("%.3f",y4);
            System.out.println(solX + " " + solY);
        }
    }
}
