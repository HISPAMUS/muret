package es.ua.dlsi.grfia.moosicae.io.json;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 12/04/2020
 */
public class JSONExportParam {
    private JSONObject jsonObject;

    public JSONExportParam() {
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

    public JSONExportParam addChild(String propertyName) {
        JSONExportParam child = new JSONExportParam();
        jsonObject.put(propertyName, child.getJsonObject());
        return child;
    }
}
