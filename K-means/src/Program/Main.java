package Program;

import Models.Centroid;
import Models.Record;
import Utils.Utils;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Record> trainRecords = Utils.fromFileToList("dataset/iris_all.csv");

        System.out.println("Records amount: " + trainRecords.size());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter K value: ");
        int k = scanner.nextInt();
        System.out.println("Your K is: " + k);

        List<Centroid> centroidList = null;

        try {
            centroidList = Compute.generateKCentroids(k, trainRecords.get(0).data.length);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("================ S T A R T   I N F O =====================");
        System.out.println("Number of columns in csv: " + trainRecords.get(0).data.length);
        for (Centroid centroid: centroidList) {
            System.out.println(centroid.toString());
        }

        System.out.println();
        System.out.println("K-means computing is going to start in few seconds...");
        System.out.println();

        for (int i=1; i<5000; i++) {
            System.out.println("Iteration number " + i);
            Compute.populateCluster(trainRecords, centroidList);
            System.out.println("=====================================");
        }

        System.out.println();
        System.out.println();
        System.out.println("================ S U M M A R Y =====================");
        for (Centroid centroid: centroidList) {
            System.out.println(centroid.toString());
            System.out.println("Centroid records: " + centroid.getAssignedRecords());
        }


    }
}
