package button;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Ramka z panelem zawierającym przyciski
 * @author Tomek
 *
 */
public class ButtonFrame extends JFrame{

    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ButtonFrame() {

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        buttonPanel = new JPanel();

//		//Tworzenie przycisków
//		var yellowButton = new JButton("Żółty");
//		var blueButton = new JButton("Niebieski");
//		var redButton = new JButton("Czerwony");
//
//
//		//Dodanie przycisków do panelu
//		buttonPanel.add(yellowButton);
//		buttonPanel.add(blueButton);
//		buttonPanel.add(redButton);
//
//		//Dodanie panelu do ramki
//		add(buttonPanel);
//
//		//Utworzenie akcji przycisków
//		var yellowAction = new ColorAction(Color.YELLOW);
//		var blueAction = new ColorAction(Color.BLUE);
//		var redAction = new ColorAction(Color.RED);
//
//		//Powiązanie akcji z przyciskami
//		yellowButton.addActionListener(yellowAction);
//		blueButton.addActionListener(blueAction);
//		redButton.addActionListener(redAction);
//

//Alternatywna wersja do listingu 10.5
//		//Dodanie przycisków do panelu
        makeButton("Żółty", Color.YELLOW);
        makeButton("Niebieski", Color.BLUE);
        makeButton("Czerwony", Color.RED);

        //Dodanie panelu do ramki
        add(buttonPanel);
    }

    public void makeButton(String name, Color backgroundColor) {

        var button = new JButton(name);
        buttonPanel.add(button);
        button.addActionListener(event ->
                buttonPanel.setBackground(backgroundColor));
    }
    /**
     * Nasłuchiwacz akcji ustawiający kolor panelu.
     */
//	private class ColorAction implements ActionListener {
//
//		private Color backgroundColor;
//
//		public ColorAction(Color c) {
//			backgroundColor = c;
//		}
//
//		public void actionPerformed(ActionEvent event) {
//			buttonPanel.setBackground(backgroundColor);
//		}
//	}
}
