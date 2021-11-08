import java.util.ArrayList;

public class PlayerUI {
    public static void playerMenu(Tournament tournament) {
        boolean closeSignup = false;

        if (closeSignup) {
            System.out.println("Der er lukket for tilmelding");
        } else {
            int input = 0;

            input = UI.getUserInputInt("1. Opret nyt hold\n2. Tilmeld spiller til eksisterende hold");

            if (input == 1) {
                int input2 = 0;
                String inputS = "";

                inputS = UI.getUserInput("Angiv holdnavn:");
                Team team = new Team(inputS);
                tournament.addTeam(team);

                inputS = UI.getUserInput("Angiv navn på første spiller:");
                team.getPlayers().add(new Player(inputS));

                inputS = UI.getUserInput("Angiv navn på næste spiller");
                team.getPlayers().add(new Player(inputS));

                input2 = UI.getUserInputInt("1. Fuldfør tilmelding\n2. Tilføj flere spillere");
                if (input2 == 1) {
                    System.out.println("Jeres hold " + team.getName() + " er nu tilmeldt " + tournament.getName() + "en");
                } else if (input2 == 2) {
                    inputS = UI.getUserInput("Angiv navn på næste spiller");
                    team.getPlayers().add(new Player(inputS));

                    input2 = UI.getUserInputInt("1.Fuldfør tilmelding\n2. Tilføj flere spillere");
                    if (input2 == 1) {
                        System.out.println("Jeres hold " + team.getName() + " er nu tilmeldt " + tournament.getName() + "en");
                    } else if (input2 == 2) {
                        inputS = UI.getUserInput("Angiv navn på sidste spiller");
                        team.getPlayers().add(new Player(inputS));
                        System.out.println("Jeres hold " + team.getName() + " er nu tilmeldt " + tournament.getName() + "en");
                    }
                }
            } else if (input == 2) {
                int count = 1;
                int inputA=0 ;
                String inputS="";

                for(int i=0 ; i< tournament.getTeams().size() ; i++) {

                    System.out.println(count + ". " + tournament.getTeams().get(i));
                    count++ ;
                }
                System.out.println(count + ". Tilbage");
                inputA=UI.getUserInputInt("Hvilket hold vil du tilføje en spiller til:");
                if(inputA==count){

                }
                inputS=UI.getUserInput("Angiv navn på spiller:");

                tournament.getTeams().get(inputA).getPlayers().add(new Player(inputS));

            }
        }
    }
}
