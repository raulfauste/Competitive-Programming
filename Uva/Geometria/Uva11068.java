package Uva;

import Geometria.Line;
import Geometria.Point;
import Geometria.Vector;

import java.util.*;

public class Uva11068 {

    static class Point {
        double x,y;

        public Point(double _x, double _y){
            x = _x; y = _y;
        }
    }

    static class Vector {
        double x,y;

        public Vector(double _x, double _y){
            x = _x; y = _y;
        }
    }

    static class Line {
        Point p;
        Vector v;

        public Line(Point p, Vector v){
            this.p = p;
            this.v = v;
        }
    }

    static boolean areParallel(Line l1, Line l2) {
        return cross(l1.v,l2.v)==0;
    }

    static double cross(Vector a, Vector b) {
        return a.x*b.y - a.y*b.x;
    }

    static Point intersect(Line l1, Line l2) {
        if(l1.v.x == 0) return intersect(l2,l1);
        double t2 = ((l2.p.y-l1.p.y)-(l2.p.x-l1.p.x)*(l1.v.y/l1.v.x))/(l1.v.y*l2.v.x/l1.v.x - l2.v.y);
        double x0 = l2.p.x + t2*l2.v.x;
        double y0 = l2.p.y + t2*l2.v.y;
        return new Point(x0, y0);
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a1 = sc.nextInt();
        double b1 = sc.nextInt();
        double c1 = sc.nextInt();
        double a2 = sc.nextInt();
        double b2 = sc.nextInt();
        double c2 = sc.nextInt();
        while(a1 != 0 || b1 != 0 || c1 !=0 || a2 != 0 || b2 !=0 || c2 != 0) {
            Vector v1 = new Vector(b1,-a1);
            Vector v2 = new Vector(b2,-a2);
            Point p1 = new Point(0.0,0.0);
            Point p2 = new Point(0.0,0.0);
            if(b1 !=0 ) {
                p1.x = 0.0;
                p1.y = c1/b1;
            } else {
                p1.x = c1/a1;
                p1.y = 0.0;
            }
            if(b2 !=0 ) {
                p2.x = 0.0;
                p2.y = c2/b2;
            } else {
                p2.x = c2/a2;
                p2.y = 0.0;
            }
            Line l1 = new Line(p1,v1);
            Line l2 = new Line(p2,v2);
            if(areParallel(l1,l2)) {
                System.out.println("No fixed point exists.");
            } else {
                Point p = intersect(l1,l2);
                String x = String.format("%.2f",p.x);
                String y = String.format("%.2f",p.y);
                System.out.println("The fixed point is at "+x+" "+y+".");
            }


            a1 = sc.nextInt();
            b1 = sc.nextInt();
            c1 = sc.nextInt();
            a2 = sc.nextInt();
            b2 = sc.nextInt();
            c2 = sc.nextInt();
        }
    }
}
