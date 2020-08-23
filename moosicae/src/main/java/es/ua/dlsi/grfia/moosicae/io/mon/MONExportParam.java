package es.ua.dlsi.grfia.moosicae.io.mon;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 12/04/2020
 */
public class MONExportParam {
    private JSONObject jsonObject;

    public MONExportParam() {
        this.jsonObject = new JSONObject();
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void add(String propertyName, String value) {
        jsonObject.put(propertyName, value);
    }
    public void add(String propertyName, JSONAware value) {
        jsonObject.put(propertyName, value);
    }

    public void add(String propertyName, int value) {
        jsonObject.put(propertyName, value);
    }

    public MONExportParam addChild(String propertyName) {
        MONExportParam child = new MONExportParam();
        jsonObject.put(propertyName, child.getJsonObject());
        return child;
    }
}
