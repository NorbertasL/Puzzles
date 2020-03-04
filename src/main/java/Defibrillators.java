import java.util.*;
import java.io.*;
import java.math.*;
public class Defibrillators {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String LON = in.next();
        String LAT = in.next();

        double userLon = stringToDouble(LON);
        double userLat = stringToDouble(LAT);

        int N = in.nextInt();
        //System.err.println("LON:"+userLon+ ": LAT:"+userLat);
        if (in.hasNextLine()) {
            in.nextLine();
        }
        double bestDist = -1.0;
        String bestDefName = "";
        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            String[] splitDefib = DEFIB.split(";");
            double lon = stringToDouble(splitDefib[splitDefib.length-2]);
            double lan = stringToDouble(splitDefib[splitDefib.length-1]);

            double dist = getRadianDistance(userLon, userLat, lon, lan);

            if(bestDist == -1 || dist < bestDist){
                bestDist = dist;
                bestDefName = splitDefib[1];
            }

            //System.err.println(DEFIB);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(bestDefName);
    }

    public static double getRadianDistance(double lonA, double latA, double lonB, double latB){
        double x = (lonB - lonA)* Math.cos((latA + latB)/2);
        double y = latB- latA;
        double dist = (Math. sqrt((x*x)+(y*y)))*6371;
        return dist;
    }
    public static double stringToDouble(String s){
        s = s.replace(",", ".");
        return Double.valueOf(s);
    }
}
