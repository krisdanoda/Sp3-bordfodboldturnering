import javax.xml.namespace.QName;

public class Match {
    private Team team1, team2;
    private int score1, score2;
    private String date;
    private static int ID = 1;
    private int matchID;
    //private int round;
    public Match(Team t1, Team t2) {
        team1 = t1;
        team2 = t2;
        matchID = ID;
        ID++;
    }

    public Match(int Id, Team t1, Team t2, int score1, int score2, String date) {
        team1 = t1;
        team2 = t2;
        this.score1 = score1;
        this.score2 = score2;
        this.date = date;
        matchID = Id;
    }

    public Match() {
        matchID = ID;
        ID++;
    }

    @Override
    public String toString() {
        String str = "";
        if (team1 != null)

            str += this.team1.toString();
        else
            str += "Ukendt hold ";
        str += ": "+score1;
        str += " < vs > ";
        if (team2 != null)
            str += this.team2.toString();
        else
            str += "Ukendt hold ";
        str += ": "+this.score2;


        return str;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public int getMatchID() {
        return matchID;
    }

    public String getDate() {
        return date;
    }

    public Team getWinner() {
        Team winner = null;
        if (score1 > score2)
            winner = team1;
        if (score2 > score1)
            winner = team2;
        return winner;
    }
}
