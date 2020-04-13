package Program;
import models.Vector;

public class Main {
    public static void main(String[] args) {

        // test data
        Vector testCzech = new Vector("testdata/czech");
        Vector testGerman = new Vector("testdata/german");
        Vector testEnglish = new Vector("testdata/english");

        Compute c = new Compute();
        c.train();

        System.out.println(c.checkRecord(testGerman));
    }


}
