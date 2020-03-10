import java.util.*;

class Descent {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            int targetIndex = -1;
            int targetHeight = -1;
            for (int i = 0; i < 8; i++) {
                int mountainH = in.nextInt(); // represents the height of one mountain.
                if(targetHeight<mountainH){
                    targetIndex = i;
                    targetHeight = mountainH;
                }
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println(targetIndex); // The index of the mountain to fire on.


        }
    }
}
