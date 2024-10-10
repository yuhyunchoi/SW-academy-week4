public class ThreadCounter extends Thread{
    final static int DEFAULT_MAX = 10;
    final static int DEFAULT_INTERVAL = 1000;
    int max = DEFAULT_MAX;
    String name;

    public ThreadCounter(String name, int max){
        this.name = name;
        this.max = max;
    }

    @Override
    public void run() {
        try{
            for(int i = 0; i < max; i++){
                System.out.printf("%s : %d%n", name, i + 1);
                Thread.sleep(DEFAULT_INTERVAL);
            }
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}