import java.util.*;
public class E {
    static int a[];
    static int n;
    static int memo[][];
    static int dp(int i, int dif){
        if(i==n) return dif;
        if(memo[i][dif]!=-1) return memo[i][dif];
        int der=dp(i+1,dif+a[i]);
        int izq=dp(i+1,Math.abs(dif-a[i]));
        memo[i][dif]= Math.min(izq,der);
        return memo[i][dif];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c=sc.nextInt();
        for(;c>0;c--){
            n=sc.nextInt();
            a=new int[n];
            int tot=0;
            for(int i=0; i<n; i++){
                a[i]=sc.nextInt();
                tot+=a[i];
            }

            memo=new int[n][tot+1];
            for(int i=0; i<n; i++){
                Arrays.fill(memo[i],-1);
            }
            int dif=dp(0,0);
         //   System.out.println(dif);
            int peque=(tot-dif)/2;

            System.out.println(peque+" "+(peque+dif));
        }
    }
}
