import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Compute {

    public static void compute() throws IOException{

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
        for(int i=0; i<10000; i++) {
            neuronSetosa.train();
        }

        Neuron neuronVersicolor = new Neuron(records, "versicolor");
        for(int i=0; i<10000; i++) {
            neuronVersicolor.train();
        }

        Neuron neuronVirginica = new Neuron(records, "virginica");
        for(int i=0; i<10000; i++) {
            neuronVirginica.train();
        }


        System.out.println(checkRecord(new Record(7, 5.5, 2.4, 3.7, 1.0, "bb"),
                neuronSetosa, neuronVersicolor, neuronVirginica));


        System.out.println("================");
        System.out.println(checkRecord(new Record(7, 5.2, 3.4, 1.4, 0.2, "bb"),
                neuronSetosa, neuronVersicolor, neuronVirginica));

//        checkRecords(testRecords, neuronSetosa, neuronVersicolor, neuronVirginica);
    }

    public static String checkRecord(Record record, Neuron neuron1, Neuron neuron2, Neuron neuron3) {
        int setosa = 0;
        int versicolor = 0;
        int virginica = 0;

        for (int i=0; i<10; i++) {
            if (neuron1.check(record)) { setosa++; }
            if (neuron2.check(record)) { versicolor++; }
            if (neuron3.check(record)) { virginica++; }
        }

        if(setosa > versicolor && setosa > virginica) {
            System.out.println("Result: " + setosa);
            return "setosa";
        } else if (versicolor > setosa && versicolor > virginica) {
            System.out.println("Result: " + versicolor);
            return "versicolor";
        } else {
            System.out.println("Result: " + setosa);
            System.out.println("Result: " + versicolor);
            System.out.println("Result: " + virginica);
            return "virginica";
        }
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
