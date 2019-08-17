import java.util.Arrays;

public class MeArrayList implements List{
    int[] array = null;
    int size = 0;

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
       /* if(array != null){
            ensureCapacity(array);
            array[size++] = element;
        }else{
            ensureCapacity(array);
            array = new int[]{element};
            size++;
        }*/
        new MeArrayList().add(size - 1,element);


        return false;
    }



    @Override // 把数据插入到 index 下标处
    public boolean add(int index, int element) {
        ensureCapacity(array);

        if(index < 0 || index > size){
            System.out.println("错误");
            return false;
        }


        //移位
        System.arraycopy(array, index ,array,index +1 ,size - index );

        array[index] = element;
        size++;
        return false;
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    @Override
    public int set(int index, int val) {
        return array[index] = val;
    }

    @Override//删除
    public int remove(int index) {
        if(index < 0 || index > size){
            System.out.println("错误");

        }

        System.arraycopy(array,index - 1 ,array,index,size - index);
        size--;
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    public static void main(String[] args) {
        MeArrayList m = new MeArrayList();
        m.add(1);
        m.add(1);
        m.add(1);
        m.add(1);
        for(int i = 0; i < m.array.length; i++){
            System.out.println(i);
        }
    }

}
