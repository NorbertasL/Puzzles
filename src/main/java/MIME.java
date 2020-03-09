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
            String ext = null;
            try{
                if(FNAME.charAt(FNAME.length()-1) == '.'){
                    throw new ArrayIndexOutOfBoundsException("Bad extension");
                }
                // "." is a special char so we need to use \\ or enclose it in []
                String [] split = FNAME.split("[.]");
                ext = split.length > 2 ? split[split.length-1] : split[1];

            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("UNKNOWN");
                continue;
            }

            String mimeType = mimePairs.get(ext);
            if(mimeType == null){
                System.out.println("UNKNOWN");
            }
            else{
                System.out.println(mimeType);
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");


        // For each of the Q filenames, display on a line the corresponding MIME type. If there is no corresponding type, then display UNKNOWN.

    }
}