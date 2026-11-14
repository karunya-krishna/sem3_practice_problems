public class AttendanceSheet {
 private final String[] names;
 private int count;
 public AttendanceSheet(int capacity){names=new String[capacity];count=0;}
 public void markPresent(String name){
  if(name==null||isPresent(name)||count==names.length)return;
  names[count++]=name;
 }
 public int getPresentCount(){return count;}
 public boolean isPresent(String name){
  for(int i=0;i<count;i++)if(names[i].equals(name))return true;
  return false;
 }
 public static void main(String[] args){
  AttendanceSheet sheet=new AttendanceSheet(30);
  sheet.markPresent("Ana");sheet.markPresent("Ben");sheet.markPresent("Ana");
  System.out.println("Present count: "+sheet.getPresentCount());
  System.out.println("Ben present: "+sheet.isPresent("Ben"));
  System.out.println("Chen present: "+sheet.isPresent("Chen"));
 }
}