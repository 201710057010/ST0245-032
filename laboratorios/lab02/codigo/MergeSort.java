import java.util.*;
/**
 * clase para ordenar un arreglo 
 * Eduard Damiam Londoño y Esteban Osorio
 */
public class MergeSort
{
    /**
     * main de la clase 
     * n es el tamaño de larreglo
     */
    
    static int n = 10000; 
    
    
    public static void main(String []args){
      System.out.println ("mergeSort de un tamaño "+ n + " es: " + tomarElTiempoParaN(n));
    }

    /**
     * este metodo recibe un arreglo y lo retorna ordenado
     * codigo basado en un codigo compartido en un canal de youtube
     * link del video: https://www.youtube.com/watch?v=78YazSSNDAw
     */
    public static int[] mergeSort (int [] num){
        int i;
        int j;
        int k;
        if (num.length>1){
           int izq= num.length/2;
           int der= num.length-izq;
           int numIzq[]= new int [izq];
           int numDer[]= new int [der];
           
           for (i=0;i<izq;i++){
              numIzq[i]=num[i];
            }
            
           for (i=izq;i<izq+der;i++){
             numDer[i - izq] = num[i];
            }
           
           numIzq= mergeSort(numIzq);
           numDer= mergeSort(numDer);
           i = 0;
           j = 0;
           k = 0;
           while (numIzq.length != j && numDer.length != k){
               if(numIzq[j]<numDer[k]){
                   num[i]=numIzq[j];
                   i++;
                   j++;
                }else {
                   num[i]= numDer[k];
                   i++;
                   k++;
                }
            
            }
           
            while (numIzq.length != j){
               num[i]= numIzq[j];
               i++;
               j++;
            }
            
            while (numDer.length != k){
                 num[i]= numDer[k];
                 i++;
                 k++;
            }
            
            return num;
        }
        return num;
    }
    
        /**
         * metodo que toma el tiempo que se tarda la ejecución de mergeSort
         * recibe la cantidad de elementos que tendra el array
         * retorna el tiempo de ejecución
         */
        public static long tomarElTiempoParaN(int n){
        int[] arreglo = crearUnArregloAleatorio(n);
        long startTime = System.currentTimeMillis();
        mergeSort(arreglo);
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
