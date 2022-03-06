package mouse;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

/**
 * Komponent z działaniami myszy,
 * do którego można dodawać (lub z którego można usuwać) kwadraty.
 * @author Tomek
 *
 */
public class MouseComponent extends JComponent {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private static final int SIDELENGTH = 10;
    private ArrayList<Rectangle2D> squares;
    private Rectangle2D current; //kwadrat zawierający kursor

    public MouseComponent() {

        squares = new ArrayList<>();
        current = null;

        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    public Dimension getPreferredSize() {

        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public void paintComponent(Graphics g) {
        var g2 = (Graphics2D) g;

        //Rysowanie wszystkich kwadratów
        for (Rectangle2D r : squares)
            g2.draw(r);;
    }

    /**
     * Znajduje pierwszy kwadrat zawierający punkt.
     * @param p punkt
     * @return pierwszy kwadrat zawierający punkt p
     */
    public Rectangle2D find(Point2D p)
    {
        for (Rectangle2D r : squares)
        {
            if (r.contains(p)) return r;
        }
        return null;
    }

    /**
     * Dodaje kwadrat do zbioru
     * @param p środek kwadratu
     * @author Tomek
     *
     */

    public void add(Point2D p) {
        double x = p.getX();
        double y = p.getY();

        current = new Rectangle2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
        squares.add(current);
        repaint();
    }

    /**
     * Usuwa kwadrat ze zbioru.
     * @param s kwadrat, który ma być usunięty
     */
    public void remove(Rectangle2D s)
    {
        if (s == null) return;
        if (s == current) current = null;
        squares.remove(s);
        repaint();
    }

    private class MouseHandler extends MouseAdapter{

        public void mousePressed(MouseEvent event) {

            //Dodanie nowego kwadratu, jeśli kursor nie jest wewnątrz innego kwadratu
            current = find(event.getPoint());
            if (current == null) add(event.getPoint());
        }

        public void mouseClicked(MouseEvent event) {

            //Usunięcie kwadratu w wyniku jego dwukrotnego kliknięcia
            current = find(event.getPoint());
            if(current != null && event.getClickCount() >=2) remove(current);
        }
    }

    private class MouseMotionHandler implements MouseMotionListener{

        public void mouseMoved(MouseEvent event) {

            //Ustawienie kursora na krzyżyk, jeśli znajduje się wewnątrz kwadratu
            if (find(event.getPoint()) == null) setCursor(Cursor.getDefaultCursor());
            else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }

        public void mouseDragged(MouseEvent event) {

            if(current != null) {

                int x = event.getX();
                int y = event.getY();

                //Przeciąganie aktualnego kwadratu w celu wyśrodkowania go w punkcie (x,y)
                current.setFrame(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
                repaint();
            }
        }
    }

}