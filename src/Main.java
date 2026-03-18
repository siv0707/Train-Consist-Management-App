import java.util.ArrayList;
import java.util.List;

class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC2 ===");

        // 1. Initialize an ArrayList for passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // 2. Add Bogies (Sleeper, AC Chair, First Class)
        // add() appends elements to the end of the list, preserving insertion order
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("After adding bogies: " + passengerBogies);

        // 3. Remove a bogie (AC Chair)
        // remove() searches for the object and deletes the first occurrence
        System.out.println("\nRemoving 'AC Chair' for maintenance...");
        passengerBogies.remove("AC Chair");

        // 4. Check existence (Sleeper)
        // contains() returns a boolean (true/false)
        boolean hasSleeper = passengerBogies.contains("Sleeper");
        System.out.println("Does the train have a Sleeper bogie? " + hasSleeper);

        // 5. Print final list state and size
        System.out.println("\nFinal Consist State: " + passengerBogies);
        System.out.println("Total Bogies in Consist: " + passengerBogies.size());
    }
}