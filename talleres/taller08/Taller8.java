import java.util.*;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
/**
 * Write a description of class Taller8 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Taller8
{   
    //Punto 1
    public static Stack<Integer> inversa (int[] stack){
       Stack<Integer> Stack = new Stack<Integer>();   
       for(int i = stack.length-1; i >= 0; i--){
           Stack.push(stack[i]);
        }
        return Stack;
    }
    //Punto 2
    /*public static void cola (Queue<String> queue){
        Queue<String> q = new LinkedList<String>();
        for(int i = 0; i < queue.length;i++){
            System.out.println("Atendiendo a"+ q.remove());
        }
        //...
    }*/
    public static void cola2 (String [] a){
        Queue<String> queue = new LinkedList<String>();
        for (int i=0;i<a.length;i++){
            queue.add(a[i]);
        }
        int b = queue.size();
        for (int i=0; i<b;i++){
            System.out.println("Atendiendo a "+ queue.remove());
        }
        }
    
    
    //notacion polaca
    public static int polaca  (String string){
        Stack <Integer> Stack = new Stack<Integer>();
        for (int i=0; i<string.length();i++){
            char a= string.charAt(i);
            if (a=='+' || a== '-' || a == '*' || a== '/'){
              if (Stack.size()<2){
                  System.out.println ("error no esta bien escrito");
                  return 0;
                }
                
              if (a == '+'){
                  int x= Stack.pop();
                  int y= Stack.pop();
                  Stack.push(x+y);
                }
              else if (a == '-'){
                  int x= Stack.pop();
                  int y= Stack.pop();
                  Stack.push(y-x);
                }
              else if (a == '*'){
                  int x= Stack.pop();
                  int y= Stack.pop();
                  Stack.push(x*y);
                }
              else if (a == '/'){
                  int x= Stack.pop();
                  int y= Stack.pop();
                  Stack.push(y/x);
                }
            }
            else {
              int c= Integer.parseInt(""+a);
              Stack.push(c);
            }
        }
        
        if (Stack.size()>1){
            System.out.println ("error esta mal escrito");
            return 0;
        }
        
        return Stack.pop();
    }
   
}

