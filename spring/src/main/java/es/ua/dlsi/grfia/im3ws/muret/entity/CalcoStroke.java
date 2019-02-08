package es.ua.dlsi.grfia.im3ws.muret.entity;

import java.util.LinkedList;
import java.util.List;

public class CalcoStroke extends Stroke {
    List<Point> points;

    public CalcoStroke(List<Point> points) {
        this.points = points;
    }

    public CalcoStroke() {
        this.points = new LinkedList<>();
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void addPoint(Point point) {
        this.points.add(point);
    }
}
