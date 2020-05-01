package Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Centroid {
    private String name;
    private double[] cords = new double[4];
    private List<Record> assignedRecords;

    public Centroid(String name, double[] cords) {
        this.name = name;
        this.cords = cords;
        this.assignedRecords = new ArrayList<>();
    }

    // generate random Models.Centroid
    public Centroid(String name) {
        this.name = name;
        this.assignedRecords = new ArrayList<>();
        this.cords[0] = new Random().nextDouble() * 10;
        this.cords[1] = new Random().nextDouble() * 10;
        this.cords[2] = new Random().nextDouble() * 10;
        this.cords[3] = new Random().nextDouble() * 10;
    }

    public void addRecord(Record record) {
        this.assignedRecords.add(record);
    }

    public double[] getCords() {
        return cords;
    }

    public void setCords(double[] cords) {
        this.cords = cords;
    }

    public List<Record> getAssignedRecords() {
        return assignedRecords;
    }

    public void setAssignedRecords(List<Record> assignedRecords) {
        this.assignedRecords = assignedRecords;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
