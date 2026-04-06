/**
 * UC18: Linear Search for Bogie ID
 * Goal: Manually traverse an array to find a specific String ID.
 */
public class TrainConsistApp {

    public static void main(String[] args) {
        // 1. Array of Bogie IDs (Unsorted)
        String[] bogieIDs = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Search Keys for testing
        String searchKey1 = "BG309"; // Exists in middle
        String searchKey2 = "BG999"; // Does not exist
        String searchKey3 = "BG101"; // Exists at start (First element)

        System.out.println("=== Railway Bogie Locator (Linear Search) ===");

        // 2. Perform Searches
        performSearch(bogieIDs, searchKey1);
        performSearch(bogieIDs, searchKey2);
        performSearch(bogieIDs, searchKey3);
    }

    /**
     * Logic for Linear Search
     * Time Complexity: O(n)
     */
    public static void performSearch(String[] arr, String key) {
        boolean found = false;
        int position = -1;

        System.out.println("\nSearching for Bogie ID: " + key + "...");

        // 3. Sequential Traversal
        for (int i = 0; i < arr.length; i++) {
            // 4. Equality Comparison (using .equals() for Strings)
            if (arr[i].equals(key)) {
                found = true;
                position = i;
                // 5. Early Termination: Stop searching once found
                break;
            }
        }

        // 6. Display Result
        if (found) {
            System.out.println("✔ Result: Bogie " + key + " found at position (Index) " + position + ".");
        } else {
            System.out.println("❌ Result: Bogie " + key + " not found in the consist.");
        }
    }
}