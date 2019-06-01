import java.util.Arrays;

//Sequence List
public class SeqList{
	//属性
	private int[] array;
	private int size;
	//private int[] array2;
	
	public SeqList(){
		//初始化
		array = new int[11] ;		//11可更改
		//array2 = new int[] {5, 7 ,4, 20, 31, 5, 6}; 
		size = 0;
	}
	
	private ensureCapacity(){
		if(size < array.length){
			return;
		}
		//否则扩容
		//1.申请空间
		int oldCapacity = array.length;
		int newCapacity = oldCapacity +  oldCapacity/2;
		int newArray = int[newCapacity];
		//2，搬家
		for(int i = 0; i < size; i++){
			newArray[i] = array[i];
		}
		//3。通知地址
		//有自动回收
	}

//头插
public void pushFront(int element){
	//空间下标
	for(int i = size; i >= 1; i--){
		array[i] = array[i - 1];
	}
	array[0] = element;
	size++;
}

//尾插
public void pushBack(int element){
	//空间下标
	array[size] = element;
	size++;
}

//中间插入，根据下标来决定 。时间复杂度 O(n)
public void insert(int index, int element){
	if(index < 0 || index > size){
		System.out.println("错误，无法插入");
		return;
	}
	//遍历从后向前。	
	//i是空间下标
	for(int i = size; i > index; i--){
		array[i] = array[i-1];	
	}
	array[index] = element;
	size++;
}

//头删
public void deleteFront(){
	if(size == 0){
		System.out.println("没有数据，无法删除");
		return;
	}
	//遍历从前往后
	//i是数据下标，遍历范围是[1，size]；
	for(int i = 1; i <= size; i++){
		//array【空间下标】= array【数据下标】
		array[i-1] = array[i];
	}
	size--;
	//或者array[--size]=0；
}

//尾删
public void deleteBack(){
	if(size == 0){
		System.out.println("没有数据，无法删除");
		return;
	}
	//数据下标
	array[size-1]  = 0;
	size--;
}

//中间删除，下标指定
public void deleteInside(int index){
	if(size == 0){
		System.out.println("没有数据，无法删除");
		return;
	}
	
	//遍历从前往后
	//i是空间下标，遍历范围是（index,size)
	for(int i = index; i < size; i++){
		array[i] = array[i+1];
	}
	array[size] = 0;
	size--;
}

//查找元素下标
public int indexOf(int element){
	for(int i = 0; i < size; i++){
		if(array[i] == element){
			return i;
		}
	}
	return -1;
}

//删除第一个遇到的元素element
public void reMove(int element){
	int index = indexOf(element);
	if(index != -1){
		deleteInside(index);
	}
}

//删除所有的element元素
public void reMoveAll(int element){
	//时间复杂度：O（n^2）；空间 O（1）
	/*int index ;
	while((index = indexOf(element)) != -1){
		deleteInside(index);
	}*/
	
	
}
/*
//交换函数
static void swap(int[] array, int a, int b){
	int t = array[a];
	array[a] = array[b];
	array[b] = t;
}
//冒泡排序，前闭后开
public static void bubbleSort(int[] array){
	for(int i = 0; i < array.length; i++){
		for(int j = 0; j < (array.length - i - 1); j++){
			if(array[j] > array[j+1]){
				swap(array, j, j+1);
			}
		}
	}
}

//二分查找
public static int binarySearch(int[] array, int key){
	int left = 0;
	int right = array.length - 1;
	
	while(right < left){
		int mid = right - (left - right) / 2; 
		if(array[mid] > key){
			right = mid;
		}else if(array[mid] < key){
			left = mid + 1;
		}else{
			return mid;
		}
	}
	return -1;
}
*/

//便于打印
public String toString(){
	return Arrays.toString(
	Arrays.copyOf(array, size)
	);
}


	
public static void test1(String[] args){                  //静态方法不能调用普通方法
		SeqList seqList = new SeqList();
		//[]
		System.out.println(seqList.toString());
		//头插 1 2 3
		seqList.pushFront(3);
		seqList.pushFront(2);
		seqList.pushFront(1);
		System.out.println(seqList.toString());
		//尾插
		seqList.pushBack(10);
		seqList.pushBack(20);
		seqList.pushBack(30);
		System.out.println(seqList.toString());
		//中间插入，根据下标来决定
		seqList.insert(2, 45);
		seqList.insert(3, 55);
		System.out.println(seqList.toString());
		//头删
		seqList.deleteFront();
		seqList.deleteFront();
		System.out.println(seqList.toString());
		//尾删
		seqList.deleteBack();
		System.out.println(seqList.toString());
		//中间删除，根据下标来决定
		seqList.deleteInside(1);
		System.out.println(seqList.toString());
		//int[] array2 = new int[] {5, 7 ,4, 20, 31, 5, 6}; 
		/*seqList.bubbleSort(array2);
		System.out.println(seqList.toString2());
		seqList.binarySearch(array2, 20);
		System.out.println(seqList.toString2());
		*/
	}	
	
	public static void test2(String[] args){
		
	}
	
	
	public static void main(String[] args){
		test1(args);
		test2(args);
	}
}
