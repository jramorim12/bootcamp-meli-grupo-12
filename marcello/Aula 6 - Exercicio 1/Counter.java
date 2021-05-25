package saveTheRopa;

public class Counter {

    private Integer count = 1;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer increment() {
        return this.count++;
    }

    public Integer decrement() {
        return this.count--;
    }

    @Override
    public String toString() {
        return "O contador está em: " + this.count + "\n";
    }
}
