import java.util.ArrayList;

public class Main {
    static IO io;
    public static void main(String[] args) {
        Tournament tournament = new Tournament("Bordfodbold-knockoutturnering");
        Knockout knockout = new Knockout(tournament.getName());
        io = new DBConnector();
        UI ui = new UI(knockout);
        ui.menu();
    }

}
