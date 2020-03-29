import java.util.Arrays;

public class Record {
    int id;
    double[] data = new double[4];
    String type;

    Record (String fileLine) {
        String[] tokens = fileLine.split(",");

        id = Integer.parseInt(tokens[0].replaceAll("\"", ""));

        for (int i=0; i<4; i++){
            data[i] = Double.parseDouble(tokens[i + 1]);
        }

        type = tokens[5].replaceAll("\"", "");
    }

    Record (int id, double a, double b, double c, double d, String type) {
        this.id = id;
        data[0] = a;
        data[1] = b;
        data[2] = c;
        data[3] = d;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", data=" + Arrays.toString(data) +
                ", type='" + type + '\'' +
                '}';
    }
}
