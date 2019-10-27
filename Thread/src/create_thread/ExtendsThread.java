package create_thread;

import java.util.concurrent.FutureTask;

public class ExtendsThread extends Thread {
    private String title ;
    public ExtendsThread(String s) {
        this.title = s;
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
            System.out.println("当前线程为" + title + "," + i);
        }
    }

}

class Test2{
    public static void main(String[] args) {

       ExtendsThread mt1 = new ExtendsThread("线程1");
       ExtendsThread mt2 = new ExtendsThread("线程2");
       ExtendsThread mt3 = new ExtendsThread("线程3");
       mt1.start();
       mt2.start();
       mt3.start();
    }
}