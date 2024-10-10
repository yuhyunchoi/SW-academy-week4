
public class Test {
    public static void main(String[] args) throws InterruptedException {
        RunnableCounter counter1 = new RunnableCounter("Counter1", 100000);
        RunnableCounter counter2 = new RunnableCounter("Counter2", 100000);

        Thread thread1 = new Thread(counter1, "Coutner1");
        Thread thread2 = new Thread(counter2, "Counter2");

        System.out.println("Thread1 State : " + thread1.getState());
        thread1.start();
        thread2.start();

        System.out.println("Thread1 State : " + thread1.getState());
        thread1.join();
        thread2.join();

        System.out.println("Thread1 State : " + thread1.getState());
        System.out.println("Counter 1 : " + counter1.getCount());
        System.out.println("Counter 2 : " + counter2.getCount());
        System.out.println("Total Count : " + RunnableCounter.totalCount.getCount());

    }
}
