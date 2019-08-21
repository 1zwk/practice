/**
 * 自己实现一个虚拟栈
 */
public class MyStack {
    private int size = 0;
    private int[] array = new int[10];

    public void ensureCapacity(){
        if(size > array.length){
            int newCapacity = array.length + array.length/2;
            int[] newArray = new int[newCapacity];
            for(int i = 0; i< size; i++){
                newArray[i] = array[i];
            }
            this.array = newArray;
        }
    }

    public boolean empty(){
        return size == 0;
    }

    public int push(int x){
        ensureCapacity();
        array[size++] = x;
        return x;
    }

    public int peek(){
        return array[size - 1];
    }

    public int pop(){
        return array[--size];//最后面一个数下标是size-1；
    }

    public int size(){
        return size;
    }

    public int search(int element){
        for(int i = 0; i< size; i++){
            if(array[i] == element){
                return i;
            }
        }
        return -1;
    }


}
