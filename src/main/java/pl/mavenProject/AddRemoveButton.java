package pl.mavenProject;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddRemoveButton extends JButton implements MouseListener {
    private AddComboBox addComboBox1;
    private AddComboBox addComboBox2;
    private TextField textField;

    AddRemoveButton(Dimension location, AddComboBox addComboBox1, AddComboBox addComboBox2, TextField textField){
        this.addComboBox1 = addComboBox1;
        this.addComboBox2 = addComboBox2;
        this.textField = textField;

        addMouseListener(this);
        setBackground(Color.lightGray);
        setSize(190,25);
        setLocation(location.width, location.height);
        setText("ADD/REMOVE (CONNECTION)");
        setBorder(new BevelBorder(0));
    }
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {
        Point point1 = Point.pointsList.get((Integer)addComboBox1.getSelectedItem());
        Point point2 = Point.pointsList.get((Integer)addComboBox2.getSelectedItem());
        Integer distance = Integer.parseInt(textField.getText());

        if (point1.getConnectionsMap().containsKey(point2) && point1.getConnectionsMap().get(point2).equals(distance)){
            point1.removeFromConnectionsMap(point2);
        } else {
            if (distance == 0){
                throw new IllegalArgumentException("Połączenie musi mieć wartość większą od 0.");
            } else {
                point1.addToConnectionsMap(point2, distance);
            }
        }
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
