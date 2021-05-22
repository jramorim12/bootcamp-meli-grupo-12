package senha;

public class SenhaForte extends Senha{

    public SenhaForte(String senha) throws SenhaFracaException {
        super(senha);
        SenhaUtils senhaUtils = new SenhaUtils();
        senhaUtils.validaSenhaForte(senha);
    }
}
