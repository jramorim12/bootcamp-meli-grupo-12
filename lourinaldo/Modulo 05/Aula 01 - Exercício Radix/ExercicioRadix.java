import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ExercicioRadix {

    public static void radixSort(int iArr[]){


        ArrayList<String> sArr = new ArrayList<>();
        ArrayList<Integer> iArrFinal = new ArrayList<>();
        final int maxSize = String.valueOf(Arrays.stream(iArr).max().getAsInt()).length();

        for(Integer value: iArr){
            sArr.add(String.valueOf(String.format("%0"+maxSize+"d", value)));
        }

        Map<Integer, List<String>> auxMapList = new HashMap<>();

        for(int pos = (maxSize-1); pos>-1; pos--) {
            final int position = pos;
            for (int i = 0; i < 10; i++) {
                final char number = (char) (i + 48);
                auxMapList.put(i, sArr.stream().filter(str -> str.charAt(position) == number).collect(Collectors.toList()));
            }

            sArr = new ArrayList<>();

            for (Map.Entry<Integer, List<String>> numeros: auxMapList.entrySet()) {
                sArr.addAll(numeros.getValue());
            }
            
            auxMapList = new HashMap<>();

        }

        for(String value: sArr){
            iArrFinal.add(Integer.parseInt(value));
        }

        System.out.println(iArrFinal);

    }
    public static void main(String[] args) {
        int iArr[]  = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};

        radixSort(iArr);
    }
}
