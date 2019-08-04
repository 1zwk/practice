/*
使用Scanner类来获取键盘上不同类型的变量
*/

//1.导包
import java.util.Scanner;

class ScannerClass{
	public static void main(String[] args){
		//2.Scanner的实例化
		Scanner scan = new Scanner(System.in);

		//3.调用Scanner的相关方法
		System.out.print("请输入姓名: ");
		String name = scan.next();
		System.out.println(name);
        
		System.out.print("请输入年龄: " );
		int age = scan.nextInt();
		System.out.println(age);
		
		System.out.print("请输入体重: ");
		float weight = scan.nextFloat();
		System.out.println(weight);
		
		System.out.print("是否有钱:  ture/false");
		boolean money = scan.nextBoolean();
		System.out.println(money);
		
		//char 类型只能通过String来获取
		System.out.print("性别:  男/女");
		String gender = scan.next();
		char genderChar = gender.charAt(0);
		System.out.println(money);

	}
}