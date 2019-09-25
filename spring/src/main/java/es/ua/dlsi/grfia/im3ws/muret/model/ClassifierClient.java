package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.AgnosticSymbolTypeAndPosition;
import es.ua.dlsi.grfia.im3ws.muret.entity.BoundingBox;
import es.ua.dlsi.grfia.im3ws.muret.entity.Region;
import es.ua.dlsi.grfia.im3ws.muret.entity.Symbol;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import org.springframework.web.client.HttpClientErrorException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * It uses the Python classifier through a REST API
 */
public class ClassifierClient {
    private static final int N_PREDICTIONS_SHAPE = 5;
    private static final int N_PREDICTIONS_POSITION = 1;
    ClassifiersRESTClient restClient;

    public ClassifierClient(String restServerURL) {
        this.restClient = new ClassifiersRESTClient(restServerURL);
    }

    public boolean checkImageExists(long imageID) throws IM3WSException {
        try {
            restClient.get("image/" + imageID, String.class);
            return true;
        } catch (HttpClientErrorException h) {
            if (h.getRawStatusCode() == 404) {
                return false;
            } else {
                throw new IM3WSException("Wrong response from server", h);
            }
        }
    }

    public void uploadImage(long imageID, Path path) {
        restClient.uploadFileWithPOST("image", "image", path, Collections.singletonMap("id", imageID));
    }

    class BBox {
        int left;
        int top;
        int right;
        int bottom;

        public BBox(BoundingBox boundingBox) {
            this.left = boundingBox.getFromX();
            this.right = boundingBox.getToX();
            this.top = boundingBox.getFromY();
            this.bottom = boundingBox.getToY();
        }

        public int getLeft() {
            return left;
        }

        public int getTop() {
            return top;
        }

        public int getRight() {
            return right;
        }

        public int getBottom() {
            return bottom;
        }
    }

    static class ShapePosition { // it must be static for letting Jackson instantiate it from JSon responses
        String [] shape;
        String [] position;

        public String[] getShape() {
            return shape;
        }

        public void setShape(String[] shape) {
            this.shape = shape;
        }

        public String[] getPosition() {
            return position;
        }

        public void setPosition(String[] position) {
            this.position = position;
        }

        @Override
        public String toString() {
            return "ShapePosition{" +
                    "shape=" + Arrays.toString(shape) +
                    ", position=" + Arrays.toString(position) +
                    '}';
        }
    }

    /**
     *
     * @param imageID
     * @param path
     * @param boundingBox
     * @return A sorted list of possibilities
     * @throws IM3WSException
     * @throws IM3Exception
     */
    public List<AgnosticSymbolTypeAndPosition> classifySymbolInImage(long imageID, Path path, BoundingBox boundingBox) throws IM3WSException {
        if (!checkImageExists(imageID)) {
            this.uploadImage(imageID, path);
        }

        Map<String, Object> postContent = new HashMap<>();
        postContent.put("left", boundingBox.getFromX());
        postContent.put("top", boundingBox.getFromY());
        postContent.put("right", boundingBox.getToX());
        postContent.put("bottom", boundingBox.getToY());
        postContent.put("predictions", N_PREDICTIONS_SHAPE);

        try {
            //ShapePosition response = this.restClient.post("image/" + imageID + "/bbox", ShapePosition.class, postContent);
            ShapePosition response = this.restClient.post("image/" + imageID + "/symbol", ShapePosition.class, postContent);


            List<AgnosticSymbolTypeAndPosition> result = new ArrayList<>();

            // take just the first position retrieved
            //TODO ¿Cómo lo hacemos?
            for (int i = 0; i < response.getShape().length; i++) {
                for (int j = 0; j < N_PREDICTIONS_POSITION && j < response.getPosition().length; j++) {
                    String shape = correctShape(response.shape[i]); // TODO Parche
                    AgnosticSymbolTypeAndPosition agnosticSymbol = new AgnosticSymbolTypeAndPosition(shape, response.position[j]);
                    result.add(agnosticSymbol);
                }
            }
            return result;
        } catch (Throwable t) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING,  "Cannot classify " + path.toString() + " with bounding box " + boundingBox, t);
            return null;
        }
    }

    private String correctShape(String s) {
        switch (s) {
            case "repetitionDots":
                return "colon";
            case "smudge":
                return "defect.smudge";
            case "inkBlot":
                return "defect.inkBlot";
            case "paperHole":
                return "defect.paperHole";
            default:
                return s;
        }

    }


    static class EndToEndItem { // it must be static for letting Jackson instantiate it from JSon responses
        int start;
        int end;
        String position;
        String shape;

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getShape() {
            return shape;
        }

        public void setShape(String shape) {
            this.shape = shape;
        }
    }

    public List<AgnosticSymbolTypeAndPosition> classifyEndToEnd(long imageID, Path path, BoundingBox boundingBox) throws IM3WSException {
        if (!checkImageExists(imageID)) {
            this.uploadImage(imageID, path);
        }

        Map<String, Object> postContent = new HashMap<>();
        postContent.put("left", boundingBox.getFromX());
        postContent.put("top", boundingBox.getFromY());
        postContent.put("right", boundingBox.getToX());
        postContent.put("bottom", boundingBox.getToY());
        postContent.put("predictions", N_PREDICTIONS_SHAPE);

        try {
            EndToEndItem [] response = this.restClient.post("image/" + imageID + "/e2e", EndToEndItem[].class, postContent);

            List<AgnosticSymbolTypeAndPosition> result = new ArrayList<>();
            for (EndToEndItem endToEndItem: response) {
                String shape = correctShape(endToEndItem.shape); // TODO Parche
                AgnosticSymbolTypeAndPosition agnosticSymbolTypeAndPosition = new AgnosticSymbolTypeAndPosition(shape, endToEndItem.position);
                agnosticSymbolTypeAndPosition.setStart(endToEndItem.start);
                agnosticSymbolTypeAndPosition.setEnd(endToEndItem.end);
                result.add(agnosticSymbolTypeAndPosition);
            }
            System.out.println(result);
            return result;
        } catch (Throwable t) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING,  "Cannot classify e2e" + path.toString() + " with bounding box " + boundingBox, t);
            return null;
        }
    }

    public static void main(String [] args) throws IM3WSException, IM3Exception {
        // used to check it
        ClassifierClient classifiersRESTClient = new ClassifierClient("http://localhost:9999");
        System.out.println("Image 1 exists: " + classifiersRESTClient.checkImageExists(1));
        System.out.println("Image 2 exists: " + classifiersRESTClient.checkImageExists(2));

        System.out.println("Uploading image 1");
        String imagePathStr = "/Users/drizo/cmg/investigacion/software/github/repositorioHispamus/python-classifiers/symbol-classification/debug_shape.png";
        Path path = Paths.get(imagePathStr);
        classifiersRESTClient.uploadImage(1, path);
        System.out.println("Image 1 exists: " + classifiersRESTClient.checkImageExists(1));

        // 47,71,146,226 -> Clef.G2
        Path path2 = Paths.get("/Applications/MAMP/htdocs/muret/b-59-850/previews/12609.JPG");
        List<AgnosticSymbolTypeAndPosition> agnosticSymbol = classifiersRESTClient.classifySymbolInImage(2271, path2, new BoundingBox(47, 71, 146, 226));
        System.out.println("Classified as " + agnosticSymbol);
    }

}
