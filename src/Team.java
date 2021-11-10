import java.util.ArrayList;

public class Team {

    private String name;
    private ArrayList players;
    private int score;
    //private static int ID = 1;



    public Team(String name) {
        this.name = name;
        players = new ArrayList<Player>();
        players.add(new Player("1"));
        players.add(new Player("2"));
        score = 0;
        //teamID = ID++;

    }

    public String getName(){
        return name ;
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        String str = "";
        str += this.name;
        return str;
    }


}
