package StringUtilsBootcamp;

import java.util.Arrays;

public class StringUtilsBootCamp {

    /**
     * Adiciona zeros à esquerda de uma String informada de acordo com seu tamanho e o tamanho desejado
     * @param s
     * @param desiredLength
     * @return s
     */
    public static String leftPadWithZeros(String s, int desiredLength) {
        int lengthDifference = desiredLength - s.length();
        if(lengthDifference <= 0) {
            System.out.println("Impossível realizar leftPad, string inserida maior que tamanho desejado inserido!");
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < lengthDifference ; i++ ){
            sb.append("0");
        }
        sb.append(s);
        return sb.toString();
    }

    /**
     * Adiciona zeros à direita de uma String informada de acordo com seu tamanho e o tamanho desejado
     * @param s
     * @param desiredLength
     * @return
     */
    public static String rightPadWithZeros(String s, int desiredLength) {
        int lengthDifference = desiredLength - s.length();
        if(lengthDifference <= 0) {
            System.out.println("Impossível realizar leftPad, string inserida maior que tamanho desejado inserido!");
            return s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for(int i = 0; i < lengthDifference ; i++ ){
            sb.append("0");
        }
        return sb.toString();
    }

    /**
     * Adiciona espaços à esquerda de uma String informada de acordo com seu tamanho e o tamanho desejado
     * @param s
     * @param desiredLength
     * @return
     */
    public static String leftPadWithSpaces(String s, int desiredLength) {
        int lengthDifference = desiredLength - s.length();
        if(lengthDifference <= 0) {
            System.out.println("Impossível realizar leftPad, string inserida maior que tamanho desejado inserido!");
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < lengthDifference ; i++ ){
            sb.append(" ");
        }
        sb.append(s);
        return sb.toString();
    }

    /**
     * Adiciona espaços à direita de uma String informada de acordo com seu tamanho e o tamanho desejado
     * @param s
     * @param desiredLength
     * @return
     */
    public static String rightPadWithSpaces(String s, int desiredLength) {
        int lengthDifference = desiredLength - s.length();
        if(lengthDifference <= 0) {
            System.out.println("Impossível realizar leftPad, string inserida maior que tamanho desejado inserido!");
            return s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for(int i = 0; i < lengthDifference ; i++ ){
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String leftTrimZeros(String s) {
        int trimmer = 0;
        for(int i=0; i < s.length(); i++) {
            if(s.charAt(i) != '0') {
                trimmer = i;
                break;
            }
        }
        return s.substring(trimmer);
    }

    public static String rightTrimZeros(String s) {
        int trimmer = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if(s.charAt(i) != '0') {
                trimmer = i + 1;
                break;
            }
        }
        return s.substring(0,trimmer);
    }

    public static String leftTrimBlankSpaces(String s) {
        int trimmer = 0;
        for(int i=0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') {
                trimmer = i;
                break;
            }
        }
        return s.substring(trimmer);
    }

    public static String rightTrimBlankSpaces(String s) {
        int trimmer = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if(s.charAt(i) != ' ') {
                trimmer = i + 1;
                break;
            }
        }
        return s.substring(0,trimmer);
    }

    public static String trimZeros(String s) {
        return s.replaceAll("0","");
    }

    public static String trimBlankSpaces(String s) {
        return s.replaceAll(" ","");
    }

    public static int indexOfN(String s,char c, int n) {
        String newString = StringUtilsBootCamp.trimBlankSpaces(s);
        int counter = 0;
        for(int i=0; i < newString.length(); i++) {
            if(newString.charAt(i) == c) {
                counter++;
            }
            if(counter == n){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = StringUtilsBootCamp.indexOfN("Marcello", 'l', 2);
        System.out.println(i);
    }

}
