import java.util.*;

// Bogie class representing the data structure
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return String.format("%-15s | Capacity: %d", name, capacity);
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        // 1. Create a List to store passenger bogies
        List<Bogie> consist = new ArrayList<>();

        // 2. Add bogies with different capacities
        consist.add(new Bogie("Sleeper", 72));
        consist.add(new Bogie("AC Chair Car", 56));
        consist.add(new Bogie("First Class", 24));
        consist.add(new Bogie("General", 90));

        System.out.println("--- Original Consist (Unordered) ---");
        consist.forEach(System.out::println);

        // 3. Apply Comparator to sort by capacity (Descending - High to Low)
        // We use Comparator.comparingInt for performance and clarity
        consist.sort(Comparator.comparingInt(Bogie::getCapacity).reversed());

        System.out.println("\n--- Sorted Consist (Highest Capacity First) ---");
        // 4. Display sorted bogies
        for (Bogie b : consist) {
            System.out.println(b);
        }

        System.out.println("\nPlanning Analysis: High-capacity bogies identified for optimal usage.");
    }
}