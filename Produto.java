public class Produto {
    private String nome;
    private String descrisao;
    private double preco;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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

    public Produto(String nome, String descrisao, double preco){
        this.nome = nome;
        this.descrisao = descrisao;
        this.preco = preco;
    }

    public void imprimir(){
        System.out.println("Nome produto: " + nome + "; descrição: " + descrisao + "; preço: " + preco);
    }
}
