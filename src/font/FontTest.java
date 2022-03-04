package font;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * @author Tomek
 *
 */
public class FontTest {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            var frame = new FontFrame();
            frame.setTitle("FontTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}

/**
 * Ramka z komponentem zawierającym tekst.
 */
class FontFrame extends JFrame{

    public FontFrame() {

        add(new FontComponent());
        pack();
    }
}

/**
 * Komponent z tekstem na środku.
 */
class FontComponent extends JComponent{

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public void paintComponent(Graphics g) {

        var g2 = (Graphics2D) g;
        var message = "Witaj, świecie!";
        var f = new Font("Serif", Font.BOLD, 36);

        g2.setFont(f);

        //Sprawdzenie rozmiaru tekstu.
        FontRenderContext context = g2.getFontRenderContext();
        //var context = g2.getFontRenderContext();
        Rectangle2D bounds = f.getStringBounds(message, context);
        //var bounds = f.getStringBounds(message, context);

        //set(x,y)=lewy górny róg tekstu.
        double x = (getWidth() - bounds.getWidth()) / 2;
        double y = (getHeight() - bounds.getHeight()) / 2;

        //Dodanie wydłużenia do y w celu sięgnięcia do lini bazowej.
        double ascent = - bounds.getY();
        double baseY = y + ascent;

        //Rysowanie komunikatu.
        g2.drawString(message, (int) x, (int) baseY);
        g2.setPaint(Color.LIGHT_GRAY);

        //Rysowanie linii bazowej.
        g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY));

        //Rysowanie otaczającego tekst prostokąta.
        var rect = new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());
        g2.draw(rect);
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}