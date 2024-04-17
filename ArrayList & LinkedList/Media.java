import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Media{
    public static void main(String[] args) {
        int soma = 0, media;
        
        ArrayList<Integer> lista = new ArrayList<>();

        int x = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o número de notas que irá inserir:"));

        do {
            JOptionPane.showMessageDialog(null, "\n==Média de um Aluno=="+
                                                            "\n==Menu do Aluno==" +
                                                            "\n1. Adicionar Notas"+
                                                            "\n2. Buscar Notas"+
                                                            "\n3. Remover nota do aluno"+
                                                            "\n4. Calcular média"+
                                                            "\n5. Verificar se o aluno foi aprovado ou reprovado"+
                                                            "\n0. Sair do programa");
       
        int opcao =Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a opção: "));

        switch (opcao) {
            case 1:
                //Adicionando elementos a lista
                for(int i = 0; i<x; i++){
                    int y = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a nota " + (i+1) + ":"));
                    soma += y;
                    lista.add(y);
                }

                //Mostrando as notas do aluno
                for(int nota: lista){
                    int i= 0;
                    JOptionPane.showMessageDialog(null,"Nota " + (i+1) + " do aluno foi: " + nota);
                    i++;
                }
                break;

                case 2:
                int z = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a nota que queira busca:"));

                if(lista.contains(z)){
                    JOptionPane.showMessageDialog(null,"Essa nota foi encontrada na lista");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Essa nota não foi encontrada na lista");
                }
                    break;

                case 3:
                int w = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a posição da nota que queira remover:"));
                lista.remove(w);

                for(int nota: lista){
                    JOptionPane.showMessageDialog(null,"Notas inseridas foram: " + nota);
                 }
                    break;

                case 4:
                    media = calcularMedia(soma,x);

                    JOptionPane.showMessageDialog(null,"A média do aluno é: " + media);
                    break;

                case 5:
                    media = calcularMedia(soma, x);
                    
                     if (media>=6){
                        JOptionPane.showMessageDialog(null,"Aluno aprovado!!");
                     }else {
                        JOptionPane.showMessageDialog(null,"Aluno reprovado!!");
                     }
                    break;

                case 0:
                     System.exit(0);
                    break;
                    
        
            default:
                 JOptionPane.showMessageDialog(null,"Valor incorreto");
                break;
        }

        } while (x!=0);
    }

    // Método calcular média
    public static int calcularMedia (int soma, int x){
        int media = soma/x;
        return media;
    }
}