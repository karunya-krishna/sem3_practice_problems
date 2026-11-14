import java.util.*;
public class RemoveDuplicatesInPlace {
 static int removeDuplicates(int[] a){if(a.length==0)return 0;int k=1;for(int i=1;i<a.length;i++)if(a[i]!=a[k-1])a[k++]=a[i];return k;}
 public static void main(String[] x){int[] a={1,1,2,2,2,3,4,4,5};int k=removeDuplicates(a);System.out.println("length = "+k);System.out.println("nums[0.."+(k-1)+"] = "+Arrays.toString(Arrays.copyOf(a,k)));}
}