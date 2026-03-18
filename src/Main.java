import java.util.LinkedHashSet;
import java.util.Set;

class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC5 ===");

        // 1. Initialize a LinkedHashSet
        // This combines a HashTable (for uniqueness) and a LinkedList (for order)
        Set<String> trainFormation = new LinkedHashSet<>();

        // 2. Attach bogies in a specific physical sequence
        System.out.println("Attaching bogies to the engine...");
        trainFormation.add("Engine (Locomotive)");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard Coach");

        // 3. Attempt to attach a duplicate bogie (Business Rule Violation)
        // In UC4 (LinkedList), this would have added a second Sleeper.
        // Here, it will be automatically rejected.
        System.out.println("\nError Check: Attempting to attach duplicate 'Sleeper'...");
        boolean isAdded = trainFormation.add("Sleeper");

        if (!isAdded) {
            System.out.println("System Alert: Duplicate bogie detected. Attachment rejected.");
        }

        // 4. Display the formation
        // Notice how the order is preserved exactly as they were added
        System.out.println("\nFinal Train Formation (Maintained Order):");
        System.out.println(trainFormation);

        // 5. Demonstrate iteration (Ordered traversal)
        System.out.println("\nScanning Train Consist:");
        for (String bogie : trainFormation) {
            System.out.println("Checking: " + bogie);
        }
    }
}