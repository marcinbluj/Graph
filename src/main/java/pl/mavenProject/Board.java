package pl.mavenProject;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.Map;

public class Board extends JPanel implements MouseListener {
    static final int WIDTH = 450;
    static final int HEIGHT = 450;
    private AddComboBox addComboBox1;
    private AddComboBox addComboBox2;

    Board(AddComboBox addComboBox1, AddComboBox addComboBox2) {
        this.addComboBox1 = addComboBox1;
        this.addComboBox2 = addComboBox2;
        addMouseListener(this);
        setBackground(Color.WHITE);
        setLocation(5, 5);
        setSize(WIDTH, HEIGHT);
        setBorder(new BevelBorder(1));
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        new Point(e.getX(), e.getY());
        addComboBox1.addToComboBox();
        addComboBox2.addToComboBox();
        repaint();
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawPoint(g2d);
        drawConnectionLine(g2d);
        repaint();
    }

    private void drawPoint(Graphics2D g2d) {
        for (int i = 0; i < Point.pointsList.size(); i++) {
            int x = Point.pointsList.get(i).getX();
            int y = Point.pointsList.get(i).getY();
            g2d.fillOval(x - 6, y - 6, 11, 11);
            g2d.drawString(("" + i), x - 6, y - 6);
        }
    }

    private void drawConnectionLine(Graphics2D g2d) {
        for (int i = 0; i < Point.pointsList.size(); i++) {
            int x1 = Point.pointsList.get(i).getX();
            int y1 = Point.pointsList.get(i).getY();


            if (Point.pointsList.get(i).getConnections() != null) {
                for (Map.Entry<Point, Integer> entry : Point.pointsList.get(i).getConnectionsMap().entrySet()) {
                    int x2 = entry.getKey().getX();
                    int y2 = entry.getKey().getY();
                    g2d.setColor(Color.red);
                    g2d.drawLine(x1, y1, x2, y2);

                    double oneEighthX = (((x1 + x2) / 2 + x2) / 2 + x2) / 2;
                    double oneEighthY = (((y1 + y2) / 2 + y2) / 2 + y2) / 2;

                    Line2D line2D = new Line2D.Double(oneEighthX, oneEighthY, x2, y2);
                    AffineTransform transform = new AffineTransform();
                    transform.rotate(Math.toRadians(30), x2, y2);
                    g2d.draw(transform.createTransformedShape(line2D));
                    transform.rotate(Math.toRadians(-60), x2, y2);
                    g2d.draw(transform.createTransformedShape(line2D));

                    double middleX = (x1 + x2) / 2;
                    double middleY = (y1 + y2) / 2;

                    g2d.setColor(Color.blue);
                    g2d.drawString((entry.getValue().toString()), (int) middleX, (int) middleY);


//                    double a;
//                    double b;
//
//                    b = (y1 * x2 - y2 * x1) / (x1 + x2);
//                    a = (-b + y1) / x1;
//
//
//                    double atan = Math.atan(a);
//                    double deg = Math.toDegrees(atan);
//
//                    AffineTransform transformString = new AffineTransform();
//                    transformString.rotate(atan);
//                    g2d.draw(transformString.createTransformedShape());
                }
            }
        }
    }
}
