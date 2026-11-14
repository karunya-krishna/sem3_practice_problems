import java.util.*;
class WeeklyRainfallAnalysis {
 public static void main(String[] x){Scanner s=new Scanner(System.in);double[] a=new double[7];double total=0,max=-1;int day=0,dry=0;for(int i=0;i<7;i++){a[i]=s.nextDouble();total+=a[i];if(a[i]>max){max=a[i];day=i+1;}if(a[i]==0)dry++;}System.out.print("Rainfall (mm):");for(double v:a)System.out.print(" "+v);System.out.printf("%nTotal Rainfall: %.1f mm%nAverage Rainfall: %.2f mm%nWettest Day: Day %d (%.1f mm)%nTotal Dry Days: %d%n",total,total/7,day,max,dry);}
}