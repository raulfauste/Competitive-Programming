import java.util.*;
public class G {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(; t>0; t--) {
            int m = sc.nextInt();
            int v = sc.nextInt();
            if(m%6==0) {
                long sol = (long)m*2*v;
                System.out.println(sol);
            }
            else {
                System.out.println(-1);
            }
        }
    }
}
