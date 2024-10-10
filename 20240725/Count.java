public class Count {
    int count;

    public Count(){
    
    }

    public int getCount(){
        return count;
    }
    public synchronized void increment(){
        count++;
    }


}
