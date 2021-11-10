import java.util.ArrayList;

public class Team {

    private String name;
    private ArrayList<Player> players;
    private int score;

    public Team() {
        players = new ArrayList<Player>();
    }

    public Team(String name) {
        this.name = name;
        players = new ArrayList<Player>();
        score = 0;

    }

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
    public void addScore(int score) {
        this.score += score;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public String toString() {
        return "PLayer: " + name;
    }
}
