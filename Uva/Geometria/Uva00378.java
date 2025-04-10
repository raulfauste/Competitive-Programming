package Uva;

import Geometria.Line;
import Geometria.Point;
import Geometria.Vector;

import java.util.*;

public class Uva00378 {

    static class Point {
        double x,y;

        public Point(double _x, double _y) {
            x = _x; y = _y;
        }
    }

    static class Vector {
        double x, y;

        public Vector(double _x, double _y) {
            x = _x; y = _y;
        }
    }

    static class Line {
        Point p;
        Vector v;

        public Line(Point _p, Vector _v) {
            p = _p; v = _v;
        }
    }

    static double cross(Vector a, Vector b) {
        return a.x*b.y - a.y*b.x;
    }

    static boolean areParallel(Line l1, Line l2) {
        return cross(l1.v,l2.v)==0;
    }

    static boolean areSame(Line l1, Line l2) {
        Vector v = new Vector(l2.p.x - l1.p.x, l2.p.y - l1.p.y);
        return areParallel(l1,l2) && cross(l1.v,v)==0;
    }

    static Point intersect(Line l1, Line l2) {
        if(l1.v.x == 0) return intersect(l2,l1);
        double t2 = ((l2.p.y - l1.p.y) - (l2.p.x - l1.p.x) * (l1.v.y / l1.v.x)) / (l1.v.y * l2.v.x / l1.v.x - l2.v.y);
        double x0 = l2.p.x + t2*l2.v.x;
        double y0 = l2.p.y + t2*l2.v.y;
        return new Point(x0, y0);
    }

    static Line pointsToLine(Point p1, Point p2){
        Vector v = new Vector(p2.x-p1.x, p2.y-p1.y);
        return new Line(p1,v);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        System.out.println("INTERSECTING LINES OUTPUT");
        for(;t > 0 ; t--) {
            Point p1 = new Point(sc.nextInt(), sc.nextInt());
            Point p2 = new Point(sc.nextInt(), sc.nextInt());
            Line l1 = pointsToLine(p1, p2);
            Point p3 = new Point(sc.nextInt(), sc.nextInt());
            Point p4 = new Point(sc.nextInt(), sc.nextInt());
            Line l2 = pointsToLine(p3, p4);
            if(areSame(l1,l2)) {
                System.out.println("LINE");
            } else if(areParallel(l1,l2)) {
                System.out.println("NONE");
            } else {
                Point p = intersect(l1,l2);
                String x = String.format("%.2f",p.x);
                String y = String.format("%.2f",p.y);
                System.out.println("POINT "+x+" "+y);
            }
        }
        System.out.println("END OF OUTPUT");
    }
}
