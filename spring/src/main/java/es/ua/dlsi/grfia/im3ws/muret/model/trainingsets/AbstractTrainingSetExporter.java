package es.ua.dlsi.grfia.im3ws.muret.model.trainingsets;

import es.ua.dlsi.grfia.im3ws.muret.model.ITrainingSetExporter;

public abstract class AbstractTrainingSetExporter implements ITrainingSetExporter {
    int id;
    String name;
    String description;
    boolean adminPermissionRequired;

    public AbstractTrainingSetExporter(int id, String name, String description, boolean adminPermissionRequired) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.adminPermissionRequired = adminPermissionRequired;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean isAdminPermissionRequired() {
        return adminPermissionRequired;
    }

    public void setAdminPermissionRequired(boolean adminPermissionRequired) {
        this.adminPermissionRequired = adminPermissionRequired;
    }
}
