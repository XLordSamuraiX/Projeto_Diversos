package ADO_1;

public class Funcoes {
    private Produto[] produtos;
    private int tamanho;

    public Funcoes(int tamanho){
        this.produtos = new Produto[tamanho];
        this.tamanho = 0;
    }

    public void adicionarProduto(Produto produto) {
        if (tamanho < produtos.length) {
            produtos[tamanho] = produto;
            tamanho++;
            System.out.println("Produto adicionado com sucesso!");
        } else {
            System.out.println("Não foi possível adicionar o produto. Limite de vendas atingido.");
        }
    }

    public Produto buscarProduto(int codigo) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.produtos[i].getCodigo() == codigo) {
                return this.produtos[i];
            }
        }
        return null;
    }

    public double calcularTotalVendas() {
        double total = 0;
        for (int i = 0; i < this.tamanho; i++) {
            total += this.produtos[i].getPreco() * this.produtos[i].getQuantidade();
        }
        return total;
    }

    public void remove(int codigo){
        for (int i = 0; i < this.tamanho; i++) {
            if (this.produtos[i].getCodigo() == codigo) {
                for (int j = i; j < this.tamanho - 1; j++) {
                    this.produtos[j] = this.produtos[j + 1];
                }
                this.tamanho--;
                System.out.println("Produto removido com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }
}
