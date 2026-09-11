import java.util.Scanner;

public class BankTransactionReferenceGeneratorValidator {
    static String normalizeReference(String raw) {
        String reference = raw.trim();
        if (reference.length() < 3) return reference;
        return reference.substring(0, 3).toUpperCase() + reference.substring(3);
    }
    static String validateAndFormat(String reference) {
        if (reference.length() != 14) return "Invalid: wrong length";
        for (int i = 0; i < 3; i++) if (!Character.isLetter(reference.charAt(i))) return "Invalid: bank code must be 3 letters";
        for (int i = 3; i < 14; i++) if (!Character.isDigit(reference.charAt(i))) return "Invalid: body must contain only digits";
        String date = reference.substring(3, 9);
        StringBuilder result = new StringBuilder();
        result.append("[").append(reference.substring(0, 3)).append("] DATE: ")
              .append(date.substring(0, 2)).append("/")
              .append(date.substring(2, 4)).append("/")
              .append(date.substring(4, 6)).append(" | SEQ: ")
              .append(reference.substring(9));
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String reference = normalizeReference(scanner.nextLine());
        System.out.println(validateAndFormat(reference));
        scanner.close();
    }
}
