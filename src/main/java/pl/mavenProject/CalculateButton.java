package pl.mavenProject;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by MSI on 09.01.2017.
 */
public class CalculateButton extends JButton implements MouseListener{
    DistanceCalculator distanceCalculator;
    JTextArea textArea;
    AddComboBox comboBox;
    AddComboBox comboBox2;

    CalculateButton(JTextArea textArea, AddComboBox comboBox, AddComboBox comboBox2, Dimension location){
        addMouseListener(this);
        this.textArea = textArea;
        this.comboBox = comboBox;
        this.comboBox2 = comboBox2;
        setSize(190, 25);
        setLocation(location.width, location.height);  //460 95
        setBackground(Color.lightGray);
        setBorder(new BevelBorder(0));
        setText("CALCULATE");
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

        this.distanceCalculator = new DistanceCalculator(Point.pointsList.get((Integer)comboBox.getSelectedItem()));

        textArea.setText(""+distanceCalculator.getShortestWayPath(Point.pointsList.get((Integer)comboBox2.getSelectedItem())));

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
