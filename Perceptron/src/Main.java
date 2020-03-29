import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        String path = "dataset/iristrain.csv";
        List<Record> records = Files.lines(Paths.get(path))
                .skip(1)
                .map(Record::new)
                .collect(Collectors.toList());

        Collections.shuffle(records);

        String pathTest = "dataset/iristest.csv";
        List<Record> testRecords = Files.lines(Paths.get(pathTest))
                .skip(1)
                .map(Record::new)
                .collect(Collectors.toList());

        Neuron neuronSetosa = new Neuron(records, "setosa");
        for(int i=0; i<100; i++) {
            neuronSetosa.train();
        }

        Neuron neuronVersicolor = new Neuron(records, "versicolor");
        for(int i=0; i<100; i++) {
            neuronVersicolor.train();
        }

        Neuron neuronVirginica = new Neuron(records, "virginica");
        for(int i=0; i<100; i++) {
            neuronVirginica.train();
        }


        System.out.println(neuronVirginica.check(new Record(7, 6.7, 3.3, 5.7, 2.1, "bb")));

//        checkRecords(testRecords, neuronSetosa, neuronVersicolor, neuronVirginica);
    }

    public static void checkRecords(List<Record> testRecords, Neuron neuron1, Neuron neuron2, Neuron neuron3) {
        for (int i=0; i<testRecords.size(); i++) {
            if (neuron1.check(testRecords.get(i))) {
                System.out.println(testRecords.get(i).id + ". " + neuron1.irisType);
            } else if (neuron2.check(testRecords.get(i))) {
                System.out.println(testRecords.get(i).id + ". " + neuron2.irisType);
            } else if (neuron3.check(testRecords.get(i))) {
                System.out.println(testRecords.get(i).id + ". " + neuron3.irisType);
            }
        }
    }
}
