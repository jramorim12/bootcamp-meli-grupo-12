package sorter;

public interface Sorter<T extends Comparable<T>> {

    public void sort(T array[], MyComparator<T> comparator);

}
