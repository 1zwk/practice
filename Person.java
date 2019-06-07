public class Person{
    //成员变量的创建
    //属性1
    static String name;
    //属性2
    static int age;
    
    //构造方法
    //对属性进行初始化
    public Person(){
       this.name = name;
       this.age = age;
    }
    //方法1
    public static void personName(String n){
       name = n;
    } 
    //方法2
    public static void personAge(int a){
       age = a;
    }
    //打印
    public static void printlnPerson(){
      System.out.println("姓名："+ name + "年龄:"+ age); 
    }  
	
    //梦开始的地方， main方法 
    public static void main(String[] args){
      //创建对象
      Person person = new Person();
      //通过方法1设置name
      Person.personName("骚男");
      //使用方法2设置age
      Person.personAge(14);
      //调用打印
      Person.printlnPerson();
    }      
}
