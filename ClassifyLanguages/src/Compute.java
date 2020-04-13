import java.util.ArrayList;

public class Compute {

    public Neuron germanNeuron;
    public Neuron czechNeuron;
    public Neuron englishNeuron;
    ArrayList<Vector> result;

    public Compute() {
        // create an array with vectors
        this.result = textsToVectors();

        // create neurons for every language
        this.germanNeuron = new Neuron(result, "de");
        this.czechNeuron = new Neuron(result, "cz");
        this.englishNeuron = new Neuron(result, "en");
    }

    // train neurons
    public void train(){
        for(int i=0; i<10000; i++) {
            germanNeuron.train();
            czechNeuron.train();
            englishNeuron.train();
        }
    }

    public String checkRecord(Vector record) {
        int czech = 0;
        int german = 0;
        int english = 0;

        for (int i=0; i<10; i++) {
            if (czechNeuron.check(record)) { czech++; }
            else if (germanNeuron.check(record)) { german++; }
            else if (englishNeuron.check(record)){ english++; }
        }

        if(czech > german && czech > english) {
            return "Czech";
        } else if (german > english && german > czech) {
            return "German";
        } else {
            return "English";
        }
    }

    // import text to vectors
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
