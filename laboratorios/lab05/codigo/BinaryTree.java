/**
 * Clase para los arboles Binarios 
 * Eduard Damiam Londoño y Esteban Osorio con colaboracion de Gonzalo Garcia 
 */

public class BinaryTree { 
    public Node root;

    public BinaryTree(String data){
        root = new Node (data);
    }
    
    /**
     * metodo auxiliar entregado por el profesor Mauricio para calcular la altura maxima
     * @return int - retorna el mayor de 2 numeros
     * @pram int i, j - recibe dos enteros para ser comparados
     */
    
    private int max2(int i, int j)  
    {
        if (i > j){
            return i;
        }
        return j;
    }
    
    /**
     * metodo auxiliar entregado por el profesor Mauricio para calcular la altura maxima
     * @return int - retorna el tamaño maximo de un nodo
     * @pram node - recibe un nodo que sera al que se le sacara la altura
     */

    private int maxheightAUX(Node node) 
    {
        if (node == null){
            return 0;
        }
        else {
            return max2(maxheightAUX(node.left), maxheightAUX(node.right))+1;
        }
    }

    /**
     * metodo entregado por el profesor para calcular la altura maxima
     * @return int - retorna el tamaño maximo del arbol
     */
    public int maxheight() 
    {
        return maxheightAUX(root);
    }

    /**
     * metodo auxiliar para imprimir de manera recursiva un arbol
     * @pram node- recibe el nodo desde el cual se empieza a imprimir
     */
    private void recursivePrintAUX(Node node)
    {
        if (node != null)
        {
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            System.out.println(node.data);
        }

    }
    
    /**
     * metodo para imprimir de manera recursiva un arbol
     */
    public void recursivePrint()
    {
        recursivePrintAUX(root);
    }
    
    /**
     * metodo para insertar un nodo a la izquierda 
     * @pram son,mother - recibe el nodo en el cual se insertara y el nodo que se va a insertara 
     */
    public void insertLeft(Node son,Node mother){
        if (root.left==null){
           root.left = mother;
        }
        else {
          insertLeftAux (root,son,mother);
        }
        
    }
    
    /**
     * metodo auxiliar para insertar un nodo a la izquierda
     * @pram son,mother, node - recibe un nodo desde el que se empezara a revisar, el nodo en el cual se insertara y el nodo que se va a insertar
     */
    private void insertLeftAux(Node node,Node son,Node mother){
      if(node==null){
         return;
          }
      else if (node.data.equals(son.data)){
         node.left = mother;
         return;
        }
      else if (node.left == null && node.right == null){
         return;
        }
      insertLeftAux(node.right,son,mother);
      insertLeftAux(node.left,son,mother);
    }
    
    /**
     * metodo para insertar un nodo a la derecha
     * @pram son-father, recibe el nodo en el cual se insertara y el nodo que se va a insertar
     */
    public void insertRight (Node son, Node father){
        if (root.right == null){
            root.right = father;
        }
        else {
           insertRightAux(root,son,father);
        }
      }
      
    /**
     * metodo auxiliar para insertar un nodo a la derecha
     * @pram son,mother, node - recibe un nodo desde el que se empezara a revisar, el nodo en el cual se insertara y el nodo que se va a insertar
     */  
    private void insertRightAux (Node node, Node son,Node father){
        if (node == null){
          return;
        }
        
        else if (node.data.equals(son.data)){
           node.right= father;
           return;
        }
        else if (node.left== null && node.right == null){
          return;
        }
        
        insertRightAux(node.left,son,father);
        insertRightAux(node.right,son,father);
    }
    
    /**
     * metodo para buscar la abuela materna
     * @pram name, recibe el nombre de la persona a la que le buscaremos su abuela materna
     */
    
    public String searchGrandma (String name){
       Node node = search(root,name);
       String a = node.data;
       if (node == null){
           return "";
        }
       else {
           if (node.left != null){
              node = node.left;
              if (node.left != null){
                 return  node.data;
                }
              
              else {
                 return "";
                }
            }
           else {
             return "";
            }
        } 
    }
    
    /**
     * metodo para buscar un nodo de manera recursiva
     * @pram r,name - se recibe el nodo desde el que se empezara a buscar y el dato que se quiere buscar
     */
    public Node search(Node r,String data){
      if (r != null){
          if (data.equals(r.data)){
              return r;
            }
          else {
             search(r.left,data);
             search(r.right,data);
            }
        }
       return null; 
    }
}
