import java.util.*;
class LibraryReturnDesk {
 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  StringBuilder input=new StringBuilder();
  while(sc.hasNextLine())input.append(sc.nextLine()).append(" ");
  String[] tokens=input.toString().replace(","," ").trim().split("\\s+");
  if(tokens.length==0||tokens[0].isEmpty())return;
  int start=0,commands=tokens.length;
  if(tokens[0].matches("\\d+")){commands=Integer.parseInt(tokens[0]);start=1;}
  String[] pile=new String[3],line=new String[3];
  int top=-1,front=0,rear=0,size=0,done=0;
  for(int i=start;i<tokens.length&&done<commands;){
   String cmd=tokens[i++],value="";
   if(cmd.equals("RETURN")||cmd.equals("WAIT")){if(i>=tokens.length)break;value=tokens[i++];}
   done++;
   switch(cmd){
    case "RETURN":
     if(top==2)System.out.println(value+" rejected: pile is full");
     else{pile[++top]=value;System.out.println(value+" placed on pile");}
     break;
    case "SHELVE":
     if(top<0)System.out.println("pile is empty");
     else System.out.println("shelved "+pile[top--]);
     break;
    case "WAIT":
     if(size==3)System.out.println(value+" rejected: line is full");
     else{line[rear]=value;rear=(rear+1)%3;size++;System.out.println(value+" joined the line");}
     break;
    case "SERVE":
     if(size==0)System.out.println("no one waiting");
     else{System.out.println("served "+line[front]);front=(front+1)%3;size--;}
     break;
    default: System.out.println("Unknown command: "+cmd);
   }
  }
 }
}