import java.util.HashMap;
import java.util.Map;

class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC6 ===");

        // 1. Initialize a HashMap to store Bogie-to-Capacity mapping
        // Key: Bogie Name (String), Value: Capacity (Integer)
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // 2. Use put() to associate bogies with their seating/load capacities
        // This acts as a digital manifest for the train
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair Car", 56);
        bogieCapacityMap.put("First Class", 24);
        bogieCapacityMap.put("Cargo (Rectangular)", 5000); // 5000kg capacity
        bogieCapacityMap.put("Cylindrical Tanker", 3000);  // 3000L capacity

        System.out.println("Bogie capacities have been registered in the system.\n");

        // 3. Iterate through the map using entrySet()
        // entrySet() allows us to access both the Key and Value in a single loop
        System.out.println("--- Train Capacity Manifest ---");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            String bogieType = entry.getKey();
            Integer capacity = entry.getValue();
            System.out.println("Bogie Type: " + bogieType + " | Capacity: " + capacity);
        }

        // 4. Demonstrate Fast Lookup
        // HashMap allows us to get the capacity instantly using the key
        String searchBogie = "Sleeper";
        if (bogieCapacityMap.containsKey(searchBogie)) {
            System.out.println("\nQuick Search: The capacity of " + searchBogie +
                    " is " + bogieCapacityMap.get(searchBogie) + " units.");
        }
    }
}