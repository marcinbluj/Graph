package pl.mavenProject;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * Created by MSI on 12.01.2017.
 */
public class TextArea extends JTextArea {
    TextArea(Dimension location) {
        setLocation(location.width, location.height); //460 125
        setSize(190, 100);
        setEditable(false);
        setBorder(new BevelBorder(1));
        setLineWrap(true);
    }
}
