import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        String csvFile = "data/train";

        List<Record> trainRecords = Files.lines(Paths.get(csvFile))
                .map(Record::new)
                .collect(Collectors.toList());

        boolean ifContinue;

        do {
            System.out.println("Enter a information for a record");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter purchase cost");
            String purchaseCost = scanner.nextLine();
            System.out.println("Enter maintenance cost");
            String maintenanceCost = scanner.nextLine();
            System.out.println("Enter number of doors");
            String numberOfDoors = scanner.nextLine();
            System.out.println("Enter amount of people");
            String peopleAmount = scanner.nextLine();
            System.out.println("Enter trunk size");
            String trunkSize = scanner.nextLine();
            System.out.println("Enter safety level");
            String safetyLevel = scanner.nextLine();
            System.out.println("Should I smooth all parameters? (true/false) ");
            boolean ifSmoothing = scanner.nextBoolean();
            System.out.println("Thank you. Result of your record is: ");

            Record testRecord = new Record(purchaseCost, maintenanceCost, numberOfDoors, peopleAmount, trunkSize, safetyLevel, "N/A");

            System.out.println(calculateResult(testRecord, trainRecords, ifSmoothing));

            System.out.println("Do you want to input another record? (true/false)");
            ifContinue = scanner.nextBoolean();
            scanner.close();
        }
        while (ifContinue);

        System.out.println("Goodbye!");

    }

    public static String calculateResult(Record testRecord, List<Record> trainRecords, boolean ifSmoothing){
        int unacc_result_amount = 0;
        int acc_result_amount = 0;
        int good_result_amount = 0;
        int vgood_result_amount = 0;


        for (Record record : trainRecords) {
            if (record.getResult().equals("unacc")) unacc_result_amount++;
            if (record.getResult().equals("acc")) acc_result_amount++;
            if (record.getResult().equals("good")) good_result_amount++;
            if (record.getResult().equals("vgood")) vgood_result_amount++;
        }

        int all_results = unacc_result_amount + acc_result_amount + good_result_amount + vgood_result_amount;

//        System.out.println(unacc_result_amount);
//        System.out.println(acc_result_amount);
//        System.out.println(good_result_amount);
//        System.out.println(vgood_result_amount);

        double[] res_unacc = new double[6];
        double[] res_acc = new double[6];
        double[] res_good = new double[6];
        double[] res_vgood = new double[6];

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

        Map<String, Double> counterMap = new HashMap<>();
        counterMap.put("unacc", 1.0);
        counterMap.put("acc", 1.0);
        counterMap.put("good", 1.0);
        counterMap.put("vgood", 1.0);


        for (int i=0; i<=res_unacc.length; i++) {
            if(i != res_unacc.length) {
                double current_value = counterMap.get("unacc");
                counterMap.replace("unacc", current_value *= res_unacc[i]/unacc_result_amount);
            } else {
                double current_value = counterMap.get("unacc");
                counterMap.replace("unacc", current_value *= (double) unacc_result_amount /all_results);
            }
        }

        for (int i=0; i<=res_acc.length; i++) {
            if(i != res_acc.length) {
                double current_value = counterMap.get("acc");
                counterMap.replace("acc", current_value *= res_acc[i]/acc_result_amount);
            } else {
                double current_value = counterMap.get("acc");
                counterMap.replace("acc", current_value *= (double) acc_result_amount /all_results);
            }
        }


        for (int i=0; i<=res_good.length; i++) {
            if(i != res_good.length) {
                double current_value = counterMap.get("good");
                counterMap.replace("good", current_value *= res_good[i]/good_result_amount);
            } else {
                double current_value = counterMap.get("good");
                counterMap.replace("good", current_value *= (double) good_result_amount /all_results);
            }
        }

        for (int i=0; i<=res_vgood.length; i++) {
            if(i != res_vgood.length) {
                double current_value = counterMap.get("vgood");
                counterMap.replace("vgood", current_value *= res_vgood[i]/vgood_result_amount);
            } else {
                double current_value = counterMap.get("vgood");
                counterMap.replace("vgood", current_value *= (double) vgood_result_amount /all_results);
            }
        }

//        System.out.println(counterMap);

        Double max = Collections.max(counterMap.values());
        System.out.println("Max: " + max);
        String biggestProbability = "";
        for (String key : counterMap.keySet()) {
            if (counterMap.get(key).equals(max)) {
                biggestProbability = key;
            }
        }


        double sum = counterMap.values().stream().reduce(0.0, Double::sum);

        System.out.println("Sum: " + sum);

        System.out.println("Probablity: " + max/sum + "%");
//
//        System.out.println("Probablity unacc: " + counterMap.get("unacc")/sum);
//        System.out.println("Probablity acc: " + counterMap.get("acc")/sum);
//        System.out.println("Probablity good: " + counterMap.get("good")/sum);
//        System.out.println("Probablity vgood: " + counterMap.get("vgood")/sum);

        return biggestProbability;
    }

}


