import java.util.*;

/**
 * UC20: Prevent Search on Empty Train
 * Goal: Use IllegalStateException to handle invalid operational states.
 */
public class TrainConsistApp {

    public static void main(String[] args) {
        // Scenario 1: An empty train consist
        List<String> emptyConsist = new ArrayList<>();

        // Scenario 2: A populated train consist
        List<String> activeConsist = Arrays.asList("BG101", "BG205", "BG309");

        System.out.println("=== Railway Operational State Validator ===");

        // Attempting search on empty train
        try {
            System.out.println("\nCase 1: Searching empty consist...");
            safeSearch(emptyConsist, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("❌ Caught State Error: " + e.getMessage());
        }

        // Attempting search on active train
        try {
            System.out.println("\nCase 2: Searching active consist...");
            safeSearch(activeConsist, "BG309");
        } catch (IllegalStateException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    /**
     * Performs a search only if the train state is valid (not empty).
     * @throws IllegalStateException if the list is empty.
     */
    public static void safeSearch(List<String> bogies, String key) {
        // 1. State Validation (Defensive Programming)
        if (bogies == null || bogies.isEmpty()) {
            // 2. Throw IllegalStateException - the system is in the wrong state for this call
            throw new IllegalStateException("Search Failed: The train consist is currently empty. Please attach bogies before searching.");
        }

        // 3. If validation passes, proceed with search logic (Linear Search example)
        boolean found = bogies.contains(key);

        if (found) {
            System.out.println("✔ Success: Bogie " + key + " located in the consist.");
        } else {
            System.out.println("ℹ Info: Bogie " + key + " is not present in this consist.");
        }
    }
}