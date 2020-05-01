import Models.Centroid;
import Models.Record;
import Program.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Record> trainRecords = Utils.fromFileToList("dataset/iris_all.csv");

        System.out.println(trainRecords);
        System.out.println(trainRecords.size());
        System.out.println("================");

        Centroid a = new Centroid("A");
        Centroid b = new Centroid("B");
        List<Centroid> centroidList = new ArrayList<>();
        centroidList.add(a);centroidList.add(b);

        for (Record record: trainRecords) {
            record.assignToCentroid(centroidList);
        }

        for (Record record: trainRecords) {
            System.out.println(record);
        }

        System.out.println(a.getAssignedRecords());

    }
}
