import java.util.LinkedList;

class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC4 ===");

        // 1. Initialize a LinkedList to represent the physical chain of bogies
        // LinkedList is ideal for frequently adding/removing at the ends
        LinkedList<String> trainConsist = new LinkedList<>();

        // 2. Add initial bogies using addLast (standard coupling)
        trainConsist.add("Sleeper");
        trainConsist.add("AC Coach");
        trainConsist.add("Cargo");

        // 3. Add Engine at the very front and Guard at the very end
        trainConsist.addFirst("Locomotive (Engine)");
        trainConsist.addLast("Guard Van");

        System.out.println("Initial Formation: " + trainConsist);

        // 4. Insert a Pantry Car at a specific position (Index 2)
        // This demonstrates the ability to break the chain and insert in the middle
        System.out.println("\nInserting Pantry Car at position 2...");
        trainConsist.add(2, "Pantry Car");

        System.out.println("After Insertion: " + trainConsist);

        // 5. Remove the first and last bogies (e.g., changing engines or removing guard)
        System.out.println("\nDetaching Engine and Guard Van for maintenance...");
        trainConsist.removeFirst();
        trainConsist.removeLast();

        // 6. Display the final ordered consist
        System.out.println("Final Ordered Consist: " + trainConsist);
        System.out.println("Current Train Length: " + trainConsist.size() + " units.");
    }
}