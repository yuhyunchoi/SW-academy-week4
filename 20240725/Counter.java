public class Counter{
    final static int DEFAULT_MAX = 10;
    final static int DEFAULT_INTERVAL = 1000;
    int max = DEFAULT_MAX;
    String name;
    int count;

    public Counter(String name, int max){
        count = 0;
        this.name = name;
        this.max = max;
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