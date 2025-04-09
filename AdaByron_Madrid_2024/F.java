import java.util.*;
public class F {
    static Scanner sc;
    static int izquierda() {
        System.out.println("I");
        System.out.flush();
        int aux = sc.nextInt();
        System.out.println("D");
        System.out.flush();
        sc.nextInt();
        return aux;
    }

    static int derecha() {
        System.out.println("D");
        System.out.flush();
        int aux = sc.nextInt();
        System.out.println("I");
        System.out.flush();
        sc.nextInt();
        return aux;
    }

    static void girar_izq() {
        if(dir==3) {
            j--;
            dir = 2;
        }
        else if(dir==1) {
            j++;
            dir = 0;
        }
        else if(dir==2) {
            i--;
            dir = 1;
        }
        else {
            i++;
            dir = 3;
        }
    }

    static void avanzar() {
        if(dir==3) {
            i++;
        }
        else if(dir==1) {
            i--;
        }
        else if(dir==2) {
            j--;
        }
        else {
            j++;
        }
    }

    static void girar_der() {
        if(dir==3) {
            j++;
            dir = 0;
        }
        else if(dir==1) {
            j--;
            dir = 2;
        }
        else if(dir==2) {
            i++;
            dir = 3;
        }
        else {
            i--;
            dir = 1;
        }
    }

    static void girar_aba() {
        if(dir==3) {
            i--;
            dir = 1;
        }
        else if(dir==1) {
            i++;
            dir = 3;
        }
        else if(dir==2) {
            j++;
            dir = 0;
        }
        else {
            j--;
            dir = 2;
        }
    }

    static int i, j, dir;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        //boolean[][][] visitados = new boolean[n][n][4];
        i = 0;
        j = 0;
        dir = 3;
        int libA = sc.nextInt();
        while(i!=n-1 || j!=n-1) {
            //visitados[i][j][dir] = true;
            int libI = izquierda();
            if(libI>0) {
                System.out.println("I");
                System.out.flush();
                sc.nextInt();
                girar_izq();
                System.out.println("A");
                System.out.flush();
                if(i==n-1 && j==n-1) sc.next();
                else libA = sc.nextInt();
            }
            else if(libA>0){
                System.out.println("A");
                System.out.flush();
                avanzar();
                if(i==n-1 && j==n-1) sc.next();
                else libA = sc.nextInt();
            }
            else {
                int libD = derecha();
                if(libD>0) {
                    System.out.println("D");
                    System.out.flush();
                    sc.nextInt();
                    girar_der();
                    System.out.println("A");
                    System.out.flush();
                    if(i==n-1 && j==n-1) sc.next();
                    else libA = sc.nextInt();
                }
                else {
                    System.out.println("D");
                    System.out.flush();
                    sc.nextInt();
                    System.out.println("D");
                    System.out.flush();
                    sc.nextInt();
                    girar_aba();
                    System.out.println("A");
                    System.out.flush();
                    if(i==n-1 && j==n-1) sc.next();
                    else libA = sc.nextInt();
                }
            }
        }
    }
}
