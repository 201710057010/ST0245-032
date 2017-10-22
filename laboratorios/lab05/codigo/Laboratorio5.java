/**
 * Eduard Damiam Londoño y Esteban Osorio con colaboracion de Gonzalo Garcia
 * clase para probar el arbol 
 */

public class Laboratorio5 {

   public static void dibujarArbol(BinaryTree a)
   {
       System.out.println("/* arbolito para http://www.webgraphviz.com/ */"); 
       System.out.println("digraph arbolito {");
       System.out.println("size=\"6,6\";");
       System.out.println("node [color=aquamarine, style=filled];");
       dibujarArbolAux(a.root);
       System.out.println("}");
   }
   
   public static void dibujarArbolAux(Node nodo)
   {
      if (nodo != null)
         //"x_\n__" -> "xo\n__";
         for(Node n: new Node[] {nodo.left, nodo.right} ){
            if (n != null)
               System.out.println("\"" + nodo.data + "\" -> \"" + n.data + "\";");
            dibujarArbolAux(n);
        }
   }

    
    public static void main(String[] args) {
    
        //Crea el árbol familiar
        BinaryTree tree = new BinaryTree("Damiam");
        // ...
        Node Damiam = new Node ("Damiam");
        Node Eduard = new Node ("Eduard");
        Node Gladis = new Node ("Gladis");
        Node Juan = new Node ("Juan");
        Node Angel = new Node ("Angel");
        Node Gabriela = new Node ("Gabriela");
        Node Sandra = new Node ("Sandra");
        Node Manuel = new Node ("manuel"); 
        Node Emilia = new Node ("Emilia"); 
        Node JuanJ = new Node ("Juan"); 
        Node Clarisa = new Node ("Clarisa");
        Node Rosaelia = new Node ("Rosaelia");
        Node Francisco = new Node ("Francisco");
        Node Laura = new Node ("Laura"); 
        Node Ruben = new Node ("Ruben");
        
        tree.insertLeft(Damiam,Eduard);
        tree.insertRight(Damiam,Gladis);
        tree.insertLeft(Eduard,Juan);
        tree.insertRight(Eduard,Sandra);
        tree.insertLeft(Gladis,Angel);
        tree.insertRight(Gladis,Gabriela);
        tree.insertLeft(Angel,Manuel);
        tree.insertRight(Angel,Emilia);
        tree.insertLeft(Juan,JuanJ);
        tree.insertRight(Juan,Clarisa);
        tree.insertLeft(Sandra,Francisco);
        tree.insertRight(Sandra,Rosaelia);
        tree.insertLeft(Gabriela,Ruben);
        tree.insertRight(Gabriela,Laura);
        //Imprime el árbol familiar
        tree.recursivePrint();
        System.out.println();
        //Dibuja el árbol familiar
        dibujarArbol(tree);
    }
}
