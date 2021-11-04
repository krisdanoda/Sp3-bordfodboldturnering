import java.util.Scanner;

public class UI {


    String getUserInput(String msg) {
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
