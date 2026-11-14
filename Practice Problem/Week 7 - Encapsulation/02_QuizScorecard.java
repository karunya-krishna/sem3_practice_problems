public class QuizScorecard {
 private final boolean[] results;
 private int recorded;
 public QuizScorecard(int questionCount){results=new boolean[questionCount];recorded=0;}
 public void recordAnswer(boolean correct){
  if(recorded<results.length)results[recorded++]=correct;
 }
 public int getScore(){
  int score=0;for(int i=0;i<recorded;i++)if(results[i])score++;
  return score;
 }
 public static void main(String[] args){
  QuizScorecard sc=new QuizScorecard(4);
  sc.recordAnswer(true);sc.recordAnswer(true);sc.recordAnswer(false);sc.recordAnswer(true);
  System.out.println("Score: "+sc.getScore());
 }
}