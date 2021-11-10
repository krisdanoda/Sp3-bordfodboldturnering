import javax.xml.namespace.QName;

public class Match {
    private String name;
    private Team team1;
    private Team team2;
    private int score1;
    private int score2;
    private String date;

    //private int round;
    public Match(Team t1, Team t2) {
        team1 = t1;
        team2 = t2;
    }

    public Match() {
    }

    @Override
    public String toString() {
        String str = "";
        if (team1 != null)
            str += this.team1.toString();
        str += " score: " + score1;
        str += " <-- MOD --> ";
        if (team2 != null)
            str += this.team2.toString();
        str += " score2: " + this.score2;

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

    public Team getWinner() {
        Team winner = null;
        if (score1 > score2)
            winner = team1;
        if (score2 > score1)
            winner = team2;
        return winner;
    }
}
