package pl.mavenProject;

import javax.swing.*;
import java.awt.*;

class App extends JFrame {
    private static final int WIDTH = 665;
    private static final int HEIGHT = 495;

    App() {
        initUI();
    }

    private void initUI() {
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setName("Graf");
        pack();
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        Label jLabel = new Label(new Dimension(490,35), "DISTANCE:");
        add(jLabel);

        TextField jTextField = new TextField(new Dimension(555,35));
        add(jTextField);

        TextArea area = new TextArea(new Dimension(460, 125));
        add(area);

        AddComboBox addComboBox = new AddComboBox(new Dimension(460, 5));
        add(addComboBox);

        AddComboBox addComboBox2 = new AddComboBox(new Dimension(555, 5));
        add(addComboBox2);

        add(new AddRemoveButton(new Dimension(460, 65), addComboBox, addComboBox2, jTextField));

        add(new CalculateButton(area, addComboBox, addComboBox2, new Dimension(460, 95)));

        add(new Board(addComboBox, addComboBox2));

        repaint();
    }
}
