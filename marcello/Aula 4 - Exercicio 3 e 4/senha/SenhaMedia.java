package senha;

public class SenhaMedia extends Senha{

    public SenhaMedia(String senha) throws SenhaFracaException {
        super(senha);
        SenhaUtils senhaUtils = new SenhaUtils();
        senhaUtils.validaSenhaMedia(senha);
    }
}
