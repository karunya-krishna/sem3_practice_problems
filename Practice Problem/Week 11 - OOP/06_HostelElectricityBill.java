import java.util.*;
class HostelElectricityBill {
 static int bill(int u){if(u<=100)return u*3+50;if(u<=200)return 300+(u-100)*5+50;return 800+(u-200)*8+50;}
 public static void main(String[] x){Scanner s=new Scanner(System.in);int n=s.nextInt(),count=0,total=0;for(int i=0;i<n;i++){String room=s.next();int u=s.nextInt();if(u<0)System.out.println(room+": invalid reading");else{int b=bill(u);System.out.println(room+": "+u+" units, bill "+b);count++;total+=b;}}System.out.println("Rooms billed "+count+", total "+total);}
}