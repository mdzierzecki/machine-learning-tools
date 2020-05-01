package Program;

import Models.Centroid;
import Models.Record;
import Utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Record> trainRecords = Utils.fromFileToList("dataset/iris_all.csv");

        System.out.println("Records amount: " + trainRecords.size());
        System.out.println("=====================================");

        List<Centroid> centroidList = Compute.generateKCentroids(3);

        for (int i=0; i<4; i++) {
            System.out.println("Iteration number " + i);
            Compute.populateCluster(trainRecords, centroidList);
            System.out.println("=====================================");
        }
        
    }
}
