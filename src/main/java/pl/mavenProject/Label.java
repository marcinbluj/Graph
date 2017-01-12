package pl.mavenProject;

import javax.swing.*;
import java.awt.*;

/**
 * Created by MSI on 12.01.2017.
 */
public class Label extends JLabel {
    Label(Dimension location, String text) {
        setSize(60, 25);
        setLocation(location.width, location.height);  //490, 35
        setText(text);  //"DISTANCE:"
    }
}
