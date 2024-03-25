package ADO_1;
import java.util.Scanner;
public class ControleVendas {
    public static void main(String[] args) {
        Scanner ler = new Scanner (System.in);
        String nome;
        int codigo, quantidade, opcao, tamanho;
        double preco, total;

        System.out.println("Informe o tamanho do vetor:");
        int x = ler.nextInt();
        Funcoes fun = new Funcoes(x);

        do{
        System.out.println("\n==Bem-Vindo ao SuperMarket==");
        System.out.println("\n==Menu de Compras==");
        System.out.println("1. Consultar Produtos");
        System.out.println("2. Adicionar produto a lista");
        System.out.println("3. Buscar produto que já foi adicionado a lista");
        System.out.println("4. Remover produto adionado a lista");
        System.out.println("5. Calcular total da compra");
        System.out.println("0. Sair do SuperMarket");
        opcao = ler.nextInt();
        
            switch (opcao) {
                case 1:
                    System.out.println("Cod: 001; Arroz; Preço: R$10,00");
                    System.out.println("Cod: 002; Feijão; Preço: R$7,00");
                    System.out.println("Cod: 003; Óleo; Preço: R$5,00");
                    System.out.println("Cod: 004; Açúcar; Preço: R$3,50");
                    System.out.println("Cod: 005; Farinha de Trigo; Preço: R$6,99");
                    System.out.println("Cod: 006; Milho 1kg; Preço: R$12,00");
                    System.out.println("Cod: 007; Vinagre; Preço: R$2,70");
                    System.out.println("Cod: 008; Bolacha; Preço: R$1,75");
                    System.out.println("Cod: 009; Maça 1kg; Preço: R$15,99");
                    System.out.println("Cod: 010; Banana 1kg; Preço: R$11,99");
                    break;
                case 2:
                    System.out.println("Digite o código do produto que quira comprar:");
                    codigo = ler.nextInt();
                    System.out.println("Digite o nome do produto que queira comprar:");
                    nome = ler.nextLine();
                    ler.nextLine();
                    System.out.println("Digite o preço desse produto:");
                    preco = ler.nextDouble();
                    System.out.println("Digite quanto desse produto que você quer:"); 
                    quantidade = ler.nextInt(); 

                    fun.adicionarProduto(new Produto(codigo, nome, preco, quantidade));
                    break;

                case 3:
                      System.out.println("Informe o código do produto:");
                      int buscarcodigo= ler.nextInt();
                      Produto buscarProduto = fun.buscarProduto(buscarcodigo);

                      if (buscarProduto != null) {
                        System.out.println("Produto encontrado: " + buscarProduto.getDescricao());
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                      break;

                case 4:
                    System.out.println("Informe o código do produto:");
                    codigo= ler.nextInt();

                    fun.remove(codigo);
                    break;
                    
                case 5:
                    total = fun.calcularTotalVendas();
                    System.out.println("Sua Compra foi igual à R$" + total);
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Função não existe! Por favor digite novamente.");
                    break;
              }
        }while(opcao !=0);

        
    }
}
