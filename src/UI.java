import java.util.Scanner;

public class UI {


    static String getUserInput(String msg) {
        System.out.println(msg);
        return getUserInput();
    }


    static String getUserInput() {
        String input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        return input;
    }

    static int getUserInputInt() {
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


     static int getUserInputInt(String msg) {
        System.out.println(msg);
        return getUserInputInt();
    }

}
