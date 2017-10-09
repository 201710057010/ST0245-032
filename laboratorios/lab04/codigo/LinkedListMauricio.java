import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada
public class LinkedListMauricio {
    private Node first;
    private int size;
    public LinkedListMauricio()
    {
        size = 0;
        first = null;	
    }

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     */
    public int get(int index) {
        Node temp = null;
        try {
            temp = getNode(index);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.exit(0);
        }

        return temp.data;
    }

    /**
     * Returns the actual size of the list
     * @return the actual size of the list
     */
    public int size()
    {
        return size;
    }

    /**
     * Insert a date in the index position 
     * @param index and data 
     */
    public void insert(int data, int index) throws IndexOutOfBoundsException
    {
        Node nodo = new Node (data);
        Node tmp= null;
        if (index == 0 ){
            if (first == null){
                first= nodo;
                size = 1;
            }
            else {
                first.data= data;
            }
        }
        else if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        else if (index == size){
            tmp =  first;
            tmp = getNode(index-1);
            if (index == size){
                tmp.next= nodo;
                size++;
            }
            else {
                tmp.data= data;
            }
        }
    }  

    /**
     * remove a Node in a index position
     * @parm index
     */
    public void remove(int index)throws IndexOutOfBoundsException
    {
        if (index ==0){
          first = first.next;
          size--;
        }
        
        else if (size <= 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        else {
            Node tmp = getNode(index-1);
            if (tmp.next == null){
                throw new IndexOutOfBoundsException ();
            }
            else {
                if (index +1 >= size || getNode(index+1) == null){
                    tmp.next = null;
                }
                else {
                    tmp.next = getNode(index+1);
                }
                size --;
            }
        }
    }

   /**
    * return true if the element data is in the list or false if isn´t in the list 
    */
    public boolean contains(int data)
   {
        Node temp = first;
        for(int i = 0; i < size; i++){
            if(temp.data == data){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    }


