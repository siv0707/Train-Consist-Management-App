import java.util.Arrays;

/**
 * UC17: Sort Bogie Names Using Arrays.sort()
 * Goal: Use Java's optimized library methods for alphabetical sorting.
 */
public class TrainConsistApp {

    public static void main(String[] args) {
        // 1. Initialize an array of bogie type names
        String[] bogieNames = {
                "Sleeper",
                "AC Chair",
                "First Class",
                "General",
                "Luxury",
                "Sleeper" // Included duplicate for testing
        };

        System.out.println("=== Railway Inventory Manager (Standard Sort) ===");
        System.out.println("Original Inventory: " + Arrays.toString(bogieNames));

        // 2. Use the built-in Arrays.sort() method
        // This uses 'Natural Ordering' (Alphabetical for Strings)
        Arrays.sort(bogieNames);

        // 3. Display the sorted result using Arrays.toString()
        System.out.println("Sorted Inventory  : " + Arrays.toString(bogieNames));

        // 4. Verification logic for reporting
        System.out.println("\nReport Summary: " + bogieNames.length + " bogies categorized alphabetically.");
    }
}