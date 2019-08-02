/*
使用Scanner类来获取键盘上不同类型的变量
*/

//1.导包
import java.util.Scanner;

class ScannerTest{
	public static void main(String[] args){
		//2.Scanner的实例化
		Scanner scan = new Scanner(System.in);

		//3.调用Scanner的相关方法
		System.out.print("请输入姓名：" + "/t");
		String name = scan.next();
		System.out.println(name);


	}
}