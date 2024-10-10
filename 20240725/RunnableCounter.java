public class RunnableCounter implements Runnable {
    
    final static int DEFAULT_MAX = 10;
    final static int DEFAULT_INTERVAL = 1000;
    static int totalCount = new Count();
    int max = DEFAULT_MAX;
    int interval = DEFAULT_INTERVAL;
    String name;
    int count = 0;
    
    Thread thread;
    boolean running = false;

    public RunnableCounter(String name, int max){
        count = 0;
        this.name = name;
        this.max = max;
    }
    public void stop(){
        running = false;
        thread.interrupt();
    }
    public int getCount(){
        return count;
    }
     public void run() {
        thread = Thread.currentThread();
        running  = true;
        
        while(running && count < max){
            try{
                while(count < max){
                    System.out.printf("%s : %d%n", name, ++count);
                    Thread.sleep(DEFAULT_INTERVAL);
                }
            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
                running = false;
            }

            
        }
    
    
    }
}
