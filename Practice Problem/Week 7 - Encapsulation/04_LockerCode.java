class LockerCode {
 private String code;
 private final int lockerNumber;
 public LockerCode(int number,String initialCode){lockerNumber=number;code=initialCode;}
 public int getLockerNumber(){return lockerNumber;}
 public boolean changeCode(String current,String next){
  if(code.equals(current)&&next!=null&&!next.isEmpty()){code=next;return true;}
  return false;
 }
 public static void main(String[] args){
  LockerCode locker=new LockerCode(101,"1234");
  System.out.println("Correct change: "+locker.changeCode("1234","5678"));
  System.out.println("Wrong change: "+locker.changeCode("0000","9999"));
 }
}