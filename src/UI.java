import java.util.Scanner;

public class UI {


<<<<<<< Updated upstream
    String getUserInput(String msg) {
=======
        String[] menuItems = {menuItem1, menuItem2,menuItem3,menuItem4};
        for (String menuItem : menuItems)
            System.out.println(menuItem);


        switch (UI.getUserInputInt()) {
            case 1:
                //1.Se tilmeldte hold
                currentTournament.printTeams(currentTournament.getTeamArray());


                break;
            case 2:
                // 2. se info om turnering

                System.out.printf(currentTournament.toString()); //todo: Make a tostring for tournament



                break;
            case 3: //3. Rediger turnering
                for (Match[] match: currentTournament.getRoundMatchList())



                break;
            case 4: // Se Kamp Oversigt
                //
                System.out.println( );

        }
    }


    //gets user input and returns input as a string. Takes a message as an input which it prints out
    static String getUserInput(String msg) {
>>>>>>> Stashed changes
        System.out.println(msg);
        return getUserInput();
    }
    String getUserInput() {
        String input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        return input;
    }

    int getUserInputInt() {
        int input;
        Scanner scan = new Scanner(System.in);
        //Check to see if its valid int
        while (true)
            try {
               input = Integer.parseInt(scan.nextLine());
                break;
            } catch (NumberFormatException nfe) {
                System.out.print("Invalid int. Try again: ");
            }
        return input;
    }


    int getUserInputInt(String msg) {
        System.out.println(msg);
        return getUserInputInt();
    }

}
