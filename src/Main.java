import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament("Bordfodbold-knockoutturnering");
        Knockout knockout = new Knockout(tournament.getName());
        UI.menu();
    }

}
