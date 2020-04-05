package neurons;

import program.Record;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Compute {
    private Neuron neuronSetosa;
    private Neuron neuronVersicolor;
    private Neuron neuronVirginica;
    List<Record> trainRecords;
    List<Record> testRecords;

    public Compute() throws IOException {
        String path = "dataset/iristrain.csv";
        trainRecords = Files.lines(Paths.get(path))
                .skip(1)
                .map(Record::new)
                .collect(Collectors.toList());

//        Collections.shuffle(trainRecords);

        String pathTest = "dataset/iristest.csv";
        testRecords = Files.lines(Paths.get(pathTest))
                .skip(1)
                .map(Record::new)
                .collect(Collectors.toList());

        neuronSetosa = new Neuron(trainRecords, "setosa");
        for(int i=0; i<20000; i++) {
            neuronSetosa.train();
        }

        neuronVersicolor = new Neuron(trainRecords, "versicolor");
        for(int i=0; i<20000; i++) {
            neuronVersicolor.train();
        }

        neuronVirginica = new Neuron(trainRecords, "virginica");
        for(int i=0; i<20000; i++) {
            neuronVirginica.train();
        }

        System.out.println(neuronSetosa.toString());

        System.out.println(neuronVersicolor.toString());

        System.out.println(neuronVirginica.toString());

        compute();
    }

    public void compute() throws IOException{

        checkRecords(testRecords);
    }

    public String checkRecord(Record record) {
        int setosa = 0;
        int versicolor = 0;
        int virginica = 0;

        for (int i=0; i<10; i++) {
            if (neuronSetosa.check(record)) { setosa++; }
            if (neuronVersicolor.check(record)) { versicolor++; }
            if (neuronVirginica.check(record)) { virginica++; }
        }

        if(setosa > versicolor && setosa > virginica) {
//            System.out.println("Result: " + setosa);
            return "setosa";
        } else if (versicolor > setosa && versicolor > virginica) {
//            System.out.println("Result: " + versicolor);
            return "versicolor";
        } else {
//            System.out.println("Result: " + setosa);
//            System.out.println("Result: " + versicolor);
//            System.out.println("Result: " + virginica);
            return "virginica";
        }
    }

    public void checkRecords(List<Record> testRecords) {
        for (int i=0; i<testRecords.size(); i++) {
            System.out.println(testRecords.get(i).id + ". " + checkRecord(testRecords.get(i)));
        }
    }
}
