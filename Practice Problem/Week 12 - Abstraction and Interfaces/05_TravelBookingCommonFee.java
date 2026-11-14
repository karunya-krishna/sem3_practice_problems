import java.util.*;
class TravelBookingCommonFee {
 static abstract class Booking{static final double FEE=50;abstract double baseFare(double d);double total(double d){return baseFare(d)+FEE;}}
 static class Bus extends Booking{double baseFare(double d){return 2*d;}}
 static class Train extends Booking{double baseFare(double d){return 1.5*d;}}
 static class Flight extends Booking{double baseFare(double d){return 2500+4*d;}}
 public static void main(String[] x){Scanner s=new Scanner(System.in);int n=s.nextInt();for(int i=0;i<n;i++){String t=s.next();double d=s.nextDouble();Booking b=t.equals("BUS")?new Bus():t.equals("TRAIN")?new Train():new Flight();System.out.printf("%s: %.2f%n",t,b.total(d));}}
}