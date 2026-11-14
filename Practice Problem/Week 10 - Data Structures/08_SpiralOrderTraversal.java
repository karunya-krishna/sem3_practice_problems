import java.util.*;
public class SpiralOrderTraversal {
 static List<Integer> spiralOrder(int[][] a){List<Integer> out=new ArrayList<>();if(a.length==0)return out;int t=0,b=a.length-1,l=0,r=a[0].length-1;while(t<=b&&l<=r){for(int c=l;c<=r;c++)out.add(a[t][c]);t++;for(int i=t;i<=b;i++)out.add(a[i][r]);r--;if(t<=b){for(int c=r;c>=l;c--)out.add(a[b][c]);b--;}if(l<=r){for(int i=b;i>=t;i--)out.add(a[i][l]);l++;}}return out;}
 public static void main(String[] x){System.out.println(spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));}
}