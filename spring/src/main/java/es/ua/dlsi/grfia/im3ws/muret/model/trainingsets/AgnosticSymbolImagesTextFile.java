package es.ua.dlsi.grfia.im3ws.muret.model.trainingsets;

import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.adt.graphics.BoundingBoxXY;
import es.ua.dlsi.im3.core.utils.FileCompressors;
import es.ua.dlsi.im3.core.utils.ImageUtils;
import es.ua.dlsi.im3.core.io.ExportException;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * It exports a file containing a line for each symbol with the image, region number, symbol, image pixels
 * @autor drizo
 */
public class AgnosticSymbolImagesTextFile extends AbstractTrainingSetExporter {
    private static final int FIXED_SIZE = 30;
    private static final String FIELD_SEPARATOR = ";";
    private final boolean useMargin;
    private final boolean fixedSize;

    public AgnosticSymbolImagesTextFile(int id, boolean margin, boolean fixedSize) {
        super(id, constructName(margin, fixedSize), constructDescription(margin, fixedSize), true);
        this.useMargin = margin;
        this.fixedSize = fixedSize;
    }

    private static String constructName(boolean margin, boolean fixedSize) {
        String name = "Text file with grayscale images";
        if (fixedSize) {
            name += ", fixed size";
        }
        if (margin) {
            name += ", with margin";
        }
        return name;
    }

    private static String constructDescription(boolean margin, boolean fixedSize) {
        String name = "Each line of text file contains the page, image name, symbol, and the symbol image encoded in grayscale";
        if (fixedSize) {
            name += ", symbol images downsampled to " + FIXED_SIZE + "x" + FIXED_SIZE;
        }
        if (margin) {
            name += ", with each margin equal of the size of the image";
        }
        return name;
    }

    @Override
    public Path generate(Path muretFolder, Collection<Document> documentCollection) throws ExportException {
        try {
            Path directory = Files.createTempDirectory("text_images");
            for (Document document : documentCollection) {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Exporting document " + document.getName());

                File documentTextFile = new File(directory.toFile(), document.getPath() + ".txt");
                generateDocumentTextFile(muretFolder, document, documentTextFile, fixedSize);
            }

            File resultTGZ = File.createTempFile("boundingboxes_pages_regions_symbols", ".tar.gz");
            FileCompressors fileCompressors = new FileCompressors();
            fileCompressors.tgzFolder(resultTGZ.toPath(), directory);
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Generated tgz {0}", resultTGZ);
            return resultTGZ.toPath();
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot generate agnostic_symbol_images", e);
            throw new ExportException(e);
        }
    }

    private void write(FileChannel channel, String string) throws IOException {
        byte[] strBytes = string.getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
        buffer.put(strBytes);
        buffer.flip();
        channel.write(buffer);
    }


