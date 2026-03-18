import java.util.ArrayList;
import java.util.List;

// Removed "public" so the filename doesn't have to match "TrainConsistApp"
class TrainConsistApp {

    public static void main(String[] args) {
        // 1. Display welcome message
        System.out.println(" === Train Consist Management App === ");

        // 2. Initialize an empty List using ArrayList
        // This creates a dynamic collection to hold our bogies later
        List<String> consist = new ArrayList<>();

        // 3. Display the initial bogie count using size()
        System.out.println("Initial Bogie Count: " + consist.size());

        System.out.println("Train system initialized successfully.");
    }
}