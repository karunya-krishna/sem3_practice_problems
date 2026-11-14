import java.util.*;import java.time.*;
class LibraryDueDate {
 static abstract class LibraryItem {
  String title;LibraryItem(String t){title=t;}
  abstract int loanDays();
  LocalDate dueDate(LocalDate today){return today.plusDays(loanDays());}
 }
 static class Book extends LibraryItem {Book(String t){super(t);}int loanDays(){return 14;}}
 static class DVD extends LibraryItem {DVD(String t){super(t);}int loanDays(){return 7;}}
 static class Magazine extends LibraryItem {Magazine(String t){super(t);}int loanDays(){return 3;}}
 static LibraryItem create(String type,String title){
  switch(type){case "BOOK":return new Book(title);case "DVD":return new DVD(title);case "MAGAZINE":return new Magazine(title);default:throw new IllegalArgumentException("Invalid item type: "+type);}
 }
 public static void main(String[] args){
  Scanner sc=new Scanner(System.in);int n=Integer.parseInt(sc.nextLine().trim());LocalDate today=LocalDate.of(2023,10,26);
  for(int i=0;i<n;i++){String[] p=sc.nextLine().trim().split("\\s+",2);String title=p[1].replaceAll("^\\"|\\"$","");LibraryItem item=create(p[0],title);System.out.println(item.title+": "+item.dueDate(today));}
 }
}