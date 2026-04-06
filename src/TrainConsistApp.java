import java.util.*;

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
        return String.format("%-15s (Seats: %d)", name, capacity);
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        // 1. Setup: Create a list of passenger bogies
        List<Bogie> consist = new ArrayList<>();
        consist.add(new Bogie("Sleeper", 72));
        consist.add(new Bogie("Sleeper", 72));
        consist.add(new Bogie("AC Chair Car", 56));
        consist.add(new Bogie("First Class", 24));
        consist.add(new Bogie("General", 90));

        System.out.println("--- Current Train Composition ---");
        consist.forEach(System.out::println);

        // 2. Stream Pipeline: Map to capacities and Reduce to a total
        // .map(Bogie::getCapacity) transforms Stream<Bogie> to Stream<Integer>
        // .reduce(0, Integer::sum) starts at 0 and adds every element
        int totalSeats = consist.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        // 3. Display the result
        System.out.println("\n-------------------------------------------");
        System.out.println("TOTAL TRAIN SEATING CAPACITY: " + totalSeats);
        System.out.println("-------------------------------------------");

        // 4. Verify Original Integrity (Requirement)
        System.out.println("Verification: Original bogie count remains " + consist.size());
    }
}