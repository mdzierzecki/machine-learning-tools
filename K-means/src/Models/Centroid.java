package Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Centroid {
    private String name;
    private double[] cords;
    private List<Record> assignedRecords;

    // generate random Centroid
    public Centroid(String name, int cordsNum) {
        this.name = name;
        this.assignedRecords = new ArrayList<>();
        this.cords = new double[cordsNum];

        for (int i=0; i<cordsNum; i++) {
            this.cords[i] = new Random().nextDouble() * 10;
        }
    }

    public void averageCords(){
        if (countRecords() > 0) {
            double[] newCords = new double[cords.length];

            for (Record record: this.assignedRecords) {
                for (int i=0; i<cords.length; i++) {
                    newCords[i] += record.getData()[i];
                }
            }

            for (int i=0; i<cords.length; i++) {
                this.cords[i] = newCords[i]/assignedRecords.size();
            }

        } else {
            for (int i=0; i<cords.length; i++) {
                this.cords[i] = new Random().nextDouble() * 10;
            }
        }

    }

    public double avarageDistance(){
        double addedDistance = 0;
        for (Record record: this.assignedRecords) {
            addedDistance += record.getDistanceFromCentroid();
        }

        return addedDistance/this.assignedRecords.size();
    }

    public int countRecords(){
        return this.assignedRecords.size();
    }

    public void addRecord(Record record) {
        this.assignedRecords.add(record);
    }

    public void resetRecords(){
        this.assignedRecords = new ArrayList<>();
    }

    public double[] getCords() {
        return cords;
    }

    public void setCords(double[] cords) {
        this.cords = cords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Record> getAssignedRecords() {
        return assignedRecords;
    }

    public void setAssignedRecords(List<Record> assignedRecords) {
        this.assignedRecords = assignedRecords;
    }


        @Override
    public String toString() {
        return this.name + " | Number of records in cluster: " + this.countRecords() + "| average distance: " + this.avarageDistance() +  " | cords: " + Arrays.toString(cords);
    }
}
