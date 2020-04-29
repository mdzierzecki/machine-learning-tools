import java.util.Arrays;

public class Record {
    private int id;
    public double[] data = new double[4];
    private String type;

    public Record (String fileLine) {
        String[] tokens = fileLine.split(",");

        id = Integer.parseInt(tokens[0].replaceAll("\"", ""));

        for (int i=0; i<4; i++){
            data[i] = Double.parseDouble(tokens[i + 1]);
        }
    }

    public double calculateDistance(Record rec, Centroid centroid) {
        return 1.0;
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
