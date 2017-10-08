/**
 * clase para el arbol
 * Eduard Damiam y Esteban Osorio
 */
public class Arbol {
    Nodo raiz;

    public Arbol(String dato){
        Nodo a = new Nodo(dato);
        raiz = a;
    }

    public void insertarIzq (Nodo hijo, Nodo madre){
        if (raiz.hijoIzq == null){
            raiz.hijoIzq = madre;
        }
        else {
            insertarIzqAUX(raiz,hijo,madre);
        }
    }

    private void insertarIzqAUX (Nodo nodo, Nodo hijo,Nodo madre){
        if (nodo==null){
            return;
        }
        if (nodo.dato.equals(hijo.dato)){
            nodo.hijoIzq = madre;
            return;
        }
        if (nodo.hijoIzq == null && nodo.hijoDer == null){
            return;
        }
        insertarIzqAUX(nodo.hijoDer,hijo,madre);
        insertarIzqAUX(nodo.hijoIzq,hijo,madre);
    }

    public void insertarDer (Nodo hijo, Nodo padre){
        if (raiz.hijoDer == null){
            raiz.hijoDer = padre;
        }
        else {
            insertarDerAUX(raiz,hijo,padre);
        }
    }

    private void insertarDerAUX (Nodo nodo, Nodo hijo,Nodo padre){
        if (nodo == null){
            return;
        }

        if (nodo.dato.equals(hijo.dato)){
            nodo.hijoDer = padre;
            return;
        }

        if (nodo.hijoIzq == null && nodo.hijoDer == null){
            return;
        }
        insertarDerAUX(nodo.hijoIzq,hijo,padre);
        insertarDerAUX(nodo.hijoDer,hijo,padre);
    }

    public void inOrden(Nodo r){
        if (r != null){
            inOrden(r.hijoIzq);
            System.out.println (r.dato);
            inOrden(r.hijoDer);
        }
    }

    public void dibujar(Nodo r){
        if (r != null){
            if (r.hijoDer != null){ 
                System.out.println (r.dato+ " -> " + r.hijoDer.dato );
            }
            if (r.hijoIzq != null){
                System.out.println (r.dato+ " -> " + r.hijoIzq.dato );
            }
            dibujar(r.hijoIzq);
            dibujar(r.hijoDer);
        }
    }
}
