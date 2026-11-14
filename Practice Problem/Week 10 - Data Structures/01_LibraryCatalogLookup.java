import java.util.*;
public class LibraryCatalogLookup {
 static String findBook(String[][] a,String isbn){int l=0,r=a.length-1;while(l<=r){int m=(l+r)/2,c=a[m][0].compareTo(isbn);if(c==0)return a[m][1];if(c<0)l=m+1;else r=m-1;}return "Not Found";}
 public static void main(String[] z){String[][] a={{"0001112223","Introduction to Algebra"},{"0002223334","Beginning Python"},{"0003334445","Classic Mythology"},{"0004445556","Data and Society"},{"0005556667","European History"}};Scanner s=new Scanner(System.in);System.out.println(findBook(a,s.next()));}
}