import java.util.*;
public class DeliveryFeeCalculator {
 interface Delivery {double fee(double weight,double distance,double customs);}
 static class Standard implements Delivery {public double fee(double w,double d,double c){return 5+.5*w+.1*d;}}
 static class Express implements Delivery {public double fee(double w,double d,double c){return 15+w+.2*d;}}
 static class International implements Delivery {public double fee(double w,double d,double c){return 25+2*w+.5*d+c;}}
 static Delivery create(String type){
  switch(type){case "STANDARD":return new Standard();case "EXPRESS":return new Express();case "INTERNATIONAL":return new International();default:throw new IllegalArgumentException("Invalid delivery type: "+type);}
 }
 public static void main(String[] args){
  Scanner sc=new Scanner(System.in);int n=sc.nextInt();double total=0;
  for(int i=0;i<n;i++){String type=sc.next();double w=sc.nextDouble(),d=sc.nextDouble(),c=type.equals("INTERNATIONAL")?sc.nextDouble():0;double fee=create(type).fee(w,d,c);System.out.printf("%s: %.2f%n",type,fee);total+=fee;}
  System.out.printf("Total: %.2f%n",total);
 }
}