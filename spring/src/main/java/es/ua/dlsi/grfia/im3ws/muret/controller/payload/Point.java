package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import java.io.Serializable;

public class Point implements Serializable {
    long time;
    int x;
    int y;

    public Point(long timestamp, int x, int y) {
        this.time = timestamp;
        this.x = x;
        this.y = y;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
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
