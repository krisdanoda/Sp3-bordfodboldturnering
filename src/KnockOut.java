import java.util.ArrayList;

public class KnockOut extends Tournament {
    private ArrayList<Team[]> teamsLeft;
    private ArrayList<Match[]> roundMatches;
    private int rounds;
    private boolean extraMatchFlag;

    public KnockOut() {
        extraMatchFlag = false;
        roundMatches = new ArrayList<Match[]>();
        teamsLeft = new ArrayList<Team[]>();
        teams = new ArrayList<Team>();
    }

    //Beregner antal kamprunder
    public void calcRounds() {
        this.rounds = (int) (Math.log(teams.size()) / Math.log(2));
        System.out.println("antal runder: " + this.rounds);
    }

    //Danner et holdlistetræ efter hver kamprunde
    public void calcTeamsTree() {
        int n = this.teamsLeft.get(0).length;
        for (int i = 1; i <= this.rounds; i++) {
            n /= 2;
            this.teamsLeft.add(new Team[n]);
        }

        System.out.println("teamsLeft længde = " + this.teamsLeft.size());

        for (int i = 1; i < this.teamsLeft.size(); i++) {
            for (int j = 0; j < this.teamsLeft.get(i).length; j++) {
                this.teamsLeft.get(i)[j] = new Team();
            }
        }

        //*** Tjek af teamsLeft arraylisten *** Kan senere slettes
        System.out.print("Holdtræ:");
        for (int i = 0; i < this.teamsLeft.size(); i++) {
            System.out.print("\nEfter " + i + ". runde = ");
            for (int j = 0; j < this.teamsLeft.get(i).length; j++) {
                System.out.print(this.teamsLeft.get(i)[j].getTeamID() + ", navn:" + this.teamsLeft.get(i)[j].getName() + " ");
            }
        }//******* Denne blok kan slettes senere *****************
    }

    public void createMatchTree() {
        int n, j;
        Match[] m;
        for (int i = 0; i < this.rounds; i++) {
            n = this.teamsLeft.get(i).length;
            if (n % 2 == 1) {
                this.extraMatchFlag = true;
                m = new Match[(n / 2) + 1];
            }
            else {
                m = new Match[n / 2];
            }
            for (int k = 0; k < n / 2; k++) {
                m[k] = new Match();
            }
            if (this.extraMatchFlag) {
                m[m.length - 1] = new Match();
                this.extraMatchFlag = false;
            }
            this.roundMatches.add(m);
        }
    }

    /*
    public void setMatchTeams(Team[] teams) {
        int n = matches.length;
        int j = (int) (n / 2);
        for (int i = 0; i < n / 2; i++) {
            this.roundMatches.get(0);
        }
    }

     */

    /*
    public int[] calcNoOfTeams() {
        int n = teamsLeftArrays.get(0).length;
        int[] nArr = new int[this.rounds];
        nArr[0] = n;
        for (int i = 0; i < this.rounds-1; i++) {
            n /= 2;
            nArr[i+1] = n;
        }
        for (int i = 0; i < this.rounds; i++) {
            System.out.print(nArr[i] + " ");
        }
        System.out.println();
        return nArr;
    }
     */

    public int[] calcNumberOfMatches(int[] noOfTeamsArray) {
        int[] noOfMatches = new int[this.rounds - 1];
        for (int i = 0; i < this.rounds - 1; i++) {
            if (noOfTeamsArray[i] % 2 == 1) {
                this.extraMatchFlag = true;
                noOfMatches[i] = (noOfTeamsArray[i] / 2) + 1;
            } else {
                noOfMatches[i] = noOfTeamsArray[i] / 2;
            }
        }
        return noOfMatches;
    }

    public void createMatches(Team[] teamArr, int round) {
        int n = teamArr.length;
        int j = (int) (n / 2);
        Match[] m = this.roundMatches.get(round);
        for (int i = 0; i < (n / 2); i++) {
            m[i].setTeam1(teamArr[i]);
            m[i].setTeam2(teamArr[j]);
            j++;
        }
        if (extraMatchFlag) {
            System.out.println("extraFlag = " + extraMatchFlag);
            m[n - 1].setTeam1(teamArr[n - 2]);
            m[n - 1].setTeam2(teamArr[n - 1]);
            extraMatchFlag = false;
        }

        for (Match ma : this.roundMatches.get(round)) {
            System.out.println("\nma = " + ma.getTeam1().getName() + " - " + ma.getTeam2().getName());
        }
    }

    /*
    public Match[] createMatches(Team[] teamArr) {
        int arrLen = teamArr.length;
        Match[] matches = new Match[calcNumberOfMatches(teamArr)];
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

     */

    public int calcNumberOfMatches(Team[] teams) {
        int arrLen = teams.length;
        if (arrLen % 2 == 1) {
            this.extraMatchFlag = true;
            return (arrLen / 2) + 1;
        }
        else {
            return arrLen / 2;
        }
    }

    /*
    public int[] calcMatchTree() {
        int n = numberOfMatches(teamsLeftArrays.get(0));
        int[] noOfMatches = new int[this.rounds];
        for (int i = 1; i < n; i++) {
            if (teamsLeftArrays.get(i).length % 2 != 0) {

            }
        }
        System.out.println("\nKampe i 1. runde: " + noOfMatches);
    }

     */

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

    //Bruges til at omdanne TeamArrayList til et TeamArray
    public Team[] getTeamArray() {
        Team[] teamArray = new Team[this.teams.size()];
        for (int i = 0; i < this.teams.size(); i++) {
            teamArray[i] = teams.get(i);
        }
        return teamArray;
    }

    public ArrayList<Team[]> getTeamsLeft() {
        return this.teamsLeft;
    }

    public void addTeamsLeft(Team[] teamArr) {
        this.teamsLeft.add(teamArr);
    }

    public int getRounds() {
        return this.rounds;
    }

    public ArrayList<Match[]> getRoundMatches() {
        return roundMatches;
    }

    public void addRoundMatches(Match[] roundMatch) {
        this.roundMatches.add(roundMatch);
    }

    /*
    //Opretter 9 hold - kan slettes senere
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
     */

}