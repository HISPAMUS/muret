package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import java.util.ArrayList;
import java.util.List;

public class PreflightCkeckResult {
    static public class PreflightCkeckRegionResult {
        long regionID;
        List<String> messages;

        public PreflightCkeckRegionResult() {
        }

        public PreflightCkeckRegionResult(long regionID, List<String> messages) {
            this.regionID = regionID;
            this.messages = messages;
        }

        public long getRegionID() {
            return regionID;
        }

        public void setRegionID(long regionID) {
            this.regionID = regionID;
        }

        public List<String> getMessages() {
            return messages;
        }

        public void setMessages(List<String> messages) {
            this.messages = messages;
        }
    }
    static public class PreflightCkeckImageResult {
        long imageID;
        String imageName;
        List<PreflightCkeckRegionResult> regionResults;

        public PreflightCkeckImageResult() {
        }

        public PreflightCkeckImageResult(long imageID, String imageName, List<PreflightCkeckRegionResult> regionResults) {
            this.imageID = imageID;
            this.imageName = imageName;
            this.regionResults = regionResults;
        }

        public long getImageID() {
            return imageID;
        }

        public void setImageID(long imageID) {
            this.imageID = imageID;
        }

        public List<PreflightCkeckRegionResult> getRegionResults() {
            return regionResults;
        }

        public void setRegionResults(List<PreflightCkeckRegionResult> regionResults) {
            this.regionResults = regionResults;
        }

        public String getImageName() {
            return imageName;
        }

        public void setImageName(String imageName) {
            this.imageName = imageName;
        }

        public void addRegionResult(PreflightCkeckRegionResult preflightCkeckRegionResult) {
            if (this.regionResults == null) {
                this.regionResults = new ArrayList<>();
            }
            this.regionResults.add(preflightCkeckRegionResult);
        }

    }

    List<PreflightCkeckImageResult> preflightCkeckImageResults;

    public PreflightCkeckResult(List<PreflightCkeckImageResult> preflightCkeckImageResults) {
        this.preflightCkeckImageResults = preflightCkeckImageResults;
    }

    public PreflightCkeckResult() {
    }

    public List<PreflightCkeckImageResult> getPreflightCkeckImageResults() {
        return preflightCkeckImageResults;
    }

    public void setPreflightCkeckImageResults(List<PreflightCkeckImageResult> preflightCkeckImageResults) {
        this.preflightCkeckImageResults = preflightCkeckImageResults;
    }

    public void addPreflightImageResult(PreflightCkeckImageResult preflightCkeckImageResult) {
        if (this.preflightCkeckImageResults == null) {
            this.preflightCkeckImageResults = new ArrayList<>();
        }
        this.preflightCkeckImageResults.add(preflightCkeckImageResult);
    }


}
