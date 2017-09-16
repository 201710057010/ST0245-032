import java.util.*;
/**
 * Esta clase imprime el tiempo de ejecución de la suma de un array aleatorio
 * @Eduard Damiam
 * @Esteban Osorio
 * @0.01
 */
public class ArraySum
{
    /**
     * Main de la clase que imprime el tiempo
     * n es el tamaño del array
     */
    
    static int n = 10000;
    
    public static void main(String [] args){
            System.out.println("suma de arrays de tamaño " + n +" tarda : "+ tomarElTiempoParaN(n)+ " milisegundos");
    }

    /**
     * metodo que suma los elementos de un array de forma recursiva
     * codigo basado en un codigo de C encontrado en http://www.jgutierrezgil.es/2009/12/10/suma-de-los-elementos-de-un-vector-de-forma-recursiva-en-c/
     * recibe un array y la cantidad de elementos ue tiene el array
     * retorna el resultado de la suma de todos los elementos
     */
    public static int arraySum(int[] A,int n) {
        int r=0;
        if (n==0){
            r+= A[0];
        }
        else {
          r= A[n]+arraySum (A,n-1);
        }
        return r;
    } 

    /**
     * metodo que toma el tiempo que se tarda la ejecución de la suma de los elementos del array
     * recibe la cantidad de elementos que tendra el array
     * retorna el tiempo de ejecución
     */
    public static long tomarElTiempoParaN(int n){
        int[] arreglo = crearUnArregloAleatorio(n);
        long startTime = System.currentTimeMillis();
        arraySum(arreglo,arreglo.length-1);
        long estimatedTime = System.currentTimeMillis() - startTime;
        return estimatedTime;
    }

    /**
     * mtodo que crea un array aleatorio
     * recibe la longitud del array
     * retorna el array creado
     */
    public static int[] crearUnArregloAleatorio(int n){
        int max = 5000;
        int[] array = new int[n];
        Random generator = new Random();
        for (int i =0; i<n; i++){
            array[i] = generator.nextInt(max);
        }
        return array;
    }
}