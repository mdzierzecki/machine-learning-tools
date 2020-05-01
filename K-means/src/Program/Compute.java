package Program;

import Models.Centroid;
import Models.Record;

import java.util.ArrayList;
import java.util.List;

public class Compute {

    public static List<Centroid> generateKCentroids(int k, int cordsNum) throws InterruptedException {
        List<Centroid> centroidList = new ArrayList<>();

        for (int i=1; i<=k; i++) {
            centroidList.add(new Centroid("C-" + i, cordsNum));
            System.out.println("Centroid " + "C-" + i + " was successfully created!");
            Thread.sleep(1500);
        }

        return centroidList;
    }

    public static void populateCluster(List<Record> trainRecords, List<Centroid> centroidList) {
        for (Centroid centroid: centroidList) {
            centroid.resetRecords();
        }

        for (Record record: trainRecords) {
            record.assignToCentroid(centroidList);
        }

        for (Record record: trainRecords) {
            System.out.println(record);
        }

        for (Centroid centroid: centroidList) {
            centroid.averageCords();
        }

        System.out.println();
        for (Centroid centroid: centroidList) {
            System.out.println(centroid.toString());
        }
    }
}
