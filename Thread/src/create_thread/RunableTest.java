package create_thread;

import java.util.concurrent.FutureTask;

class MyThread implements Runnable{
    private int ticket = 20;
    @Override
    //每个线程都必须执行的任务
    public void run() {
        while(ticket > 0){
            System.out.println("当前线程为" + ExtendsThread.currentThread().getName() + "，还剩下" + ticket-- + "票" );
        }
    }
}

class Test1{
    public static void main(String[] args) {
        MyThread mt1 = new MyThread();
        Thread thread1 = new Thread(mt1);//Thread 类中有 Thread(Runnable)构造方法，
                                         // 可以传入一个Runnable,把它变为Thread类型。
        Thread thread2 = new Thread(mt1);
        Thread thread3 = new Thread(mt1);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
