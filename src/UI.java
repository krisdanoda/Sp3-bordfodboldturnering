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
        input = scan.nextInt();
        return input;
    }


    int getUserInputInt(String msg) {
        System.out.println(msg);
        return getUserInputInt();
    }

}
