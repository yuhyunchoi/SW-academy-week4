public class SharedCount {
    
    int count;

    public int getCount(){
        return count;
    }
    
    public void increment(){
        count = getCount() +1;
    }
}
