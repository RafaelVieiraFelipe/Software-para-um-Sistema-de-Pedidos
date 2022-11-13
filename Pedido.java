import java.util.ArrayList;

public class Pedido extends Pessoa{
    
    private ArrayList <Produto> produtos;
    private double valorTotal;
    
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Pedido(String nome, String email, ArrayList produtos, double valorTotal) {
            super(nome, email);
            this.produtos = produtos;
            this.valorTotal = valorTotal;
        }
}
