import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Vector> result = textsToVectors();

        Neuron germanNeuron = new Neuron(result, "de");
        germanNeuron.train();

        // test

        Vector testV = new Vector("testdata/czech");

        System.out.println(germanNeuron.check(testV));

    }


    private static ArrayList<Vector> textsToVectors() {
        ArrayList<Vector> result = new ArrayList<>();
        for (int i=1; i<=10; i++){

            Vector vc = new Vector("de", "languages/german/" + i);
            result.add(vc);

            Vector vc2 = new Vector("cz", "languages/czech/" + i);
            result.add(vc2);

            Vector vc3 = new Vector("en", "languages/english/" + i);
            result.add(vc3);
        }

        return result;
    }



}
