import java.util.*;

/**
 * Week 11 — Classes, Inheritance, Encapsulation and Polymorphism
 * Compile: javac Week11OOP.java
 * Run:     java Week11OOP
 */
public class Week11OOP {
    // 1. Campus Staff Salary
    static class Staff {
        String name; double baseSalary;
        Staff(String name, double baseSalary) { this.name = name; this.baseSalary = baseSalary; }
        double getBonus() { return 0; }
        String type() { return "Staff"; }
        double total() { return baseSalary + getBonus(); }
        void print() {
            System.out.printf("%s (%s): base %.1f, bonus %.1f, total %.1f%n",
                    name, type(), baseSalary, getBonus(), total());
        }
    }
    static class Teacher extends Staff {
        Teacher(String n, double s) { super(n, s); }
        @Override double getBonus() { return 5000; }
        @Override String type() { return "Teacher"; }
    }
    static class LabAssistant extends Staff {
        LabAssistant(String n, double s) { super(n, s); }
        @Override double getBonus() { return 2000; }
        @Override String type() { return "LabAssistant"; }
    }
    static void printStaff(Staff[] staff) {
        double grandTotal = 0;
        for (Staff s : staff) { s.print(); grandTotal += s.total(); }
        System.out.printf("Grand Total Salary: %.1f%n", grandTotal);
    }

    // 2. Class Report Card; invalid marks are rejected; bubble sort stops on a no-swap pass.
    static class Student {
        private String name; private int a, b, c;
        Student(String name) { this.name = name; }
        boolean setMarks(int a, int b, int c) {
            if (a < 0 || a > 100 || b < 0 || b > 100 || c < 0 || c > 100) return false;
            this.a = a; this.b = b; this.c = c; return true;
        }
        int total() { return a + b + c; }
        double average() { return total() / 3.0; }
        char grade() {
            double avg = average();
            if (avg >= 80) return 'A';
            if (avg >= 70) return 'B';
            if (avg >= 60) return 'C';
            if (avg >= 40) return 'D';
            return 'F';
        }
        @Override public String toString() {
            return String.format("%s total=%d avg=%.2f grade=%c", name, total(), average(), grade());
        }
    }
    static int sortStudents(Student[] students) {
        int passes = 0;
        for (int end = students.length - 1; end > 0; end--) {
            boolean swapped = false;
            for (int i = 0; i < end; i++)
                if (students[i].total() < students[i+1].total()) {
                    Student temp = students[i]; students[i] = students[i+1]; students[i+1] = temp;
                    swapped = true;
                }
            passes++;
            if (!swapped) break;
        }
        return passes;
    }

    // 3. Fixed-size array stack and circular queue, both with capacity 3.
    static class BookStack {
        String[] data = new String[3]; int top = -1;
        void push(String book) {
            if (top == 2) System.out.println(book + " rejected: pile is full");
            else { data[++top] = book; System.out.println(book + " placed on pile"); }
        }
        void pop() {
            if (top == -1) System.out.println("pile is empty");
            else System.out.println("shelved " + data[top--]);
        }
    }
    static class StudentQueue {
        String[] data = new String[3]; int front = 0, rear = 0, size = 0;
        void add(String name) {
            if (size == 3) System.out.println(name + " rejected: line is full");
            else { data[rear] = name; rear = (rear + 1) % 3; size++; System.out.println(name + " joined the line"); }
        }
        void remove() {
            if (size == 0) System.out.println("no one waiting");
            else { System.out.println("served " + data[front]); front = (front + 1) % 3; size--; }
        }
    }

    // 4. Payment Processing
    interface PaymentMode { double processPayment(double amount); String name(); }
    static class CashPayment implements PaymentMode {
        public double processPayment(double amount) { return amount; }
        public String name() { return "Cash"; }
    }
    static class CardPayment implements PaymentMode {
        public double processPayment(double amount) { return amount * 1.02; }
        public String name() { return "Card"; }
    }
    static class UpiPayment implements PaymentMode {
        public double processPayment(double amount) { return amount; }
        public String name() { return "UPI"; }
    }
    static void printPayments(PaymentMode[] modes, double[] amounts) {
        double total = 0;
        for (int i = 0; i < modes.length; i++) {
            double processed = modes[i].processPayment(amounts[i]);
            double fee = processed - amounts[i]; total += processed;
            System.out.printf("%s: amount %.1f, fee %.1f, processed %.1f%n",
                    modes[i].name(), amounts[i], fee, processed);
        }
        System.out.printf("Total Amount Processed: %.1f%n", total);
    }

    // 5. Weekly Rainfall Analysis
    static void rainfall(double[] values) {
        double total = 0, max = -1; int wettest = 0, dry = 0;
        for (int i = 0; i < values.length; i++) {
            total += values[i];
            if (values[i] > max) { max = values[i]; wettest = i + 1; }
            if (values[i] == 0) dry++;
        }
        System.out.println("Rainfall (mm): " + Arrays.toString(values));
        System.out.printf("Total Rainfall: %.1f mm%nAverage Rainfall: %.2f mm%n", total, total / values.length);
        System.out.printf("Wettest Day: Day %d (%.1f mm)%nTotal Dry Days: %d%n", wettest, max, dry);
    }

    // 6. Hostel Electricity Bill
    static int bill(int units) {
        if (units < 0) return -1;
        if (units <= 100) return units * 3 + 50;
        if (units <= 200) return 100 * 3 + (units - 100) * 5 + 50;
        return 100 * 3 + 100 * 5 + (units - 200) * 8 + 50;
    }

    public static void main(String[] args) {
        printStaff(new Staff[]{new Teacher("Rahul",30000), new LabAssistant("Priya",20000),
                new Staff("Amit",25000)});
        Student[] students = {new Student("Asha"), new Student("Ravi"), new Student("Kiran")};
        students[0].setMarks(80,90,70); students[1].setMarks(60,65,70); students[2].setMarks(45,50,40);
        int passes = sortStudents(students);
        for (int i=0;i<students.length;i++) System.out.println((i+1) + ". " + students[i]);
        System.out.println("Sorted in " + passes + " passes");
        BookStack stack = new BookStack(); stack.push("B1"); stack.push("B2"); stack.pop();
        StudentQueue queue = new StudentQueue(); queue.add("Asha"); queue.remove();
        printPayments(new PaymentMode[]{new CashPayment(),new CardPayment(),new UpiPayment()},
                new double[]{1000,2000,1500});
        rainfall(new double[]{12,0,25,18,0,30,15});
        System.out.println("A101: 80 units, bill " + bill(80));
    }
}
