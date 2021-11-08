import java.util.ArrayList;

public class Main {
    static Knockout currentTournament;
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        Knockout knockout = new Knockout();
        tournament.setName("Bordfodbold-knockoutturnering");

        Menu.menu(tournament);
    }

}
