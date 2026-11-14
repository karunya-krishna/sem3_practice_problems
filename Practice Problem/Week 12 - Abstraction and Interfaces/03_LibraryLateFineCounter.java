import java.util.*;
public class LibraryLateFineCounter {
 static abstract class Item{String title;int days;Item(String t,int d){title=t;days=d;}abstract double fine();}
 static class Book extends Item{Book(String t,int d){super(t,d);}double fine(){return days*2.0;}}
 static class DVD extends Item{DVD(String t,int d){super(t,d);}double fine(){return Math.min(days*5.0,50);}}
 static class Magazine extends Item{Magazine(String t,int d){super(t,d);}double fine(){return days*1.0;}}
 public static void main(String[] x){Scanner s=new Scanner(System.in);int n=s.nextInt();Item[] a=new Item[n];for(int i=0;i<n;i++){String t=s.next(),name=s.next();int d=s.nextInt();a[i]=t.equals("BOOK")?new Book(name,d):t.equals("DVD")?new DVD(name,d):new Magazine(name,d);}double total=0;for(Item p:a){System.out.printf("%s: %.2f%n",p.title,p.fine());total+=p.fine();}System.out.printf("Total Fines: %.2f%n",total);}
}