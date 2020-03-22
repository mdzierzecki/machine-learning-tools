import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Iris> trainIrisArray = Iris.createIrisesCsv("dataset/iristrain.csv");
        ArrayList<Iris> testIrisArray = Iris.createIrisesCsv("dataset/iristest.csv");

        FindClosest fc = new FindClosest();

        for (Iris testIris: testIrisArray) {
            System.out.println(testIris.getNumber() +  " | " + fc.findResultIris(trainIrisArray, testIris, 5));;
        }


    }


}
