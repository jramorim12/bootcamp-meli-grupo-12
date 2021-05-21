package counter;

public class Main {

    public static void main(String[] args) {
        Counter counterPadrao = new Counter();
        Counter counterComValor = new Counter(10);
        CounterUtils counterUtils = new CounterUtils();

        for(int i=0; i < 5; i++){
            counterUtils.increment(counterPadrao);
            counterUtils.increment(counterComValor);
        }

        for(int i=0; i < 5; i++) {
            counterUtils.decrement(counterPadrao);
            counterUtils.decrement(counterComValor);
        }
    }

}
