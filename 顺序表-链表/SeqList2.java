public class SeqList2{
	public int size; //用来保存数组长度
	public int[] array;//用来保存数据
	
	//构造函数
	public SeqList(){
		this.array =  new array[15];//数组初始化
		this.size = 0;
	}
	
	//扩容
	private ensureCapacity(){
		if(size < array.length  ){
			return;
		}
		//否则扩容
        //1.申请空间
        int[] newArray	= new newArray[(array.length) + (array.length/2)];
		//2.搬家
		for(int i = 0; i < size; i++){
			newArray[i] = array;
		}
		//3.通知地址
		//有自动回收
	}
	
	//头插
	public void putFront(){
		
	} 
}