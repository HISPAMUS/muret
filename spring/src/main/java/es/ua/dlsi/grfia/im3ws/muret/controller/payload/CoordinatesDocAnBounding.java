package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

public class CoordinatesDocAnBounding {

    /**
     * From x
     */
    Integer x0;
    /**
     * From y
     */
    Integer y0;
    /**
     * To x
     */
    Integer xf;
    /**
     * To y
     */
    Integer yf;
    String regionType;

    public Integer getX0() {
        return x0;
    }

    public void setX0(Integer x0) {
        this.x0 = x0;
    }

    public Integer getY0() {
        return y0;
    }

    public void setY0(Integer y0) {
        this.y0 = y0;
    }

    public Integer getXf() {
        return xf;
    }

    public void setXf(Integer xf) {
        this.xf = xf;
    }

    public Integer getYf() {
        return yf;
    }

    public void setYf(Integer yf) {
        this.yf = yf;
    }

    public String getRegionType() {
        return regionType;
    }

    public void setRegionType(String regionType) {
        this.regionType = regionType;
    }
}
