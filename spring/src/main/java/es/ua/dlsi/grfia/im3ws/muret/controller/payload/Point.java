package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import java.io.Serializable;

public class Point implements Serializable {
    long timestamp;
    int x;
    int y;

    public Point(long timestamp, int x, int y) {
        this.timestamp = timestamp;
        this.x = x;
        this.y = y;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
