package es.ua.dlsi.grfia.im3ws.muret.entity;

public class Point {
    long time;
    int x;
    int y;

    public Point(long time, int x, int y) {
        this.time = time;
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
