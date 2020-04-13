package models;

import java.util.Collections;
import java.util.List;

public class Neuron {
    double[] weights;
    double alpha;
    double bias;
    double theta;
    List<Vector> records;
    String language;

    public Neuron(List<Vector> records, String language) {
        this.weights = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        this.alpha = 0.5;
        this.bias = 0;
        this.theta = -0.5;
        this.records = records;
        this.language = language;
    }


    public void train() {
        Collections.shuffle(this.records);

        for (Vector record : records) {

            int d = (record.getLanguage().equals(this.language)) ? 1 : 0;

            double output = 0;
            for (int i=0; i<26; i++) {
                output += record.getVector().get(0) * weights[i];
            }

            int y = (output > theta) ? 1 : 0;

            if (d == y) {
                continue;
            }

            double[] inputs = new double[record.getVector().size()];
            for (int j=0; j<record.getVector().size(); j++) {
                inputs[j] = record.getVector().get(j);
            }

            for (int j = 0; j < inputs.length; j++) {
                inputs[j] = (d - y) * alpha * inputs[j];
            }

            for (int j = 0; j < inputs.length; j++) {
                weights[j] = weights[j] + inputs[j];
            }

            theta = theta - (d - y) * alpha;
        }
    }

    public boolean check(Vector record) {
        double output = 0;
        for (int i=0; i<26; i++) {
            output += record.getVector().get(i) * this.weights[i];
        }
        return output > theta;
    }

    public double distance(Vector record) {
        double output = 0;
        for (int i=0; i<26; i++) {
            output += record.getVector().get(i) * this.weights[i];
        }
        return output + theta;
    }

}
