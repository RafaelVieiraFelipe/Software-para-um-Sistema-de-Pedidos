import java.util.Scanner;

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

    public void fechamento(Pedido pedido){
        Scanner entrada = new Scanner(System.in);
        System.out.println("É possível parcelar o pedido em até 5 vezes.");
        System.out.println("Parcelar em quantas vezes?");
        int parcela = entrada.nextInt();
        if(parcela>=1 && parcela<=5){
            double valorFinal = pedido.getValorTotal()/parcela;
            System.out.println("O pedido foi parcelado em " + parcela + "vezes de " + valorFinal);
            System.out.println("Finalizar compra? [1] - Sim [2] - Não");
            int op = entrada.nextInt();
            if(op==1){
                pedido.setPedidoFechado(true);
            }
        } else{
            System.out.println("Valor invalido");
        }
    }
    
}
