package Uva;

import java.util.*;

public class Uva10865 {

    public static class Point {
        int x,y;

        public Point(int _x, int _y){
            x = _x; y = _y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while ( n != 0) {
            Point[] a = new Point[n-1];
            int ind = 0;
            Point c = new Point(0, 0);
            for(int i = 0; i < n; i++) {
                Point p = new Point(sc.nextInt(), sc.nextInt());
                if(i != n/2) {
                    a[ind] = p;
                    ind++;
                } else {
                    c = p;
                }
            }
            int cont1 = 0;
            int cont2 = 0;
            for(int i = 0; i < n-1; i++) {
                if(a[i].x<c.x && a[i].y<c.y) cont1++;
                else if(a[i].x>c.x && a[i].y>c.y) cont1++;
                else if(a[i].x<c.x && a[i].y>c.y) cont2++;
                else if(a[i].x>c.x && a[i].y<c.y) cont2++;
            }
            System.out.println(cont1+" "+cont2);
            n = sc.nextInt();
        }
    }
}
