class StudentResultCard {
 static class Student {
  String name; int[] marks;
  Student(String name,int[] marks){this.name=name;this.marks=marks;}
  double average(){return (marks[0]+marks[1]+marks[2])/3.0;}
  char grade(){
   double a=average();
   if(a>=90)return 'A';
   if(a>=75)return 'B';
   if(a>=60)return 'C';
   if(a>=40)return 'D';
   return 'F';
  }
  void print(){System.out.printf("%s: Average %.1f, Grade %c%n",name.toUpperCase(),average(),grade());}
 }
 public static void main(String[] args) {
  new Student("Asha",new int[]{80,90,70}).print();
  new Student("Ravi",new int[]{60,55,50}).print();
 }
}