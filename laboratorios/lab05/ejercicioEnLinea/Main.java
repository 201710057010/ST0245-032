import java.util.Scanner;
/**
 * 
 * Eduard Damiam y Esteban Osorio 
 */
public class Main
{ 
    public static void main(String [] args){
       Scanner input = new Scanner(System.in); // se crea el scanner para leer la entrada
       BinarySearchTree arbol = new BinarySearchTree(); // se crea un arbol   //C1
       System.out.println("inserte los valores en el arbol, inserte una letra para terminar"); //C2
       while(true){ //m
        try { 
            int n= input.nextInt(); // si el usuario mete un numero //C3
            arbol.insertar(n);// lo inserta al arbol  //O(log n)
        }
        catch (Exception e){
           break; // si no se inserta un numero se termina el ciclo  //C4
        }
        }
       PosOrden.posOrden(arbol); // se imprime en pos orden el arbol //O(n)
    }
}
