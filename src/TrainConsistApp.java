import java.util.Arrays;

/**
 * UC18: Binary Search for Bogie ID
 * PRECONDITION: The array MUST be sorted for Binary Search to work.
 */
public class TrainConsistApp {

    public static void main(String[] args) {
        // 1. Sorted Array of Bogie IDs (Requirement for Binary Search)
        String[] bogieIDs = {"BG101", "BG205", "BG309", "BG412", "BG550", "BG600", "BG710"};

        // Search Keys for testing
        String target1 = "BG550"; // Exists in upper half
        String target2 = "BG101"; // Exists at the very start
        String target3 = "BG999"; // Does not exist

        System.out.println("=== Railway High-Speed Locator (Binary Search) ===");
        System.out.println("Sorted Database: " + Arrays.toString(bogieIDs));

        // 2. Perform Binary Searches
        performBinarySearch(bogieIDs, target1);
        performBinarySearch(bogieIDs, target2);
        performBinarySearch(bogieIDs, target3);
    }

    /**
     * Manual implementation of Binary Search logic
     * Time Complexity: O(log n)
     */
    public static void performBinarySearch(String[] arr, String key) {
        int low = 0;
        int high = arr.length - 1;
        int position = -1;
        boolean found = false;

        System.out.println("\nLocating Bogie ID: " + key + "...");

        // 3. Divide and Conquer Loop
        while (low <= high) {
            // 4. Compute Middle Index
            int mid = low + (high - low) / 2;

            // 5. Compare key with middle element using compareTo()
            // compareTo returns: 0 if equal, <0 if key is smaller, >0 if key is larger
            int comparison = key.compareTo(arr[mid]);

            if (comparison == 0) {
                found = true;
                position = mid;
                break; // Target found, exit loop
            }
            else if (comparison < 0) {
                // Key is in the left half, adjust high pointer
                high = mid - 1;
            }
            else {
                // Key is in the right half, adjust low pointer
                low = mid + 1;
            }
        }

        // 6. Display Result
        if (found) {
            System.out.println("✔ Result: Bogie " + key + " identified at index " + position + ".");
        } else {
            System.out.println("❌ Result: Bogie " + key + " not found in the sorted consist.");
        }
    }
}