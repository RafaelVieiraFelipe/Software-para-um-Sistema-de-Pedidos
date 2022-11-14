import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

class App{
    public static void main(String[] args) {
        Scanner entradaString = new Scanner(System.in);
        Scanner entradaNum = new Scanner(System.in);

        String nome, email, documento, descricao;
        double preco;
        int op, id, idPessoa=0;

        ArrayList <Pessoa> pessoas = new ArrayList<Pessoa>();
        ArrayList <PessoaFisica> pf = new ArrayList<PessoaFisica>();
        ArrayList <PessoaJuridica> pj = new ArrayList<PessoaJuridica>();
        ArrayList <Fornecedor> fornecedors = new ArrayList<Fornecedor>();
        ArrayList <Produto> produtos = new ArrayList<Produto>();
        ArrayList <Pedido> pedidos = new ArrayList<Pedido>();

        pessoas.add(new Pessoa("Rafael", "rafael.vf04@gmail.com", 0));
        do{
            System.out.println("[1] - Cadastro de cliente");
            System.out.println("[2] - Cadastro de fornecedor");
            System.out.println("[3] - Cadastro de produto");
            System.out.println("[4] - Efetuar pedido");
            System.out.println("[5] - Baixa de pagamento de um pedido");
            System.out.println("[6] - Relatórios");
            System.out.println("[7] - Sair");
            System.out.println(":");

            op = entradaNum.nextInt();

            switch(op){
                case 1:
                    System.out.println("Digite o nome: ");
                    nome = entradaString.nextLine();
                    System.out.println("Digite o e-mail: ");
                    email = entradaString.nextLine();
                    System.out.println("[1] - Pessoa física\n[2] - Pessoa jurídica\n:");
                    op = entradaNum.nextInt();
                    if(op == 1){
                        System.out.println("Informe o CPF");
                        documento = entradaString.nextLine();
                        idPessoa++;
                        pf.add(new PessoaFisica(nome, email, idPessoa, documento));
                        pessoas.addAll(pf);
                    } else if(op == 2){
                        System.out.println("Informe o CNPJ: ");
                        documento = entradaString.nextLine();
                        pj.add(new PessoaJuridica(nome, email, idPessoa, documento));
                        pessoas.addAll(pj);
                    } else{
                        System.out.println("Opção invalida, apagando registro.");
                    }
                    break;
                case 2:
                    System.out.println("Digite o nome do fornecedor: ");
                    nome = entradaString.nextLine();
                    System.out.println("Digite o CNPJ: ");
                    documento = entradaString.nextLine();
                    fornecedors.add(new Fornecedor(nome, documento));
                    break;
                case 3:
                    System.out.println("Digite o nome do produto: ");
                    nome = entradaString.nextLine();
                    System.out.println("Digite a descrição do produto: ");
                    descricao = entradaString.nextLine();
                    System.out.println("Digite o preço: ");
                    preco = entradaNum.nextDouble();
                    produtos.add(new Produto(nome, descricao, preco));
                    break;
                case 4:
                    System.out.println("Digite o nome: ");
                    nome = entradaString.nextLine();
                    System.out.println("Digite o e-mail: ");
                    email = entradaString.nextLine();
                    System.out.println("Digito o ID do pedido: ");
                    id = entradaNum.nextInt();
                    System.out.println("Produtos: ");
                    System.out.println("Nome:\tDescrição:\tPreço:");
                    do{
                        for(int i=0; i<produtos.size(); i++){
                            System.out.println(produtos.get(i).getNome()+"\t"+produtos.get(i).getDescrisao()+"\t"+produtos.get(i).getPreco());
                        }
                        System.out.println("digite o nome do produto: ");
                        String nomeProduto = entradaString.nextLine();
                        ArrayList <Produto> produtoPedido = new ArrayList<Produto>();
                        for(int i=0; i<produtos.size(); i++){
                            if(nomeProduto.equals(produtos.get(i).getNome())){
                                produtoPedido.add(produtos.get(i));
                            }
                        }
                        System.out.println("Continuar comprando? [1] - Sim [2] - Não");
                    }while(op == 1);
                    System.out.println("Digite a data do pedido: dd/mm/yyyy");
                    String dataRecebida = entradaString.nextLine();
                    try{
                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        Date dt = df.parse(dataRecebida);
                        int auxId;
                        for(int i=0; i<pessoas.size(); i++){
                            if(nome.equals(pessoas.get(i).getNome())){
                                auxId = pessoas.get(i).getId();
                                pedidos.add(new Pedido(nome, email, auxId, id, produtos, (java.sql.Date) dt));
                            } else{
                                System.out.println("Pessoa não cadastrada");
                            }
                        }
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                
            }
        }while(op != 7);
        

        
        // System.out.println("Digite duas datas separada por espaços dd/mm/yyyy: ");
        // String dataRecebida = entradaString.nextLine();
        // String dataRecebida2 = entradaString.nextLine();
        // try{
        //     DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        //     Date dt = df.parse(dataRecebida);
        //     Date dt2 = df.parse(dataRecebida2);
        //     if(dt.before(dt2)){
        //         System.out.println("A primeira data é antes");
        //         System.out.println(dt);
        //     } else{
        //         System.out.println("A segunda data é antes");
        //         System.out.println(dt2);
        //     }
        //     Date dataProduto = df.parse("24/05/2003");
        //     if(dataProduto.after(dt) && dataProduto.before(dt2)){
        //         System.out.println("Produto encontrado: ");
        //         System.out.println(dataProduto);
        //     }
            
        // } catch (Exception ex) {
        // ex.printStackTrace();
        // }
        


        


    }
}
