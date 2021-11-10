package codility.thread;

public class RunSync {
    public static void main(String[] args) throws Exception {
        RunSync runSync = new RunSync();
        runSync.runCommonCalculate();

    }
    public void runCommonCalculate() throws InterruptedException{
        CommonCalculate calc = new CommonCalculate();
        ModifyAmountThread thread1 = new ModifyAmountThread(calc, true);
        ModifyAmountThread thread2 = new ModifyAmountThread(calc, true);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("final value = " +  calc.getAmount());

    }
}

class ModifyAmountThread extends Thread{
    private CommonCalculate calc;
    private boolean addFlag;
    public ModifyAmountThread(CommonCalculate calc, boolean addFlag){
        this.calc = calc;
        this.addFlag = addFlag;
    }
    public void run(){
        for(int i =0 ; i < 10000; i++){
            if(addFlag){
                calc.plus(1);
            } else {
                calc.minus(1);
            }
        }
    }
}

class CommonCalculate{
    private int amount;
    public CommonCalculate(){
        amount = 0;
    }

    public synchronized void plus(int value){
        amount += value;
    }

    public void minus(int value){
        amount -= value;
    }

    public int getAmount(){
        return amount;
    }
}