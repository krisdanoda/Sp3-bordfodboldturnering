import java.util.ArrayList;

public class Main {
    static IO io;
    public static void main(String[] args) {
        io = new DBConnector();
        UI ui = new UI();
        ui.menu();
    }

}
