import java.util.*;

public class HandGame {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        List<Player> players = new ArrayList<>();
        String winOrder[] = {"C","P","R","L","S","C","L","P","S","R","C"};
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int NUMPLAYER = in.nextInt();
            String SIGNPLAYER = in.next();
            players.add(new Player(NUMPLAYER, SIGNPLAYER));
        }
        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");
        while(players.size() > 1){
            for(int i = 0; i < players.size(); i++){
                System.err.println("Number of players:"+players.size());
                System.err.println("Index of:"+i);
                //checking for tie
                if(players.get(i).getMove().equals(players.get(i+1).getMove())){
                    System.err.println("TIE!!!!!");
                    if(players.get(i).getId()<players.get(i+1).getId()){
                        System.err.println("P1 WINS");
                        players.get(i).addOpponent(players.get(i+1).getId());
                        players.remove(i+1);
                    }else{
                        System.err.println("P2 WINS");
                        players.get(i+1).addOpponent(players.get(i).getId());
                        players.remove(i);
                    }
                    continue;
                }
                String pOneMove = players.get(i).getMove();
                String pTwoMove = players.get(i+1).getMove();
                System.err.println("P1:"+pOneMove + "  P2:"+pTwoMove);
                for(int j = 0; j < winOrder.length-1; j++){
                    if(pOneMove.equals(winOrder[j])){
                        if(pTwoMove.equals(winOrder[j+1])){
                            System.err.println("P1 WINS");
                            players.get(i).addOpponent(players.get(i+1).getId());
                            players.remove(i+1);
                        }
                    }
                    if(pTwoMove.equals(winOrder[j])){
                        if(pOneMove.equals(winOrder[j+1])){
                            System.err.println("P2 WINS");
                            players.get(i+1).addOpponent(players.get(i).getId());
                            players.remove(i);
                        }
                    }
                }

            }
        }
        System.out.println(players.get(0).getId());
        System.out.println(players.get(0).getOpponents());
        //System.out.println("WHO IS THE WINNER?");
    }

}
class Player {
    private int id;
    private String move;
    private String opponents = "";
    public Player(int id, String move){
        this.id = id;
        this.move = move;
    }
    public int getId(){
        return id;
    }
    public String getMove(){
        return move;
    }
    public void addOpponent(int id){
        opponents+=id+" ";
    }
    public String getOpponents(){
        return opponents.substring(0, opponents.length()-1);
    }

}
