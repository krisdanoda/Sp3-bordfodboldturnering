
import javax.swing.*;
public class Frame extends JFrame {

    Panel panel;

    public Frame(Knockout knockout) {

        panel = new Panel(knockout);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }


}
