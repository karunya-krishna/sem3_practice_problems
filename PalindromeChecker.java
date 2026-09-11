import java.util.Scanner;
import java.util.Arrays;

public class PalindromeChecker {
    static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left++) != text.charAt(right--)) return false;
        }
        return true;
    }
    static boolean isPalindromeRecursive(String text) {
        return checkRecursive(text, 0, text.length() - 1);
    }
    static boolean checkRecursive(String text, int left, int right) {
        if (left >= right) return true;
        if (text.charAt(left) != text.charAt(right)) return false;
        return checkRecursive(text, left + 1, right - 1);
    }
    static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = text.toCharArray();
        for (int i = 0; i < reversed.length / 2; i++) {
            char temp = reversed[i];
            reversed[i] = reversed[reversed.length - 1 - i];
            reversed[reversed.length - 1 - i] = temp;
        }
        return Arrays.equals(original, reversed);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println("Iterative: " + (isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Recursive: " + (isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Array Reversal: " + (isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome"));
        scanner.close();
    }
}
