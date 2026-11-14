import java.util.*;
class PaymentProcessing {
 interface PaymentMode{double processPayment(double amount);String name();}
 static class CashPayment implements PaymentMode{public double processPayment(double a){return a;}public String name(){return "Cash";}}
 static class CardPayment implements PaymentMode{public double processPayment(double a){return a*1.02;}public String name(){return "Card";}}
 static class UpiPayment implements PaymentMode{public double processPayment(double a){return a;}public String name(){return "UPI";}}
 public static void main(String[] x){Scanner s=new Scanner(System.in);int n=s.nextInt();PaymentMode[] p=new PaymentMode[n];double[] amount=new double[n];for(int i=0;i<n;i++){String t=s.next();amount[i]=s.nextDouble();p[i]=t.equals("Cash")?new CashPayment():t.equals("Card")?new CardPayment():new UpiPayment();}double total=0;for(int i=0;i<n;i++){double done=p[i].processPayment(amount[i]),fee=done-amount[i];System.out.printf("%s: amount %.1f, fee %.1f, processed %.1f%n",p[i].name(),amount[i],fee,done);total+=done;}System.out.printf("Total Amount Processed: %.1f%n",total);}
}