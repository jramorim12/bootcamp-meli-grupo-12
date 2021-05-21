public class StringUtils {

    public static String rpad(String s, char c, int n){

        int len = s.length();
        return String.valueOf(String.format("%1$-"+(n+len)+"s", s).replace(' ',c));
    }

    public static String lpad(String s, char c, int n){

        int len = s.length();
        return String.valueOf(String.format("%1$"+(n+len)+"s", s).replace(' ',c));
    }

    public static String ltrim(String s){
        return s.replaceAll("^\\s+", "");
    }

    public static String rtrim(String s){
        return s.replaceAll("\\s+$", "");
    }

    public static String trim(String s){
        return s.replaceAll(" ","");
    }

    public static int indexOfN(String s,char c, int n) {
        String string = s.trim();
        int pos = 0;
        for(int i=0; i < string.length(); i++) {
            if(string.charAt(i) == c) {
                pos++;
            }
            if(pos == n){
                return i;
            }
        }
        return -1;
    }
}
