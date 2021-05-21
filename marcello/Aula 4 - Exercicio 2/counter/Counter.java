package counter;

public class Counter {

    private Integer count = 0;

    public Counter(){}

    public Counter(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "O contador está em: " + this.count;
    }
}
