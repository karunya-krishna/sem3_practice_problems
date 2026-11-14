import java.util.*;
class InPlaceArrayReversal {
 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in); int n=sc.nextInt(); int[] a=new int[n];
  for(int i=0;i<n;i++)a[i]=sc.nextInt();
  for(int l=0,r=n-1;l<r;l++,r--){int t=a[l];a[l]=a[r];a[r]=t;}
  System.out.println(Arrays.toString(a));
 }
}