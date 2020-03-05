
import java.util.*;


/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Unary {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        System.err.println("MESSAGE:"+MESSAGE);

        List<Integer> binary = getBinaryInt(MESSAGE);

        boolean newSet = true;
        int lastBit = -1;
        int sameBitCount = 0;

        String result = "";

        int i = 0;
        while(i < binary.size()){
            if(newSet){
                result+="0";
                if(binary.get(i) == 0){
                    result+="0";
                }
                result+=" ";
                newSet = false;
                lastBit = binary.get(i);
            }
            if(lastBit == binary.get(i)){
                result+="0";
                lastBit = binary.get(i);
                i++;
                continue;
            }
            result+=" ";
            newSet = true;

        }
        System.out.print(result);

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

    }
    private static List<Integer> getBinaryInt(String s) {
        byte[] bytes = s.getBytes();
        System.err.println("BYTES:"+Arrays.toString(bytes));
        List<Integer> binary = new ArrayList<>();
        //int[] binary = new int[7];
        for (byte b : bytes) {
            int val = b;
            for (int i = 0; i < 7; i++) {
                binary.add(((val & 64) == 0 ? 0 : 1));
                val <<= 1;
            }
        }
        return binary;
    }

}
