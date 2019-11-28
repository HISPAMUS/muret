package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import org.springframework.web.multipart.MultipartFile;

public class UploadModel
{
    private String eName;
    private String eCollection;
    private String eClassifierType;
    private String eNotationType;
    private String eManuscriptType;
    private String eModelType;

    private MultipartFile eModelFile;

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteCollection() {
        return eCollection;
    }

    public void seteCollection(String eCollection) {
        this.eCollection = eCollection;
    }

    public String geteClassifierType() {
        return eClassifierType;
    }

    public void seteClassifierType(String eClassifierType) {
        this.eClassifierType = eClassifierType;
    }

    public String geteNotationType() {
        return eNotationType;
    }

    public void seteNotationType(String eNotationType) {
        this.eNotationType = eNotationType;
    }

    public String geteManuscriptType() {
        return eManuscriptType;
    }

    public void seteManuscriptType(String eManuscriptType) {
        this.eManuscriptType = eManuscriptType;
    }

    public String geteModelType() {
        return eModelType;
    }

    public void seteModelType(String eModelType) {
        this.eModelType = eModelType;
    }

    public MultipartFile geteModelFile() {
        return eModelFile;
    }

    public void seteModelFile(MultipartFile eModelFile) {
        this.eModelFile = eModelFile;
    }
}
