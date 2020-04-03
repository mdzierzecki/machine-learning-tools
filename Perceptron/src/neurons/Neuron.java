package neurons;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import program.Record;

public class Neuron {
    double[] weights;
    double alfa;
    double bias;
    List<Record> records;
    String irisType;

    public Neuron(List<Record> records, String irisType) {
        this.weights = new double[]{20, 5, 2, 9};
        this.alfa = 0.5;
        this.bias = 0;
        this.records = records;
        this.irisType = irisType;
    }

    public void train() {
        Collections.shuffle(this.records);

        for (Record record : records) {

            int d = (record.type.equals(irisType)) ? 1 : 0;

            double output = record.data[0] * weights[0] + record.data[1] * weights[1]
                    + record.data[2] * weights[2] + record.data[3] * weights[3] - bias;

            double[] inputs = Arrays.copyOf(record.data, record.data.length);

            int y = (output > 0) ? 1 : 0;

            // theta
            if (d - y == -1 || d - y == 1) {
                for (int j = 0; j < inputs.length; j++) {
                    inputs[j] = alfa * (d - y) * inputs[j];
                }

                for (int j = 0; j < inputs.length; j++) {
                    weights[j] = weights[j] + inputs[j];
                }
            }

            bias = bias - (d - y) * alfa;

        }
    }

    public boolean check(Record record) {
        double output = record.data[0] * weights[0] + record.data[1] * weights[1]
                + record.data[2] * weights[2] + record.data[3] * weights[3];
        return output > 0;

    }


}
