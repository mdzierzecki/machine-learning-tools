import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Neuron {
    double[] weights;
    double alfa;
    List<Record> records;
    String irisType;

    public Neuron(List<Record> records, String irisType) {
        this.weights = new double[]{20, 5, 2, 9};
        this.alfa = 0.5;
        this.records = records;
        this.irisType = irisType;
    }

    public void train() {
        Collections.shuffle(records);

        for (int i=0; i<records.size(); i++) {

            int d = (records.get(i).type.equals(irisType)) ? 1 : 0;

            double output = records.get(i).data[0] * weights[0] + records.get(i).data[1] * weights[1]
                    + records.get(i).data[2] * weights[2] + records.get(i).data[3] * weights[3];

            double[] inputs =  Arrays.copyOf(records.get(i).data, records.get(i).data.length);

            int y = (output>0) ? 1: 0;

            if (d - y == -1 || d - y == 1) {
                for (int j=0; j<inputs.length; j++) {
                    inputs[j] = alfa*(d-y)*inputs[j];
                }

                for (int j=0; j<inputs.length; j++) {
                    weights[j] = weights[j]+inputs[j];
                }
            }

        }
    }

    public boolean check(Record record) {
        double output = record.data[0] * weights[0] + record.data[1] * weights[1]
                + record.data[2] * weights[2] + record.data[3] * weights[3];
        if (output>0) {
            return true;
        } else {
            return false;
        }
    }


}
