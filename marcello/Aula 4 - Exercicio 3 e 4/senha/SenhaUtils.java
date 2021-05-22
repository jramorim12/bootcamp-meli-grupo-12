package senha;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SenhaUtils {

    public void validaSenhaFraca(String senha) throws SenhaFracaException {
        Pattern lowerCase = Pattern.compile(".*[a-z].*");
        if(lowerCase.matcher(senha).matches()){
            System.out.println("Senha válida");
        } else {
            throw new SenhaFracaException("Sua senha é fraca, insira outra senha");
        }
    }

    public void validaSenhaMedia(String senha) throws SenhaFracaException {
        Pattern lowerCase = Pattern.compile(".*[a-z].*");
        Pattern upperCase = Pattern.compile(".*[A-Z].*");
        if(lowerCase.matcher(senha).matches() && upperCase.matcher(senha).matches()){
            System.out.println("Senha válida");
        } else {
            throw new SenhaFracaException("Sua senha é fraca, insira outra senha");
        }
    }

    public void validaSenhaForte(String senha) throws SenhaFracaException {
        Pattern lowerCase = Pattern.compile(".*[a-z].*");
        Pattern upperCase = Pattern.compile(".*[A-Z].*");
        Pattern specialChars = Pattern.compile(".*[@!#$%&].*");
        if( lowerCase.matcher(senha).matches() //
         && upperCase.matcher(senha).matches() //
         && specialChars.matcher(senha).matches() ) {
            System.out.println("Senha válida");
        } else {
            throw new SenhaFracaException("Sua senha é fraca, insira outra senha");
        }
    }

}
