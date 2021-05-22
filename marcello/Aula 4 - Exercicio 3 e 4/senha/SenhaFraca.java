package senha;

public class SenhaFraca extends Senha{

    public SenhaFraca(String senha) throws SenhaFracaException {
        super(senha);
        SenhaUtils senhaUtils = new SenhaUtils();
        senhaUtils.validaSenhaFraca(senha);
    }

}
