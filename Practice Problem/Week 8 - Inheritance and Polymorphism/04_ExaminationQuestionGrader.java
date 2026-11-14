import java.util.*;
public class ExaminationQuestionGrader {
 interface Question {double grade(String correct,String answer,double points);}
 static class ExactQuestion implements Question {public double grade(String c,String a,double p){return c.equals(a)?p:0;}}
 static class EssayQuestion implements Question {
  public double grade(String c,String a,double p){
   String lower=a.toLowerCase();int found=0;
   for(String key:c.split(","))if(lower.contains(key.trim().toLowerCase()))found++;
   return found>=2?p*.75:found==1?p*.5:0;
  }
 }
 static Question create(String type){return type.equals("ESSAY")?new EssayQuestion():new ExactQuestion();}
 static String[] quotedFields(String line){
  java.util.regex.Matcher m=java.util.regex.Pattern.compile("\\\"([^\\\"]*)\\\"|(\\S+)").matcher(line);
  java.util.ArrayList<String> out=new java.util.ArrayList<>();
  while(m.find())out.add(m.group(1)!=null?m.group(1):m.group(2));
  return out.toArray(new String[0]);
 }
 public static void main(String[] args){
  Scanner sc=new Scanner(System.in);int n=Integer.parseInt(sc.nextLine().trim());double total=0;
  for(int i=0;i<n;i++){
   String[] p=quotedFields(sc.nextLine());String type=p[0],correct=p[2],answer=p[3];double points=Double.parseDouble(p[4]);
   double score=create(type).grade(correct,answer,points);System.out.printf("%s: %.2f%n",type,score);total+=score;
  }
  System.out.printf("Total Score: %.2f%n",total);
 }
}