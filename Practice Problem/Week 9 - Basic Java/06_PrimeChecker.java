import java.util.Scanner;
public class PrimeChecker {
 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in); int n=sc.nextInt(); boolean prime=n>1;
  for(int i=2;i<=n/i;i++)if(n%i==0){prime=false;break;}
  System.out.println(n+(prime?" is prime":" is not prime"));
 }
}