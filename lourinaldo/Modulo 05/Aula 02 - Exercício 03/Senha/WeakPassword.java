import java.util.regex.Pattern;

public class WeakPassword extends  Password{

    private static final Pattern pattern = Pattern.compile("^(?=.*[0-9]).{8,20}$");

    public WeakPassword(String password) throws PasswordException {
        super(password);
        validatePassword();
    }

    public void validatePassword() throws PasswordException {
        if(!pattern.matcher(this.password).matches()){
            throw new PasswordException("Senha Fraca inválida ");
        }
    }
}
