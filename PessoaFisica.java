public class PessoaFisica extends Pessoa {
    private int cpf;

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public PessoaFisica(String nome, String email, int cpf) {
        super(nome, email);
        this.cpf = cpf;
    }
    
}
