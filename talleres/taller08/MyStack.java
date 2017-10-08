


/**
 * Write a description of class stack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */ 
import java.util.Stack;
public class MyStack
{
   public static void main(String[] args){
       Stack<String> s = new Stack();
       s.push("Mauricio");
       s.push("Helmuth");
       System.out.println(s.pop());
       System.out.println(s.pop());
   }
}

