package List;

public class List<T> implements IList<T> {
    private class Node<T> {
        T object;
        Node next;
        Node prev;

        public Node(T object){
            this.object = object;
            this.next = null;
            this.prev = null;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public List(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void insert(Object object, int position) {
        if(position < 0){
            throw new IndexOutOfBoundsException("Index was out of bound");
        }
        Node newNode = new Node(object);
        if(position == 0){
            if(head == null){
                head = tail = newNode;
                size++;
            }
            else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
                size++;
            }
        } else if(position == size){
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        } else {
            Node current = head;
            for (int i = 0; i < position -1; i++)
            {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            if(current.next != null){
                current.next.prev = newNode;
            }
            current.next = newNode;
            size++;
        }
    }

    @Override
    public void delete(int position) {
        if(position < 0){
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        if(position == 0){
            if(head == null){
                throw new IndexOutOfBoundsException("The list is empty");
            }
            else {
                head = head.next;
                head.prev = null;
                size--;
            }
        } else if (position == size) {
            if(tail.prev != null) {
                tail = tail.prev;
                tail.next = null;
            }
            else {
                tail = null;
                head = null;
            }
            size--;
        }
        else {
            Node currentNode = head;
            for(int i = 0; i < position; i++){
                currentNode = currentNode.next;
            }
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
            size--;
        }
    }

    @Override
    public T access(int position) {
        return null;
    }

    @Override
    public IList<T> append(IList<T> listOne, IList<T> listTwo) {
        return null;
    }
}
