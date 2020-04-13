import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Vector vc = new Vector("cz", "languages/czech/1");
        System.out.println(vc.getText());
        System.out.println(vc.getNormalizedText());

        // {65=7, 66=3, 67=10, 68=2, 73=1, 74=7, 75=2, 77=6, 78=7, 79=2, 80=5, 83=7, 84=1, 85=1, 86=33, 87=10, 90=4, 97=366, 98=61, 99=159, 100=138, 101=485, 102=10, 103=6, 104=85, 105=306, 106=89, 107=141, 108=137, 109=162, 110=266, 111=329, 112=135, 114=144, 115=246, 116=241, 117=160, 118=157, 119=3, 121=108, 122=157}

        System.out.println(vc.getVector());


    }


}
