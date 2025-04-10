package Uva;

import Geometria.Line;
import Geometria.Point;
import Geometria.Vector;

import java.util.*;

public class Uva00191 {

    static class Point {
        double x,y;

        public Point(double _x, double _y) {
            x = _x; y = _y;
        }
    }

    static class Vector {
        double x,y;

        public Vector(double _x, double _y) {
            x = _x; y = _y;
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

    // Convierte dos puntos en una linea
    static Line pointsToLine(Point p1, Point p2){
        Vector v = new Vector(p2.x-p1.x, p2.y-p1.y);
        return new Line(p1,v);
    }

    static double cross(Vector a, Vector b) {
        return a.x*b.y - a.y*b.x;
    }

    static boolean areSame(Line l1, Line l2) {
        Vector v = new Vector(l2.p.x - l1.p.x, l2.p.y - l1.p.y);
        return areParallel(l1,l2) && cross(l1.v,v)==0;
    }

    static boolean areParallel(Line l1, Line l2) {
        return cross(l1.v,l2.v)==0;
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
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            Point p1 = new Point(sc.nextDouble(), sc.nextDouble());
            Point p2 = new Point(sc.nextDouble(), sc.nextDouble());
            Line l = pointsToLine(p1, p2);

            double xleft = sc.nextDouble();
            double ytop = sc.nextDouble();
            double xright = sc.nextDouble();
            double ybottom = sc.nextDouble();
            if(xleft>xright) {
                double aux = xleft;
                xleft = xright;
                xright = aux;
            }
            if(ybottom>ytop) {
                double aux = ytop;
                ytop = ybottom;
                ybottom = aux;
            }


            Point c1 = new Point(xleft,ytop);
            Point c3 = new Point(xright, ybottom);
            Point c2 = new Point(c3.x,c1.y);
            Point c4 = new Point(c1.x,c3.y);
            Line l12 = pointsToLine(c1, c2);
            Line l23 = pointsToLine(c2,c3);
            Line l34 = pointsToLine(c3,c4);
            Line l14 = pointsToLine(c1,c4);


            if(p1.x>=Math.min(c1.x,c2.x) && p1.x<=Math.max(c1.x,c2.x) && p1.y<=Math.max(c1.y,c4.y) && p1.y>=Math.min(c1.y,c4.y)) System.out.println("T");
            else if(p2.x>=Math.min(c1.x,c2.x) && p2.x<=Math.max(c1.x,c2.x) && p2.y<=Math.max(c1.y,c4.y) && p2.y>=Math.min(c1.y,c4.y)) System.out.println("T");
            else if(c1.x == c3.x && c1.y == c3.y) {
                Vector v = new Vector(c1.x-p1.x, c1.y-p1.y);
                if(cross(v,l.v) != 0) System.out.println("F");
                else if(l.v.x != 0 && c1.x>=Math.min(p1.x,p2.x) && c1.x<Math.max(p1.x,p2.x)) {
                    System.out.println("T");
                } else if (c1.y>=Math.min(p1.y,p2.y) && c1.y<Math.max(p1.y,p2.y)) {
                    System.out.println("T");
                } else {
                    System.out.println("F");
                }
            }
            else if(l.v.x == 0 && l.v.y == 0) System.out.println("F");
            else {
                boolean cut = false;
                if(!areParallel(l,l12)) {
                    Point p = intersect(l,l12);
                    if(p.x>=c1.x && p.x<=c2.x && !cut && p.y<=Math.max(p1.y,p2.y) && p.y>=Math.min(p1.y,p2.y)) {
                        cut = true;
                        System.out.println("T");
                    }
                    p = intersect(l,l34);
                    if(p.x<=c3.x && p.x>=c4.x && !cut && p.y<=Math.max(p1.y,p2.y) && p.y>=Math.min(p1.y,p2.y)) {
                        cut = true;
                        System.out.println("T");
                    }
                }
                if(!areParallel(l,l23)) {
                    Point p = intersect(l,l23);
                    if(p.y<=c2.y && p.y>=c3.y && !cut && p.x<=Math.max(p1.x,p2.x) && p.x>=Math.min(p1.x,p2.x)) {
                        cut = true;
                        System.out.println("T");
                    }
                    p = intersect(l,l14);
                    if(p.y<=c1.y && p.y>=c4.y && !cut && p.x<=Math.max(p1.x,p2.x) && p.x>=Math.min(p1.x,p2.x)) {
                        cut = true;
                        System.out.println("T");
                    }
                }
                if(!cut) System.out.println("F");
            }
        }
    }
}
