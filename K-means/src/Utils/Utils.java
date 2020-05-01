package Utils;

import Models.Centroid;
import Models.Record;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static double calculateDistance(Record rec, Centroid centroid) {
        double toRoot = Math.pow(Math.abs(rec.getData()[0] - centroid.getCords()[0]), 2)
                + Math.pow(Math.abs(rec.getData()[1] - centroid.getCords()[1]), 2)
                + Math.pow(Math.abs(rec.getData()[2] - centroid.getCords()[2]), 2)
                + Math.pow(Math.abs(rec.getData()[3] - centroid.getCords()[3]), 2);

        return Math.sqrt(toRoot);
    }

    public static List<Record> fromFileToList(String path) throws IOException {
        List<Record> trainRecords;
        trainRecords = Files.lines(Paths.get(path))
                .skip(1)
                .map(Record::new)
                .collect(Collectors.toList());

        return trainRecords;
    }
}
