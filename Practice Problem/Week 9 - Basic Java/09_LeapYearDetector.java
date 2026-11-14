import java.util.Scanner;
class LeapYearDetector {
 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in); int y=sc.nextInt();
  System.out.println(y%400==0||(y%4==0&&y%100!=0)?"Leap year":"Not a leap year");
 }
}