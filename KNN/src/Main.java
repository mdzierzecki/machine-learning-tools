
import java.util.ArrayList;
import java.lang.Math;


public class Main {
    public static void main(String[] args) {

        ArrayList<Iris> trainIrisArray = Iris.createIrisesCsv("dataset/iristrain.csv");

        Iris newIris = new Iris(4.6, 3.1, 1.5, 0.2);
        System.out.println(trainIrisArray.get(1));
        System.out.println(newIris);
        double result = computeDistance(trainIrisArray.get(1), newIris) ;
        System.out.println(result);

        FindClosest fc = new FindClosest();

        int arr[] = {12, 16, 22, 30, 35, 39, 42,
                45, 48, 50, 53, 55, 56
        };
        int n = arr.length;
        int x = 35, k = 4;

        ArrayList<Integer> resultList = fc.giveKclosest(arr, x, 4, n);

        System.out.println(resultList);

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
