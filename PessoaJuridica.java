public class PessoaJuridica extends Pessoa{
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public PessoaJuridica(String nome, String email, int id, String cnpj) {
        super(nome, email, id);
        this.cnpj = cnpj;
    }
    
}
