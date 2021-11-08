import java.util.ArrayList;

public class TournamentController {

    private KnockOut k;

    public TournamentController() {
        k = new KnockOut();
        initTeams();
    }

    public void runLoop() {
        //Beregner antal runder i turneringen
        k.calcRounds();

        Team[] t0 = k.getTeamArray();
        k.addTeamsLeft(t0);

        k.calcTeamsTree();

        k.createMatchTree();

        ArrayList<Match[]> mAl = k.getRoundMatches();
        int maLen = mAl.size();
        System.out.println("\nma-size = " + maLen);
        for (int i = 0; i < maLen; i++) {
            for (int j = 0; j < mAl.get(i).length; j++) {
                System.out.print("\n" + mAl.get(i)[j].getName() + "," + mAl.get(i)[j].getDate() + " ");
            }
            System.out.println();

        }

        Team[] t = k.getTeamsLeft().get(0);
        for (int i = 0; i < t.length; i++) {
            System.out.print(t[i].getName() + " ");
        }
        k.createMatches(t, 0);

/*
        for (int i = 0; i < k.getRoundMatches().size(); i++) {
            System.out.println("\nrunde " + i + ":");
            for (int j = 0; j < k.getRoundMatches().get(i).length; j++) {
                System.out.print(k.getRoundMatches().get(i)[j].getName() + " - " +
                        k.getRoundMatches().get(i)[j].getName() + ", ");
            }
        }




 */




        /*
        //laver holdArrayListen om til et holdArray
        Team[] t = k.getTeamArray();
        //Lægger Team-arrayet over i en ny ArrayList
        k.setTeamsLeftArrays(t);

        //System.out.println();
        System.out.print("holdnavne: ");
        for (Team tm: k.getTeamsLeftArrays().get(0)) {
            System.out.print(tm.getName() + " ");
        }
        System.out.println();

        //Beregner antallet af hold i hver runde
        System.out.print("Antal hold: ");
        int[] tt = k.calcNoOfTeams();

        int[] noM = k.calcNumberOfMatches(tt);
        System.out.print("Antal kampe: ");
        for (int i = 0; i < noM.length; i++) {
            System.out.print(noM[i] + " ");
        }
        System.out.println();


         */


    }

    private void initTeams() {
        k.teams.add(new Team("#1"));
        k.teams.add(new Team("#2"));
        k.teams.add(new Team("#3"));
        k.teams.add(new Team("#4"));
        k.teams.add(new Team("#5"));
        k.teams.add(new Team("#6"));
        k.teams.add(new Team("#7"));
        k.teams.add(new Team("#8"));
        k.teams.add(new Team("#9"));
        //k.teams.add(new Team("#10"));
    }

}
