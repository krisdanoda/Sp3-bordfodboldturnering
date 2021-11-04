public class Team {

    private String name;
    private String[] players;
    private int score;
    private int teamID;
    private static int cnt = 0;
    private static int ID = 0;



    public Team(String name) {
        this.name = name;
        players = new String[2];
        score = 0;
        initPlayers();
        teamID = ID++;
    }


    public void initPlayers() {
        cnt++;
        players[0] = "p" + cnt;
        cnt++;
        players[1] = "p" + cnt;
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
                ", player1 = " + this.players[0] + ", player2 = " + this.players[1];
        return str;
    }

}
