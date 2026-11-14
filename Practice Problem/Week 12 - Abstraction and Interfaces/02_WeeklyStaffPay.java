import java.util.*;
public class WeeklyStaffPay {
 static abstract class Staff{String name;Staff(String n){name=n;}abstract double pay();}
 static class FullTime extends Staff{double salary;FullTime(String n,double s){super(n);salary=s;}double pay(){return salary;}}
 static class Hourly extends Staff{double hours,rate;Hourly(String n,double h,double r){super(n);hours=h;rate=r;}double pay(){return Math.min(40,hours)*rate+Math.max(0,hours-40)*rate*1.5;}}
 static class Intern extends Staff{double stipend;Intern(String n,double s){super(n);stipend=s;}double pay(){return stipend;}}
 public static void main(String[] x){Scanner s=new Scanner(System.in);int n=s.nextInt();Staff[] a=new Staff[n];for(int i=0;i<n;i++){String t=s.next(),name=s.next();if(t.equals("FULLTIME"))a[i]=new FullTime(name,s.nextDouble());else if(t.equals("HOURLY"))a[i]=new Hourly(name,s.nextDouble(),s.nextDouble());else a[i]=new Intern(name,s.nextDouble());}double total=0;for(Staff p:a){System.out.printf("%s: %.2f%n",p.name,p.pay());total+=p.pay();}System.out.printf("Total Payroll: %.2f%n",total);}
}