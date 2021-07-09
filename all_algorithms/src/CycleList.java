public class CycleList {

    public Node head, tail;
    public int size;

    // Constructor, constructs an empty list
    public CycleList() {
        head = tail = null;
        size = 0;
    }


    // Appends the specified element to the end of this list.
    public void add(char obj) {
        if (head == null) {
            head = new Node(obj, null, null);
            tail = head;
            head.setNext(tail);
            head.setPrev(tail);
        } else {
            Node n = new Node(obj, tail, head);
            tail.setNext(n);
            tail = n;
            head.setPrev(tail);
        }
        size++;
    }

    public Node getHead() {
        return head;
    }

    public Node getNext(Node n) {
        return n.getNext();
    }

    public void setHead(Node n){
        this.head=n;
    }
    public void setTail(Node t){
        this.tail=t;
    }

    public String toString() {
        String s = "[";
        if (head != null) {
            s = s + head.toString() + ", ";
            for (Node n = head.getNext(); n != head; n = n.getNext()) {
                s = s + n.toString() + ", ";
            }
            s = s.substring(0, s.length() - 2);
        }
        return s + "]";
    }
}
