import java.util.*;

/**
 * Week 12 — Abstraction and Interfaces
 * Compile: javac Week12AbstractionInterfaces.java
 * Run:     java Week12AbstractionInterfaces
 */
public class Week12AbstractionInterfaces {
    // 1. Garden Plot Area Report — polymorphic area calculation.
    interface Plot { String owner(); String shape(); double area(); }
    static class Circle implements Plot {
        String owner; double radius;
        Circle(String o, double r) { owner=o; radius=r; }
        public String owner(){return owner;} public String shape(){return "CIRCLE";}
        public double area(){return Math.PI*radius*radius;}
    }
    static class Rectangle implements Plot {
        String owner; double length,width;
        Rectangle(String o,double l,double w){owner=o;length=l;width=w;}
        public String owner(){return owner;} public String shape(){return "RECTANGLE";}
        public double area(){return length*width;}
    }
    static class Triangle implements Plot {
        String owner; double base,height;
        Triangle(String o,double b,double h){owner=o;base=b;height=h;}
        public String owner(){return owner;} public String shape(){return "TRIANGLE";}
        public double area(){return 0.5*base*height;}
    }
    static void printPlotReport(Plot[] plots) {
        double total=0;
        for(Plot p:plots){System.out.printf("%s (%s): %.2f%n",p.owner(),p.shape(),p.area());total+=p.area();}
        System.out.printf("Total Area: %.2f%n",total);
    }

    // 2. Weekly Staff Pay — abstract base class prevents generic staff instances.
    static abstract class Staff { String name; Staff(String n){name=n;} abstract double pay(); }
    static class FullTime extends Staff {
        double salary; FullTime(String n,double s){super(n);salary=s;} double pay(){return salary;}
    }
    static class Hourly extends Staff {
        double hours,rate; Hourly(String n,double h,double r){super(n);hours=h;rate=r;}
        double pay(){return Math.min(hours,40)*rate+Math.max(0,hours-40)*rate*1.5;}
    }
    static class Intern extends Staff {
        double stipend; Intern(String n,double s){super(n);stipend=s;} double pay(){return stipend;}
    }
    static void payroll(Staff[] staff) {
        double total=0;
        for(Staff s:staff){System.out.printf("%s: %.2f%n",s.name,s.pay());total+=s.pay();}
        System.out.printf("Total Payroll: %.2f%n",total);
    }

    // 3. Library Late Fine Counter
    static abstract class LibraryItem {
        String title; int daysLate;
        LibraryItem(String t,int d){title=t;daysLate=d;}
        abstract double fine();
    }
    static class Book extends LibraryItem {
        Book(String t,int d){super(t,d);} double fine(){return daysLate*2.0;}
    }
    static class DVD extends LibraryItem {
        DVD(String t,int d){super(t,d);} double fine(){return Math.min(daysLate*5.0,50.0);}
    }
    static class Magazine extends LibraryItem {
        Magazine(String t,int d){super(t,d);} double fine(){return daysLate*1.0;}
    }
    static void fines(LibraryItem[] items) {
        double total=0;
        for(LibraryItem item:items){System.out.printf("%s: %.2f%n",item.title,item.fine());total+=item.fine();}
        System.out.printf("Total Fines: %.2f%n",total);
    }

    // 4. Electricity Connection Billing
    static abstract class Connection {
        int units; Connection(int u){units=u;} abstract double bill();
    }
    static class Home extends Connection {
        Home(int u){super(u);} double bill(){return Math.min(units,100)*5.0+Math.max(0,units-100)*7.0;}
    }
    static class Shop extends Connection {
        Shop(int u){super(u);} double bill(){return units*8.0+100;}
    }
    static class Factory extends Connection {
        Factory(int u){super(u);} double bill(){return Math.max(1000,units*6.0);}
    }
    static void connectionBills(Connection[] connections) {
        double total=0;
        for(Connection c:connections){System.out.printf("%s: %.2f%n",c.getClass().getSimpleName().toUpperCase(),c.bill());total+=c.bill();}
        System.out.printf("Total: %.2f%n",total);
    }

    // 5. Travel Booking — common fee is implemented once in the abstract base class.
    static abstract class Booking {
        static final double BOOKING_FEE=50;
        abstract double baseFare(double distance);
        double total(double distance){return baseFare(distance)+BOOKING_FEE;}
    }
    static class Bus extends Booking { double baseFare(double d){return 2*d;} }
    static class Train extends Booking { double baseFare(double d){return 1.5*d;} }
    static class Flight extends Booking { double baseFare(double d){return 2500+4*d;} }

    public static void main(String[] args) {
        printPlotReport(new Plot[]{new Circle("Asha",5),new Rectangle("Ravi",4,6),new Triangle("Neha",10,3)});
        payroll(new Staff[]{new FullTime("Asha",12000),new Hourly("Ravi",45,200),new Intern("Neha",5000)});
        fines(new LibraryItem[]{new Book("Algebra",4),new DVD("Inception",12),new Magazine("Sports",3)});
        connectionBills(new Connection[]{new Home(150),new Shop(90),new Factory(120)});
        System.out.printf("BUS: %.2f%n",new Bus().total(200));
        System.out.printf("TRAIN: %.2f%n",new Train().total(300));
        System.out.printf("FLIGHT: %.2f%n",new Flight().total(500));
    }
}
