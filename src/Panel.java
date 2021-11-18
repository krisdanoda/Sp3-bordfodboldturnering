import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;

public class Panel extends JPanel {
    final int h, w;
    ArrayList<Match[]> brackets = new ArrayList<>();

    public Panel(Knockout knockout) {

            this.h = 800;
            this.w = 1200;
            this.setPreferredSize(new Dimension(w, h));
            this.brackets = knockout.getMatchesList();

    }


    public void paint(Graphics G) {

        Graphics2D g2d = (Graphics2D) G;
        Rectangle2D.Double r;
        Font font = new Font("Courier", Font.BOLD, 24);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.PI/2,0,0);
        Font rotatedFont = font.deriveFont(affineTransform);

        g2d.setFont(rotatedFont);

        g2d.setStroke(new BasicStroke(10));
        int k = (int) Math.pow(2, brackets.size() - 1);
        int d = w / (k * 2 + 1);
        int s = d;
        int s0 = s;
        int S = s;
        int H = h / (brackets.size() + 2);
        int h0 = H;



        for (int i = brackets.size()-1; i >= 0; i--) {
            Match[] M = brackets.get(i);
            for (int j = 0;  j < M.length; j++) {
                Match m = M[j];
                g2d.setColor(new Color(38, 38, 38));
                g2d.drawLine(s, h - H, s, h - (h0 + H));
                g2d.drawLine(s + d, h - H, s + d, h - (h0 + H));
                g2d.drawLine(s, h - (h0 + H), s + d, h - (h0 + H));
                g2d.setColor(new Color(77, 0, 0));
                if (m.getTeam1() != null)
                    g2d.drawString(m.getTeam1().getName(), s + d, h - H);
                if (m.getTeam2() != null)
                    g2d.drawString(m.getTeam2().getName(), s, h - H);

                s += 2 * d;


            }
            S += 0.5 * d;
            d += d;
            s = S;
            H += h0;

        }


        //r = (new Rectangle2D.Double(5 * w / (8), 5 * h / (8), h / 8, h / 8));
        //g2d.fill(r);

    }


}
