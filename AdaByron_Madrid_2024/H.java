import java.util.*;
public class H {
    static int w,l;
    static int tet[][];
    static int mem[][];
    static int dp(int i, int em){
        if(i==l)
            return 0;
        if(mem[i][em]!=-1) return mem[i][em];
        int izq=0;
        int der=0;
        int med=dp(i+1,em)+tet[i][em]+tet[i][em+1];
        if(em>0) izq=dp(i+1,em-1)+tet[i][em]+tet[i][em-1];
        if(em<w-2) der=dp(i+1,em+1)+tet[i][em+1]+tet[i][em+2];
        mem[i][em]= Math.max(izq,Math.max(med,der));
        return mem[i][em];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        w=sc.nextInt();
        l=sc.nextInt();
        tet=new int[l][w];
        int n=sc.nextInt();
        mem=new int[l][w];
        for(int i=0;i<n;i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            tet[y][x] = sc.nextInt();
        }
        for(int i=0;i<l;i++) {
            Arrays.fill(mem[i], -1);
        }
        int solu=0;
        for(int i=0;i<w-1;i++) {
            solu=Math.max(solu, dp(0,i));
        }
        System.out.println(solu);
    }
}
