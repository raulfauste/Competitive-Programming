package Uva;

import Geometria.Line;
import Geometria.Point;
import Geometria.Vector;

import java.util.*;

public class Uva00920 {
    private static double EPS = 1e-9;

    static class Point implements Comparable<Point> {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(Math.abs(x -o.x)>EPS) {
                double aux = x-o.x;
                if(aux>0) return 1;
                else return -1;
            } else if(Math.abs(y - o.y)>EPS) {
                double aux = y-o.y;
                if(aux>0) return 1;
                else return -1;
            } else {
                return 0;
            }
        }
    }

    static class Vector {
        double x, y;

        public Vector(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Line {
        Point p;
        Vector v;

        public Line(Point p, Vector v) {
            this.p = p;
            this.v = v;
        }
    }

    static Point intersect(Line l1, Line l2) {
        if(l1.v.x == 0) return intersect(l2,l1);
        double t2 = ((l2.p.y-l1.p.y)-(l2.p.x-l1.p.x)*(l1.v.y/l1.v.x))/(l1.v.y*l2.v.x/l1.v.x - l2.v.y);
        double x0 = l2.p.x + t2*l2.v.x;
        double y0 = l2.p.y + t2*l2.v.y;
        return new Point(x0, y0);
    }

    static Line pointsToLine(Point p1, Point p2){
        Vector v = new Vector(p2.x-p1.x, p2.y-p1.y);
        return new Line(p1,v);
    }

    static double dist(Point a, Point b) {
        return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(; t > 0 ; t--) {
            int n = sc.nextInt();
            Point[] a = new Point[n];
            for(int i = 0; i < n; i++) {
                a[i] = new Point(sc.nextDouble(), sc.nextDouble());
            }
            Arrays.sort(a);
            Point max = a[n-1];
            double distance = 0.0;
            Point ant = max;
            for(int i = n-2;i>=0;i--) {
                Point p = a[i];
                if(p.y > max.y) {
                    Vector v = new Vector(1.0,0.0);
                    Line l = new Line(max,v);
                    Line l2 = pointsToLine(ant,p);
                    Point in = intersect(l,l2);
                    distance += dist(p,in);
                    max.y = p.y;
                    max.x = p.x;
                }
                ant = p;
            }
            String sol = String.format("%.2f", distance);
            System.out.println(sol);
        }
    }
}
