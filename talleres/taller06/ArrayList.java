import java.util.Arrays;
/**
 * clase que improvisa un arrayList
 * 
 * @Eduard Damiam
 * @version 1.0
 */
public class ArrayList
{
    private int size;
    private static final int DEFAULT_CAPACITY=10;
    private int elements[];

    // contructor de la calse
    public ArrayList(){
        this.size=0;
        this.elements=  new int [DEFAULT_CAPACITY];
    }

    // metodo que devuelve el tamaño del array
    public int getSize (){
        size=elements.length;
        return size;
    }
    
    // metodo que añade un valor en la ultima posicion del array
    public void addFinal(int e){
        size=elements.length;
        if (elements[size-1]!=0){
            copiarArray();
            addFinal(e);
        }    

        if (elements[size-1]==0){
            elements[size-1]=e;    
        }
    }

    public void addPosicion (int index,int e){
        // size se inicia con el valor del tamaño del array
        size=elements.length;  
        // se mira si la posicion es menor o igual al tamaño del array
        if (index<=size-1){
            // en caso de que si, se mira si el valor que hay en la posicion es cero, 
            //si lo es entonces la posicion esta vacio y se pone el valor
            if (elements[index]==0){
                elements[index]=e;
            }
            // si el valor en la posicion no es cero entonces se mueven todos los elmentos
            else {
                // i se inicia como el tamaño del array-1
                int i=size-1;
                // x es el tamaño del array (se necesitara para el ultimo elemento)
                int x=size;
                // se mete el ultimo elemento del array en una variable
                int a= elements[i];
                // se copia el array, ya que hay que hacerlo mas grande
                copiarArray();
                // el ciclo empieza desde el ultimo elemento del array hasta la posicion
                // y va cambiando los valores, de adelante hacia atras
                while (i>index){
                    elements[i]=elements[i-1];
                    i--;
                }
                // se pone el valor deseado en la posicion deseada
                elements[index]=e; 
                // se pone el valor que estaba en la ultima posicion en su nueva posicion
                elements[x]=a;
            }  
        }
        else {
            // si no es igual o menor, se ejecuta el metodo para poner el valor en el final del array
            addFinal(e);
        }
    }

    // metodo que devuelve el valor en la posicion i del array
    public int getElement (int i){
        return elements[i];
    }

    // metodo que crea un array mas grande y pasa los valores del array antiguo
    private void copiarArray (){
        size= elements.length;
        elements=Arrays.copyOf(elements,size*2);
    }

}
