import java.util.*;
class EmployeeIdLookup {
 static Map<String,String> buildLookup(String[][] records){Map<String,String> m=new HashMap<>();for(String[] r:records)m.put(r[0],r[1]);return m;}
 static String getDepartment(Map<String,String> m,String id){return m.getOrDefault(id,"Unknown");}
 public static void main(String[] x){Map<String,String> m=buildLookup(new String[][]{{"E245","Finance"},{"E110","Engineering"},{"E390","Marketing"},{"E101","Engineering"}});System.out.println(getDepartment(m,"E390"));System.out.println(getDepartment(m,"E999"));}
}