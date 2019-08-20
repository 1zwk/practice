

import java.util.*;

class ArrayListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>(100);
        Set<String> set = new HashSet<>();
        // Set<Integer> set1 = new HashSet<>();

        set.add("你好");
        set.add("世界");
        set.add("中国");
        //set1.add(1);

        //set1.remove(1);
        //boolean i = set.contains(0);

        List<String> list3 = new ArrayList<>(set);//Arraylist 有三个构造方法，一个无参构造，
        // 一个容量构造，一个collection构造
        System.out.println(list);
        System.out.println(list2);
        System.out.println(list3);
        // System.out.println(i);
        // System.out.println(set1);
    }
}

class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        //List<String> list1 = new LinkedList<>();
       // List<String> list2 = new LinkedList<>();

        list.add("java");
        list.add("牛逼");
        list.add("!");
        list.push("123");
        System.out.println(list.size());
        System.out.println(list);
        System.out.println(list.pop());//头删，需要和头插push一起控制栈；
        System.out.println(list.poll());//检索但删除链表的第一个头
        System.out.println(list.peek());//检索但不删除链表的第一个头


    }
}
