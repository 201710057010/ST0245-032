/**
 * arbol binario
 * Eduard Damiam Londoño Garcia y Esteban Osorio 
 * codigo basado en el codigo de :
 * https://www.youtube.com/watch?v=ZKnwBJ8q2TE&list=PLCLpAU8VN0j4RGemFfybZrWoSX57NbEq9&index=34
 */

public class BinaryTree {
    class Node { // clase nodo para guardar los datos
        public Node left;
        public Node right;
        public int data;
        public Node(int d){ 
            data = d;
        }
    }
    private Node root;
     
    public BinaryTree (){ 
      root = null; 
    }
    
    private boolean buscar(Node nodo, int n){ // metodo auxiliar para buscar un nodo 
        if (nodo == null){ // si no encuentra el nodo es null retorna false
            return false;
        }
        
        if (nodo.data == n){ // si el nodo contiene el dato necesitado retorna true
           return true;
        }
            
        if (n < nodo.data){ // si n es menor al dato del nodo actual busca en la rama izquierda
            return buscar(nodo.left, n);
        }
            
        return buscar(nodo.right, n); // si n no es menor busca en la rama derecha
    }
    
    public boolean buscar(int n){ // metodo para buscar
        return buscar(root, n);
    }
    
    public void insertar (int data){ // metodo para insertar 
        Node nodo = new Node(data); // crea el nodo que se va a insertar 
        if (root == null){ // si la raiz es null se inserta el dato en la raiz
            root = nodo;
        }
        else {
          Node aux = root;
          Node a;
          while (true){// si la raiz no es null se recorren las ramas del arbol hasta llegar a la hoja 
             a= aux;
              if (data<aux.data){ // si el dato es menor al que se encuentra en el nodo actual, se empieza a recorrer la rama izquierda
                  aux = aux.left;
                  if (aux==null){
                     a.left= nodo;
                     break;
                    }
                }
              else {// si el dato no es menor se empieza a recorrer la rama derecha
                  aux = aux.right; 
                  if (aux == null){
                     a.right = nodo;
                     break;
                    }
                }
            }
        }
    }
    
    public void borrar(int n){
       Node aux = root;
       Node padre = root;
       boolean esIzq = true;
       while (aux.data!=n){ // mientras el dato en el nodo auxiliar sea distinto al que buscamos recorremos el arbol
          padre = aux;
          if (n<aux.data){ // si n es menor al dato del nodo actual recorre la rama izquierda y esIzq es true
             esIzq = true;
             aux = aux.left; 
            }
          else {// si n no es menor recorre la rama derecha y esIzq es falsa
             esIzq= false;
             aux = aux.right;
            }
          if (aux == null){ // si aux es igual a null se acaba el metodo porque no encontro el dato necesitado 
             return;
            }
        }
       if (aux.left == null && aux.right == null){ // si aux es una hoja 
          if (aux == root){ // y es la raiz, la raiz se vuelve null
             root = null;
            } 
          else if (esIzq){ // o si es una rama izquierda se borra desde su nodo padre
             padre.left=null;
            }
          else { 
             padre.right= null; // o si es una rama derecha se borra tambien 
            }
        }
       else if (aux.right== null){ // si aux no tiene rama derecha
         if (aux == root){ // y es la raiz, la raiz se hace igual a la rama izquierda de aux
             root = aux.left;
            } 
          else if (esIzq){// o si es una rama izquierda se hace la rama izquierda de su nodo padre igual a su propia rama izquierda
             padre.left=aux.left;
            }
          else { //o si es una rama derecha se hace la rama derecha de su nodo padre igual a su propia rama izquierda
             padre.right= aux.left;
            }
        }
       else if (aux.left== null){ //si aux no tiene rama izquierda 
          if (aux == root){ // y aux es la raiz la raiz se hace igual a la rama derecha de aux 
             root = aux.right;
            } 
          else if (esIzq){ // o si es una rama izq, se hace la rama izquierda de su nodo padre igual a su propia rama derecha
             padre.left=aux.right;
            }
          else {//o si es una rama derecha se hace la rama derecha de su nodo padre igual a su propia rama derecha 
             padre.right= aux.right;
            }
        }
       else {// si el nodo tiene 2 hijos entonces 
          Node nodo = obtNodo(aux);  // se guarda el nodo que reemplazara al altual
          if (aux == root){ // si es una raiz, se hace la raiz igual al nodo
             root = nodo;
            }
          else if (esIzq){// si es un hijo izq o der se cambiar por el nodo (los ifs es para saber cuando es der o cuando es izq)
             padre.left= nodo;
            }
          else {
             padre.right=nodo; 
            }
          nodo.left = aux.left; // la rama izquierda de aux pasa a ser la rama izquierda de nodo
        }
        }
      
     private Node obtNodo(Node aux ){ // metodo para obtener el nodo que servira de reemplazo
           Node rempPadre = aux; 
           Node rem = aux;
           Node nodo = aux.right;
           
           while (nodo != null){ // mientras nodo sea distinto de null se recorren los hijos del nodo
              rempPadre= rem;
              rem = aux;
              nodo = nodo.right;
            }
            
           if (rem!=aux.right){ // si rem es distinto a la rama derecha de aux se organiza
             rempPadre.left = rem.right;
             rem.right=aux.right;
            }
           
           return rem;  // se retorna rem como nodo que servira de remplazo
        }
    }
    
