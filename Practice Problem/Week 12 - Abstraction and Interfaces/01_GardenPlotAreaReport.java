import java.util.*;
class GardenPlotAreaReport {
 interface Plot{String owner();String shape();double area();}
 static class Circle implements Plot{String o;double r;Circle(String o,double r){this.o=o;this.r=r;}public String owner(){return o;}public String shape(){return "CIRCLE";}public double area(){return Math.PI*r*r;}}
 static class Rectangle implements Plot{String o;double l,w;Rectangle(String o,double l,double w){this.o=o;this.l=l;this.w=w;}public String owner(){return o;}public String shape(){return "RECTANGLE";}public double area(){return l*w;}}
 static class Triangle implements Plot{String o;double b,h;Triangle(String o,double b,double h){this.o=o;this.b=b;this.h=h;}public String owner(){return o;}public String shape(){return "TRIANGLE";}public double area(){return .5*b*h;}}
 public static void main(String[] x){Scanner s=new Scanner(System.in);int n=s.nextInt();Plot[] a=new Plot[n];for(int i=0;i<n;i++){String t=s.next(),o=s.next();if(t.equals("CIRCLE"))a[i]=new Circle(o,s.nextDouble());else if(t.equals("RECTANGLE"))a[i]=new Rectangle(o,s.nextDouble(),s.nextDouble());else a[i]=new Triangle(o,s.nextDouble(),s.nextDouble());}double total=0;for(Plot p:a){System.out.printf("%s (%s): %.2f%n",p.owner(),p.shape(),p.area());total+=p.area();}System.out.printf("Total Area: %.2f%n",total);}
}