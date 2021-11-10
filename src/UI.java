import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    static private Match currentMatch;
    static private ArrayList<Match> currentMatches;
    static private Knockout currentTournament;



    static void adminMainMenu(){
        String menuItem1 = "1. Se turnering";
        String menuItem2 = "2. Lav turnering";
        String menuItem3 = "3. quit";
        String[] menuItems = {menuItem1, menuItem2, menuItem3};
        while (true) {
            for (String menuItem: menuItems)
                System.out.println(menuItem);

            switch (getUserInputInt()){
                case 1:
                    adminTournamentMainMenu();
                    break;


                case 2:
                    System.out.println("Skriv navn til turnering");
                    currentTournament = new Knockout(getUserInput());
                    currentTournament.initTeams();
                    System.out.println(currentTournament.teams.size());
                    break;

                case 3:
                    break;

            }
        }
    }

    static void adminTournamentMainMenu() {
        boolean quit = false;
        System.out.println(currentTournament.teams.size());
        String menuItem1 = "1. Se tilmeldte hold";
        String menuItem2 = "2. Se info om turnering";
        String menuItem3 = "3. Rediger turnering"; //Change name, change date, close deadline
        String menuItem4 = "4. Se oversigt"; //If only the tournament has started
        String menuItem5 = "5. Rediger kampe";
        String menuQuit = "6. Return til main menu";
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
                    System.out.println(currentTournament.matches.length + ". sæt vinner til næste runde");

                    int input = getUserInputInt();
                    if (input == currentTournament.matches.length) {
                        System.out.println("Vinder i " + currentTournament.getName() + " er sæt.");
                        currentTournament.setNextRound();
                    } else if (input > 0 || input <= currentTournament.matches.length)
                        editMatch(currentTournament.matches[input - 1]);
                    else {
                    }

                case 6:
                    //Return til main menu
                    quit = true;
                    break;

            }
        }
    }

    static private void editTournament() {

        String menuItem1 = "1. ændre på turnering navn: " + currentTournament.getName();
        String menuItem2 = "2. ændre på tilmedling frist: " + currentTournament.getDeadline();
        String menuItem3 = "3. Luk tilmedling";
        String menuItem4 = "4. Shuffle hold"; //todo: make shuffle team method in Tournament Not n
        String menuItemQuit = "Return";

        String[] menuItems = {menuItem1, menuItem2, menuItem3};
        for (String menuItem : menuItems)
            System.out.println(menuItem);
        switch (getUserInputInt()) {
            case 1:
                currentTournament.setName(getUserInput("Navn: "));
                break;
            case 2:
                currentTournament.setDeadline(getUserInput("Ændre tilmedling frist "));
                break;
            case 3:
                System.out.println("Tilmelding er lukket");
                currentTournament.setCloseSignUp(true);
                currentTournament.createMatches();
                currentTournament.createBracket();
                break;
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
        String msg = "Sæt point for holde";
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
