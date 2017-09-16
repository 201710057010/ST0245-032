import java.util.*;
/**
 * clase para ordenar un arreglo 
 * Eduard Damiam Londoño y Esteban Osorio
 */
public class InsertionSort
{
    /**
     * main de la clase 
     * n es el tamaño del arreglo
     */
    
    static int n = 1000;
    
    public static void main(String [] args){
      System.out.println ("insertionSort de un tamaño "+ n + "es: " + tomarElTiempoParaN(n));
    }

    /**
     * este metodo recibe un arreglo y lo retorna ordenado
     */
    public static int[] insertionSort(int [] num){
        int x=0;
        if (num.length <=1){
          return num;
        }
        for (int i=0; i< num.length-1;i++){
            for (int j=i;j< num.length-1;j++){
                if (num[j]<num[i]){
                    x= num [j];
                    num[j]= num[i];
                    num[i]= x;
                    }
            }
        }
        return num;
}
    
        /**
         * metodo que toma el tiempo que se tarda la ejecución de insertionSort
         * recibe la cantidad de elementos que tendra el array
         * retorna el tiempo de ejecución
         */
        public static long tomarElTiempoParaN(int n){
        int[] arreglo = crearUnArregloAleatorio(n);
        long startTime = System.currentTimeMillis();
        insertionSort(arreglo);
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
