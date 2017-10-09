import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedListMauricioTest {

    @Test
    public void testInsert() {
        LinkedListMauricio list = new LinkedListMauricio();
        list.insert(1, 0);
        list.insert(2, 1);
        list.insert(3, 2);
        list.insert(4, 3);
        list.insert(5, 4);
        for (int i = 0; i < list.size(); i++)
        {
            assertEquals(list.get(0),1);
            assertEquals(list.get(1),2);
            assertEquals(list.get(2),3);
            assertEquals(list.get(3),4);
            assertEquals(list.get(4),5);            
        }       
    }

    @Test
    public void testRemovePrimero() {
        LinkedListMauricio list = new LinkedListMauricio();
        list.insert(1, 0);
        list.insert(2, 1);
        list.insert(3, 2);
        list.insert(4, 3);
        list.insert(5, 4);
        assertTrue(list.contains(1));
        list.remove(0);
        assertFalse(list.contains(1));
    }

    @Test
    public void testRemoveUltimo() {
        LinkedListMauricio list = new LinkedListMauricio();
        list.insert(1, 0);
        list.insert(2, 1);
        list.insert(3, 2);
        list.insert(4, 3);
        list.insert(5, 4);
        assertTrue(list.contains(5));
        list.remove(4);
        assertFalse(list.contains(5));
    }
    
    @Test
    // en este test debe sacar error, porque no se puede borrar un elemento que no existe
    public void testRemoveVacio() {
        LinkedListMauricio list = new LinkedListMauricio();
        list.remove(0);
    }

    
    @Test
    public void testContains() {
        LinkedListMauricio list = new LinkedListMauricio();
        list.insert(5, 0);
        list.insert(4, 1);
        list.insert(3, 2);
        list.insert(2, 3);
		list.insert(1, 4);
		assertTrue(list.contains(3));
		assertFalse(list.contains(10));
	}

}
