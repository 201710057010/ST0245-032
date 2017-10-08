/**
 * Clase para implementar el arbol genealogico
 * Eduard Damiam y Esteban Osorio
 */
public class Main {
    
    public static void main(String []args){
        Arbol genealogico = new Arbol ("Wilkenson");
       
        genealogico.insertarIzq(new Nodo ("Wilkenson"),new Nodo ("Joaquina"));
        genealogico.insertarDer(new Nodo ("Wilkenson"),new Nodo("Sufranio"));
        genealogico.insertarIzq(new Nodo ("Joaquina"), new Nodo("Eustaquia"));
        genealogico.insertarDer(new Nodo ("Joaquina"), new Nodo ("Eustaquio"));
        genealogico.insertarIzq(new Nodo ("Eustaquia"),new Nodo ("Florinda"));
        genealogico.insertarDer(new Nodo ("Eustaquio"), new Nodo("Jovin"));
        genealogico.insertarIzq(new Nodo ("Sufranio"), new Nodo ("Piolina"));
        genealogico.insertarDer(new Nodo ("Sufranio"), new Nodo("Piolin"));
        genealogico.insertarIzq(new Nodo ("Piolina"), new Nodo ("Wilberta"));
        genealogico.insertarDer(new Nodo ("Piolin"), new Nodo("Usnavy"));
        
        genealogico.inOrden(genealogico.raiz);
        genealogico.dibujar(genealogico.raiz);
    }
}
