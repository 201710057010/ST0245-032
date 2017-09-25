/**
 * Eduard Damiam Londoño
 * Esteban Osorio
 */

import java.util.*;

public class Laboratorio3 {
    /**
     * la clase Almacen y la clase Solicitudes son para el punto 1.4
     */
    public static class Almacen {
        public int codigo;
        public String descripcion;

        public Almacen (int a, String b){
            codigo= a;
            descripcion= b;
        }
    }

    public static class Solicitudes {
        public String nombre;
        public int solicitud;

        public Solicitudes (String a, int b){
            nombre = a;
            solicitud = b;
        }
    }

    /**
     * retorna el producto de los elementos de la lista. 
     * @recibe una lista.
     * @retorna un entero.
     */
    public static int multiply(List<Integer> list) {
        int res = 1;
        for(int i = 0; i < list.size();i++){
            res = res * list.get(i);
        }
        return res;
    }
    
    /**
     * inserta datos no repetidos
     * @ recibe una lista y el dato 
     * @retorna una lista
     */

    public static List smartInsert(List<Integer> l, int data){
        boolean verif = true;

        for(int i = 0; i < l.size(); i++){
            if(l.get(i) == data){
                verif = false;
            }
        }

        if(verif){
            l.add(data);
        }

        return l;
    }

    /**
     * calcula la posicion optima para colocar un pivote
     * @recibe una lista
     * @retorna un entero
     */
    public static int pivote (List <Integer> l){
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        for (int i=0; i<l.size()-1;i++ ){
            d = 0;
            if (i == 0){
                for (int h = 0; h<l.size(); h++){
                    b= b+l.get(h);    
                }
            }
            else {
                c = c+ l.get(i-1);
                for (int j=i+1; j<l.size(); j++){
                    d = d+l.get(j);
                }
                if (Math.abs(c-d)<b){
                    a= i;
                    b= Math.abs(c-d);
                }
            }
        }
        return a;
    }
    
    /**
     * imprime las tiendas con sus respectivas neveras 
     * @recibe 2 listas una de tipo Almacen  y otra de tipo Solicitudes
     * @no retorna nada
     */

    public static void neveras(List <Almacen> A,List <Solicitudes> T){
        int cont =0;

        for (int i=T.size()-1;i>=0;i--){
            Solicitudes Solicitud = T.get(i);
            int c= Solicitud.solicitud;
            int x=0;
            for (int j= A.size()-(1+cont);c>0;c--){
                Almacen nevera= A.get(j-x);
                System.out.println(Solicitud.nombre + " : " + nevera.codigo + " " + nevera.descripcion);
                cont++;
                x++;
            }
        }
    }

    /**
     * Tests the methods.
     * @param args
     */
    public static void main(String[] args) {
        LinkedList<Integer> linked = new LinkedList<>();
        linked.addAll(Arrays.asList(new Integer[] {1, 3, 5, 7}));

        ArrayList<Integer> array = new ArrayList<>();
        array.addAll(Arrays.asList(new Integer[] {10,20,5,3,20,10}));

        ArrayList<Almacen> almacenes = new ArrayList <>();
        almacenes.add(new Almacen (1,"haceb"));
        almacenes.add(new Almacen (2,"LG"));
        almacenes.add(new Almacen (3,"IBM"));
        almacenes.add(new Almacen (4,"haceb"));
        almacenes.add(new Almacen (5,"LG"));
        almacenes.add(new Almacen (6,"IBM"));
        almacenes.add(new Almacen (7,"haceb"));
        almacenes.add(new Almacen (8,"LG"));
        almacenes.add(new Almacen (9,"IBM"));
        almacenes.add(new Almacen (8,"LG"));
        almacenes.add(new Almacen (9,"IBM"));
        // Multiply

        ArrayList<Solicitudes> listSolicitudes = new ArrayList<>();
        listSolicitudes.add(new Solicitudes("eafit",10));
        listSolicitudes.add(new Solicitudes("la14",2));
        listSolicitudes.add(new Solicitudes("olimpica",4));
        listSolicitudes.add(new Solicitudes("exito",1));

        neveras(almacenes,listSolicitudes);
        System.out.println(multiply(linked));
        System.out.println(multiply(array));
        System.out.println(pivote(array));
        System.out.println(smartInsert(array,7));

    }
}