import java.util.ArrayList;

public class Tournament {
    private String name;
    private String deadline;
    protected ArrayList<Team> teams;
    private boolean closeSignUp;

    public Tournament(String name){
        this.name=name ;
        teams = new ArrayList<>();
    }
    public Tournament(){
        teams = new ArrayList<>();
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
}
