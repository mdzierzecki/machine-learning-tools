package neurons;

import program.Record;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Compute {
    private Neuron neuronFirstLayer;
    private Neuron neuronSecondLayer;
    List<Record> trainRecords;
    List<Record> testRecords;
    List<Record> recordsSecondLayer = new ArrayList<>();

    public Compute() throws IOException {
        String path = "dataset/iristrain.csv";
        trainRecords = Files.lines(Paths.get(path))
                .skip(1)
                .map(Record::new)
                .collect(Collectors.toList());

        Collections.shuffle(trainRecords);

        String pathTest = "dataset/iristest.csv";
        testRecords = Files.lines(Paths.get(pathTest))
                .skip(1)
                .map(Record::new)
                .collect(Collectors.toList());

        neuronFirstLayer = new Neuron(trainRecords, "setosa");
        for(int i=0; i<20000; i++) {
            neuronFirstLayer.train();
        }

        checkRecordsSecondLayer(trainRecords);

        neuronSecondLayer = new Neuron(recordsSecondLayer, "versicolor");
        for(int i=0; i<20000; i++) {
            neuronSecondLayer.train();
        }
        System.out.println(neuronFirstLayer.toString());

        compute();
    }

    public void compute(){
        checkRecords(testRecords);
    }

    public String checkRecord(Record record) {
        int setosa = 0;
        int versicolor = 0;
        int virginica = 0;

        for (int i=0; i<10; i++) {
            if (neuronFirstLayer.check(record)) { setosa++; }
            else if (neuronSecondLayer.check(record)) { versicolor++; }
            else {
                virginica++;
            }
        }

        if(setosa > versicolor && setosa > virginica) {
            return "setosa";
        } else if (versicolor > setosa && versicolor > virginica) {
            return "versicolor";
        } else {
            return "virginica";
        }
    }

    public void checkRecords(List<Record> testRecords) {
        for (Record testRecord : testRecords) {
            System.out.println(testRecord.id + ". " + checkRecord(testRecord));
        }
    }

    public void checkRecordsSecondLayer(List<Record> recordsSecondGroup) {
        Collections.shuffle(recordsSecondGroup);
        for (Record testRecord : recordsSecondGroup) {
            if (!neuronFirstLayer.check(testRecord)) {
                recordsSecondLayer.add(testRecord);
            }
        }
    }
}
