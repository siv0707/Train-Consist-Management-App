import java.util.*;

// 1. Define the Custom Exception
// We extend Exception to create a 'Checked Exception'
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// 2. Bogie class with Fail-Fast Validation
class Bogie {
    private String name;
    private int capacity;

    // The constructor 'throws' the exception if validation fails
    public Bogie(String name, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Invalid Capacity: [" + capacity +
                    "]. Capacity for " + name + " must be greater than zero.");
        }
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return String.format("%-15s | Seats: %d", name, capacity);
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        List<Bogie> consist = new ArrayList<>();

        System.out.println("=== Train Consist Creation with Validation ===\n");

        // Test Case 1: Valid Capacity
        try {
            System.out.println("Attempting to add Sleeper (72 seats)...");
            consist.add(new Bogie("Sleeper", 72));
            System.out.println("✔ Successfully added.");
        } catch (InvalidCapacityException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }

        // Test Case 2: Zero Capacity (Invalid)
        try {
            System.out.println("\nAttempting to add AC Chair (0 seats)...");
            consist.add(new Bogie("AC Chair", 0));
        } catch (InvalidCapacityException e) {
            System.out.println("❌ Caught Expected Exception: " + e.getMessage());
        }

        // Test Case 3: Negative Capacity (Invalid)
        try {
            System.out.println("\nAttempting to add First Class (-10 seats)...");
            consist.add(new Bogie("First Class", -10));
        } catch (InvalidCapacityException e) {
            System.out.println("❌ Caught Expected Exception: " + e.getMessage());
        }

        System.out.println("\n--- Final Valid Consist ---");
        consist.forEach(System.out::println);
        System.out.println("Total valid bogies: " + consist.size());
    }
}