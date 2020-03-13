import java.util.*;

class MIME {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.

        TreeMap<String, String> mimePairs = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.
            mimePairs.put(EXT, MT);
        }
        in.nextLine();
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            System.err.println(FNAME);
            int lastDotIndex = FNAME.lastIndexOf(".");
            String extension = lastDotIndex == -1 ? "" : FNAME.substring(lastDotIndex + 1);
            System.out.println(mimePairs.getOrDefault(extension, "UNKNOWN"));
        }
    }
}