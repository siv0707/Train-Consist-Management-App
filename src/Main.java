import java.util.HashSet;
import java.util.Set;

class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC3 ===");

        // 1. Initialize a HashSet for unique Bogie IDs
        // HashSet uses hashing to ensure that every element is unique
        Set<String> bogieIds = new HashSet<>();

        // 2. Add Bogie IDs to the set
        System.out.println("Registering Bogie IDs...");
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");

        // 3. Attempt to add a duplicate ID (BG101)
        // In a List, this would add a second "BG101". In a Set, it is ignored.
        System.out.println("Attempting to add duplicate ID: BG101");
        boolean isAdded = bogieIds.add("BG101");

        if (!isAdded) {
            System.out.println("Warning: Duplicate ID 'BG101' rejected by the system!");
        }

        // 4. Print the final set
        // Note: The order in the output may differ from the order of insertion
        System.out.println("\nFinal Registered Bogie IDs: " + bogieIds);
        System.out.println("Total Unique Bogies: " + bogieIds.size());
    }
}