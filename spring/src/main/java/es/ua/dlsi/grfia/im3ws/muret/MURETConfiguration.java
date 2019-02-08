package es.ua.dlsi.grfia.im3ws.muret;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ConfigurationProperties(prefix = "muret")
public class MURETConfiguration {
    public static final String MASTER_IMAGES = "masters";
    public static final String THUMBNAIL_IMAGES = "thumbnails";
    public static final String PREVIEW_IMAGES = "previews";

    private String folder;
    private String url;
    private int thumbnailHeight;
    private int previewHeight;
    private boolean disableSecurity;

    String pythonclassifiers;

    public MURETConfiguration() {
    }

    public MURETConfiguration(String folder, String url, String pythonclassifiers, int thumbnailHeight, int previewHeight, boolean disableSecurity) {
        this.folder = folder;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}
