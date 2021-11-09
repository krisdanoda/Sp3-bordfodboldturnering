import java.util.ArrayList;
import java.util.Arrays;

public class Knockout extends Tournament {
    private ArrayList<Team> teams;
    private Match[] matches; // Array of ALL matches
    private int rounds;
    ArrayList<Match[]> matchesList = new ArrayList<>(); // matchesList has an array of matches, each array represents a round of matches.
    private String name;

    public Knockout(String name) {
        this.name = name;
        teams = new ArrayList<Team>();
        rounds = (int) (Math.log(teams.size()) / Math.log(2)) + 1;
    }
    //Create a ALL matches from a list of teams. The first rounds a placed first
    public Match[] createMatches() {
        // Create list of empty matches
        matches = new Match[teams.size() - 1];
        for (int i = 0; i < matches.length; i++)
            matches[i] = new Match();

        //Puts in teams into the first matches
        for (int i = 0; i < teams.size(); i++) {
            if (i % 2 == 0) {
                matches[i / 2].setTeam1(teams.get(i));
            } else if (i % 2 != 0) {
                matches[((i - 1) / 2)].setTeam2(teams.get(i));
            }
        }
        return matches;
    }

    //Creates our bracket from a list of rounds
    public void createBracket() {
        int sum = 0, round = 1;

        //while loop to count the number of rounds, and to initialize rounds
        while (true) {
            sum += Math.pow(2, round - 1);

            //add a new round
            matchesList.add(new Match[(int) Math.pow(2, round - 1)]);
            if (sum + Math.pow(2, round) >= matches.length)
                break;
            round++;
        }
        //adds a new round so that it reduces the number of teams/matches into a "standard" tournament bracket format, so a potence of 2.
        int dif = matches.length - sum;
        if (dif > 0)
            matchesList.add(new Match[dif]);
        int k = 0;
        for (int i = matchesList.size() - 1; i >= 0; i--) {

            for (int j = matchesList.get(i).length - 1; j >= 0; j--) {
                matchesList.get(i)[j] = matches[k];
                k++;
            }


        }


    }

    public void setNextRound() {
        for (int i = matchesList.size() - 1; i >= 1; i--) {
            Match[] currentMatches = matchesList.get(i);

            for (int j = 0; currentMatches.length > j; j++)

                if (j % 2 == 0)
                    matchesList.get(i - 1)[(j / 2)].setTeam2(currentMatches[j].getWinner());
                else matchesList.get(i - 1)[(j - 1) / 2].setTeam1(currentMatches[j].getWinner());

        }
    }


    public void printMatches(Match[] matches) {
        System.out.println("Kampe:");
        for (Match m : matches) {
            System.out.println(m.toString());
        }
    }

    public void printTeams() {
        for (Team t : teams) {
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

    public void printMatches() {
        for (Match match : matches)
            System.out.println(match.toString());

    }

    public void setWinners(int i) {
        for (Match match : matchesList.get(i))
            match.setScore1(10);
    }

    public Team[] getWinners() {
        Team winners[] = new Team[matches.length];
        for ( int i = 0; i < winners.length; i++)
            winners[i] = matches[i].getWinner();
        return winners;
    }

    private boolean checkRoundOver( ){
        for (Match match: matches) {
            if (match == null)
                return false;
        }

        return true;
    }

    public void initTeams() {
        teams.add(new Team("#1"));
        teams.add(new Team("#2"));
        teams.add(new Team("#3"));
        teams.add(new Team("#4"));
        teams.add(new Team("#5"));
        teams.add(new Team("#6"));
        teams.add(new Team("#7"));
        teams.add(new Team("#8"));
        teams.add(new Team("#9"));
        teams.add(new Team("#10"));
        teams.add(new Team("#11"));
        teams.add(new Team("#12"));
        teams.add(new Team("#13"));
        teams.add(new Team("#14"));


    }

}


