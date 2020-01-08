package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

public class PermissionsForm {

    private String userName;
    private String collectionID;
    private char typeOfPermission;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCollectionID() {
        return collectionID;
    }

    public void setCollectionID(String collectionID) {
        this.collectionID = collectionID;
    }

    public char getTypeOfPermission() {
        return typeOfPermission;
    }

    public void setTypeOfPermission(char typeOfPermission) {
        this.typeOfPermission = typeOfPermission;
    }
}
