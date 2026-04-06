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
        return "Bogie{Capacity=" + capacity + "}";
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        // 1. Setup: Create a list with multiple bogies of the same types
        List<Bogie> consist = new ArrayList<>();
        consist.add(new Bogie("Sleeper", 72));
        consist.add(new Bogie("Sleeper", 72));
        consist.add(new Bogie("AC Chair Car", 56));
        consist.add(new Bogie("First Class", 24));
        consist.add(new Bogie("AC Chair Car", 56));

        System.out.println("Processing " + consist.size() + " bogies for categorization...\n");

        // 2. Stream Pipeline: Grouping by Bogie Name
        // Structure: Map<String, List<Bogie>>
        Map<String, List<Bogie>> groupedBogies = consist.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        // 3. Display the grouped results
        System.out.println("--- Consist Report (Grouped by Type) ---");
        groupedBogies.forEach((type, list) -> {
            System.out.println("Category: " + type + " | Count: " + list.size());
            list.forEach(b -> System.out.println("  - " + b));
        });

        // 4. Integrity Check
        System.out.println("\nOriginal list size remains: " + consist.size());
    }
}