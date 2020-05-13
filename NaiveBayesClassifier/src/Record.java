public class Record {
    String purchaseCost;
    String maintenanceCost;
    String numberOfDoors;
    String peopleAmount;
    String trunkSize;
    String safetyLevel;
    String result;

    public Record (String fileLine) {
        String[] tokens = fileLine.split(",");

        this.purchaseCost = tokens[0];
        this.maintenanceCost = tokens[1];
        this.numberOfDoors = tokens[2];
        this.peopleAmount = tokens[3];
        this.trunkSize = tokens[4];
        this.safetyLevel = tokens[5];
        this.result = tokens[6];
    }

    @Override
    public String toString() {
        return "Record{" +
                "purchaseCost='" + purchaseCost + '\'' +
                ", maintenanceCost='" + maintenanceCost + '\'' +
                ", numberOfDoors='" + numberOfDoors + '\'' +
                ", peopleAmount='" + peopleAmount + '\'' +
                ", trunkSize='" + trunkSize + '\'' +
                ", safetyLevel='" + safetyLevel + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
