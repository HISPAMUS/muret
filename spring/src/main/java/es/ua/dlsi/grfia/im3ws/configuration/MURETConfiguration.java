package es.ua.dlsi.grfia.im3ws.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "muret")
public class MURETConfiguration {
    public static final String MASTER_IMAGES = "masters";
    public static final String THUMBNAIL_IMAGES = "thumbnails";
    public static final String PREVIEW_IMAGES = "previews";

    private String angularurl;
    private String folder;
    private int thumbnailHeight;
    private int previewHeight;
    private boolean disableSecurity;

    String pythonclassifiers;

    public MURETConfiguration() {
    }

    public MURETConfiguration(String angularurl, String folder, String pythonclassifiers, int thumbnailHeight, int previewHeight, boolean disableSecurity) {
        this.folder = folder;
        this.angularurl = angularurl;
        //this.url = url;
        this.thumbnailHeight = thumbnailHeight;
        this.previewHeight = previewHeight;
        this.pythonclassifiers = pythonclassifiers;
        this.disableSecurity = disableSecurity;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public int getThumbnailHeight() {
        return thumbnailHeight;
    }

    public void setThumbnailHeight(int thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }

    public int getPreviewHeight() {
        return previewHeight;
    }

    public void setPreviewHeight(int previewHeight) {
        this.previewHeight = previewHeight;
    }

    public String getPythonclassifiers() {
        return pythonclassifiers;
    }

    public void setPythonclassifiers(String pythonclassifiers) {
        this.pythonclassifiers = pythonclassifiers;
    }

    public boolean isDisableSecurity() {
        return disableSecurity;
    }

    public void setDisableSecurity(boolean disableSecurity) {
        this.disableSecurity = disableSecurity;
    }

    public String getAngularurl() {
        return angularurl;
    }

    public void setAngularurl(String angularurl) {
        this.angularurl = angularurl;
    }
}
