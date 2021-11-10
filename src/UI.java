import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    static private Knockout currentTournament;
    public static int count2=0;
    public static void menu() {
        int input=0 ;

        while(count2==0) {
            input = UI.getUserInputInt("1. Admin\n2. Spiller\n3. Afslut");
            if (input == 1) {
                //Admin Menu
                UI.adminMainMenu();
            } else if (input == 2) {
                //Spiller menu
                count2++ ;
                PlayerUI.playerMenu(currentTournament);
            }
            else if (input == 3){
                count2=9;
            }
        }
    }


    static void adminMainMenu(){
        String menuItem1 = "1. Se turnering";
        String menuItem2 = "2. Lav turnering";
        String menuItem3 = "3. Tilbage";
        String[] menuItems = {menuItem1, menuItem2, menuItem3};
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
                    //currentTournament.initTeams();
                    break;

                case 3:
                    quit = true;
                    break;

            }
        }
    }

    static void adminTournamentMainMenu() {
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

            switch (UI.getUserInputInt()) {
                case 1:
                    //1.Se tilmeldte hold
                    System.out.println(currentTournament.teams.size());
                    currentTournament.printTeams();


                    break;
                case 2:
                    // 2. se info om turnering
                    //todo: Make a tostring for tournament //this is done :)
                    System.out.println(currentTournament.toString());
                    break;
                case 3: //3. Rediger turnering
                    editTournament();
                    break;
                case 4: // Se Kamp Oversigt
                    currentTournament.printBracket();

                    break;
                case 5: // Rediger matches
                    
                    currentTournament.printMatches();
                    System.out.println((currentTournament.matches.length +1) + ": sæt vinder til næste runde");

                    int input = getUserInputInt();
                    if (input == currentTournament.matches.length+1) {
                        System.out.println("Vindere i " + currentTournament.getName() + " er sat.");
                        currentTournament.setNextRound();
                    } else if (input > 0 && input <= currentTournament.matches.length)
                        editMatch(currentTournament.matches[input - 1]);

                    break;
                case 6:
                    //Return til main menu
                    quit = true;
                    break;

            }
        }
    }

    static private void editTournament() {
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
                    System.out.println("Tilmelding er lukket");
                    currentTournament.setCloseSignUp(true);
                    currentTournament.createMatches();
                    currentTournament.createBracket();
                    break;
                case 4:
                    quit2=true;
            }

        }
    }


    static private void editMatch(Match match) {
        Team team1 = match.getTeam1();
        Team team2 = match.getTeam2();

        String menuItem1 = "1. Sæt point for hold: " + team1.getName();
        String menuItem2 = "2. Sæt point for hold: " + team2.getName();
        String[] menuItems = {menuItem1, menuItem2};


        for (String menuItem : menuItems)
            System.out.println(menuItem);
        String msg = "Sæt point for hold";
        switch (UI.getUserInputInt()) {
            case 1:
                match.setScore1(getUserInputInt("Sæt point for hold " + team1));
                break;
            case 2:
                match.setScore2(getUserInputInt("Sæt point for hold " + team2));
                break;
        }
    }


    //gets user input and returns input as a string. Takes a message as an input which it prints out
    static String getUserInput(String msg) {
        System.out.println(msg);
        return getUserInput();
    }

    //gets user input and returns input as a string
    static String getUserInput() {
        String input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        return input;
    }

    //gets user input and returns an int
    static int getUserInputInt() {
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

    static int intGetUserIntWithin(int menuItemsSize) {
        int input;
        return getUserInputInt();
    }


    //gets user input and returns it as a string
    static int getUserInputInt(String msg) {
        System.out.println(msg);
        return getUserInputInt();
    }

}
