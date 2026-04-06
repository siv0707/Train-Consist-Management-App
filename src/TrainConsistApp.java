import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() { return name; }
    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return String.format("%-15s | Capacity: %d", name, capacity);
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        // 1. Setup: Create a list of bogies (Reuse logic from UC7)
        List<Bogie> consist = new ArrayList<>();
        consist.add(new Bogie("General", 90));
        consist.add(new Bogie("Sleeper", 72));
        consist.add(new Bogie("AC Chair Car", 56));
        consist.add(new Bogie("First Class", 24));

        System.out.println("Total Bogies in Consist: " + consist.size());

        // 2. Define the Capacity Threshold
        int threshold = 60;
        System.out.println("Filtering bogies with capacity > " + threshold + "...\n");

        // 3. Stream API Pipeline: stream() -> filter() -> collect()
        List<Bogie> highCapacityBogies = consist.stream()
                .filter(b -> b.getCapacity() > threshold) // Lambda condition
                .collect(Collectors.toList());            // Gather into new list

        // 4. Display the results
        if (highCapacityBogies.isEmpty()) {
            System.out.println("No bogies found matching the criteria.");
        } else {
            System.out.println("--- High Capacity Bogies (Filtered) ---");
            highCapacityBogies.forEach(System.out::println);
        }

        // 5. Verify Original Integrity (Requirement)
        System.out.println("\nOriginal list size: " + consist.size() + " (Unchanged)");
    }
}