import java.util.*;

/**
 * Eduard Damiam Londoño
 * Esteban Osorio
 */
public class EjercicioOnline
{
   public static void main (String [] args){
      Scanner input= new Scanner (System.in); // C1
      String consola; //C2
      
      while((consola=input.nextLine())!=null){ //C3
         LinkedList<Character> lista = new LinkedList<>(); //C4
         int index=0; //C5
         for (char c: consola.toCharArray()){ //O(n)
            if (c=='['){ //C7
              index=0; //C8
            }
            else if (c== ']'){ //C9
              index= lista.size(); //C10
            }
            else { 
              lista.add(index++,c); //C11
            }
            }
         StringBuilder string = new StringBuilder(); //C12
         for (char c: lista){ //O(m)
              string.append(c); //C13
            }
          System.out.println(string.toString()); //C14   
    }
    
    }


}
