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

        for (int i=0; i<records.size(); i++) {

            int d = (records.get(i).type.equals(irisType)) ? 1 : 0;

            double output = records.get(i).data[0] * weights[0] + records.get(i).data[1] * weights[1]
                    + records.get(i).data[2] * weights[2] + records.get(i).data[3] * weights[3];

            double[] inputs =  Arrays.copyOf(records.get(i).data, records.get(i).data.length);

            int y = (output>theta) ? 1 : 0;

            if (d == y) {
                continue;
            }

//            theta = theta - (d-y) * alfa;

            if (d - y == -1 || d - y == 1) {
                for (int j=0; j<inputs.length; j++) {
                    inputs[j] = (d-y)*alfa*inputs[j];
                }

                for (int j=0; j<inputs.length; j++) {
                    weights[j] = weights[j]+inputs[j];
                }

//                bias = bias + (bias*alfa*(d-y));
            }

            theta = theta - (d - y) * alfa;

        }
    }

    public boolean check(Record record) {
        double output = record.data[0] * weights[0] + record.data[1] * weights[1]
                + record.data[2] * weights[2] + record.data[3] * weights[3];
        return output > 0;

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
