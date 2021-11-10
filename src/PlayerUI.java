import java.util.ArrayList;

public class PlayerUI {

    public static void playerMenu(Tournament tournament) {
        boolean closeSignup = false;

        int input = 0;
        Team team=new Team("test") ;
        Team team2=new Team("test2") ;
        tournament.addTeam(team);
        tournament.addTeam(team2);

        while(Menu.count2==1){
        if (closeSignup) {
            System.out.println("Der er lukket for tilmelding");
            Menu.count2=0 ;
        } else {

            input = UI.getUserInputInt("1. Opret nyt hold\n2. Tilmeld spiller til eksisterende hold\n3. Tilbage");
            Menu.count2++ ;
        }
            if (input == 1) {
                while(Menu.count2==2){

                team = teamName(tournament);

                playerNames(team);
                    Menu.count2++ ;
            }
                while(Menu.count2==3) {
                    int input3 = 0;
                    input3 = UI.getUserInputInt("1. Fuldfør tilmelding\n2. Tilføj flere spillere\n3. Tilbage");

                    if (input3 == 1) {
                        registrationComplete(tournament, team);

                    } else if (input3 == 2) {
                        extraPlayer(team);

                        input3 = UI.getUserInputInt("1.Fuldfør tilmelding\n2. Tilføj flere spillere");
                        if (input3 == 1) {
                            registrationComplete(tournament, team);

                        } else if (input3 == 2) {
                            lastPlayer(team);

                            registrationComplete(tournament, team);
                        }
                    }
                    else if (input3==3){
                        Menu.count2=0 ;
                    }
                    Menu.count2++ ;
                }
            } else if (input == 2) {
                while(Menu.count2==2) {
                    int count = 1;
                    int inputA = 0;

                    System.out.println("Hvilket hold vil du tilføje en spiller til?");

                    for (int i = 0; i < tournament.getTeams().size(); i++) {

                        System.out.println(count + ". " + tournament.getTeams().get(i).getName());
                        count++;
                    }
                    System.out.println(count + ". Tilbage");

                    inputA = UI.getUserInputInt();
                    Menu.count2++ ;
                    if(inputA!=count){
                        extraPlayer(tournament.getTeams().get(inputA-1));
                    }
                    else{
                        Menu.count2=1 ;
                    }
                }
            }
            else if(input==3){
                Menu.count2=0 ;
            }
        }
    }
    public static Team teamName(Tournament tournament){
        String inputS2 = "";

        inputS2 = UI.getUserInput("Angiv holdnavn:");
        Team team = new Team(inputS2);
        tournament.addTeam(team);
        return team ;
    }
    public static void playerNames(Team team){
        String inputS="";

        inputS = UI.getUserInput("Angiv navn på første spiller:");
        team.getPlayers().add(new Player(inputS));

        inputS = UI.getUserInput("Angiv navn på næste spiller");
        team.getPlayers().add(new Player(inputS));
    }
    public static void registrationComplete(Tournament tournament, Team team){
        System.out.println("Jeres hold "+ team.getName()+" er nu tilmeldt " + tournament.getName() + "en");
    }
    public static void extraPlayer(Team team){
        String inputS="";

        inputS = UI.getUserInput("Angiv navn på næste spiller");
        team.getPlayers().add(new Player(inputS));
    }
    public static void lastPlayer(Team team){
        String inputS="" ;
        inputS = UI.getUserInput("Angiv navn på sidste spiller");
        team.getPlayers().add(new Player(inputS));
    }
}
