import java.util.*;

// 1. Custom Runtime Exception for operational safety
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    private String shape; // "Rectangular" or "Cylindrical"
    private String cargo = "Empty";

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    // 2. Method to assign cargo with safety logic
    public void assignCargo(String newCargo) {
        System.out.println("\n>>> Attempting to assign [" + newCargo + "] to [" + shape + "] bogie...");

        // Business Rule: Petroleum requires a Cylindrical bogie
        if (newCargo.equalsIgnoreCase("Petroleum") && shape.equalsIgnoreCase("Rectangular")) {
            throw new CargoSafetyException("SAFETY ALERT: Petroleum cannot be assigned to a Rectangular bogie (Leak Risk)!");
        }

        this.cargo = newCargo;
        System.out.println("✔ Assignment Successful: " + shape + " is now carrying " + cargo);
    }

    public String getStatus() {
        return shape + " Bogie | Current Cargo: " + cargo;
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        GoodsBogie rectBogie = new GoodsBogie("Rectangular");
        GoodsBogie cylBogie = new GoodsBogie("Cylindrical");

        // 3. Structured Exception Handling
        String[] cargoRequests = {"Grain", "Petroleum", "Coal"};

        for (String request : cargoRequests) {
            try {
                // Testing the Rectangular bogie with various cargoes
                rectBogie.assignCargo(request);
            } catch (CargoSafetyException e) {
                // Handle the domain-specific error
                System.out.println("❌ ERROR CAUGHT: " + e.getMessage());
            } finally {
                // Mandatory logic (Cleanup or Logging)
                System.out.println("[System Log]: Cargo validation cycle completed for request: " + request);
            }
        }

        // Test a valid assignment to show program continuation
        try {
            cylBogie.assignCargo("Petroleum");
        } catch (CargoSafetyException e) {
            System.out.println("❌ Error: " + e.getMessage());
        } finally {
            System.out.println("[System Log]: Final validation cycle completed.");
        }

        System.out.println("\n--- Final Train Status ---");
        System.out.println(rectBogie.getStatus());
        System.out.println(cylBogie.getStatus());
        System.out.println("System remains operational. No crashes occurred.");
    }
}