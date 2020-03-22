
import java.util.ArrayList;
import java.lang.Math;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        ArrayList<Iris> trainIrisArray = Iris.createIrisesCsv("dataset/iristrain.csv");

        Iris newIris = new Iris(4.6, 3.1, 1.5, 0.2);
        System.out.println(trainIrisArray.get(1));
        System.out.println(newIris);
        Map<Iris, Double> distanceMap = new HashMap<>();

        ArrayList<Double> distanceArray = new ArrayList<>();
        for (Iris iris: trainIrisArray) {
            double distanceResult = computeDistance(iris, newIris);
            distanceMap.put(iris, distanceResult);
            distanceArray.add(distanceResult);
        }

        System.out.println(distanceArray.get(0));

        int minIndex = distanceArray.indexOf(Collections.min(distanceArray));

        FindClosest fc = new FindClosest();
        System.out.println(distanceArray.get(minIndex));
        System.out.println(trainIrisArray.get(minIndex));
    }


    static double computeDistance(Iris irisModel, Iris irisTest){
        double base = Math.pow(irisModel.getSepalLength()-irisTest.getSepalLength(), 2)
                + Math.pow(irisModel.getSepalWidth()-irisTest.getSepalWidth(), 2)
                + Math.pow(irisModel.getPetalLength()-irisTest.getPetalLength(), 2)
                + Math.pow(irisModel.getPetalWidth()-irisTest.getPetalWidth(), 2);
        double result = Math.sqrt(base);
        return result;
    }

}
