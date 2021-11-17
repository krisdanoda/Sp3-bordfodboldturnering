import java.util.ArrayList;
import java.util.Arrays;

public class Knockout extends Tournament {
    ArrayList<Match[]> matchesList = new ArrayList<>(); // matchesList has an array of matches, each array represents a round of matches.

    public Knockout(String name) {
        this.name = name;
        teams = new ArrayList<>();
    }

    public Knockout(ArrayList <Team> teams ){
        this.teams=teams;
        this.closeSignUp =false;

    }


    //Create ALL matches from a list of teams. The first rounds a placed first
    public Match[] createMatches() {
        // Create list of empty matches
        matches = new Match[teams.size() - 1];
        for (int i = 0; i < matches.length; i++)
            matches[i] = new Match();

        //Puts in teams into the first matches
        for (int i = 0; i < teams.size(); i++) {
            if (i % 2 == 0) {
                matches[i / 2].setTeam1(teams.get(i));
            } else {
                matches[((i - 1) / 2)].setTeam2(teams.get(i));
            }
        }
        return matches;
    }

    public void printBracket(){
        if( matchesList == null || matchesList.size() == 0)
            System.out.println("Brackets er ikke lavet endnu");

        for (int i = 0; i < matchesList.size(); i++) {
            System.out.println("           Runde " + (matchesList.size() - i));
            for (Match match : matchesList.get(i))
                System.out.println(match);;
        }
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



    public Team[] getTeamArray() {
        Team[] teamArray = new Team[this.teams.size()];
        for (int i = 0; i < this.teams.size(); i++) {
            teamArray[i] = teams.get(i);
        }
        return teamArray;
    }

    public ArrayList<Match[]> getMatchesList() {
        return matchesList;
    }
}


