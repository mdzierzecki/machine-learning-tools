package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Vector {
    String language;
    String text;
    String normalizedText;
    String path;
    ArrayList<Integer> vector;
    boolean textOnly;

    public Vector(String language, String path) {
        this.language = language;
        this.path = path;
        this.vector = new ArrayList<>();
        readText();
        normalizeText();
        countChars();
    }

    public Vector(String text, boolean textOnly) {
        this.vector = new ArrayList<>();
        this.text = text;
        this.textOnly = true;
        normalizeText();
        countChars();
    }

    public Vector(String path) {
        this.language = null;
        this.path = path;
        this.vector = new ArrayList<>();
        readText();
        normalizeText();
        countChars();
    }


    private void readText(){
        StringBuilder stringBuilder = new StringBuilder();

        File myObj = new File(this.path);
        try {
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                stringBuilder.append(data);
            }
            myReader.close();
            this.text = stringBuilder.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void normalizeText(){
        String normalized = Normalizer.normalize(this.text, Normalizer.Form.NFD);
        String accentRemoved = normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        String lowerCaseText = accentRemoved.toLowerCase();
        this.normalizedText = lowerCaseText.replaceAll("[^A-Za-z]+", "");
    }

    private void countChars() {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i=97; i<=122; i++) {
            hm.put(i, 0);
        }

        this.normalizedText.chars().forEach(letter -> hm.put(letter, (hm.containsKey(letter) ? hm.get(letter) : 0) + 1));

        hm.forEach((c, i) -> this.vector.add(i));
    }

    public String getLanguage() {
        return language;
    }

    public String getText() {
        return text;
    }

    public String getPath() {
        return path;
    }

    public String getNormalizedText() {
        return normalizedText;
    }

    public ArrayList<Integer> getVector() {
        return vector;
    }
}
