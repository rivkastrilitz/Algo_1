import java.util.Stack;

public class Node {

    private char data;
    private Node prev;
    private Node next;
    private int num;
    Stack<Integer> st;
    public Node(char data,Node prev,Node next){
        this.data=data;
        this.prev=prev;
        this.next=next;
    }
    public Node(int n){
        this.num=n;
        st=new Stack<>();
    }

    public char getData(){
        return this.data;
    }

    public void setData(char d){
        this.data=d;
    }

    public Node getPrev(){
        return this.prev;
    }

    public void setPrev(Node p){
        this.prev=p;
    }

    public Node getNext(){
        return this.next;
    }

    public void setNext(Node n){
        this.next=n;
    }

    public int getNum() {
        return this.num;
    }

    public Stack<Integer> getSt() {
        return this.st;
    }
}
