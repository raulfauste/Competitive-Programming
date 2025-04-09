import java.util.*;

public class L {

    public static void FloydWarshall(int[][] matriz, int n) {
        for(int k = 0; k <= n; k++) {
            for(int i = 0; i <= n; i++) {
                for(int j = 0; j<= n;j++) {
                    matriz[i][j] = Math.min(matriz[i][j],matriz[i][k] + matriz[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int x = sc.nextInt();
        int t = sc.nextInt();
        while(n != 0 || e != 0 || x !=0 || t != 0) {
            int[][] grafo = new int[n+10][n+10];
            for(int i = 0; i < n+10; i++) {
                for(int j = 0; j < n+10; j++) {
                    if(i==j) grafo[i][j] = 0;
                    else grafo[i][j] = 0x3f3f3f3f;
                }
            }
            for(int i =0 ; i < e ; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int c = sc.nextInt();
                grafo[u][v] = c;
                grafo[v][u] = c;
            }
            FloydWarshall(grafo, n);
            //boolean[] sol =new boolean[x];
            String sol = "";
            for(int i = 0; i < x; i++) {
                HashSet<Integer> set = new HashSet<>();
                int num = sc.nextInt();
                for(int j = 0; j < num; j++) {
                    int s = sc.nextInt();
                    for(int k = 0; k <= n; k++) {
                        if(grafo[s][k] < t) {
                            set.add(k);
                        }
                    }
                }
                //sol[i] = set.size() >= ciudadesPersonal.size();
                if(sol.equals("") && set.size() >= n) sol = sol + (i+1);
                else if(set.size() >= n) sol = sol +" "+(i+1);
            }
            if(sol.equals("")) System.out.println("NO HAY EMPRESAS");
            else System.out.println(sol);
            n = sc.nextInt();
            e = sc.nextInt();
            x = sc.nextInt();
            t = sc.nextInt();
        }
    }
}
