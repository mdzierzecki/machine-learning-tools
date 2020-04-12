package neurons;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import program.Record;

public class Neuron {
    double[] weights;
    double alfa;
    double bias;
    double theta;
    List<Record> records;
    String irisType;

    public Neuron(List<Record> records, String irisType) {
        this.weights = new double[]{0, 0, 0, 0};
        this.alfa = 0.5;
        this.bias = 0;
        this.theta = -0.5;
        this.records = records;
        this.irisType = irisType;
    }

    public void train() {
        Collections.shuffle(this.records);

        for (Record record : records) {

            int d = (record.type.equals(irisType)) ? 1 : 0;

            double output = record.data[0] * weights[0] + record.data[1] * weights[1]
                    + record.data[2] * weights[2] + record.data[3] * weights[3];

            double[] inputs = Arrays.copyOf(record.data, record.data.length);

            int y = (output > theta) ? 1 : 0;

            if (d == y) {
                continue;
            }

            for (int j = 0; j < inputs.length; j++) {
                inputs[j] = (d - y) * alfa * inputs[j];
            }

            for (int j = 0; j < inputs.length; j++) {
                weights[j] = weights[j] + inputs[j];
            }

            theta = theta - (d - y) * alfa;
        }
    }

    public boolean check(Record record) {
        double output = record.data[0] * weights[0] + record.data[1] * weights[1]
                + record.data[2] * weights[2] + record.data[3] * weights[3];
        return output > theta;
    }

    @Override
    public String toString() {
        return "Neuron{" +
                "weights=" + Arrays.toString(weights) +
                ", alfa=" + alfa +
                ", bias=" + bias +
                ", theta=" + theta +
                ", records=" + records +
                ", irisType='" + irisType + '\'' +
                '}';
    }
}
