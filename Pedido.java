import java.sql.Date;
import java.util.ArrayList;

public class Pedido extends Pessoa{
    private int idPedido;
    private Date data;
    private ArrayList <Produto> produtos;
    private double valorTotal;
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

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

    public Pedido(String nome, String email, int idPessoa, int idPedido, ArrayList<Produto> produtos, java.util.Date dt) {
            super(nome, email, idPessoa);
            this.idPedido = idPedido;
            this.produtos = produtos;
            for(int i=0; i<produtos.size(); i++){
                this.valorTotal += produtos.get(i).getPreco();
            }
            this.data = (Date) dt;
        }

    public void imprimir(){
        System.out.println("ID: " + idPedido);
        super.imprimir();
        for(int i=0; i<produtos.size(); i++){
            produtos.get(i).imprimir();
        }
        System.out.println("Data: " + data.toString());
        System.out.println("Valor total: " + valorTotal);
    }
}
