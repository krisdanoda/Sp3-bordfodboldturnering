import java.util.ArrayList;

public class Tournament {
    private String name;
    private String deadline;
    private ArrayList<Team> teams;
    private boolean closeSignUp;

    public Tournament(String name){
        this.name=name ;
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

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }
}
