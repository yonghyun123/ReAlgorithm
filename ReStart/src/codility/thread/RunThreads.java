package codility.thread;

public class RunThreads {
    public static void main(String[] args) {
        RunThreads runThreads = new RunThreads();
        // runThreads.runBasic();
        runThreads.runDaemonThread();
    }
    public void runBasic(){
        RunnableSample runnableSample = new RunnableSample();
        new Thread(runnableSample).start();

        ThreadSample threadSample = new ThreadSample();
        threadSample.start();
    }

    public void runDaemonThread(){
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true);
        daemonThread.start();
    }
}

class RunnableSample implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("this is RunnableSample's run() method.");
    }
}

class ThreadSample extends Thread{

    public void run(){
        System.out.println("this is ThreadSample's run() method.");
    }
}

//daemonThread
class DaemonThread extends Thread{
    public void run(){
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
