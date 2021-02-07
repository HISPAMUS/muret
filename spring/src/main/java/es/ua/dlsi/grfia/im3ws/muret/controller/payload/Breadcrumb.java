package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 7/2/21
 */
public class Breadcrumb {
    private int id;
    private BreadcrumbType breadcrumbType;
    private String title;

    public Breadcrumb() {
    }

    public Breadcrumb(int id, BreadcrumbType breadcrumbType, String title) {
        this.id = id;
        this.breadcrumbType = breadcrumbType;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BreadcrumbType getBreadcrumbType() {
        return breadcrumbType;
    }

    public void setBreadcrumbType(BreadcrumbType breadcrumbType) {
        this.breadcrumbType = breadcrumbType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
