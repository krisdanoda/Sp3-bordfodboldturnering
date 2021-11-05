import java.util.ArrayList;

public class Team {

    private String name;
    private ArrayList players;
    private int score;
    private int teamID;
    private static int cnt = 0;
    private static int ID = 1;



    public Team(String name) {
        this.name = name;
        players = new ArrayList<Player>();
        score = 0;
        //initPlayers();
        teamID = ID++;

    }


    /*public void initPlayers() {
        cnt++;
        players[0] = "p" + cnt;
        cnt++;
        players[1] = "p" + cnt;
    }*/
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

    public int getTeamID() {
        return teamID;
    }

    @Override
    public String toString() {
        String str = "";
        str += "ID = " + getTeamID() + ", HoldNavn = " + this.name +
                ", player1 = " + this.players.get(0) + ", player2 = " + this.players.get(1);
        return str;
    }


}
