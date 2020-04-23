import java.util.*;

/**
 * Turns out Arrays.sort() is really fast/optimised.Should use it more often.
 */
public class HorseRacingDuals {
    public static void main(String args[]) {
        long startTimeStamp = System.currentTimeMillis();
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.err.println("Array Size:"+N);
        int [] horses = new int[N];
        for (int i = 0; i < N; i++) {
            horses[i] = in.nextInt();
        }
        System.err.println("Array gen time:"+ (System.currentTimeMillis() - startTimeStamp)+"ms");
        long lastStamp = System.currentTimeMillis();
        Arrays.sort(horses);
        System.err.println("Array Sort time:"+ (System.currentTimeMillis() - lastStamp)+"ms");
        int dif = horses[1]-horses[0];
        for(int i = 1; i<N-1; i++){
            if(horses[i+1]-horses[i] < dif){
                dif = horses[i+1]-horses[i];
            }
        }
        System.out.println(dif);
        System.err.println("Total computation time:"+(System.currentTimeMillis()-startTimeStamp)+"ms");
    }
}
