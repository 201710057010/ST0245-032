
/**
 * Eduard Damiam Londoño y Esteban Osorio con colaboracion de Gonzalo Garcia
 */
public class PosOrden
{
    public static void posOrden(BinarySearchTree arb){
        posOrdenAux(arb.root);
    }
    
    private static void posOrdenAux(Node nodo){ //O(n)
        if(nodo.left != null){
            posOrdenAux(nodo.left); //O(n/2)
        }
        if(nodo.right != null){
            posOrdenAux(nodo.right); //O(n/2)
        }
        System.out.println(nodo.data);
    }
}
