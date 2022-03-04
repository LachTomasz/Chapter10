package draw;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * @author Tomek
 *
 */
public class DrawTest {

    public static void main(String[] args) {

        EventQueue.invokeLater(()->
        {
            var frame = new DrawFrame();
            frame.setTitle("DrawTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}
/**
 * Ramka zawierająca okienko z rysunkami.
 */
class DrawFrame extends JFrame{

    public DrawFrame() {
        add(new DrawComponent());
        pack();
    }
}

/**
 *Komponent wyświetlający prostokąty i elipsy.
 */
class DrawComponent extends JComponent{

    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    public void paintComponent(Graphics g) {

        var g2 = (Graphics2D) g;

        //rysowanie prostokąta.
        double leftX = 100;
        double topY = 100;
        double width = 200;
        double height = 150;

        var rect = new Rectangle2D.Double(leftX, topY, width, height);
        g2.draw(rect);

        //Rysowanie elipsy.
        var ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.draw(ellipse);

        //Rysowanie przekątnej.
        g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));

        //Rysowanie koła z takim samym środkiem.
        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();
        double radius = 150;

        var circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
        g2.draw(circle);
    }

    public Dimension getPreferredSize() {//Tu jak sie zle napisze nazwe metody to ramka
        //wyjdzie hujowo!!! tzn. maxymalnie mala!!!
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}