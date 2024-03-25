package ADO_1;
import javax.swing.JOptionPane;

public class InterfaceGrafica {
    public static void main(String[] args) {
        String nome;
        int codigo, quantidade, tamanho, opcao;
        double preco, total;

        int x = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o tamanho do vetor:"));
        Funcoes fun = new Funcoes(x);

        do{
        JOptionPane.showMessageDialog(null, "\n==Bem-Vindo ao SuperMarket=="+
                                                            "\n==Menu de Compras==" +
                                                            "\n1. Consultar Produtos"+
                                                            "\n2. Adicionar produto a lista"+
                                                            "\n3. Buscar produto que já foi adicionado a lista"+
                                                            "\n4. Remover produto adionado a lista"+
                                                            "\n5. Calcular total da compra"+
                                                            "\n0. Sair do SuperMarket");
       
        opcao =Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a opção: "));;
        
            switch (opcao) {
                case 1:
                   JOptionPane.showMessageDialog(null, "Cod: 001; Arroz; Preço: R$10,00"+
                                                                       "\nCod: 002; Feijão; Preço: R$7,00"+
                                                                       "\nCod: 003; Óleo; Preço: R$5,00"+
                                                                       "\nod: 004; Açúcar; Preço: R$3,50"+
                                                                       "\nCod: 005; Farinha de Trigo; Preço: R$6,99"+
                                                                       "\nCod: 006; Milho 1kg; Preço: R$12,00"+
                                                                       "\nCod: 007; Vinagre; Preço: R$2,70"+
                                                                       "\n: 008; Bolacha; Preço: R$1,75"+
                                                                       "\nCod: 009; Maça 1kg; Preço: R$15,99"+
                                                                       "\nCod: 010; Banana 1kg; Preço: R$11,99");
                    break;

                case 2:
                    codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código do produto que quira comprar: "));
                   
                    nome = JOptionPane.showInputDialog(null, "Digite o nome do produto que queira comprar:");
                    
                    preco =  Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o preço desse produto: "));

                    quantidade =  Integer.parseInt(JOptionPane.showInputDialog(null, "Digite quanto desse produto que você quer: "));

                    fun.adicionarProduto(new Produto(codigo, nome, preco, quantidade));
                    break;

                case 3:
                      int buscarcodigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o código do produto: "));
                      Produto buscarProduto = fun.buscarProduto(buscarcodigo);

                      if (buscarProduto != null) {
                        JOptionPane.showMessageDialog(null,"Produto encontrado: " + buscarProduto.getDescricao());
                    } else {
                        JOptionPane.showMessageDialog(null,"Produto não encontrado.");
                    }
                      break;

                case 4:
                    codigo= Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o código do produto: "));

                    fun.remove(codigo);
                    break;
                    
                case 5:
                    total = fun.calcularTotalVendas();
                    JOptionPane.showMessageDialog(null,"Sua Compra foi igual à R$" + total);
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null,"Função não existe! Por favor digite novamente.");
                    break;
              }
        }while(opcao !=0);

        
    }
}
