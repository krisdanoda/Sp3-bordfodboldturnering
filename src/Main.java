import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
<<<<<<< Updated upstream
        TournamentController tc = new TournamentController();
        tc.runLoop();

=======
        //UI ui = new UI();
        //ui.getUserInputInt();
>>>>>>> Stashed changes

       UI ui = new UI();
       ui.getUserInputInt();

<<<<<<< Updated upstream
=======
        Tournament tournament = new Tournament("Bordfodbold-knockoutturnering");
        //Menu.menu(tournament);

        Knockout k = new Knockout();
        ArrayList<Team> t = k.getTeams(); //Henter startHold-ArrayListen
        Team[] tArr = k.getTeamArray();//Laver arraylisten -> array
        k.setRoundTeamArray(tArr, 0);

        int[] t2 = k.calcTeamsTree(tArr);
        for (int i = 0; i < t2.length; i++) {
            System.out.println("t2[" + i + "] = " + t2[i]);
        }

        int[] matchTree = k.calcMatchTree(t2);
        for (int i = 0; i < matchTree.length; i++) {
            System.out.println("mTree[" + i + "] = " + matchTree[i]);
        }

        Match[] m1 = k.createMatches(tArr);
        System.out.println("1. kamprunde:");
        for (int i = 0; i < m1.length; i++) {
            System.out.println(m1[i].toString());
        }

        ArrayList<Match[]> am = k.getRoundMatchList();
        /*
        System.out.println("am længde = " + am.size());
        for (int i = 0; i < am.get(0).length; i++) {
            System.out.println(am.get(0)[i].toString());
        }


         */
        System.out.println();
        //k.printProgram();

        int a = 0, b = 0;
        for (int i = 0; i < am.get(0).length; i++) {
            a = (int) (5 * Math.random());
            b = (int) (5 * Math.random());
            if (a == b) {
                b++;
            }
            am.get(0)[i].setScore1(a);
            am.get(0)[i].setScore2(b);

        }

        for (int i = 0; i < am.get(0).length; i++) {
            System.out.println(am.get(0)[i].toString());
        }


        Team[] tl = new Team[matchTree[0]];
        for (int i = 0; i < matchTree[0]; i++) {
            tl[i] = am.get(0)[i].getWinner();
        }

        System.out.println("tl =");
        for (int i = 0; i < tl.length; i++) {
            System.out.print(tl[i].getName() + " ");
        }

>>>>>>> Stashed changes
    }


}
