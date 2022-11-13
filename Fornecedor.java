public class Fornecedor {
    private String nomeFornecedor;
    private int cnpj;

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }
    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }
    public int getCnpj() {
        return cnpj;
    }
    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public Fornecedor(String nomeFornecedor, int cnpj){
        this.nomeFornecedor = nomeFornecedor;
        this.cnpj = cnpj;
    }
}
