import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

class App{
    public static void main(String[] args) {
        Scanner entradaString = new Scanner(System.in);
        Scanner entradaNum = new Scanner(System.in);

        String nome, email, documento, descricao;
        double preco;
        int op, id=0, idPessoa=0;

        ArrayList <Pessoa> pessoas = new ArrayList<Pessoa>();
        ArrayList <PessoaFisica> pf = new ArrayList<PessoaFisica>();
        ArrayList <PessoaJuridica> pj = new ArrayList<PessoaJuridica>();
        ArrayList <Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        ArrayList <Produto> produtos = new ArrayList<Produto>();
        ArrayList <Pedido> pedidos = new ArrayList<Pedido>();

        pf.add(new PessoaFisica("Rafael", "rafael.vf04@gmail.com", 210090, "123456789"));
        pessoas.add(new Pessoa("Rafael", "rafael.vf04@gamil.com", 210090));
        fornecedores.add(new Fornecedor("Padrão", "44. 333. 11/22221-01"));

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
                    idPessoa++;
                    if(op == 1){
                        System.out.println("Informe o CPF");
                        documento = entradaString.nextLine();
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
                    fornecedores.add(new Fornecedor(nome, documento));
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
                    ArrayList <Produto> produtoPedido = new ArrayList<Produto>();
                    produtoPedido.clear();
                    System.out.println("Digite o nome: ");
                    nome = entradaString.nextLine();
                    System.out.println("Produtos: ");
                    System.out.println("Nome:\tDescrição:\tPreço:");
                    do{
                        for(int i=0; i<produtos.size(); i++){
                            System.out.println(produtos.get(i).getNome()+"\t"+produtos.get(i).getDescrisao()+"\t"+produtos.get(i).getPreco());
                        }
                        System.out.println("digite o nome do produto: ");
                        String nomeProduto = entradaString.nextLine().toLowerCase();
                        for(int i=0; i<produtos.size(); i++){
                            if(nomeProduto.equals(produtos.get(i).getNome().toLowerCase())){
                                produtoPedido.add(produtos.get(i));
                            }
                        }
                        System.out.println("Continuar comprando? [1] - Sim [2] - Não");
                        op = entradaNum.nextInt();
                    }while(op == 1);
                    System.out.println("Digite a data do pedido: dd/mm/yyyy");
                    String dataRecebida = entradaString.nextLine();
                    try{
                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        Date dt = df.parse(dataRecebida);
                        int auxId;
                        for(int i=0; i<pessoas.size(); i++){
                            if(nome.equals(pessoas.get(i).getNome())){
                                id++;
                                auxId = pessoas.get(i).getId();
                                java.sql.Date d = new java.sql.Date (dt.getTime());
                                pedidos.add(new Pedido(auxId, id, produtoPedido, d));
                                System.out.println("ID do pedido: " + id);
                                break;
                            }
                        }
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                        System.out.println("Disposição errada das vagas");
                    }
                    break;
                case 5:
                    System.out.println("Digite o ID do pedido: ");
                    int auxId = entradaNum.nextInt();
                    for(int i=0; i<pedidos.size(); i++){
                        if(pedidos.get(i).getIdPedido() == auxId){
                            for(int j=0; j<pf.size(); j++){
                                if(pedidos.get(i).getIdPessoa() == (pf.get(j).getId())){
                                    System.out.println("Pessoa física");
                                    System.out.println("CPF: " + pf.get(j).getCpf() + " Nome: " + pf.get(j).getNome());
                                    pedidos.get(i).imprimir();
                                    pf.get(j).fechamento(pedidos.get(i));
                                }
                            }
                            for(int j=0; j<pj.size(); j++){
                                if(pedidos.get(i).getIdPessoa() == (pj.get(j).getId())){
                                    System.out.println("Pessoa jurídica");
                                    System.out.println("CNPJ: " + pj.get(j).getCnpj() + " Nome: " + pj.get(j).getNome());
                                    pedidos.get(i).imprimir();
                                    pj.get(j).fechamento(pedidos.get(i));
                                }
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println("1 - Listagem de todos os Clientes");
                    System.out.println("2 - Listagem de todos os Fornecedores");
                    System.out.println("3 - Listagem de todos os Produtos");
                    System.out.println("4 - Listagem de todos os Pedidos");
                    System.out.println("5 - Listagem de todos os pedidos feitos em um determinado intervalo de datas"); 
                    System.out.println("6 - Busca de um pedido pelo número");
                    System.out.println("7 - Listagem de todos os pedidos pagos"); 
                    System.out.println("8 - Busca de um produto pelo nome"); 
                    System.out.println("9 - Cálculo do total dos pedidos em aberto");
                    System.out.println(":");
                    op = entradaNum.nextInt();
                    switch(op){
                        case 1:
                            for(int i=0; i<pessoas.size(); i++){
                                pessoas.get(i).imprimir();
                                for(int j=0; j<pf.size(); j++){
                                    if(pessoas.get(i).getId() == pf.get(j).getId()){
                                        System.out.println("Pessoa física");
                                        System.out.println("CPF: " + pf.get(j).getCpf());
                                    }
                                }
                                for(int j=0; j<pj.size(); j++){
                                    if(pessoas.get(i).getId() == pj.get(j).getId()){
                                        System.out.println("Pessoa jurídica");
                                        System.out.println("CNPJ: " + pj.get(j).getCnpj());
                                    }
                                }
                                System.out.println();
                            }
                            break;
                        case 2:
                            for(int i=0; i<fornecedores.size(); i++){
                                fornecedores.get(i).imprimir();
                            }
                            break;
                        case 3:
                            for(int i=0; i<produtos.size(); i++){
                                produtos.get(i).imprimir();
                            }
                            break;
                        case 4:
                            for(int i=0; i<pedidos.size(); i++){
                                pedidos.get(i).imprimir();
                                for(int j=0; j<pf.size(); j++){
                                    if(pedidos.get(i).getIdPessoa() == pf.get(j).getId()){
                                        System.out.println("CPF: " + pf.get(j).getCpf() + " Nome: " + pf.get(j).getNome());
                                    }
                                }
                                for(int j=0; j<pj.size(); j++){
                                    if(pessoas.get(i).getId() == pj.get(j).getId()){
                                        System.out.println("CNPJ: " + pj.get(j).getCnpj() + " Nome: " + pj.get(j).getNome()) ;
                                     }
                                }
                                if(pedidos.get(i).isPedidoFechado() == true){
                                    System.out.println("Pedido fechado");;
                                }
                                else if(pedidos.get(i).isPedidoFechado() == false){
                                    System.out.println("Pedido em aberto");;
                                }
                                System.out.println();
                            }
                            break;
                        case 5:
                            System.out.println("Digite a primeira data dd/mm/yyyy: ");
                            String dtRecebida = entradaString.nextLine();
                            System.out.println("Digite a segunda data data dd/mm/yyyy: ");
                            String dtRecebida2 = entradaString.nextLine();
                            System.out.println("Pedidos encontrados: ");
                            for(int i=0; i<pedidos.size(); i++){
                                try{
                                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                    Date dt = df.parse(dtRecebida);
                                    Date dt2 = df.parse(dtRecebida2);
                                    if(dt2.before(dt)){
                                        System.out.println("Sequencia invalida");
                                    } else if(dt.after(dt2)){
                                        System.out.println("Sequencia invalida");
                                    }
                                    else{
                                        if(dt.before(pedidos.get(i).getData()) && dt2.after(pedidos.get(i).getData())){
                                            pedidos.get(i).imprimir();
                                        }
                                    }
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                            break;
                        case 6:
                            System.out.println("Digite o ID do pedido: ");
                            auxId = entradaNum.nextInt();
                            for(int i=0; i<pedidos.size(); i++){
                                if(pedidos.get(i).getIdPedido() == auxId){
                                    pedidos.get(i).imprimir();
                                }
                            }
                            break;
                        case 7:
                            System.out.println("Pedido pagos: ");
                            for(int i=0; i<pedidos.size(); i++){
                                if(pedidos.get(i).isPedidoFechado() == true){
                                    pedidos.get(i).imprimir();
                                }
                            }
                            op = 0;
                            break;
                        case 8:
                            System.out.println("digite o nome do produto: ");
                            String nomeProduto = entradaString.nextLine().toLowerCase();
                            for(int i=0; i<produtos.size(); i++){
                                if(nomeProduto.equals(produtos.get(i).getNome().toLowerCase())){
                                    produtos.get(i).imprimir();;
                                }
                            }
                            break;
                        case 9:
                            System.out.println("Soma total dos pedidos em aberto: ");
                            double somaTotal = 0;
                            for(int i=0; i<pedidos.size(); i++){
                                if(pedidos.get(i).isPedidoFechado() == false){
                                    somaTotal += pedidos.get(i).getValorTotal();
                                }
                            }
                            System.out.println("Ainda falta serem pagos: R$" + somaTotal);
                            break;
                        default:
                            break;                
                    }
                    System.out.println("Pressione enter...");
                    entradaString.nextLine();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("valor invalido");
                    break;
            }
        }while(op != 7);
    }
}
