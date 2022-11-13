public class PessoaJuridica extends Pessoa{
    private int cnpj;

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public PessoaJuridica(String nome, String email, int cnpj) {
        super(nome, email);
        this.cnpj = cnpj;
    }
    
}
