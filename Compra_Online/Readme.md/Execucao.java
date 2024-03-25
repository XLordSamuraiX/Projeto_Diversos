package CompraOnline;
import java.util.*;
public class Execucao {
      static Scanner ler = new Scanner(System.in);
    public static void main (String[]args){
        String nome1, email1, nomeProduto;
        Double preco1;
        
        
        Cliente cliente = new Cliente();
        System.out.println("Qual é o seu nome?");
        nome1 = ler.nextLine();
        cliente.setNome(nome1);
        System.out.println("\nQual é seu email?");
        email1 =ler.nextLine();
        cliente.setEmail(email1);
        
        System.out.println("\nQuantos itens irá comprar?");
        int quantidade = ler.nextInt();
        ler.nextLine();
      
        
        Item[] itens = new Item[quantidade];
        
        for(int i = 0; i<itens.length;i++){
        
            Item item = new Item();
            System.out.println("\nQual o nome do produto " + (i+1) + "?");
            nomeProduto = ler.nextLine();
            item.setNome(nomeProduto);
            System.out.println("\nQual o preço desse produto?");
            preco1 = ler.nextDouble();
            item.setPreco(preco1);
            ler.nextLine();
            
              itens[i] = item;
              System.out.println();
        }
        
        Compra compra = new Compra();
        compra.setCliente(cliente);
        compra.setCarrinho(itens);
        System.out.println("\nDigite o cupom:");
        compra.setCupom(ler.nextLine());
        System.out.println("\nDigite o quanto quer parcelar:");
        compra.setParcelas(ler.nextInt());
        ler.nextLine();
        System.out.println("\nQual a forma de pagamento?");
        compra.setFormaPag(ler.nextLine());
        
        LojaOnline lojaOnline = new LojaOnline();
        lojaOnline.efetuarCompra(compra);
        
        NotaFiscal notaFiscal = lojaOnline.efetuarCompra(compra);
        
        System.out.println("\n==================");
        System.out.println("\nO total da compra foi R$"+ notaFiscal.getTotal());
        System.out.println("\nSua forma de pagamento foi "+ compra.getFormaPag()+".");
        System.out.println("\nOs intens da compra foram: ");
        for(Item item : itens){
            System.out.println(item.getNome());
        }
        System.out.println("\nO código da compra é "+notaFiscal.getCodNota());
        System.out.println("\nO valor das parelas é igual à R$" + notaFiscal.getValorParcela());
        System.out.println("==================");
    }
}
