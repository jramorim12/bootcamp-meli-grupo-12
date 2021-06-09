import java.util.regex.PatternSyntaxException;

public class main {
    public static void main(String[] args){

        try {
            WeakPassword weakPassword = new WeakPassword("42353534512");
            System.out.println(weakPassword);
            MediumPassword mediumPassword = new MediumPassword("Pot3213fgesd");
            System.out.println(mediumPassword);
            StrongPassword strongPassword = new StrongPassword("4231Hiahsd!");
            System.out.println(strongPassword);
        } catch (PasswordException e) {
            e.printStackTrace();
        }

    }
}
