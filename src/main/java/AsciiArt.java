import java.util.*;

class AsciiArt {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String T = in.nextLine();

        //System.err.println("String is :"+T);


        for(int i = 0; i < H; i++){
            String ROW=in.nextLine();;
            String lineToPrint = "";
            for(int j = 0; j<T.length(); j++){
                int charToInt = Character.getNumericValue(T.charAt(j));
                int startIndex = 0;
                if(charToInt < 0){
                    //special char will alway be last 
                    startIndex = ROW.length()-L;
                    //System.err.println("Special char index start:"+ startIndex);
                }else{
                    startIndex = (charToInt-10)*L;
                }

                lineToPrint += ROW.substring(startIndex, startIndex+L);
                //System.err.println(lineToPrint);

            }

            //



            System.out.println(lineToPrint);
        }

    }
}