package SprNazwCzcionekSystemowych;

import java.awt.*;
/**
 * @author Tomek
 *
 */
public class SprNazwCzcionekSystemowych {

    public static void main(String[] args) {

        String[] fontNames = GraphicsEnvironment
                .getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for(String fontName : fontNames) System.out.println(fontName);
    }

}