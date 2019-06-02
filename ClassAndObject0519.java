class Group{
	//属性
	String name;
	int numble;
	
	 //方法
	//构造方法
    //

	Group(String name, int numble){
		this.name  = name ;
		this.numble  = numble;
	}
	
	void print(String welcome){
	 	System.out. printf("%s %s 的 %d 位同学们%n",
		welcome,     //形参             ?
		name,        //属性
		numble      //属性
	    );
	}
}

class B{
    int sum;

    B(int a, int b, int c){
    System.out. println(a + b + c);
    sum = a + b + c;
    }
    
    void print(){
         System.out.println(sum);
    }
}


//只能有一个被public 修饰的类
public class ClassAndObject0519{
	public static void main(String[] args){
		Group group = new Group("java10班",50);
		group.print("欢迎来到比特，");
        
        B b = new B(1, 2, 3);
        b.print();
	}
}