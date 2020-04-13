package Program;

import models.Neuron;
import models.Vector;

import java.util.ArrayList;
import java.lang.Math;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Compute {

    public Neuron germanNeuron;
    public Neuron czechNeuron;
    public Neuron englishNeuron;
    ArrayList<Vector> result;

    public Compute() {
        // create an array with vectors
        this.result = textsToVectors();

        // create neurons for every language
        this.germanNeuron = new Neuron(result, "de");
        this.czechNeuron = new Neuron(result, "cz");
        this.englishNeuron = new Neuron(result, "en");
    }

    // train neurons
    public void train(){
        for(int i=0; i<10000; i++) {
            germanNeuron.train();
            czechNeuron.train();
            englishNeuron.train();
        }
    }

    public String checkRecord(Vector record) {
        Map<String, Double> vals = new HashMap<>();

        // if perceptron activated, then put distance between output and theta to Map
        if (czechNeuron.check(record)) {
            vals.put("Czech", Math.abs(czechNeuron.distance(record)));
        }
        if (germanNeuron.check(record)) {
            vals.put("German", Math.abs(germanNeuron.distance(record)));
        }
        if (englishNeuron.check(record)){
            vals.put("English", Math.abs(englishNeuron.distance(record)));
        }

        // find min distance from Map
        Double min = Collections.min(vals.values());

        String result = "N/A";

        for (String key : vals.keySet()) {
            if (vals.get(key).equals(min)) {
                result = key;
            }
        }

        return result;
    }

    // import text to vectors
    private static ArrayList<Vector> textsToVectors() {
        ArrayList<Vector> result = new ArrayList<>();
        for (int i=1; i<=10; i++){

            Vector vc = new Vector("de", "languages/german/" + i);
            result.add(vc);

            Vector vc2 = new Vector("cz", "languages/czech/" + i);
            result.add(vc2);

            Vector vc3 = new Vector("en", "languages/english/" + i);
            result.add(vc3);
        }

        return result;
    }
}
