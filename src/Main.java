import java.util.ArrayList;

public class Main {
    static Knockout currentTournament;
    public static void main(String[] args) {
        UI ui = new UI();
        //ui.getUserInputInt();


        Tournament tournament = new Tournament("Bordfodbold-knockoutturnering");
        Menu.menu(tournament);
    }

}
