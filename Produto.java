public class Produto {
    private String nomeProduto;
    private String descrisao;
    private double preco;

    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public String getDescrisao() {
        return descrisao;
    }
    public void setDescrisao(String descrisao) {
        this.descrisao = descrisao;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Produto(String nomeProdudo, String descrisao, double preco){
        this.nomeProduto = nomeProduto;
        this.descrisao = descrisao;
        this.preco = preco;
    }
}
