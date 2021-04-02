package es.ua.dlsi.grfia.im3ws.muret.model.actionlogs;

import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.ActionLogModel;
import es.ua.dlsi.im3.core.IM3Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ActionLogsDocument extends AbstractActionLogs {
    public static int OPEN_DOCUMENT_ID = 10;
    private final ActionType OPEN_DOCUMENT;
    private final ActionType CREATE_DOCUMENT;
    private final ActionType UPLOAD_FILES;
    private final ActionType REORDER_IMAGES;
    private final ActionType CREATE_SECTION;
    private final ActionType DELETE_SECTION;
    private final ActionType REORDER_SECTION;
    private final ActionType MOVE_IMAGES_TO_SECTION;
    private final ActionType OPEN_IMAGE;

    @Autowired
    public ActionLogsDocument(ActionLogModel actionLogModel) throws IM3Exception {
        super(actionLogModel);
        OPEN_DOCUMENT = getActionType(OPEN_DOCUMENT_ID);
        CREATE_DOCUMENT = getActionType(11);
        UPLOAD_FILES = getActionType(12);
        REORDER_IMAGES = getActionType(13);
        CREATE_SECTION = getActionType(14);
        DELETE_SECTION = getActionType(15);
        REORDER_SECTION = getActionType(16);
        MOVE_IMAGES_TO_SECTION = getActionType(34);
        OPEN_IMAGE = getActionType(35);
    }

    public void logOpenDocument(Document document) {
        this.log(OPEN_DOCUMENT, document);
    }
    public void logCreateDocument(Document document) {
        this.log(CREATE_DOCUMENT, document);
    }
    public void logUploadFiles(Document document) {
        this.log(UPLOAD_FILES, document);
    }
    public void logReorderImages(Document document) {
        this.log(REORDER_IMAGES, document);
    }
    public void logCreateSection(Document document) {
        this.log(CREATE_SECTION, document);
    }
    public void logDeleteSection(Section section) {
        this.log(DELETE_SECTION, section);
    }
    public void logReorderSection(Document document) {
        this.log(REORDER_SECTION, document);
    }
    public void logMoveImagesToSection(Document document) {
        this.log(MOVE_IMAGES_TO_SECTION, document);
    }

    public void logOpenImage(Image image) {
        this.log(OPEN_IMAGE, image);
    }
}
