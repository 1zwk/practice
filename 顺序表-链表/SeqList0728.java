import java.util.Arrays;

public class SeqList0728{
	private int[] array;
    private int size;

    SeqList0728(){
		array = new int[20];
		this.size = size;
	}	
	
	//扩容
    private void ensureCapacity(){
		if(size < array.length){
			return;
		}
	    int newArrayLength = array.length + array.length/2;
		int[] newArray = new int[newArrayLength];
		for(int i = 0; i < array.length; i++){
			newArray[i] = array[i];
		}
		this.array = newArray;
	}
	
	//头插
	public void putFront(int element){
		ensureCapacity();
		if(size == 0){
			putEnd(element);
		}
		//插入，遍历从后往前，
		//找到遍历的次数，开始和结尾
		//array[空间] = array[数据]；空间一般比数据大1
		//调整size
		for(int i = size - 1; i >= 0; i--){
			array[i+1] = array[i]; 
		}
		array[0] = element;
		size++;
		
	}
	
	//尾插
	public void putEnd(int element){
		ensureCapacity();
		array[size++] = element;
		
	}
	
	//随机插入
	public void insert(int index, int element){
		if(index < 0 || index > size){
			System.out.println("下标错误");
			return;
		}	
		ensureCapacity(); 
		for(int i = size-1; i >= index; i--){
			array[i+1] = array[i];
		}
		array[index] = element;
		size++;
	}

    //头删
	public void deleteFront(){
		if(size == 0){
			System.out.println("空表无法删除");
			return;			
		}
		//删除
		//遍历从前往后
		//找到开始和结尾，遍历次数
		//arra[空间] = array[数据];一般空间比数据小1
		//调整size
		for(int i = 1; i < size; i++){
			array[i-1] = array[i];			
		}
		size--;
	}
	
	//尾删
	public void deleteEnd(){
		if(size == 0){
			System.out.println("空白表无法删除");
			return;
		}
        size--;//array[--size] = 0;		
	}
	
	//随机删除
	public void delete(int index){
		if(size == 0){
			System.out.println("空白表无法删除");
			return;
		}
		if(index < 0 || index >= size){
			System.out.println("下标不合法");
			return;
		}
		for(int i = index + 1; i < size; i++){
			array[i-1] = array[i];
		}
		size--;	
	}
	
	//查找元素，获取下标
	public int searchIndex(int element){
		for(int i = 0; i < size; i++){
			if(array[i] == element){
				return i;
			}
		}
		return -1;
	}
	
	//根据下标，获取元素
    public int searchElement(int index){
		if(index < 0 || index >= size){
			System.out.println("下标不合法");
			return -1;
		}
		return array[index];
	}
	
	//给定下标修改
	public void recompose(int index, int element){
		if(index < 0 || index >= size){
			System.out.println("下标不合法");
			return;
		}
		array[index] = element;
	}
	
	
	
	//打印
	public String toString(){
		return Arrays.toString(Arrays.copyOf(array, size));
	}

    public static void main(String[] args){
		SeqList0728 s = new SeqList0728();
		s.putEnd(1);
		s.putEnd(2);
		s.putEnd(3);
		s.putEnd(4);
		System.out.println(s.toString());
		s.putFront(5);
		System.out.println(s.toString());
		s.putFront(6);
		System.out.println(s.toString());
		s.insert(1,100);
		System.out.println(s.toString());
		s.deleteEnd();
		s.deleteEnd();
		System.out.println(s.toString());
		s.deleteFront();
		System.out.println(s.toString());
		s.delete(1);
		System.out.println(s.toString());
		
		System.out.println(s.searchIndex(3));
		System.out.println(s.searchElement(2));
		s.recompose(2,2333);
		System.out.println(s.toString());
	}





















	
} 