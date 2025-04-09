import java.util.*;

public class J {
    private static int mod = 1000000009;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(;t > 0 ; t-- ) {
            int e = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            PriorityQueue<Long> mins = new PriorityQueue<>();
            PriorityQueue<Long> maxs = new PriorityQueue<>();
            long sumaMins = 0;
            long sumaMaxs = 0;
            long[] auxi = new long[a+b];
            for(int i =0 ; i < a+b ; i++) {
                sc.next();
                auxi[i] = sc.nextLong();
            }
            Arrays.sort(auxi);
            for(int i = 0; i < a; i++) {
                mins.add(-auxi[i]);
                sumaMins = (sumaMins%mod + auxi[i]%mod)%mod;
            }
            for(int i = a; i < a+b ; i++) {
                maxs.add(auxi[i]);
                sumaMaxs = (sumaMaxs%mod + auxi[i]%mod)%mod;
            }
            for(int i = a+b ; i < e ; i ++) {
                String s = sc.next();
                if(s.equals("H")) {
                    long num = sc.nextLong();
                    if(b>0 && num>maxs.peek()) {
                        long aux = maxs.poll();
                        maxs.add(num);
                        sumaMins = ((sumaMins + mod - (aux)%mod)%mod + num%mod)%mod;
                    } else if(a>0 && num<-mins.peek()) {
                        long aux = -mins.poll();
                        mins.add(-num);
                        sumaMaxs = ((sumaMaxs + mod - (aux)%mod)%mod + num%mod)%mod;
                    }
                } else {
                    System.out.println((sumaMaxs+sumaMins)%mod);
                }
            }
            System.out.println("---");
        }
    }
}
