import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Knockout k = new Knockout();
        k.printTeams(k.getTeamArray());
        Match[] matches = k.createMatches(k.getTeamArray());
        k.printMatches(matches);

    }

}
