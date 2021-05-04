package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.im3.core.adt.Pair;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 4/5/21
 */
public class ImageModel {
    /**
     * It finds how the score is rotated by using Hough Transforms
     * https://mattrajca.com/2016/12/08/aligning-music-scores-with-hough-transforms-core-image-and-swift.html
     * @param bufferedImage
     * @return degrees
     */
    public double computeScoreRotation(BufferedImage bufferedImage) {
        int pixelsWide = bufferedImage.getWidth();
        int pixelsHigh = bufferedImage.getHeight();

        boolean [] edgeMap = new boolean[pixelsHigh * pixelsWide];

        for (int y=0; y<pixelsHigh; y++) {
            for (int x = 0; x < pixelsWide; x++) {
                int rgb = bufferedImage.getRGB(x,y);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = (rgb & 0xFF);
                int gray = (r + g + b) / 3;
                edgeMap[y * pixelsWide + x] = gray > 127;
            }
        }

        //int thetaSubdivisions = 2; // each 0.5 degrees
        int thetaSubdivisions = 10; // each 0.1 degrees
        double thetaMax = 5; // max and min (5 degrees)
        double thetaMin = -thetaMax;
        int thetaCells = (int) (thetaMax * thetaSubdivisions * 2 /* plus/minus */ + 1);
        int rFactor = 4;
        int rMax = (int)(Math.sqrt(Math.pow(pixelsWide, 2) + Math.pow(pixelsHigh, 2)));
        int rCells = rMax / rFactor;

        int [] cells = new int[thetaCells * rCells];

        for (int y=0; y<pixelsHigh; y++) {
            for (int x=0; x<pixelsWide; x++) {
                if (edgeMap[y * pixelsWide + x]) {
                    continue;
                } else {
                    for (double theta = thetaMin; theta < thetaMax; theta += 0.5) {
                        int r = (int)(Math.cos(theta * Math.PI / 180.0) * (double)x + Math.sin(theta * Math.PI / 180.0) * (double)y);
                        if (r < rMax && r >= 0) {
                            int thetaIndex = (int)(Math.round(theta * (double)thetaSubdivisions) + thetaMax * thetaSubdivisions);
                            cells[thetaIndex * rCells + r / rFactor] += 1;
                        }
                    }
                }
            }
        }

        ArrayList<Pair<Integer, Double>> cellTuples = new ArrayList<>();

        for (int theta = 0; theta < thetaCells; theta++) {
            for (int r = 0; r < rCells; r++) {
                int frequency = cells[theta * rCells + r];
                double thetaScaled = (double)theta / (double)thetaSubdivisions - (double)thetaMax;
                cellTuples.add(new Pair<>(frequency, thetaScaled));
            }
        }

        cellTuples.sort((o1, o2) -> {
            // cellTuples.sort { return $0.frequency > $1.frequency }
            if (o1.getX() > o2.getX()) {
                return -1;
            } else if (o1.getX() < o2.getX()) {
                return 1;
            } else {
                return o1.hashCode() - o2.hashCode();
            }
        });
        double sum = 0;
        List<Pair<Integer, Double>> top5List = cellTuples.subList(0, 5);
        for (Pair<Integer, Double> top5 : top5List) {
            sum += top5.getY();
        }
        double average = sum / (double) (top5List.size());
        return average;
    }
}
