class Person{
    //成员变量的创建
    //属性1
    private String name;
    //属性2
    private int age;
    
    //构造方法
    //对属性进行初始化
    public Person(){
       this.name = name;
       this.age = age;
    }
    //方法1
    public void personName(String n){
       name = n;
    } 
    //方法2
    public void personAge(int a){
       age = a;
    }
    //打印
    public void printlnPerson(){
      System.out.println("姓名："+ name + "年龄:"+ age); 
    }  
}

public class DailyPractice{
    // main方法 
    public static void main(String[] args){
      //创建对象
      Person person = new Person();
      //通过方法1设置name
      person.personName("骚男");
      //使用方法2设置age
      person.personAge(14);
      //调用打印
      person.printlnPerson();
    }      
}