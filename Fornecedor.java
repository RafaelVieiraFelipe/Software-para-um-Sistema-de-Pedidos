public class Fornecedor {
    private String nomeFornecedor;
    private String cnpj;

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }
    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Fornecedor(String nomeFornecedor, String cnpj){
        this.nomeFornecedor = nomeFornecedor;
        this.cnpj = cnpj;
    }
}
