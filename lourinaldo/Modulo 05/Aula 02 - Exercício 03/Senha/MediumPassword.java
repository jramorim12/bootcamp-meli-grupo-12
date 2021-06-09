import java.util.regex.Pattern;

    public class MediumPassword extends  Password{
    private static final Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$");

    public MediumPassword(String password) throws PasswordException {
        super(password);
        validatePassword();
    }

    public void validatePassword() throws PasswordException {
        if(!pattern.matcher(this.password).matches()){
            throw new PasswordException("Senha Média inválida");
        }
    }
}
