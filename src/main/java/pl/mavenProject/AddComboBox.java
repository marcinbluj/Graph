package pl.mavenProject;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

class AddComboBox extends JComboBox{

    AddComboBox(Dimension dimension){
        setBackground(Color.WHITE);
        setBorder(new BevelBorder(1));
        setSize(90, 25);
        setLocation(dimension.width, dimension.height);
    }

    void addToComboBox(){
            removeAllItems();
        for (int i = 0; i < Point.pointsList.size(); i++) {
            addItem(i);
        }
    }

}
