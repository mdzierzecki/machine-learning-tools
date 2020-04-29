import java.util.Arrays;
import java.util.Random;

public class Centroid {
    private double[] cords = new double[4];

    public Centroid(double[] cords) {
        this.cords = cords;
    }

    // generate random Centroid
    public Centroid() {
        this.cords[0] = new Random().nextDouble() * 10;
        this.cords[1] = new Random().nextDouble() * 10;
        this.cords[2] = new Random().nextDouble() * 10;
        this.cords[3] = new Random().nextDouble() * 10;
    }

    @Override
    public String toString() {
        return "Centroid{" +
                "cords=" + Arrays.toString(cords) +
                '}';
    }
}
