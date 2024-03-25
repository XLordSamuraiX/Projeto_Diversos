package CompraOnline;
import java.util.Random;
public class LojaOnline {
    public NotaFiscal efetuarCompra (Compra compra){
        
        int codigo = this.gerarCodNota();
        double total = this.verificarCupom(compra);
        double parcela = this.calcularParcela(total, codigo);
        int parcelas = compra.getParcelas();
        double valorParcela = 0;
        if(parcelas > 1) {
             valorParcela = total / parcelas;
        } else {
             valorParcela = total ;
        }
        
        
        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setCliente(compra.getCliente());
        notaFiscal.setItens(compra.getCarrinho());
        notaFiscal.setValorParcela(valorParcela);
        notaFiscal.setCodNota(codigo);
        notaFiscal.setTotal(total);
        
        return notaFiscal;
    }
    
    private double calcularTotal (Compra compra){
        double w=0, y = 0, z,total=0;
        Item[] itens = compra.getCarrinho();
        for(Item item : itens){
            w+= item.getPreco();
        }
        String x = compra.getFormaPag();
        String a = "debito";
        String b = "credito";
        String c = "pix";
        
        if (x.equals(a)){
            y = w *0.05;
            z = w - y;
            total = z;
            return total;
        }
        
        else if (x.equals(b)){
            total = w;
            return total;
        }
        else
            y = w *0.10;
            z = w - y;
            total = z;
          return total;  
    }
    
    private double verificarCupom (Compra compra){
        String y = compra.getCupom();
        double total = this.calcularTotal(compra);
        double z;
        
        String a = "Quero100";
        String b = "Quero200";
        String c = "Quero500";
        
        if (y.equals(a)){
            z= total-100;
            return z;
        }
        else if (y.equals(b)){
            z= total-200;
            return z;
            
         }
          else if (y.equals(c)){
            z= total-500;
            return z;
            
         }
        else{
            z= total;
            return z;
        }
      
    }
    
    
    private double calcularParcela (double total, int parcelas){
        if (parcelas > 1) {
            double jurosPorMes = total * 0.03;
            double totalComJuros = total + jurosPorMes;
            return totalComJuros / parcelas;
        } else {
            return 1;
        }
    }
    
    private int gerarCodNota(){
        int codigo = (int)(Math.random()*999);
        return codigo;
    }
}
