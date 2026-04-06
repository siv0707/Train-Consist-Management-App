import java.util.*;

/**
 * UC12: Safety Compliance Check for Goods Bogies
 * Enforces domain rules: Cylindrical bogies MUST carry Petroleum.
 */
class GoodsBogie {
    private String type;  // e.g., "Cylindrical", "Open", "Box"
    private String cargo; // e.g., "Petroleum", "Coal", "Grain"

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() { return type; }
    public String getCargo() { return cargo; }

    @Override
    public String toString() {
        return String.format("[%s Bogie | Cargo: %s]", type, cargo);
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        // 1. Prepare a list of goods bogies (Scenario: Mixed Cargo)
        List<GoodsBogie> goodsConsist = new ArrayList<>();
        goodsConsist.add(new GoodsBogie("Open", "Coal"));
        goodsConsist.add(new GoodsBogie("Box", "Grain"));
        goodsConsist.add(new GoodsBogie("Cylindrical", "Petroleum"));

        System.out.println("--- Current Goods Train Formation ---");
        goodsConsist.forEach(System.out::println);

        // 2. Safety Validation Rule using Stream.allMatch()
        // Rule: If Type is "Cylindrical", Cargo MUST be "Petroleum".
        boolean isSafe = goodsConsist.stream().allMatch(bogie -> {
            if (bogie.getType().equalsIgnoreCase("Cylindrical")) {
                return bogie.getCargo().equalsIgnoreCase("Petroleum");
            }
            return true; // Other bogie types pass this specific rule
        });

        // 3. Display Safety Result
        System.out.println("\n--- Safety Compliance Report ---");
        if (isSafe) {
            System.out.println("STATUS: ✔ SAFE");
            System.out.println("Message: All cylindrical bogies are carrying approved liquid cargo.");
        } else {
            System.out.println("STATUS: ❌ UNSAFE");
            System.out.println("Message: CRITICAL! Improper cargo detected in cylindrical bogie.");
        }

        // 4. Testing a Violation Scenario
        System.out.println("\n--- Testing Violation Scenario (Adding Cylindrical with Coal) ---");
        goodsConsist.add(new GoodsBogie("Cylindrical", "Coal"));

        // Short-circuit check
        boolean isSafeAfterViolation = goodsConsist.stream().allMatch(bogie ->
                !bogie.getType().equalsIgnoreCase("Cylindrical") ||
                        bogie.getCargo().equalsIgnoreCase("Petroleum")
        );

        System.out.println("New Safety Status: " + (isSafeAfterViolation ? "✔ SAFE" : "❌ UNSAFE"));
    }
}