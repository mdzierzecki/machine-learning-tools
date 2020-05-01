package Program;

import Models.Centroid;
import Models.Record;

import java.util.ArrayList;
import java.util.List;

public class Compute {

    public static List<Centroid> generateKCentroids(int k){
        Centroid a = new Centroid("A");
        Centroid b = new Centroid("B");
        List<Centroid> centroidList = new ArrayList<>();
        centroidList.add(a);centroidList.add(b);

        return centroidList;
    }

    public static void populateCluster(List<Record> trainRecords, List<Centroid> centroidList) {
        for (Record record: trainRecords) {
            record.assignToCentroid(centroidList);
        }

        for (Record record: trainRecords) {
            System.out.println(record);
        }
    }
}
