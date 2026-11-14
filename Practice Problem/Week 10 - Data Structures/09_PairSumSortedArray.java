public class PairSumSortedArray {
 static String pairSumSorted(int[] a,int target){int l=0,r=a.length-1;while(l<r){int sum=a[l]+a[r];if(sum==target)return "("+a[l]+", "+a[r]+")";if(sum<target)l++;else r--;}return "Not Found";}
 public static void main(String[] x){System.out.println(pairSumSorted(new int[]{-4,-1,0,3,5,9},4));System.out.println(pairSumSorted(new int[]{1,2,3},100));}
}