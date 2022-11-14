public class PessoaFisica extends Pessoa {
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public PessoaFisica(String nome, String email, int id, String cpf) {
        super(nome, email, id);
        this.cpf = cpf;
    }
    
}
