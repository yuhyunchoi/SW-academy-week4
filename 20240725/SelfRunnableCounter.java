public class SelfRunnableCounter implements Runnable {
    
    final static int DEFAULT_MAX = 10;
    final static int DEFAULT_INTERVAL = 1000;
    int max = DEFAULT_MAX;
    int count = 0;
    String name;
    Thread thread;

    public SelfRunnableCounter(String name, int max){
        this.name = name;
        this.max = max;
        count = 0;
        thread = new Thread(this);
    }
    public void start(){
        thread.start();
    }
    
    public void run() {
        try{
            while(count < max){
                System.out.printf("%s : %d%n", name, ++count);
                Thread.sleep(DEFAULT_INTERVAL);
            }
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
