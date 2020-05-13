import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        String csvFile = "data/train";

        List<Record> trainRecords = Files.lines(Paths.get(csvFile))
                .map(Record::new)
                .collect(Collectors.toList());

        int unacc_result_amount = 0;
        int acc_result_amount = 0;
        int good_result_amount = 0;
        int vgood_result_amount = 0;

        for (Record record: trainRecords) {
            if(record.getResult().equals("unacc")) unacc_result_amount++;
            if(record.getResult().equals("acc")) acc_result_amount++;
            if(record.getResult().equals("good")) good_result_amount++;
            if(record.getResult().equals("vgood")) vgood_result_amount++;
        }

        System.out.println(unacc_result_amount);
        System.out.println(acc_result_amount);
        System.out.println(good_result_amount);
        System.out.println(vgood_result_amount);

        Record testRecord = new Record("vhigh", "vhigh", "4", "4", "big", "high", "A");

        double[] res_unacc = new double[7];
        double[] res_acc = new double[7];
        double[] res_good = new double[7];
        double[] res_vgood = new double[7];

        for (Record record: trainRecords) {

            if(record.getPurchaseCost().equals(testRecord.getPurchaseCost()) && record.getResult().equals("unacc")) res_unacc[0]++;
            if(record.getMaintenanceCost().equals(testRecord.getMaintenanceCost()) && record.getResult().equals("unacc")) res_unacc[1]++;
            if(record.getNumberOfDoors().equals(testRecord.getNumberOfDoors()) && record.getResult().equals("unacc")) res_unacc[2]++;
            if(record.getPeopleAmount().equals(testRecord.getPeopleAmount()) && record.getResult().equals("unacc")) res_unacc[3]++;
            if(record.getTrunkSize().equals(testRecord.getTrunkSize()) && record.getResult().equals("unacc")) res_unacc[4]++;
            if(record.getSafetyLevel().equals(testRecord.getSafetyLevel()) && record.getResult().equals("unacc")) res_unacc[5]++;

            if(record.getPurchaseCost().equals(testRecord.getPurchaseCost()) && record.getResult().equals("acc")) res_acc[0]++;
            if(record.getMaintenanceCost().equals(testRecord.getMaintenanceCost()) && record.getResult().equals("acc")) res_acc[1]++;
            if(record.getNumberOfDoors().equals(testRecord.getNumberOfDoors()) && record.getResult().equals("acc")) res_acc[2]++;
            if(record.getPeopleAmount().equals(testRecord.getPeopleAmount()) && record.getResult().equals("acc")) res_acc[3]++;
            if(record.getTrunkSize().equals(testRecord.getTrunkSize()) && record.getResult().equals("acc")) res_acc[4]++;
            if(record.getSafetyLevel().equals(testRecord.getSafetyLevel()) && record.getResult().equals("acc")) res_acc[5]++;

            if(record.getPurchaseCost().equals(testRecord.getPurchaseCost()) && record.getResult().equals("good")) res_good[0]++;
            if(record.getMaintenanceCost().equals(testRecord.getMaintenanceCost()) && record.getResult().equals("good")) res_good[1]++;
            if(record.getNumberOfDoors().equals(testRecord.getNumberOfDoors()) && record.getResult().equals("good")) res_good[2]++;
            if(record.getPeopleAmount().equals(testRecord.getPeopleAmount()) && record.getResult().equals("good")) res_good[3]++;
            if(record.getTrunkSize().equals(testRecord.getTrunkSize()) && record.getResult().equals("good")) res_good[4]++;
            if(record.getSafetyLevel().equals(testRecord.getSafetyLevel()) && record.getResult().equals("good")) res_good[5]++;

            if(record.getPurchaseCost().equals(testRecord.getPurchaseCost()) && record.getResult().equals("vgood")) res_vgood[0]++;
            if(record.getMaintenanceCost().equals(testRecord.getMaintenanceCost()) && record.getResult().equals("vgood")) res_vgood[1]++;
            if(record.getNumberOfDoors().equals(testRecord.getNumberOfDoors()) && record.getResult().equals("vgood")) res_vgood[2]++;
            if(record.getPeopleAmount().equals(testRecord.getPeopleAmount()) && record.getResult().equals("vgood")) res_vgood[3]++;
            if(record.getTrunkSize().equals(testRecord.getTrunkSize()) && record.getResult().equals("vgood")) res_vgood[4]++;
            if(record.getSafetyLevel().equals(testRecord.getSafetyLevel()) && record.getResult().equals("vgood")) res_vgood[5]++;
        }

        double rezulcik_unacc = 1;

        for (int i=0; i<res_acc.length-1; i++) {
            rezulcik_unacc *= res_unacc[i]/unacc_result_amount;
        }

        rezulcik_unacc *= (double) unacc_result_amount/(unacc_result_amount+acc_result_amount+good_result_amount+vgood_result_amount);

        double rezulcik_acc = 1;

        for (int i=0; i<res_acc.length-1; i++) {
            rezulcik_acc *= res_acc[i]/acc_result_amount;
        }

        rezulcik_acc *= (double) acc_result_amount/(unacc_result_amount+acc_result_amount+good_result_amount+vgood_result_amount);

        double rezulcik_good= 1;

        for (int i=0; i<res_acc.length-1; i++) {
            rezulcik_good *= res_good[i]/good_result_amount;
        }

        rezulcik_good *= (double) good_result_amount/(unacc_result_amount+acc_result_amount+good_result_amount+vgood_result_amount);

        double rezulcik_vgood = 1;

        for (int i=0; i<res_acc.length-1; i++) {
            rezulcik_vgood *= res_vgood[i]/vgood_result_amount;
        }

        rezulcik_vgood *= (double) vgood_result_amount/(unacc_result_amount+acc_result_amount+good_result_amount+vgood_result_amount);



        System.out.println("Result unacc " + rezulcik_unacc);
        System.out.println("Result acc " + rezulcik_acc);
        System.out.println("Result good " + rezulcik_good);
        System.out.println("Result good " + rezulcik_vgood);

        System.out.println(rezulcik_unacc>rezulcik_acc);

    }
}
