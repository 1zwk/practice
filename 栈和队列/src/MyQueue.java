/**
 * 自己实现一个虚拟队列
 */
public class MyQueue {
    private static class Node{
        private int val;
        private Node next = null;


        public Node() {
            this.val = val;
            this.next = next;
        }
    }

    private Node front = null;
    private Node rear = null;
    private int size = 0;

    public boolean add(int element){
        if(rear == null){
            front = rear = new Node();
        }else {
            rear.next = new Node();
            rear = rear.next;
        }
        return true;
    }

    public int element(){
        return front.val;
    }

    public int remove(){
        int n = front.val;
        front = front.next;

        size--;
        return n;
    }

    public int size(){
        return size;
    }

    public boolean empty(){
        return size == 0;
    }





}
