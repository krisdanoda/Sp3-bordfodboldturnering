import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private Knockout currentTournament;
    public int count2=0;



    public void menu() {
        int input=0 ;

        while(count2==0) {
            input = getUserInputInt("1. Admin\n2. Spiller\n3. Afslut");
            if (input == 1) {

                adminMainMenu();
            } else if (input == 2) {

                count2++ ;
                playerMenu(currentTournament);
            }
            else if (input == 3){
                count2=9;
            }
            else{
                System.out.println("Indtast gyldigt menu nummer");
            }
        }
    }


    void adminMainMenu(){
        String menuItem1 = "1. Se turnering";
        String menuItem2 = "2. Lav turnering";
        String menuItem3 = "3. Load Data";
        String menuItem4 = "4. Save Data";
        String menuItem5 = "5. Tilbage";
        String[] menuItems = {menuItem1, menuItem2, menuItem3, menuItem4,menuItem5};
        boolean quit = false;
        while (!quit) {
            for (String menuItem: menuItems)
                System.out.println(menuItem);

            switch (getUserInputInt()){
                case 1:
                    if(currentTournament!=null) {
                        adminTournamentMainMenu();
                    }
                    else{
                        System.out.println("Der findes ikke nogen turnering");
                    }
                    break;


                case 2:
                    System.out.println("Skriv navn til turnering");
                    currentTournament = new Knockout(getUserInput());
                    break;
                case 3:
                    //Load data
                    ArrayList <Team> tempTeam = Main.io.readTeamData();
                    Match [] tempMatches = Main.io.readMatchData();
                    if (tempMatches.length>0) {
                        currentTournament = new Knockout(tempTeam, tempMatches);
                    }
                    else {
                        currentTournament = new Knockout(tempTeam);
                    }
                    break;

                case 4:
                    //Save Data
                    Main.io.saveGameData(currentTournament);
                    System.out.println(currentTournament.getName() + " er gemt");
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Indtast gyldigt menu nummer");
                    break;
            }
        }
    }

    void adminTournamentMainMenu() {
        boolean quit = false;
        String menuItem1 = "1. Se tilmeldte hold";
        String menuItem2 = "2. Se info om turnering";
        String menuItem3 = "3. Rediger turnering"; //Change name, change date, close deadline
        String menuItem4 = "4. Se oversigt"; //If only the tournament has started
        String menuItem5 = "5. Rediger kampe";
        String menuQuit = "6. Tilbage";
        String[] menuItems = {menuItem1, menuItem2, menuItem3, menuItem4,menuItem5, menuQuit};


        while (!quit) {

            for (String menuItem : menuItems)
                System.out.println(menuItem);

            switch (getUserInputInt()) {
                case 1:
                    //1.Se tilmeldte hold
                    currentTournament.printTeams();
                    break;
                case 2:
                    // 2. se info om turnering
                    System.out.println(currentTournament.toString());
                    break;
                case 3: //3. Rediger turnering
                    editTournament();
                    break;
                case 4: // Se Kamp Oversigt
                    currentTournament.printBracket();
                    Frame f = new Frame(currentTournament);
                    break;
                case 5: // Rediger matches
                    if(currentTournament.matches!=null) {
                        currentTournament.printMatches();
                        System.out.println((currentTournament.matches.length + 1) + ": sæt vinder til næste runde");

                        int input = getUserInputInt();
                        if (input == currentTournament.matches.length + 1) {
                            System.out.println("Vindere i " + currentTournament.getName() + " er sat.");
                            currentTournament.setNextRound();
                        } else if (input > 0 && input <= currentTournament.matches.length)

                            editMatch(currentTournament.matches[input - 1]);
                    }
                    else{
                        System.out.println("Der er ikke oprettet nogen kampe");
                    }
                    break;
                case 6:
                    //Return til main menu
                    quit = true;
                    break;
                default:
                    System.out.println("Indtast gyldigt menu nummer");
            }
        }
    }

     private void editTournament() {
        boolean quit2=false ;
        while(!quit2) {
            String menuItem1 = "1. ændre på turnering navn: " + currentTournament.getName();
            String menuItem2 = "2. ændre på tilmelding frist: " + currentTournament.getDeadline();
            String menuItem3 = "3. Luk tilmelding";
            String menuItem4 = "4. Shuffle hold"; //todo: make shuffle team method in Tournament Not n
            String menuItemQuit = "4. Tilbage";

            String[] menuItems = {menuItem1, menuItem2, menuItem3, menuItemQuit};
            for (String menuItem : menuItems)
                System.out.println(menuItem);
            switch (getUserInputInt()) {
                case 1:
                    currentTournament.setName(getUserInput("Navn: "));
                    break;
                case 2:
                    currentTournament.setDeadline(getUserInput("Ændre tilmeldingsfrist "));
                    break;
                case 3:
                    if(currentTournament.teams.size()>=1) {
                    System.out.println("Tilmelding er lukket");
                    currentTournament.setCloseSignUp(true);
                    currentTournament.createMatches();
                    currentTournament.createBracket();
                    }
                    else{
                        System.out.println("Der er ikke nok hold tilmeldt");
                    }
                    break;
                case 4:
                    quit2=true;
                    break;
                default:
                    System.out.println("Indtast gyldigt menu nummer");
                    break;
            }
        }
    }


     private void editMatch(Match match) {
        if ( match.getTeam1() == null || match.getTeam2() == null) {
            System.out.println("Kan ikke sæt Score på kampen fordi der mangler hold");
        }else {
            Team team1 = match.getTeam1();
            Team team2 = match.getTeam2();

            String menuItem1 = "1. Sæt point for hold: " + team1.getName();
            String menuItem2 = "2. Sæt point for hold: " + team2.getName();
            String[] menuItems = {menuItem1, menuItem2};


            for (String menuItem : menuItems)
                System.out.println(menuItem);
            String msg = "Sæt point for hold";
            switch (getUserInputInt()) {
                case 1:
                    match.setScore1(getUserInputInt("Sæt point for hold " + team1));
                    break;
                case 2:
                    match.setScore2(getUserInputInt("Sæt point for hold " + team2));
                    break;
            }
        }

    }


    //gets user input and returns input as a string. Takes a message as an input which it prints out
    private String getUserInput(String msg) {
        System.out.println(msg);
        return getUserInput();
    }

    //gets user input and returns input as a string
    String getUserInput() {
        String input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        return input;
    }

    //gets user input and returns an int
    int getUserInputInt() {
        int input;
        Scanner scan = new Scanner(System.in);
        //Check to see if its valid int
        while (true)
            try {
                input = Integer.parseInt(scan.nextLine());
                break;
            } catch (NumberFormatException nfe) {
                System.out.print("Invalid int. Prøv igen:");
            }
        return input;
    }

    int intGetUserIntWithin(int menuItemsSize) {
        int input;
        return getUserInputInt();
    }


    //gets user input and returns it as a string
    int getUserInputInt(String msg) {
        System.out.println(msg);
        return getUserInputInt();
    }
    public void playerMenu(Knockout tournament) {
        int input = 0;
        Team team=new Team("test") ;

        while(count2==1){
            if (tournament.getIsCloseSignUp()) {
                System.out.println("Der er lukket for tilmelding");
                count2=0 ;
            } else {

                input = getUserInputInt("1. Opret nyt hold\n2. Tilmeld spiller til eksisterende hold\n3. Tilbage");
                count2++ ;
            }
            if (input == 1) {
                while(count2==2){

                    team = teamName(tournament);

                    playerNames(team);
                    count2++ ;
                }
                while(count2==3) {
                    int input3;
                    input3 = getUserInputInt("1. Fuldfør tilmelding\n2. Tilføj flere spillere\n3. Tilbage");

                    if (input3 == 1) {
                        registrationComplete(tournament, team);
                        count2=0 ;
                    } else if (input3 == 2) {
                        extraPlayer(team);

                        input3 = getUserInputInt("1.Fuldfør tilmelding\n2. Tilføj flere spillere\n3. Tilbage");
                        if (input3 == 1) {
                            registrationComplete(tournament, team);
                            count2=0;

                        } else if (input3 == 2) {
                            lastPlayer(team);

                            registrationComplete(tournament, team);
                            count2=0 ;
                        }
                        else if (input3==3){
                            count2=0;
                        }
                        else{
                            System.out.println("Indtast gyldigt menu nummer");
                            count2=0 ;
                        }
                    }
                    else if (input3==3){
                        count2=0 ;
                    }
                    else{
                        System.out.println("Indtast gyldigt menu nummer");
                        count2=0 ;
                    }
                    count2++ ;
                }
            } else if (input == 2) {
                while(count2==2) {
                    int count = 1;
                    int inputA;

                    System.out.println("Hvilket hold vil du tilføje en spiller til?");

                    for (int i = 0; i < tournament.getTeams().size(); i++) {

                        System.out.println(count + ". " + tournament.getTeams().get(i).getName());
                        count++;
                    }
                    System.out.println(count + ". Tilbage");

                    inputA = getUserInputInt();
                    count2++ ;
                    if(inputA==count){
                        count2=1;
                    }
                    else if(inputA<=count){
                        extraPlayer(tournament.getTeams().get(inputA-1));
                        count2=0;
                    }
                    else{
                        System.out.println("Indtast gyldigt menu nummer");
                        count2=2 ;
                    }
                }
            }
            else if(input==3){
                count2=0 ;
            }
            else{
                System.out.println("Indtast gyldigt menu nummer");
                count2=1 ;
            }
        }
    }
    public Team teamName(Tournament tournament){
        String inputS2;

        int id = tournament.getTeams().size()+1;

        inputS2 = getUserInput("Angiv holdnavn:");
        Team team = new Team(id, inputS2, 0);
        tournament.addTeam(team);
        return team ;
    }
    public void playerNames(Team team){
        String inputS;

        inputS = getUserInput("Angiv navn på første spiller:");
        team.getPlayers().add(new Player(inputS));

        inputS = getUserInput("Angiv navn på næste spiller");
        team.getPlayers().add(new Player(inputS));
    }
    public void registrationComplete(Tournament tournament, Team team){
        System.out.println("Jeres hold "+ team.getName()+" er nu tilmeldt " + tournament.getName() + "en");
    }
    public void extraPlayer(Team team){
        String inputS;

        inputS = getUserInput("Angiv navn på næste spiller");
        team.getPlayers().add(new Player(inputS));
    }
    public void lastPlayer(Team team){
        String inputS ;
        inputS = getUserInput("Angiv navn på sidste spiller");
        team.getPlayers().add(new Player(inputS));
    }
}
