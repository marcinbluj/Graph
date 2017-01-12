package pl.mavenProject;

import org.testng.annotations.Test;

import java.util.Map;

import static junit.framework.Assert.assertTrue;

/**
 * Created by MSI on 06.01.2017.
 */
public class DistanceCalculatorTest {

    @Test
    public void mapOfShortestWays_simple() {
        //given
        Point.pointsList.clear();
        Point sourcePoint = new Point(1, 2);
        Point point1 = new Point(2, 2);
        Point point2 = new Point(3, 2);
        Point point3 = new Point(3, 3);
        Point point4 = new Point(4, 3);
        sourcePoint.addToConnectionsMap(point1, 11);
        sourcePoint.addToConnectionsMap(point2, 22);
        sourcePoint.addToConnectionsMap(point3, 10);
        point1.addToConnectionsMap(point3, 13);
        point1.addToConnectionsMap(point4, 8);
        point2.addToConnectionsMap(point3, 17);
        point3.addToConnectionsMap(point4, 10);
        point4.addToConnectionsMap(point2, 1);

        //when
        DistanceCalculator dc = new DistanceCalculator(sourcePoint);
        Map<Point, Double> shortestMap = dc.getShortestMap();

        //then
        assertTrue(shortestMap.containsKey(point3));
        assertTrue(shortestMap.get(sourcePoint) == 0);
        assertTrue(shortestMap.get(point1) == 11);
        assertTrue(shortestMap.get(point2) == 20);
        assertTrue(shortestMap.get(point3) == 10);
        assertTrue(shortestMap.get(point4) == 19);

    }

    @Test
    public void mapOfShortestWays_medium() {
        //given
        Point.pointsList.clear();
        Point sourcePoint = new Point(1, 2);
        Point point1 = new Point(2, 2);
        Point point2 = new Point(3, 2);
        Point point3 = new Point(3, 3);
        Point point4 = new Point(4, 3);
        Point point5 = new Point(4, 4);
        Point point6 = new Point(5, 4);

        //when
        sourcePoint.addToConnectionsMap(point1, 5);
        sourcePoint.addToConnectionsMap(point2, 7);
        sourcePoint.addToConnectionsMap(point4, 4);
        sourcePoint.addToConnectionsMap(point5, 1);

        point1.addToConnectionsMap(point6, 7);

        point2.addToConnectionsMap(point3, 2);

        point4.addToConnectionsMap(point1, 1);
        point4.addToConnectionsMap(point6, 5);

        point5.addToConnectionsMap(point4, 2);
        DistanceCalculator dc = new DistanceCalculator(sourcePoint);
        Map<Point, Double> shortestMap = dc.getShortestMap();

        //then
        assertTrue(shortestMap.containsKey(point6));
        assertTrue(shortestMap.get(sourcePoint) == 0);
        assertTrue(shortestMap.get(point1) == 4);
        assertTrue(shortestMap.get(point2) == 7);
        assertTrue(shortestMap.get(point3) == 9);
        assertTrue(shortestMap.get(point4) == 3);
        assertTrue(shortestMap.get(point5) == 1);
        assertTrue(shortestMap.get(point6) == 8);

    }

    @Test
    public void mapOfShortestWays_hard_NoConnectionCase() {
        //given
        Point.pointsList.clear();
        Point sourcePoint = new Point(1, 2);
        Point point1 = new Point(2, 2);
        Point point2 = new Point(3, 2);
        Point point3 = new Point(3, 3);

        //when
        sourcePoint.addToConnectionsMap(point1, 4);
        sourcePoint.addToConnectionsMap(point2, 4);

        point1.addToConnectionsMap(point2, 1);

        DistanceCalculator dc = new DistanceCalculator(sourcePoint);
        Map<Point, Double> shortestMap = dc.getShortestMap();

        //then
        assertTrue(shortestMap.containsKey(point3));
        assertTrue(shortestMap.get(sourcePoint) == 0);
        assertTrue(shortestMap.get(point1) == 4);
        assertTrue(shortestMap.get(point2) == 4);
        assertTrue(shortestMap.get(point3) == Double.POSITIVE_INFINITY);
    }
}
