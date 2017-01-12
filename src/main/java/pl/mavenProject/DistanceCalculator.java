package pl.mavenProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DistanceCalculator {
    private Map<Point, Double> queueMap = new HashMap<Point, Double>();
    private Map<Point, Double> shortestMap = new HashMap<Point, Double>();

    private Map<Point, List<String>> shortestWayMap = new HashMap<Point, List<String>>();


    DistanceCalculator(Point source) {

        for (int i = 0; i < Point.pointsList.size(); i++) {
            queueMap.put(Point.pointsList.get(i), Double.POSITIVE_INFINITY);
            shortestMap.put(Point.pointsList.get(i), Double.POSITIVE_INFINITY);

            shortestWayMap.put(Point.pointsList.get(i), new ArrayList<String>());
        }

        queueMap.put(source, 0d);
        shortestMap.put(source, 0d);

        setValueOfConnections(source);
        findAndMoveLowestValueToShortestMap();

        queueMapClear(source);

    }

    private void setValueOfConnections(Point pointWithConnections) {

        for (Map.Entry<Point, Integer> entry : pointWithConnections.getConnectionsMap().entrySet()) {
            if (shortestMap.get(entry.getKey()) > (shortestMap.get(pointWithConnections) + entry.getValue())) {

                queueMap.put(entry.getKey(), shortestMap.get(pointWithConnections) + entry.getValue());
                shortestMap.put(entry.getKey(), shortestMap.get(pointWithConnections) + entry.getValue());

                List<String> tempList = new ArrayList<String>();
                for (int i = 0; i < shortestWayMap.get(pointWithConnections).size(); i++) {
                    tempList.add(shortestWayMap.get(pointWithConnections).get(i));
                }
                shortestWayMap.put(entry.getKey(), tempList);
                shortestWayMap.get(entry.getKey()).add(pointWithConnections.toString());
                System.out.println(shortestWayMap.get(entry.getKey()));


                for (Map.Entry<Point, Integer> entryConnection : entry.getKey().getConnectionsMap().entrySet()) {

                    if (entry.getKey().getConnectionsMap().get(entryConnection) != null) {
                        if (shortestMap.get(entryConnection) > shortestMap.get(entry.getKey()) + entry.getKey().getConnectionsMap().get(entryConnection)) {
                            queueMapUpdate(entryConnection.getKey());
                        }
                    }
                }
            }
        }
    }

    private void findAndMoveLowestValueToShortestMap() {

        List<Point> list = new ArrayList<Point>();
        Double distance = Double.POSITIVE_INFINITY;

        for (Map.Entry<Point, Double> entry : queueMap.entrySet()) {
            if ((entry.getValue().equals(distance)) && (entry.getValue() != Double.POSITIVE_INFINITY)) {
                list.add(entry.getKey());
            } else if (entry.getValue() < distance) {
                list.clear();
                list.add(entry.getKey());
                distance = entry.getValue();
            }
        }

        for (Point aList : list) {
            shortestMap.put(aList, distance);
            queueMap.remove(aList);
        }
    }

    private void queueMapClear(Point sourcePoint) {
        if (!queueMap.isEmpty()) {

            for (Map.Entry<Point, Integer> entry : sourcePoint.getConnectionsMap().entrySet()) {
                setValueOfConnections(entry.getKey());
            }

            findAndMoveLowestValueToShortestMap();

            for (Map.Entry<Point, Integer> entry : sourcePoint.getConnectionsMap().entrySet()) {
                if (!entry.getKey().getConnectionsMap().isEmpty())
                    queueMapClear(entry.getKey());
            }
        }
    }

    private void queueMapUpdate(Point sourcePoint) {
        if (!queueMap.isEmpty()) {

            for (Map.Entry<Point, Integer> entry : sourcePoint.getConnectionsMap().entrySet()) {
                setValueOfConnections(entry.getKey());
            }

            for (Map.Entry<Point, Integer> entry : sourcePoint.getConnectionsMap().entrySet()) {
                if (!entry.getKey().getConnectionsMap().isEmpty())
                    queueMapUpdate(entry.getKey());
            }
        }

    }


    Map<Point, Double> getShortestMap() {
        return shortestMap;
    }

    public String getShortestWayPath(Point finalPoint) {

        List<String> finalPointList = shortestWayMap.get(finalPoint);

        StringBuilder shortestWayBuilder = new StringBuilder();
        for (int i = 0; i < finalPointList.size(); i++) {
            shortestWayBuilder.append(finalPointList.get(i));
            shortestWayBuilder.append("->");
        }
        return shortestWayBuilder.toString()+finalPoint;
    }
}
