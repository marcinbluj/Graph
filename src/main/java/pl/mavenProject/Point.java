package pl.mavenProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Point {
    private int x;
    private int y;
    private List<Point> connections = new ArrayList<Point>();
    private Map<Point, Integer> connectionsMap = new HashMap<Point, Integer>();

    static List<Point> pointsList = new ArrayList<Point>();

    Point(int x, int y) {

        this.x = x;
        this.y = y;
        if (!isInBoardRange()) {
            throw new IllegalArgumentException("Punkt poza zasiegiem pola.");
        } else {
            addToPointsList();
        }
    }

    Point(int x, int y, List<Point> connections) {

        this.x = x;
        this.y = y;
        this.connections = connections;
        if (!isInBoardRange()) {
            throw new IllegalArgumentException("Punkt poza zasiegiem pola.");
        } else {
            addToPointsList();
        }
    }

    int getX() {
        return x;
    }

    void setX(int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    void setY(int y) {
        this.y = y;
    }

    List<Point> getConnections() {
        return connections;
    }

    void setConnections(List<Point> connections) {
        this.connections = connections;
    }

    void addConnection(Point point) {
        if (!point.equals(this)) {
            this.connections.add(point);
        } else {
            throw new IllegalArgumentException("Nie można połączyć punktu z samym sobą.");
        }
    }

    void removeConnection(Point point) {
        if (connections.contains(point)) {
            this.connections.remove(point);
        }
    }

    private void addToPointsList() {
        for (int i = 0; i < pointsList.size(); i++) {
            if (pointsList.get(i).getX() == this.getX() && pointsList.get(i).getY() == this.getY()) {
                pointsList.remove(i);
            }
        }
        pointsList.add(this);
    }

    private boolean isInBoardRange() {
        return !(x > Board.WIDTH || y > Board.HEIGHT || x < 0 || y < 0);
    }

    void addToConnectionsMap(Point point, Integer distance){
        if (!point.equals(this)) {
            connectionsMap.put(point, distance);
        } else {
            throw new IllegalArgumentException("Nie można połączyć punktu z samym sobą.");
        }

    }

    void removeFromConnectionsMap(Point point){
        if (connectionsMap.containsKey(point)) {
            connectionsMap.remove(point);
        } else {
            throw new IllegalArgumentException("Nie ma takiego punktu w mapie.");
        }
    }

    Map<Point, Integer> getConnectionsMap(){
        return connectionsMap;
    }

    @Override
    public String toString() {
        return "P"+Integer.toString(pointsList.indexOf(this));
    }
}