import java.util.ArrayList;
import java.util.Arrays;

public class Tournament {
    protected Match[] matches; // Array of ALL matches
    protected String name;
    protected String deadline;
    protected ArrayList<Team> teams;
    protected boolean closeSignUp;

    public Tournament(String name){
        this.name=name ;
        teams = new ArrayList<>();
    }
    public Tournament(){
        teams = new ArrayList<>();
    }

    public void printMatches() {
        for (Match match : matches)
            System.out.println(match.toString());
    }

    public void printTeams() {
        if (teams.size() != 0 ){
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

    public Match getMatch(int index){
        if (index > matches.length-1 || index <0) {
            System.out.println("E Index out of bounds: " + index );
            return null;
        }
        return this.matches[index];
    }



    public String getName() {
        return name;
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

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        String str = "";
        str+= " Navn: " + name;
        str+= " Tilmedning frist: " + deadline;
        str+= " Der er " + teams.size() + " hold tilmedte";
        if ( closeSignUp == true )
        str+= " Tilmedling er slut";
        else str+= " Tilmedling er åben";
        return str;

    }
}
