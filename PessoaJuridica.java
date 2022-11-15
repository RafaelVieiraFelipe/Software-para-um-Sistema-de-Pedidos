import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

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

    public void fechamento(Pedido pedido){
        GregorianCalendar gc = new GregorianCalendar();
        Scanner entrada = new Scanner(System.in);
        Date prazo = pedido.getData();
        gc.setTime(prazo);
        gc.add(gc.DAY_OF_MONTH, 2);
        System.out.println("O pedido deve ser faturado até dia: " + gc.getTime());
        System.out.println("Finalizar pedido? [1] - Sim [2] - Não");
        int op = entrada.nextInt();
        if(op==1){
            System.out.println("Pedido fechado");
            pedido.setPedidoFechado(true);
        }
    }
    
}
