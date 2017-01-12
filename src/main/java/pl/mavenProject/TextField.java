package pl.mavenProject;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class TextField extends JTextField implements KeyListener {
    private List<Character> characterList = new ArrayList<Character>();

    TextField(Dimension location) {
        addKeyListener(this);
        characterList.add('1');
        characterList.add('2');
        characterList.add('3');
        characterList.add('4');
        characterList.add('5');
        characterList.add('6');
        characterList.add('7');
        characterList.add('8');
        characterList.add('9');
        characterList.add('0');

        setSize(90, 25);
        setLocation(location.width, location.height); //555 35
        setBorder(new BevelBorder(1));
    }

    public void keyTyped(KeyEvent e) {

        if (!characterList.contains(e.getKeyChar())) {
            e.consume();
        }
    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }
}


