import java.util.Random;

public class MyHashBucket {

    private static class Node{
        private int key;
        private int value;
        private Node next;
    }

    private Node[] array;
    private int size;

    public MyHashBucket(){
        array = new Node[8];
        size = 0;
    }

    //搜索
    public int get(int key){
        int index = key % array.length;
        Node head = array[index];
        Node cur = head;
        while(cur != null){
            if(key == cur.key){
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }

    //插入/更改
    public int put(int key, int value){
        int index = key % array.length;
        Node head = array[index];
        Node cur = head;
        while(cur != null){
            if(key == cur.key){
                int oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }
            cur = cur.next;
        }
        Node node = new Node();
        node.key = key;
        node.value = value;

        array[index] = node;
        node.next = head;
        size++;

        //扩容
        if((double)size / array.length > 0.75){
            resize();
        }

        return -1;
    }

    private void resize() {
        Node[] newArray = new Node[array.length * 2];
        //因为改变了容量，hash里面的元素下标会变化，
        for(int i = 0; i < array.length; i++){
            Node head = array[i];
            Node cur = head;
            while(cur != null){
                int index = hashFunction(cur.value, newArray.length);
                Node node = new Node();
                node.value = cur.value;
                node.key = cur.key;
                node.next = newArray[index];
                newArray[index] = node;

                cur = cur.next;
            }
        }
        array = newArray;
    }

    private int hashFunction(int value, int length) {
        return value % length ;
    }

    //删除
    public int remove(int key){
        int index = key % array.length;
        Node head = array[index];
        Node cur = head;
        Node prev = null;
        while(cur != null){
            if(cur.key == key) {
                int oldValue = cur.value;
                if (cur == head) {
                    array[index] = cur.next;
                } else {
                    prev.next = cur.next;
                }
                size--;
                return oldValue;
            }
            prev = cur;
            cur = cur.next;

        }
        return -1;
    }

    public static void main(String[] args) {
        MyHashBucket map = new MyHashBucket();
        Random random = new Random(20190912);
        for (int i = 0; i < 5; i++) {
            //int r = random.nextInt(100);
            System.out.println(random.nextInt(52));
            //map.put(r, r + 1000);
        }



        map.remove(26);
        map.remove(45);
        map.remove(0);
        map.remove(1);
        System.out.println("Success");

    }

}
