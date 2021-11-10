public class Match {
    private String name;
    private Team team1;
    private Team team2;
    private int score1;
    private int score2;
    private String date;

    public Match() {
<<<<<<< Updated upstream
        this.name = "x";
        this.date = "00 / 00";
=======
        this.name = "ukendt";
>>>>>>> Stashed changes
    }

    public Match(Team t1, Team t2) {
        team1 = t1;
        team2 = t2;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score) {
        this.score1 = score;
    }

<<<<<<< Updated upstream
    public void setScore2(int score) {
        this.score2 = score;
    }

=======
>>>>>>> Stashed changes
    public int getScore2() {
        return score2;
    }

<<<<<<< Updated upstream
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
=======
    public void setScore2(int score) {
        this.score2 = score;
    }

    public String getName() {
        return this.name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
>>>>>>> Stashed changes
    }

    public Team getWinner() {
        if (this.score1 > this.score2) {
<<<<<<< Updated upstream
            return team1;
        }
        else {
            return team2;
        }
    }

    /*
    @Override
    public String toString() {
        String str = "";
        str += this.team1.toString() + " <-- MOD --> " + this.team2.toString() +
                ", " + this.score1 + " - " + this.score2;
        return str;
    }

     */

=======
            return this.team1;
        }
        else if (this.score1 < this.score2) {
            return this.team2;
        }
        else {
            return null;
        }
    }
>>>>>>> Stashed changes
}
