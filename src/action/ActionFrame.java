package action;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Ramka z panelem, który demonstruje akcje zmiany koloru.
 */
public class ActionFrame extends JFrame
{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ActionFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        buttonPanel = new JPanel();

        // Definicje akcji
        Action yellowAction = new ColorAction("Żółty", new ImageIcon("com/yellow-ball.gif"),Color.YELLOW);
        Action blueAction = new ColorAction("Blue", new ImageIcon("com/blue-ball.gif"), Color.BLUE);
        Action redAction = new ColorAction("Red", new ImageIcon("com/red-ball.gif"), Color.RED);

        // Dodanie przycisków dla akcji
        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(blueAction));
        buttonPanel.add(new JButton(redAction));

        // Dodanie panelu do ramki
        add(buttonPanel);

        // Powiązanie klawiszy Z, N i C z nazwami
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ctrl Z"), "panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl N"), "panel.blue");
        imap.put(KeyStroke.getKeyStroke("ctrl C"), "panel.red");

        // Powiązanie nazw z akcjami
        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.yellow", yellowAction);
        amap.put("panel.blue", blueAction);
        amap.put("panel.red", redAction);
    }

    public class ColorAction extends AbstractAction
    {
        /**
         * Tworzy akcję zmiany koloru.
         * @param name nazwa, która pojawi się na przycisku
         * @param icon ikona, która pojawi się na przycisku
         * @param c kolor tła
         */
        public ColorAction(String name, Icon icon, Color c)
        {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "Ustaw kolor panelu na " + name.toLowerCase());
            putValue("color", c);
        }

        public void actionPerformed(ActionEvent event)
        {
            Color c = (Color) getValue("color");
            buttonPanel.setBackground(c);
        }
    }
}
