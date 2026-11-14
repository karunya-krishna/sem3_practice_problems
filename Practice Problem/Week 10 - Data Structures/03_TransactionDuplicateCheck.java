import java.util.*;
class TransactionDuplicateCheck {
 static boolean hasDuplicate(String[] ids){Set<String>s=new HashSet<>();for(String id:ids)if(!s.add(id))return true;return false;}
 public static void main(String[] x){System.out.println(hasDuplicate(new String[]{"TXN1001","TXN1002","TXN1003","TXN1002","TXN1004"}));System.out.println(hasDuplicate(new String[]{"TXN2001","TXN2002","TXN2003"}));}
}