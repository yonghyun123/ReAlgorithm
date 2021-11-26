package codility.thread;

import java.util.Random;

public class LocalUserThread  extends Thread{
    public void run(){
        int value = ThreadLocalSample.generateNumber();
        System.out.println(this.getName() + " LocalUserThread value = " + value);

        OtherLogic OtherLogic = new OtherLogic();
        OtherLogic.printMyName();

    }
    
}
class OtherLogic{
    public void printMyName(){
        System.out.println(Thread.currentThread().getName()+" LocalUserThread value = "+ThreadLocalSample.get());
    }
}

class ThreadLocalSample{
    private final static ThreadLocal<Integer> local = new ThreadLocal<>();
    private static Random random;

    static{
        random = new Random();
    }

    public static Integer generateNumber(){
        int value = random.nextInt(45);
        local.set(value);
        return value;
    }

    public static Integer get(){
        return local.get();
    }
}


class MainC {
    public static void main(String[] args) {
        LocalUserThread t1 = new LocalUserThread();
        LocalUserThread t2 = new LocalUserThread();
        LocalUserThread t3 = new LocalUserThread();

        t1.start();
        t2.start();
        t3.start();

    }
}
