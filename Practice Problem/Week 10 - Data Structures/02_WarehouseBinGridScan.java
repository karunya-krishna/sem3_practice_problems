import java.util.*;
public class WarehouseBinGridScan {
 static void warehouseSummary(int[][] g){int total=0,max=-1,mr=0,mc=0;for(int r=0;r<g.length;r++)for(int c=0;c<g[r].length;c++){total+=g[r][c];if(g[r][c]>max){max=g[r][c];mr=r;mc=c;}}System.out.println("total = "+total+", maxCoordinate = ("+mr+", "+mc+")");}
 public static void main(String[] x){warehouseSummary(new int[][]{{4,9,2},{7,1,6},{3,12,5}});}
}