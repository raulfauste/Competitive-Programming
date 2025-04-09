import java.util.*;

public class K {
    //static ArrayList primos = new ArrayList();
    static boolean[] esPrimo;
    static int[] nums;

    public static void criba(int n) {
        esPrimo = new boolean[n+1];
        esPrimo[0] = true;esPrimo[1]=true;
        for(int p=2;p<=n;p++) {
            if(!esPrimo[p]) {
                //primos.add(p);
                for(int px = p*2;px<=n && px>0;px+=p) {
                    esPrimo[px] = true;
                }
            }
        }
    }

    public static void serie() {
        nums = new int[500005];
        int ind = 0;
        for(int i = 5; ind<500001;i++) {
            if(esPrimo[i] && !esPrimo[i-2]) {
                nums[ind] = i;
                ind++;
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        criba(8500000);
        serie();
        for(;t>0;t--) {
            int n = sc.nextInt();
            System.out.println(nums[n-1]);
        }
    }
}
