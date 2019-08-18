import ListClass.Iterator;

import java.util.Arrays;

public class MeArrayList implements List{
    private int[] array = null;
    private int size = 0;

    public void  ensureCapacity(){
        //1.判断是否需要扩容
        if(array != null && size < array.length){
            return;
        }
        //2.计算容量大小
        int capacity = 0;
        if(array == null){
            capacity = 10;
        }else{
            capacity = 2 * array.length;
        }
        //扩容
        if(array != null){
            array = Arrays.copyOf(array, capacity);
        }else{
            array = new int[capacity];
        }
    }

    @Override//尾插
    public boolean add(int element) {
       /* 第一种，自己手写
       ensureCapacity();
       if(array != null){
            array[size++] = element;
        }else{
            array[0] = element;
            size++;
        }
       return true;
        */
        //new MeArrayList().add(size - 1,element);
       // 第二种，调用add函数来完成
        return add(size,element);
    }

    @Override // 把数据插入到 index 下标处
    public boolean add(int index, int element) {
        //1.确保空间够用
        ensureCapacity();
        //2.确保下标正确
        if(index < 0 || index > size){
            System.out.println("错误");
            return false;
        }
        //移出插入位
        System.arraycopy(array, index ,array,index +1 ,size - index );
        //插入
        array[index] = element;
        //更变size
        size++;
        return true;
    }

    @Override
    public int get(int index) {
        //判断下标
        if(index < 0 || index > size){
            System.out.println("错误");
            return -1;
        }
        return array[index];
    }

    @Override
    public int set(int index, int val) {
        //判断下标
        if(index < 0 || index > size){
            System.out.println("错误");
            return -1;
        }

        return array[index] = val;
    }

    @Override//删除
    public int remove(int index) {
        if(index < 0 || index > size){
            System.out.println("错误");
            return -1;
        }

        System.arraycopy(array,index + 1 ,array,index,size - index - 1);

        array[--size] = 0;//把删除的点归零
        return 0;
    }

    @Override
    //返回size值
    public int size() {
        return size;
    }

    @Override
    //判断是否为空
    public boolean isEmpty() {
        /*if(size == 0){
            return true;
        }else{
            return false;
        }*/
        return size == 0;
    }

    private class MeArrayListIterator implements Iterator {
        //表示迭代器当前位置
        private int cur;

        //有参构造，给cur赋值
        private MeArrayListIterator(int cur){
            this.cur = cur;
        }

        @Override
        //判断迭代器是否走到了线性表最后
        public boolean hasNext() {
            return cur < size();
        }

        @Override
        // 1. 让迭代器往后走一步；2. 返回当前值
        public int next() {
            return array[cur++];
        }

        @Override
        // 删除当前迭代器代表的值
        public int remove() {
            new MeArrayList().remove(cur);
            return 0;
        }
    }

    @Override
    public Iterator iterator() {
        return new MeArrayListIterator(0);
    }

    public static void main(String[] args) {
        MeArrayList m = new MeArrayList();
        m.add(1);
        m.add(2);
        m.add(3);
        m.add(4);
        for(int i = 0; i < m.array.length; i++){
            System.out.printf("%d ",m.array[i] );
        }
        System.out.println();

        m.add(2,10);
        for(int i = 0; i < m.array.length; i++){
            System.out.printf("%d ",m.array[i] );
        }
        System.out.println();

        m.remove(2);
        m.remove(3);
        for(int i = 0; i < m.array.length; i++){
            System.out.printf("%d ",m.array[i]);
        }
    }



}
