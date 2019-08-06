package learning.object;
/*
 * 定义类student，包含三个属性，学号，年级，成绩，
 * 创建20个学生对象，学号为1到20，年级和成绩随机，
* Q1：打印出三年级学生的学生信息
* Q2：使用冒泡排序给学生成绩排序，并输出。
*/

public class StudentTest {
	public static void main(String[] args) {
		Student[] stu = new Student[20];
		//创建20 个对象
		for(int i=0; i<stu.length; i++) {
			stu[i] = new Student();
			
			//学号[1,20]
			stu[i].number = i+1;
			//年级[1,6]
			stu[i].state = (int)(Math.random() * (6-1-1)+1);
			//成绩[0,100]
			stu[i].score = (int)(Math.random() * (100-1));						
		}	
		
		StudentTest test = new StudentTest();
		
		//遍历学生信息
		test.print(stu);
		System.out.println("********************");
		
		//打印三年级信息
		test.searchState(stu, 3);
		System.out.println("********************");
		
		//排序输出
		test.sort(stu);
		test.print(stu);
		
	}
	
	//遍历学生信息
	public void print(Student[] stu) {
		for(int i=0; i<stu.length; i++) {
			System.out.println(stu[i].info());
		}
	}

	//查找年级信息
	public void searchState(Student[] stu, int state) {
		for(int i=0; i<stu.length; i++) {
			if(stu[i].state == state) {
				System.out.println(stu[i].info());
			}
		}
	}
	
	
	//排序
	public void sort(Student[] stu) {
		for(int i = 0; i<stu.length - 1; i++) {
			for(int j = 0; j<stu.length - 1 - i; j++) {
				if(stu[j].score > stu[j+1].score) {
					Student tmp = stu[j];
					stu[j] = stu[j+1];
					stu[j+1] = tmp;
				}
			}
		}
					
	}
      
}


class Student{
	int number;//学号
	int state;//年级
	int score;//成绩
	
	public String info() {
		return ("学号" + number + "，年级：" + state + "，成绩：" + score);
	}
	
}