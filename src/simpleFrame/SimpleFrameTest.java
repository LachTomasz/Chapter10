package simpleFrame;

import java.awt.*;
import javax.swing.*;

/*
 * @author Tomek
 */
public class SimpleFrameTest {

    public static void main(String[] args) {

        EventQueue.invokeLater(()->//wykonuje instrukcje w wątku dystrybucji zdarzeń str 508
                //tak jest poprawnie!
        {
            var frame = new SimpleFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocation(500, 200);
            //przyklad jak ustawic ramke dopasowana do rozdzielczości ekranu
            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension screenSize = kit.getScreenSize();
            int screenWidth = screenSize.width;
            int screenHeight = screenSize.height;
            frame.setSize(screenWidth / 2, screenHeight / 2);
            //
            frame.setTitle("TEST");
            frame.setResizable(true);
            frame.setVisible(true);
        });
    }
}

class SimpleFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public SimpleFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
