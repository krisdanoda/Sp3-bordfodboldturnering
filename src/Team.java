import java.util.ArrayList;

public class Team {

    private String name;
    private ArrayList<Player> players;
    private int score;
    private static int ID = 1;
    private int  teamID;


    public Team(String name) {
        this.name = name;
        players = new ArrayList<Player>();
        score = 0;
        this.teamID = ID++;

    }

    public Team(int ID, String name, int Score){
        this.teamID = ID;
        this.name = name;
        this.score = Score;
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
    public void addScore(int score) {
        this.score += score;
    }

    public int getTeamID() {
        return teamID;
    }

    @Override
    public String toString() {
        String str = "";
        str += this.name;
        return str;

    }


}
