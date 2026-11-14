import java.util.*;
public class CampusStaffSalary {
 static class Staff{String name;double base;Staff(String n,double b){name=n;base=b;}double getBonus(){return 0;}String type(){return "Staff";}double total(){return base+getBonus();}}
 static class Teacher extends Staff{Teacher(String n,double b){super(n,b);}double getBonus(){return 5000;}String type(){return "Teacher";}}
 static class LabAssistant extends Staff{LabAssistant(String n,double b){super(n,b);}double getBonus(){return 2000;}String type(){return "LabAssistant";}}
 public static void main(String[] x){Scanner s=new Scanner(System.in);int n=s.nextInt();Staff[] a=new Staff[n];for(int i=0;i<n;i++){String t=s.next(),name=s.next();double b=s.nextDouble();a[i]=t.equals("Teacher")?new Teacher(name,b):t.equals("LabAssistant")?new LabAssistant(name,b):new Staff(name,b);}double sum=0;for(Staff p:a){System.out.printf("%s (%s): base %.1f, bonus %.1f, total %.1f%n",p.name,p.type(),p.base,p.getBonus(),p.total());sum+=p.total();}System.out.printf("Grand Total Salary: %.1f%n",sum);}
}