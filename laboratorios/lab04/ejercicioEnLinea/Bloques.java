import java.io.*;
import java.util.*;

/**
 * Esteban Osorio y Eduard Damiam
 * Codigo basado en el del siguiente link:
 * https://github.com/AhmedHani/Online-Judges-Problems-SourceCode/blob/master/UVa/101%20-%20The%20Blocks%20Problem.java
 */

public class Bloques{
    public static int numeroBloques; // atributo para manejar la cantidad de bloques
    public static Stack <Integer> bloques[];
    public static int posicion[];
    public static String linea;
    public static int A,B;

    public static void main (String[] args) throws IOException{
        Scanner Input = new Scanner(System.in);
        numeroBloques = (Input.nextInt());
        bloques = new Stack[numeroBloques];
        posicion = new int [numeroBloques];
        for (int i = 0; i< numeroBloques; i++){
            bloques[i] = new Stack<Integer>();
            bloques[i].push(i);
            posicion[i]= i;
        }

        linea = "";
        while (!(linea=Input.nextLine()).equals("quit")){
            StringTokenizer token = new StringTokenizer(linea);
            String primero= token.nextToken();
            A = Integer.parseInt(token.nextToken());
            String segundo = token.nextToken();
            B = Integer.parseInt(token.nextToken());

            if (A==B  || posicion[A] == posicion[B]){
                continue;
            }

            if (primero.equals("move")){
                if (segundo.equals("onto")){
                    MoveOnto(A,B);
                }
                else if (segundo.equals("over")){
                    MoverOver(A,B);
                }
            }
            else if (primero.equals("pile")){
                if (segundo.equals("onto")){
                    PileOnto(A,B);
                }
                else if (segundo.equals("over")){
                    PileOver(A,B);
                }
            }
        }
        for (int i=0; i<bloques.length; i++){
            System.out.println(Solve(i));
        }

    }

    public static void MoveOnto(int primero,int segundo){
        limpiar(segundo);
        MoverOver(primero,segundo);
    }

    public static void MoverOver(int primero, int segundo) {   
        limpiar(primero);
        bloques[posicion[segundo]].push(bloques[posicion[primero]].pop());
        posicion[primero] = posicion[segundo];
    }

    public static void PileOnto(int primero,int segundo){
       limpiar(segundo);
       PileOver(primero,segundo);
    }
    
     public static void PileOver(int primero, int segundo) {
       Stack<Integer> Pila = new Stack<Integer>();
       while(bloques[posicion[primero]].peek() != primero) {
           Pila.push(bloques[posicion[primero]].pop());
       }
       Pila.push(bloques[posicion[primero]].pop());
       while(!Pila.isEmpty()) {
          int Tmp = Pila.pop();
          bloques[posicion[segundo]].push(Tmp);
          posicion[Tmp] = posicion[segundo];
       }
    }
    
    public static void limpiar(int bloque){
     while (bloques[posicion[bloque]].peek() != bloque){
         intial(bloques[posicion[bloque]].pop());
        }
    }
    
    public static void intial(int bloque){
       while(!bloques[bloque].isEmpty()) {
           intial(bloques[bloque].pop());
        }
        bloques[bloque].push(bloque);
        posicion[bloque] = bloque;
    }
    
      public static String Solve(int Index) {
        String Result = "";
        while(!bloques[Index].isEmpty()) {
         Result = " " + bloques[Index].pop() + Result;
         Result = Index + ":" + Result;
        }
        return Result;
    }
}