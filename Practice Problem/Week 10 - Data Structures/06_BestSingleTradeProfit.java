class BestSingleTradeProfit {
 static int maxProfit(int[] p){int min=Integer.MAX_VALUE,best=0;for(int n:p){min=Math.min(min,n);best=Math.max(best,n-min);}return best;}
 public static void main(String[] x){System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));System.out.println(maxProfit(new int[]{7,6,4,3,1}));}
}