import java.util.ArrayList;
import java.util.List;

public class Knockout {
    private ArrayList<Team> teams;
    private Team[][] roundTeamArray;
    private ArrayList<Match> roundMatchList;
    private int rounds;
    private boolean extraMatchFlag;

    public Knockout() {
        extraMatchFlag = false;
        roundMatchList = new ArrayList<Match>();
        teams = new ArrayList<Team>();
        initTeams();
        rounds = (int) (Math.log(teams.size()) / Math.log(2)) + 1;
        roundTeamArray = new Team[rounds][];
    }

    public Match[] createMatches(Team[] teamArr) {
        int arrLen = teamArr.length;
        Match[] matches = new Match[numberOfMatches(teamArr)];
        int j = (int) (arrLen / 2);
        for (int i = 0; i < (arrLen / 2); i++) {
            matches[i] = new Match(teams.get(i), teams.get(j));
            j++;
        }
        if (extraMatchFlag) {
            matches[matches.length - 1] = new Match(teams.get(matches.length - 2), teams.get(matches.length - 1));
            extraMatchFlag = false;
        }
        return matches;
    }

    public int numberOfMatches(Team[] teams) {
        int arrLen = teams.length;
        if (arrLen % 2 == 1) {
            this.extraMatchFlag = true;
            return (arrLen / 2) + 1;
        }
        else {
            return arrLen / 2;
        }
    }

    public void printMatches(Match[] matches) {
        System.out.println("Kampe:");
        for (Match m : matches) {
            System.out.println(m.toString());
        }
    }

    public void printTeams(Team[] teamArray) {
        for (Team t : teamArray) {
            System.out.println(t.toString());
        }
        System.out.println("Antal runder = " + rounds);
    }

    public Team[] getTeamArray() {
        Team[] teamArray = new Team[this.teams.size()];
        for (int i = 0; i < this.teams.size(); i++) {
            teamArray[i] = teams.get(i);
        }
        return teamArray;
    }

    private void initTeams() {
        teams.add(new Team("#1"));
        teams.add(new Team("#2"));
        teams.add(new Team("#3"));
        teams.add(new Team("#4"));
        teams.add(new Team("#5"));
        teams.add(new Team("#6"));
        teams.add(new Team("#7"));
        teams.add(new Team("#8"));
        teams.add(new Team("#9"));

    }

}


