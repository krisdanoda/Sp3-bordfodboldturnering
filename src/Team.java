import java.util.ArrayList;

public class Team {

    private String name;
    private ArrayList<Player> players;
<<<<<<< Updated upstream
    private int points;
=======
    private int score;
>>>>>>> Stashed changes
    private int teamID;
    private boolean hasPlayedExtra = false;
    private static int cnt = 1;
    private static int ID = 1;

<<<<<<< Updated upstream
    public Team() {
        this.teamID = ID;
        ID++;
    }

=======
>>>>>>> Stashed changes
    public Team(String name) {
        this.name = name;
        players = new ArrayList<Player>();
        points = 0;
        initPlayers(); //Slettes senere
        teamID = ID++;
    }

    public void initPlayers() {
        //int n = (int) (10 * Math.random() + 2);
        for (int i = 0; i < 2; i++) {
            players.add(new Player("p" + cnt));
            cnt++;
        }
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getTeamID() {
        return teamID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    @Override
    public String toString() {
        String str = "";
<<<<<<< Updated upstream
        int t = 0;
        str += "ID = " + getTeamID() + ": " + this.name;
        for (Player p : players) {
            if (t % 20 == 0) {
                str += "\n";
            }
            else {
                str += ", ";
            }
            str += players.get(t);
            t++;
        }

=======
        str += "ID = " + getTeamID() + ", HoldNavn = " + this.name;
>>>>>>> Stashed changes
        return str;
    }

     */

}
