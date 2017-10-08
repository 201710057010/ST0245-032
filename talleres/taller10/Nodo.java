
/**
 *clase para los Nodos del arbol binario
 *Eduard Damiam y Esteban Osorio 
 */
public class Nodo {
    public Nodo hijoIzq;
    public Nodo hijoDer;
    public String dato;
    
    public Nodo(String dato){
      this.dato = dato;
      hijoIzq= null;
      hijoDer= null;
    }

}
