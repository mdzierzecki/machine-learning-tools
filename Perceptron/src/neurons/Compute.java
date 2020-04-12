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
    private Neuron neuronSetosa;
    private Neuron neuronVersicolor;
    private Neuron neuronVirginica;
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

        neuronSetosa = new Neuron(trainRecords, "setosa");
        for(int i=0; i<20000; i++) {
            neuronSetosa.train();
        }

        checkRecordsSecondLayer(trainRecords);

        neuronVersicolor = new Neuron(recordsSecondLayer, "versicolor");
        for(int i=0; i<20000; i++) {
            neuronVersicolor.train();
        }
        System.out.println(neuronSetosa.toString());

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
            if (neuronSetosa.check(record)) { setosa++; }
            else if (neuronVersicolor.check(record)) { versicolor++; }
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
            if (!neuronSetosa.check(testRecord)) {
                recordsSecondLayer.add(testRecord);
            }
        }
    }
}
