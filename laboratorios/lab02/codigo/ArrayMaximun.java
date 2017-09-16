import java.util.*;
/**
 * clase para calcular el elemento mas grande de un arreglo
 * 
 * Eduard Damiam Londoño y Esteban Osorio
 */
public class ArrayMaximun
{

    /**
     * Main de la clase que imprime el tiempo
     * n es el tamaño del arreglo
     */
    
    static int n = 10000000;
    
    public static void main(String [] args){
        System.out.println("arrayMaximun de un tamaño "+ n +" tarda : "+ tomarElTiempoParaN(n)+ " nanosegundos");
    }

    /**
     * metodo que calcula el elemento maximo de un arreglo
     * recibe el arreglo, un n que servira de indice y un max para guardar el valor maximo
     */
    public static int arrayMaximum(int[] A,int n, int max) {
        if (n==0){
            return max;
        }
        else {
            if (max<A[n]){
                max=A[n];
            }
            return arrayMaximum(A,n-1,max);
        }
     } 

    /**
     * metodo que toma el tiempo que se tarda la ejecución arrayMaximum
     * recibe la cantidad de elementos que tendra el array
     * retorna el tiempo de ejecución
     */
    public static long tomarElTiempoParaN(int n){
        int[] arreglo = crearUnArregloAleatorio(n);
        long startTime = System.currentTimeMillis();
        arrayMaximum(arreglo,arreglo.length-1,0);
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