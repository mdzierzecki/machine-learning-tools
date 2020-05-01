package Models;

import Models.Centroid;
import Program.Utils;

import java.util.*;

public class Record {
    private int id;
    public double[] data = new double[4];
    private Centroid c;
    private double distanceFromCentroid;
    private String type;

    public Record (String fileLine) {
        String[] tokens = fileLine.split(",");

        id = Integer.parseInt(tokens[0].replaceAll("\"", ""));

        for (int i=0; i<4; i++){
            data[i] = Double.parseDouble(tokens[i + 1]);
        }
    }

    public void assignToCentroid(List<Centroid> centroidList){
        Map<Centroid, Double> distanceMap = new HashMap<>();

        for (Centroid centroid: centroidList) {
            distanceMap.put(centroid, Utils.calculateDistance(this, centroid));
        }

        Double min = Collections.min(distanceMap.values());

        for (Centroid key : distanceMap.keySet()) {
            if (distanceMap.get(key).equals(min)) {
                this.c = key;
                this.distanceFromCentroid = distanceMap.get(key);
                key.addRecord(this);
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double[] getData() {
        return data;
    }

    public void setData(double[] data) {
        this.data = data;
    }

    public Centroid getC() {
        return c;
    }

    public void setC(Centroid c) {
        this.c = c;
    }

    public double getDistanceFromCentroid() {
        return distanceFromCentroid;
    }

    public void setDistanceFromCentroid(double distanceFromCentroid) {
        this.distanceFromCentroid = distanceFromCentroid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Models.Record nr. " + this.id + ", centroid is [" + this.c + "] with distance: " + this.distanceFromCentroid;
    }
}
