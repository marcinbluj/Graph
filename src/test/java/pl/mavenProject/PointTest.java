package pl.mavenProject;



import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class PointTest {

    @Test
    public void constructor_shouldFillFieldsXY() {

        // given
        int x = 10;
        int y = 5;

        // when
        Point point = new Point(x, y);

        // then
        assertTrue(point.getConnections() == null);
        assertEquals(point.getX(), x);
        assertEquals(point.getY(), y);
    }

    @Test
    public void constructor_shouldFillFieldsXYConnections() {

        // given
        int x = 10;
        int y = 5;
        List<Point> list = new ArrayList<Point>();

        // when
        Point point = new Point(x, y, list);

        // then
        assertEquals(point.getX(), x);
        assertEquals(point.getY(), y);
        assertEquals(point.getConnections(), list);
    }

    @Test
    public void addConnection_addsPoints() {

        // given
        int x = 5;
        int y = 9;
        List<Point> list = new ArrayList<Point>();
        Point connectionPoint = new Point(5, 5);

        // when
        list.add(connectionPoint);
        Point point = new Point(x, y ,list);
        point.addConnection(new Point(2,3));
        point.setX(0);
        point.setY(0);
        point.setConnections(list);

        // then
        assertEquals(point.getConnections().size(), 2);
        assertEquals(point.getConnections().get(1).getX(), 2);
        assertEquals(point.getX(), 0);
        assertEquals(point.getY(), 0);
        assertEquals(point.getConnections(), list);
    }

    @Test
    public void addToPointsList_addsPoints() {

        // given
        Point.pointsList.clear();

        // when
        Point point1 = new Point(2,1);
        Point point2 = new Point(1,1);
        Point point3 = new Point(1,1);

        // then
        assertEquals(Point.pointsList.size(), 2);
        assertEquals(Point.pointsList.get(0), point1);
        assertEquals(Point.pointsList.get(1), point3);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void constructor_isCorrectForOutOfRangeValues() {

        // given
        Point.pointsList.clear();

        // when
        Point point1 = new Point(201,1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void constructor_isCorrectForNegativeValues() {

        // given
        Point.pointsList.clear();

        // when
        Point point1 = new Point(-1,1);
    }
}


