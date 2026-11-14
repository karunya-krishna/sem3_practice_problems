import java.util.*;
class ElectricityConnectionBilling {
 static abstract class Connection{int units;Connection(int u){units=u;}abstract double bill();}
 static class Home extends Connection{Home(int u){super(u);}double bill(){return Math.min(units,100)*5.0+Math.max(0,units-100)*7.0;}}
 static class Shop extends Connection{Shop(int u){super(u);}double bill(){return units*8.0+100;}}
 static class Factory extends Connection{Factory(int u){super(u);}double bill(){return Math.max(1000,units*6.0);}}
 public static void main(String[] x){Scanner s=new Scanner(System.in);int n=s.nextInt();Connection[] a=new Connection[n];String[] type=new String[n];for(int i=0;i<n;i++){type[i]=s.next();int u=s.nextInt();a[i]=type[i].equals("HOME")?new Home(u):type[i].equals("SHOP")?new Shop(u):new Factory(u);}double total=0;for(int i=0;i<n;i++){double b=a[i].bill();System.out.printf("%s: %.2f%n",type[i],b);total+=b;}System.out.printf("Total: %.2f%n",total);}
}