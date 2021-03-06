import java.util.ArrayList;
import java.util.Arrays;

public class Tournament {
    protected Match[] matches; // Array of ALL matches
    protected String name;
    protected String deadline;
    protected ArrayList<Team> teams;
    protected boolean closeSignUp;


    public void setScore() {
        for (Team team : teams)
            team.setScore(0);

        for (Match match : matches) {
            if (match.getTeam1() != null && match.getTeam2() != null) {
                match.getTeam1().addScore(match.getScore1() - match.getScore2());
                match.getTeam2().addScore(match.getScore2() - match.getScore1());
            }
        }
    }

    public Tournament(String name) {
        this.name = name;
        teams = new ArrayList<>();
        closeSignUp = false;
    }

    public Tournament() {
        teams = new ArrayList<>();
    }

    public void printMatches() {
        int i = 1;
        for (Match match : matches) {
            System.out.println(i + ": " + match.toString());
            i++;
        }
    }

    public void printTeams() {
        if (teams.size() != 0) {
            for (Team t : teams) {
                System.out.println(t.toString());
            }
        } else {
            System.out.println("Der er ingen hold tilmeldt endnu");
        }
    }

    public void setCloseSignUp(boolean closeSignUp) {
        this.closeSignUp = closeSignUp;
    }

    public boolean getIsCloseSignUp() {
        return closeSignUp;
    }


    public String getName() {
        return name;
    }

    public Match[] getMatches() {
        return matches;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void addTeam(Team newTeam) {
        teams.add(newTeam);
    }

    @Override
    public String toString() {
        String str = "";
        str += " Navn: " + name;
        str += ". Tilmeldingsfrist: " + deadline;
        str += ". Der er " + teams.size() + " hold tilmeldte";
        if (closeSignUp == true)
            str += ". Tilmelding er slut";
        else str += ". Tilmelding er ??ben";
        return str + ".";

    }
}