    public void generateDocumentTextFile(Path muretFolder, Document document, File outputTextFile, boolean fixedSize) throws IOException, IM3Exception, InterruptedException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputTextFile,true),8192*40);

        StringBuilder sb = new StringBuilder();
        sb.append("#Image");
        sb.append(FIELD_SEPARATOR);
        sb.append("Page");
        sb.append(FIELD_SEPARATOR);
        sb.append("Region");
        sb.append(FIELD_SEPARATOR);
        sb.append("Agnostic symbol");
        sb.append(FIELD_SEPARATOR);


        /*if (fixedSize) {
            if (useMargin) {
                ps.print("Image pixels (including margin):");
                ps.print(FIXED_SIZE*3);
                ps.print('x');
                ps.println(FIXED_SIZE*3);
            } else {
                ps.print("Image pixels:");
                ps.print(FIXED_SIZE);
                ps.print('x');
                ps.println(FIXED_SIZE);
            }
        } else {
            if (useMargin) {
                ps.print("Width (including margins)");
                ps.print(FIELD_SEPARATOR);
                ps.println("Height");
            } else {
                ps.print("Width (including margins)");
                ps.print(FIELD_SEPARATOR);
                ps.println("Height");
            }
        }*/

        sb.append("Width");
        sb.append(FIELD_SEPARATOR);
        sb.append("Height\n");

        writer.write(sb.toString());

        int nimage = 1;
        for (Image image: document.getImages()) {
            System.out.println("\tExporting image " + nimage + " of " + document.getImages().size());
            nimage++;
            //Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Exporting image " + image.getFilename());

            int npage = 1;
            Path imagePath = Paths.get(muretFolder.toFile().getPath(), document.getPath(),
                    MURETConfiguration.MASTER_IMAGES, image.getFilename());
            for (Page page : image.getPages()) {
                System.out.println("> Page " + page);
                if (!page.getRegions().isEmpty()) {
                    int nregion = 1;
                    StringBuilder sbRegion = new StringBuilder();

                    for (Region region : page.getRegions()) {
                        System.out.println("\t> Region " + nregion);
                        //Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Exporting region " + region.getId());

                        if (!region.getSymbols().isEmpty()) {
                            for (Symbol symbol : region.getSymbols()) {
                                printSymbol(sbRegion, imagePath.toFile(), image, npage, nregion, symbol, fixedSize);
                            }
                            nregion++;

                            /*if (nregion == 7) {
                                nregion = 1;
                                npage++;
                            }*/
                        } else {
                            System.out.println("\t\t> Empty region");
                        }
                    }

                    writer.write(sbRegion.toString());
                    npage++;
                }
            }
        }

        writer.close();
    }

    private void printSymbol(StringBuilder sb, File imageFile, Image image, int page, int region, Symbol symbol, boolean fixedSize) throws IM3Exception {
        sb.append(image.getFilename());
        sb.append(FIELD_SEPARATOR);
        sb.append(page);
        sb.append(FIELD_SEPARATOR);
        sb.append(region);
        sb.append(FIELD_SEPARATOR);
        sb.append(symbol.getAgnosticSymbol().getAgnosticString());
        sb.append(FIELD_SEPARATOR);

        BoundingBoxXY boundingBoxXY;
        if (useMargin) {
            int width = symbol.getBoundingBox().getWidth();
            int height = symbol.getBoundingBox().getToY() - symbol.getBoundingBox().getFromY();

            boundingBoxXY = new BoundingBoxXY(
                    Math.max(0, symbol.getBoundingBox().getFromX()-width),
                    Math.max(0, symbol.getBoundingBox().getFromY()-height),
                    Math.min(image.getWidth(), symbol.getBoundingBox().getToX()+width),
                    Math.min(image.getHeight(), symbol.getBoundingBox().getToY()+height));
        } else {
            boundingBoxXY = new BoundingBoxXY(
                    symbol.getBoundingBox().getFromX(), symbol.getBoundingBox().getFromY(), symbol.getBoundingBox().getToX(), symbol.getBoundingBox().getToY()
            );
        }

        if (fixedSize) {
            int[] imagePixels = getGrayscaleImagePixelsNormalized(imageFile, boundingBoxXY);
            boolean first = true;
            for (int i = 0; i < imagePixels.length; i++) {
                if (first) {
                    first = false;
                } else {
                    sb.append(',');
                }
                sb.append(imagePixels[i]);
            }
        } else {
            int [][] imagePixels = getGrayscaleImagePixels(imageFile, boundingBoxXY);
            sb.append(imagePixels.length);
            sb.append(FIELD_SEPARATOR);
            sb.append(imagePixels[0].length);
            sb.append(FIELD_SEPARATOR);
            boolean first = true;
            for (int i = 0; i < imagePixels.length; i++) {
                for (int j = 0; j < imagePixels[i].length; j++) {
                    if (first) {
                        first = false;
                    } else {
                        sb.append(',');
                    }
                    sb.append(imagePixels[i][j]);
                }
            }
        }
        sb.append('\n');
    }

    private int[][] getGrayscaleImagePixels(File imageFile, BoundingBoxXY boundingBoxXY) throws IM3Exception {
        BufferedImage subimage = ImageUtils.getInstance().generateBufferedImage(imageFile, boundingBoxXY);
        int[][] imagePixels = ImageUtils.getInstance().readGrayScaleImage(subimage);
        return imagePixels;
    }


    /**
     * Get rescaled pixels to RESIZE_W and RESIZE_H
     * @param imageFile
     * @param boundingBoxXY
     * @return
     * @throws IM3Exception
     */
    public int[] getGrayscaleImagePixelsNormalized(File imageFile, BoundingBoxXY  boundingBoxXY) throws IM3Exception {
        BufferedImage subimage = ImageUtils.getInstance().generateBufferedImage(imageFile, boundingBoxXY);
        int size = FIXED_SIZE;
        if (useMargin) {
            size = size * 3;
        }
        BufferedImage scaledImage = ImageUtils.getInstance().rescaleToGray(subimage, size, size);
        int[][] imagePixels = ImageUtils.getInstance().readGrayScaleImage(scaledImage);

        if (imagePixels.length != size) {
            throw new IM3Exception("Expected width " +  size + " and found " + imagePixels.length);
        }
        if (imagePixels[0].length != size) {
            throw new IM3Exception("Expected height " +  size + " and found " + imagePixels[0].length);
        }
        int [] result = new int[size * size];
        int index=0;
        for (int i=0; i<imagePixels.length; i++) {
            for (int j=0; j<imagePixels[i].length; j++) {
                result[index++] = imagePixels[i][j];
            }
        }
        return result;
    }
}
