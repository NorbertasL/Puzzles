import java.util.*;

public class HorseRacingDuals {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.err.println("Size:"+N);
        int [] horses = new int[N];
        for (int i = 0; i < N; i++) {
            horses[i] = in.nextInt();
        }
        int dif = -1;
        for(int i = 0; i<N-1; i++){
            for(int j = i+1; j<N; j++){
                int strDif = Math.abs(horses[i]-horses[j]);
                if(dif>strDif || dif == -1){
                    dif = strDif;
                }
            }
        }
        System.out.println(dif);


    }
}
