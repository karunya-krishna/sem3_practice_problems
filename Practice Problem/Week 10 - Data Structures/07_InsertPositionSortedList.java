class InsertPositionSortedList {
 static int searchInsertPosition(int[] a,int target){int l=0,r=a.length;while(l<r){int m=l+(r-l)/2;if(a[m]<target)l=m+1;else r=m;}return l;}
 public static void main(String[] x){System.out.println(searchInsertPosition(new int[]{1,3,5,6},5));System.out.println(searchInsertPosition(new int[]{1,3,5,6},2));}
}