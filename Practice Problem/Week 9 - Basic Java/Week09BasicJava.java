import java.util.*;

/**
 * Week 9 — Basic Java Practice Problems (PDF: CATEGORY-C-DATA-STRUCTURE_PRACTICE.pdf)
 * Compile: javac Week09BasicJava.java
 * Run:     java Week09BasicJava
 */
public class Week09BasicJava {
    static void vowelConsonantCount(String word) {
        int vowels = 0, consonants = 0;
        for (char ch : word.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(ch) >= 0) vowels++;
            else consonants++;
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    static void reverseAndCheckPalindrome(String word) {
        String reversed = new StringBuilder(word).reverse().toString();
        System.out.println(reversed + (word.equals(reversed) ? " - palindrome" : " - not a palindrome"));
    }

    static void countEvenOdd(int[] nums) {
        int even = 0, odd = 0;
        for (int n : nums) if (n % 2 == 0) even++; else odd++;
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }

    static void reverseArrayInPlace(int[] nums) {
        for (int left = 0, right = nums.length - 1; left < right; left++, right--) {
            int temp = nums[left]; nums[left] = nums[right]; nums[right] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }

    static void digitSumAndReverse(int number) {
        int n = number, sum = 0, reverse = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            reverse = reverse * 10 + digit;
            n /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);
    }

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= n / i; i++) if (n % i == 0) return false;
        return true;
    }

    static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }

    static char grade(int marks) {
        if (marks >= 90) return 'A';
        if (marks >= 75) return 'B';
        if (marks >= 60) return 'C';
        if (marks >= 40) return 'D';
        return 'F';
    }

    static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    static class Student {
        String name;
        int[] marks;
        Student(String name, int[] marks) { this.name = name; this.marks = marks; }
        double average() { return (marks[0] + marks[1] + marks[2]) / 3.0; }
        char grade() {
            double avg = average();
            if (avg >= 75) return 'B';
            if (avg >= 60) return 'C';
            if (avg >= 40) return 'D';
            return 'F';
        }
        void printResult() {
            System.out.printf("%s: Average %.1f, Grade %c%n",
                    name.toUpperCase(), average(), grade());
        }
    }

    public static void main(String[] args) {
        vowelConsonantCount("Programming");
        reverseAndCheckPalindrome("level");
        countEvenOdd(new int[]{3, 8, 12, 5, 7, 10});
        reverseArrayInPlace(new int[]{11, 22, 33, 44});
        digitSumAndReverse(4721);
        System.out.println(isPrime(29) ? "29 is prime" : "29 is not prime");
        System.out.println(factorial(5));
        System.out.println("Grade " + grade(72));
        System.out.println(isLeapYear(2024) ? "Leap year" : "Not a leap year");
        new Student("Asha", new int[]{80, 90, 70}).printResult();
    }
}
