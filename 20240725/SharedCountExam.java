

public class SharedCountExam {
    public static void main(String[] args) throws InterruptedException{
        SharedCount sharedCount = new SharedCount();
        SharedCounter counter1 = new SharedCounter("Counter1", 10, sharedCount);
        SharedCounter counter2 = new SharedCounter("Counter2", 10, sharedCount);

        long start = System.currentTimeMillis();
        counter1.start();
        counter2.start();

        System.out.println(counter1.getName() + " : started");
        System.out.println(counter2.getName() + " : started");

        counter1.join();
        counter2.join();

        System.out.println(counter1.getName() + " : terminated");
        System.out.println(counter2.getName() + " : terminated");
        System.out.println("shartedCount : " + sharedCount.getCount());
        long finished = System.currentTimeMillis();
        System.out.println("Finished : " + (finished - start));
    }
}
