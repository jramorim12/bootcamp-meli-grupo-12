package counter;

public class CounterUtils {

    public void increment(Counter counter){
        counter.setCount(counter.getCount() + 1);
        System.out.println(counter);
    }

    public void decrement(Counter counter){
        counter.setCount(counter.getCount() - 1);
        System.out.println(counter);
    }

}
