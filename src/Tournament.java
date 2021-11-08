import java.util.ArrayList;
import java.util.Date;

public class Tournament {

    private String name;
    private ArrayList<Team> teams;
    private Knockout knockout;
    private String deadline;
    private boolean closeSignUp;
    public Tournament(String name){
        this.name=name ;
    }
    public ArrayList getTeams(){
        return teams ;
    }
    //maybe private date
    //private Date deadline


    public String getName(){
        return name ;
    }
}
