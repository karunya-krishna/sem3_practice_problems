import java.util.*;
class PairWithTargetSum {
 static boolean hasPairWithSum(int[] a,int target){Set<Integer>s=new HashSet<>();for(int n:a){if(s.contains(target-n))return true;s.add(n);}return false;}
 public static void main(String[] x){System.out.println(hasPairWithSum(new int[]{2,7,11,15},9));System.out.println(hasPairWithSum(new int[]{3,4,6},20));}
}