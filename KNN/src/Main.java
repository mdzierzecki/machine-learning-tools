import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Iris> trainIrisArray = Iris.createIrisesCsv("dataset/iristrain.csv");
        ArrayList<Iris> testIrisArray = Iris.createIrisesCsv("dataset/iristest.csv");

        FindClosest fc = new FindClosest();

        for (Iris testIris: testIrisArray) {
            System.out.println(testIris.getNumber() +  " | " + fc.findResultIris(trainIrisArray, testIris, 1));;
        }

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Do you want to check your own flower? yes / no");

        String answer = myObj.nextLine();  // Read user input
        if(answer.equals("yes")) {
            System.out.println("Provide sepal length: ");
            Double sepalLength = myObj.nextDouble();
            System.out.println("Provide sepal width: ");
            Double sepalWidth = myObj.nextDouble();
            System.out.println("Provide petal width: ");
            Double petalLength = myObj.nextDouble();
            System.out.println("Provide petal width: ");
            Double petalWidth = myObj.nextDouble();
            System.out.println("Provide k for KNN: ");
            Integer k = myObj.nextInt();

            Iris testingIris = new Iris(sepalLength, sepalWidth, petalLength, petalWidth);
            System.out.println("Result is: " + fc.findResultIris(trainIrisArray, testingIris, 5));
        } else {
            System.out.println("Exiting...");  // Output user input
            System.exit(0);
        }


    }




}
