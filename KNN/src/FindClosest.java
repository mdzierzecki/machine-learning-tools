import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;

import java.util.*;

public class FindClosest {

    private int findCrossOver(ArrayList<Double> arr, int low, int high, double x) {
        // Base cases
        if (arr.get(high) <= x) // x is greater than all
            return high;
        if (arr.get(low) > x)  // x is smaller than all
            return low;

        // Find the middle point
        int mid = (low + high) / 2;  /* low + (high - low)/2 */

        /* If x is same as middle element, then return mid */
        if (arr.get(mid) <= x && arr.get(mid+1) > x)
            return mid;

        /* If x is greater than arr[mid], then either arr[mid + 1]
          is ceiling of x or ceiling lies in arr[mid+1...high] */
        if (arr.get(mid) < x)
            return findCrossOver(arr, mid + 1, high, x);

        return findCrossOver(arr, low, mid - 1, x);
    }

    // This function prints k closest elements to x in arr[].
    // n is the number of elements in arr[]
    private ArrayList<Double> giveKclosest(ArrayList<Double> unsortedArr, double x, int k, int n, ArrayList<Iris> trainIrisArray)
    {
        ArrayList<Double> arr = new ArrayList<>(unsortedArr);
        Collections.sort(arr);
        // Find the crossover point
        int l = findCrossOver(arr, 0, n-1, x);
        int r = l+1;   // Right index to search
        int count = 0; // To keep track of count of elements
        // already printed

        // If x is present in arr[], then reduce left index
        // Assumption: all elements in arr[] are distinct
        if (arr.get(l) == x) l--;

        ArrayList<Double> resultArray = new ArrayList<>();

        // Compare elements on left and right of crossover
        // point to find the k closest elements
        while (l >= 0 && r < n && count < k)
        {
            if (x - arr.get(l) < arr.get(r) - x)
                resultArray.add(arr.get(l--));
            else
                resultArray.add(arr.get(r++));
            count++;
        }


        // If there are no more elements on right side, then
        // print left elements

        while (count < k && l >= 0)
        {
            resultArray.add(arr.get(l--));
            count++;
        }


        // If there are no more elements on left side, then
        // print right elements
        while (count < k && r < n)
        {
            resultArray.add(arr.get(r++));
            count++;
        }
//        System.out.println(resultArray);
        return resultArray;
    }

    private double computeDistance(Iris irisModel, Iris irisTest){
        double base = Math.pow(irisModel.getSepalLength()-irisTest.getSepalLength(), 2)
                + Math.pow(irisModel.getSepalWidth()-irisTest.getSepalWidth(), 2)
                + Math.pow(irisModel.getPetalLength()-irisTest.getPetalLength(), 2)
                + Math.pow(irisModel.getPetalWidth()-irisTest.getPetalWidth(), 2);

        return Math.sqrt(base);
    }


    public String findResultIris(ArrayList<Iris> trainIrisArray, Iris examinedIris, int k){
        Map<Iris, Double> distanceMap = new HashMap<>();

        ArrayList<Double> distanceArray = new ArrayList<>();
        for (Iris iris: trainIrisArray) {
            double distanceResult = computeDistance(iris, examinedIris);
            distanceMap.put(iris, distanceResult);
            distanceArray.add(distanceResult);
        }
        double minValue = Collections.min(distanceArray);

        int minIndex = distanceArray.indexOf(Collections.min(distanceArray));

        if(k == 1) {
            return trainIrisArray.get(minIndex).result;
        } else if(k>1) {

            ArrayList<Double> closestKnumbersArray = giveKclosest(distanceArray, minValue, k, distanceArray.size(), trainIrisArray);
            ArrayList<Iris> fittedIrises = convertNumbersToIrises(trainIrisArray, distanceArray, closestKnumbersArray);

            String[] resultsArr = new String[fittedIrises.size()];

            int i = 0;
            for (Iris iris: fittedIrises) {
                resultsArr[i] = iris.getResult();
                i++;
            }

            
            return findWord(resultsArr);
        } else {
            throw new IllegalArgumentException("K must be a number from 1 to infinity");
        }
    }

    private ArrayList<Iris> convertNumbersToIrises(ArrayList<Iris> trainIrisArray, ArrayList<Double> distanceArray, ArrayList<Double> numbers) {

        ArrayList<Iris> results = new ArrayList<>();

        for (Double number: numbers) {

            results.add(trainIrisArray.get(distanceArray.indexOf(number)));
        }
        return results;
    }

    private String findWord(String[] arr)
    {

        // Create HashMap to store word and it's frequency
        HashMap<String, Integer> hs = new HashMap<String, Integer>();

        // Iterate through array of words
        for (int i = 0; i < arr.length; i++) {
            // If word already exist in HashMap then increase it's count by 1
            if (hs.containsKey(arr[i])) {
                hs.put(arr[i], hs.get(arr[i]) + 1);
            }
            // Otherwise add word to HashMap
            else {
                hs.put(arr[i], 1);
            }
        }

        // Create set to iterate over HashMap
        Set<Map.Entry<String, Integer> > set = hs.entrySet();
        String key = "";
        int value = 0;

        for (Map.Entry<String, Integer> me : set) {
            // Check for word having highest frequency
            if (me.getValue() > value) {
                value = me.getValue();
                key = me.getKey();
            }
        }

        // Return word having highest frequency
        return key;
    }

}