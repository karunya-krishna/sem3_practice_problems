class PiggyBank {
 private double savings;
 private final String id;
 public PiggyBank(String id){this.id=id;savings=0;}
 public String getId(){return id;}
 public double getSavings(){return savings;}
 public void deposit(double amount){if(amount>0)savings+=amount;}
 public boolean withdraw(double amount){
  if(amount<=0||amount>savings)return false;
  savings-=amount;return true;
 }
 public static void main(String[] args){
  PiggyBank pb=new PiggyBank("PB-1");
  pb.deposit(100);System.out.println("Savings: "+pb.getSavings());
  pb.withdraw(30);System.out.println("Savings: "+pb.getSavings());
  System.out.println("Withdrawal accepted: "+pb.withdraw(500));
  System.out.println("Savings: "+pb.getSavings());
 }
}