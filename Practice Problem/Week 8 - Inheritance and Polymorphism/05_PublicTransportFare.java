import java.util.*;
public class PublicTransportFare {
 interface Transport {double fare(double distance,double factor);}
 static class Bus implements Transport {public double fare(double d,double f){return Math.min(2+.10*d,10);}}
 static class Train implements Transport {public double fare(double d,double f){return 3+.15*d;}}
 static class Metro implements Transport {public double fare(double d,double f){return (1.5+.20*d)*f;}}
 static Transport create(String type){
  switch(type){case "BUS":return new Bus();case "TRAIN":return new Train();case "METRO":return new Metro();default:throw new IllegalArgumentException("Invalid transport type: "+type);}
 }
 public static void main(String[] args){
  Scanner sc=new Scanner(System.in);int n=sc.nextInt();double total=0;
  for(int i=0;i<n;i++){String type=sc.next();double distance=sc.nextDouble(),factor=type.equals("METRO")?sc.nextDouble():1;double fare=create(type).fare(distance,factor);System.out.printf("%s: %.2f%n",type,fare);total+=fare;}
  System.out.printf("Total: %.2f%n",total);
 }
}