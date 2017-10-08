
/**
 * Write a description of class MyCola here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Queue;
import java.util.LinkedList;
public class MyCola{
    public static void colas(){
        Queue<Integer> q = new LinkedList();
        q.add(1);
        q.add(2);
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
