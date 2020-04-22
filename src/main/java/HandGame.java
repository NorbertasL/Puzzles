import java.util.*;

public class HandGame {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        List<Player> players = new ArrayList<>();
        String winOrder[] = {"C","P","R","L","S","C","L","P","S","R","C"};
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            players.add(new Player(in.nextInt(), in.next()));
        }
        while(players.size() > 1){
            for(int i = 0; i < players.size(); i++){
                System.err.println("Number of players:"+players.size());
                System.err.println("Index of:"+i);
                //checking for tie
                Player p1 = players.get(i);
                Player p2 = players.get(i+1);
                if(p1.getMove().equals(p2.getMove())){
                    System.err.println("TIE!!!!!");
                    //Resolving the tie
                    if(p1.getId()<p2.getId()){
                        System.err.println("P1 WINS");
                        setWinner(p1, p2, players);
                    }else{
                        System.err.println("P2 WINS");
                        setWinner(p2, p1, players);
                    }
                    continue;
                }
                System.err.println("P1:"+p1.getMove() + "  P2:"+p2.getMove());
                for(int j = 0; j < winOrder.length-1; j++){
                    if(p1.getMove().equals(winOrder[j])){
                        if(p2.getMove().equals(winOrder[j+1])){
                            System.err.println("P1 WINS");
                            setWinner(p1, p2, players);
                        }
                    }
                    if(p2.getMove().equals(winOrder[j])){
                        if(p1.getMove().equals(winOrder[j+1])){
                            System.err.println("P2 WINS");
                            setWinner(p2, p1, players);
                        }
                    }
                }

            }
        }
        System.out.println(players.get(0).getId());
        System.out.println(players.get(0).getOpponents());
        //System.out.println("WHO IS THE WINNER?");
    }
    private static void setWinner(Player winner, Player loser, List<Player> players){
        winner.addOpponent(loser.getId());
        players.remove(loser);
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
