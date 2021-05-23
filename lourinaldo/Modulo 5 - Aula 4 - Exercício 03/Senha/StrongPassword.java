import java.util.regex.Pattern;

public class StrongPassword extends Password{
    private static final Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}:;<>,.?/~_+]).{8,20}$");

    public StrongPassword(String password) throws PasswordException {
        super(password);
        validatePassword();
    }

    public void validatePassword() throws PasswordException {
        if(!pattern.matcher(this.password).matches()){
            throw new PasswordException("Senha Forte inválida");
        }
    }
}
