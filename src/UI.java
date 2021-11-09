import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    static private Match currentMatch;
    static private ArrayList<Match> currentMatches;

    static void adminTournamentMainMenu(Knockout currentKnockout) {
        String menuItem1 = "1. Se tilmeldte hold";
        String menuItem2 = "2. Se info om turnering";
        String menuItem3 = "3. Rediger turnering"; //Change name, change date, close deadline
        String menuItem4 = "4. Se oversigt"; //If only the tournament has started

        String[] menuItems = {menuItem1, menuItem2,menuItem3,menuItem4};
        for (String menuItem : menuItems)
            System.out.println(menuItem);


        switch (UI.getUserInputInt()) {
            case 1:
                //1.Se tilmeldte hold
                currentKnockout.printTeams();


                break;
            case 2:
                // 2. se info om turnering
                //todo: Make a tostring for tournament
                System.out.println(currentKnockout.toString());



                break;
            case 3: //3. Rediger turnering




                break;
            case 4: // Se Kamp Oversigt
                //
                System.out.println( );

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
    static int intGetUserIntWithin(int menuItemsSize ){
        int input;
        return getUserInputInt();
    }


    //gets user input and returns it as a string
    static int getUserInputInt(String msg) {
        System.out.println(msg);
        return getUserInputInt();
    }

}
