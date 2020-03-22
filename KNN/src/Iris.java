import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Iris {
    double sepalLength;
    double sepalWidth;
    double petalLength;
    double petalWidth;
    String result;

    public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth, String result) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.result = result;
    }

    public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
    }

    public static ArrayList<Iris> createIrisesCsv(String csvFile){
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        ArrayList<Iris> irisArray = new ArrayList<Iris>();

        try {
            int i=0;
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                if(i != 0) {
                    // use comma as separator
                    String[] element = line.split(cvsSplitBy);

                    Iris newIris = new Iris(Double.parseDouble(element[1]), Double.parseDouble(element[2]),
                            Double.parseDouble(element[3]), Double.parseDouble(element[4]), element[5]);

                    irisArray.add(newIris);
                }

                i++;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return irisArray;
    }


    @Override
    public String toString() {
        return "Iris{" +
                "sepalLength=" + sepalLength +
                ", sepalWidth=" + sepalWidth +
                ", petalLength=" + petalLength +
                ", petalWidth=" + petalWidth +
                ", result='" + result + '\'' +
                '}';
    }

    public double getSepalLength() {
        return sepalLength;
    }

    public double getSepalWidth() {
        return sepalWidth;
    }

    public double getPetalLength() {
        return petalLength;
    }

    public double getPetalWidth() {
        return petalWidth;
    }

    public String getResult() {
        return result;
    }
}
