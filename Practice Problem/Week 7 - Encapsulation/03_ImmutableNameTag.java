public final class ImmutableNameTag {
 private final String firstName,lastInitial;
 public ImmutableNameTag(String fullName){
  String[] parts=fullName.split(" ");
  firstName=parts[0];lastInitial=parts[1].substring(0,1);
 }
 public String getNickname(){return firstName+" "+lastInitial+".";}
 public static void main(String[] args){
  ImmutableNameTag tag=new ImmutableNameTag("Maria Gomez");
  System.out.println(tag.getNickname());
 }
}