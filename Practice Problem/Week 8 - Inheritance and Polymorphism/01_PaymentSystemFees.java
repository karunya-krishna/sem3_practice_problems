import java.util.*;
class PaymentSystemFees {
 interface Payment {double finalAmount(double amount);}
 static class Card implements Payment {public double finalAmount(double a){return a*1.02;}}
 static class Wallet implements Payment {public double finalAmount(double a){return a*1.01;}}
 static class BankTransfer implements Payment {public double finalAmount(double a){return a;}}
 static Payment create(String type){
  switch(type){case "CARD":return new Card();case "WALLET":return new Wallet();case "BANKTRANSFER":return new BankTransfer();default:throw new IllegalArgumentException("Invalid payment type: "+type);}
 }
 public static void main(String[] args){
  Scanner sc=new Scanner(System.in);int n=sc.nextInt();double total=0;
  for(int i=0;i<n;i++){String type=sc.next();double amount=sc.nextDouble();double adjusted=create(type).finalAmount(amount);System.out.printf("%s: %.2f%n",type,adjusted);total+=adjusted;}
  System.out.printf("Total: %.2f%n",total);
 }
}