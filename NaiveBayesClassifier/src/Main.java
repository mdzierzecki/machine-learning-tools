import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello");

        String csvFile = "data/train";

        List<Record> trainRecords = Files.lines(Paths.get(csvFile))
                .map(Record::new)
                .collect(Collectors.toList());

        for (Record record: trainRecords
             ) {
            System.out.println(record);
            System.out.println();
        }


    }
}
