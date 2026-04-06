import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * UC11: Validate Train ID & Cargo Codes (Regex)
 * This class ensures that all input follows strict railway formatting rules.
 */
public class TrainConsistApp {

    // Regex Patterns:
    // TRN-\\d{4} ensures "TRN-" followed by exactly 4 digits.
    // PET-[A-Z]{2} ensures "PET-" followed by exactly 2 uppercase letters.
    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";

    public static void main(String[] args) {
        // Test Data for Train IDs
        String[] testTrainIDs = {"TRN-1234", "TRAIN12", "TRN-123", "TRN-5566A", "1234-TRN"};

        // Test Data for Cargo Codes
        String[] testCargoCodes = {"PET-AB", "PET-bc", "PET12", "PET-XYZ", "PET-XY"};

        System.out.println("=== Railway Input Validation (UC11) ===");

        // Validate Train IDs
        System.out.println("\n--- Validating Train IDs (Required: TRN-DDDD) ---");
        for (String id : testTrainIDs) {
            checkFormat(id, TRAIN_ID_REGEX, "Train ID");
        }

        // Validate Cargo Codes
        System.out.println("\n--- Validating Cargo Codes (Required: PET-AA) ---");
        for (String code : testCargoCodes) {
            checkFormat(code, CARGO_CODE_REGEX, "Cargo Code");
        }

        System.out.println("\nValidation process complete. Only '✔ Valid' data will be processed.");
    }

    /**
     * core validation logic using Pattern and Matcher
     */
    private static void checkFormat(String input, String regex, String type) {
        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);
        // Create matcher for the input string
        Matcher matcher = pattern.matcher(input);

        // matches() checks the ENTIRE string against the pattern
        if (matcher.matches()) {
            System.out.println("✔ Valid " + type + ": " + input);
        } else {
            System.out.println("❌ Invalid " + type + ": " + input + " (Format Mismatch)");
        }
    }
}