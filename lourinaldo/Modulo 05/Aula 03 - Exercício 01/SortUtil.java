public class SortUtil {
    public static Precedente[] sort(Precedente[] arr){
        boolean sorted = false;
        Precedente<Pessoa> temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].precedeA(arr[i+1]) == -1) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sorted = false;
                }
            }
        }
        return arr;
    }
}
