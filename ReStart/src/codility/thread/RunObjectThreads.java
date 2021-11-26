package codility.thread;

public class RunObjectThreads {
    public static void main(String[] args) {
        RunObjectThreads sample = new RunObjectThreads();
        sample.checkThreadState();
    }

    public void checkThreadState(){
        Object monitor = new Object();
        StateThread thread1 = new StateThread(monitor);
        StateThread thread2 = new StateThread(monitor);
        try{
            System.out.println("Thread state = " + thread1.getState());
            thread1.start();
            thread2.start();
            System.out.println("thread state(after start)=" + thread1.getState());

            Thread.sleep(100);

            System.out.println("thread state(after 0.1sec) = " + thread1.getState());
            synchronized(monitor){
                monitor.notifyAll();
            }

            Thread.sleep(100);
            System.out.println("thread state(after notify) = " + thread1.getState());

            thread1.join();
            System.out.println("thread state(after join) = " + thread1.getState());
            thread2.join();
            System.out.println("thread2 state(after join) = " + thread2.getState());
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

class StateThread extends Thread{
    private Object monitor;
    public StateThread(Object monitor){
        this.monitor = monitor;
    }

    public void run(){
        try {
            for(int i = 0; i < 1000; i++){
                String a = "A";
            }
            synchronized(monitor){
                monitor.wait();    
            }
            System.out.println(getName() + "is notified");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
