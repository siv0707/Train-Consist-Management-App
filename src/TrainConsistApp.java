import java.util.Arrays;

/**
 * UC16: Sort Passenger Bogies by Capacity (Bubble Sort)
 * Goal: Manually sort an array without using library methods like Arrays.sort().
 */
public class TrainConsistApp {

    public static void main(String[] args) {
        // 1. Initialize an unsorted array of passenger bogie capacities
        int[] capacities = {72, 56, 24, 70, 60, 56}; // Includes a duplicate (56)

        System.out.println("=== Railway Capacity Optimizer (Manual Sort) ===");
        System.out.println("Original Capacities: " + Arrays.toString(capacities));

        // 2. Perform Bubble Sort Algorithm
        bubbleSort(capacities);

        // 3. Display Result
        System.out.println("Sorted Capacities  : " + Arrays.toString(capacities));
        System.out.println("\nLogic Check: High-capacity bogies are now positioned at the end of the array.");
    }

    /**
     * Manual implementation of Bubble Sort
     * Time Complexity: O(n^2)
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Outer loop for multiple passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for adjacent comparisons
            // (n - 1 - i) because the largest elements "bubble" to the end each pass
            for (int j = 0; j < n - 1 - i; j++) {

                // Compare adjacent elements
                if (arr[j] > arr[j + 1]) {

                    // 4. Swapping Logic using a temporary variable
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // Optimization: If no two elements were swapped by inner loop, then break
            if (!swapped) break;
        }
    }
}