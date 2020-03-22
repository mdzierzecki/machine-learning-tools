import java.util.ArrayList;

public class FindClosest {

    public int findCrossOver(ArrayList<Double> arr, int low, int high, int x) {
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

    public ArrayList<Integer> giveKclosest(ArrayList<Double> arr, int x, int k, int n) {
        // Find the crossover point
        int l = findCrossOver(arr, 0, n - 1, x);
        int r = l + 1;   // Right index to search
        int count = 0; // To keep track of count of elements
        // already printed

        // If x is present in arr[], then reduce left index
        // Assumption: all elements in arr[] are distinct
        if (arr.get(l) == x) l--;

        ArrayList<Integer> resultArray = new ArrayList<>();
        // Compare elements on left and right of crossover
        // point to find the k closest elements
        while (l >= 0 && r < n && count < k) {
            if (x - arr.get(l) < arr.get(r) - x)
                resultArray.add(arr.indexOf(l--));
            else
                resultArray.add(arr.indexOf(r++));
            count++;
        }

        // If there are no more elements on right side, then
        // print left elements
        while (count < k && l >= 0) {
            resultArray.add(arr.indexOf(l--));
            count++;
        }


        // If there are no more elements on left side, then
        // print right elements
        while (count < k && r < n) {
            resultArray.add(arr.indexOf(r++));
            count++;
        }

        return resultArray;
    }
}