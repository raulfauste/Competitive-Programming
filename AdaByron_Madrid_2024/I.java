import java.util.*;
public class I{
    static ArrayList<Integer>[] grafi;
    static boolean[]visi;

    static int nim(int i){
        int grundy=0;
        visi[i]=true;
        for(int son:grafi[i]){
            if(!visi[son]){
                grundy^=(1+nim(son));
            }
        }
        // System.out.println(i+" "+grundy);
        return grundy;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(;t>0;t--){
            int n = sc.nextInt();
            grafi = new ArrayList[n];
            for(int i = 0; i < n; i++){
                grafi[i] = new ArrayList<>();
            }
            for (int i = 1; i < n; i++) {
                int papa= sc.nextInt()-1;
                grafi[papa].add(i);
                grafi[i].add(papa);
            }
            visi = new boolean[n];
            if(nim(0)==0) System.out.println(2);
            else System.out.println(1);
        }

    }
}
