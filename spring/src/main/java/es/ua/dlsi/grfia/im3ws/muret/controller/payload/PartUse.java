package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import java.math.BigInteger;

public class PartUse implements IPartUse {
    String partName;
    BigInteger partId;
    BigInteger imageId;
    /**
     * It corresponds to the ID of the symbol, region or page. If the part is used by an image, id = imageId
     */
    BigInteger id;

    public PartUse() {
    }

    public PartUse(String partName, BigInteger partId, BigInteger imageId, BigInteger id) {
        this.partName = partName;
        this.partId = partId;
        this.imageId = imageId;
        this.id = id;
    }

    public PartUse(BigInteger partId, BigInteger imageId, BigInteger id) {
        this.partId = partId;
        this.imageId = imageId;
        this.id = id;
    }

    public PartUse(Long partID, Long imageID, Long id) {
        this.partId = BigInteger.valueOf(partID);
        this.imageId = BigInteger.valueOf(imageID);
        if (id != null) {
            this.id = BigInteger.valueOf(id);
        }
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public void setPartId(BigInteger partId) {
        this.partId = partId;
    }

    public void setImageId(BigInteger imageId) {
        this.imageId = imageId;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Override
    public BigInteger getPartId() {
        return partId;
    }

    @Override
    public BigInteger getImageId() {
        return imageId;
    }

    @Override
    public BigInteger getId() {
        return id;
    }

}
