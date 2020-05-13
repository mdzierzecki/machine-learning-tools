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

    public Record(String purchaseCost, String maintenanceCost, String numberOfDoors, String peopleAmount, String trunkSize, String safetyLevel, String result) {
        this.purchaseCost = purchaseCost;
        this.maintenanceCost = maintenanceCost;
        this.numberOfDoors = numberOfDoors;
        this.peopleAmount = peopleAmount;
        this.trunkSize = trunkSize;
        this.safetyLevel = safetyLevel;
        this.result = result;
    }

    public String getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(String purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public String getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setMaintenanceCost(String maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    public String getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(String numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getPeopleAmount() {
        return peopleAmount;
    }

    public void setPeopleAmount(String peopleAmount) {
        this.peopleAmount = peopleAmount;
    }

    public String getTrunkSize() {
        return trunkSize;
    }

    public void setTrunkSize(String trunkSize) {
        this.trunkSize = trunkSize;
    }

    public String getSafetyLevel() {
        return safetyLevel;
    }

    public void setSafetyLevel(String safetyLevel) {
        this.safetyLevel = safetyLevel;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
