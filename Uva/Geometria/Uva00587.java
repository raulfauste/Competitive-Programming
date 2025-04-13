package Uva;

import java.util.Scanner;

public class Uva00587 {

    static class Point {
        double x, y;

        public Point(double _x, double _y){
            x = _x; y = _y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int cont = 1;
        while(!s.equals("END")) {
            s = s.replace(".","");
            String[] a = s.split(",");
            Point p = new Point(0.0,0.0);
            for(int i = 0; i < a.length; i++) {
                if(a[i].contains("NE")) {
                    int ind = a[i].indexOf("NE");
                    int num = Integer.parseInt(a[i].substring(0, ind));
                    double aux = Math.sqrt((double)num*num/2);
                    p.x = p.x + aux; p.y = p.y + aux;
                } else if(a[i].contains("SE")) {
                    int ind = a[i].indexOf("SE");
                    int num = Integer.parseInt(a[i].substring(0, ind));
                    double aux = Math.sqrt((double) num * num / 2);
                    p.x = p.x + aux;
                    p.y = p.y - aux;
                } else if(a[i].contains("SW")) {
                    int ind = a[i].indexOf("SW");
                    int num = Integer.parseInt(a[i].substring(0, ind));
                    double aux = Math.sqrt((double) num * num / 2);
                    p.x = p.x - aux;
                    p.y = p.y - aux;
                } else if(a[i].contains("NW")) {
                    int ind = a[i].indexOf("NW");
                    int num = Integer.parseInt(a[i].substring(0, ind));
                    double aux = Math.sqrt((double) num * num / 2);
                    p.x = p.x - aux;
                    p.y = p.y + aux;
                } else if(a[i].contains("N")) {
                    int ind = a[i].indexOf("N");
                    int num = Integer.parseInt(a[i].substring(0, ind));
                    p.y = p.y + num;
                } else if(a[i].contains("E")) {
                    int ind = a[i].indexOf("E");
                    int num = Integer.parseInt(a[i].substring(0, ind));
                    p.x = p.x + num;
                } else if(a[i].contains("S")) {
                    int ind = a[i].indexOf("S");
                    int num = Integer.parseInt(a[i].substring(0, ind));
                    p.y = p.y - num;
                } else {
                    int ind = a[i].indexOf("W");
                    int num = Integer.parseInt(a[i].substring(0, ind));
                    p.x = p.x - num;
                }
            }
            System.out.println("Map #"+cont);
            String x = String.format("%.3f",p.x);
            String y = String.format("%.3f",p.y);
            System.out.println("The treasure is located at ("+x+","+y+").");
            double dist = Math.sqrt(p.x*p.x + p.y*p.y);
            String d = String.format("%.3f",dist);
            System.out.println("The distance to the treasure is "+d+".");
            System.out.println();
            cont++;
            s = sc.nextLine();
        }
    }
}
