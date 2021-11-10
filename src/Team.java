import java.util.ArrayList;

public class Team {

    private String name;
    private ArrayList<Player> players;
    private int score;
    private int teamID;
    private static int cnt = 0;
    private static int ID = 1;

    public Team() {
        players = new ArrayList<Player>();
    }

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

    public void setName(String name) {
        this.name = name;
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

    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public String toString() {
        String str = "";
        str += "ID = " + getTeamID() + ", HoldNavn = " + this.name +
                ", player1 = " + this.players.get(0) + ", player2 = " + this.players.get(1);
        return str;
    }

}
