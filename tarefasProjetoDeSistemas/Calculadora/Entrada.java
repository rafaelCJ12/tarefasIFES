//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.Scanner;


public class Entrada {
    public Scanner input;

   
    public Entrada() {
        this.input = new Scanner(System.in);
    }

    /**
     * Faz a leitura de uma linha inteira
     * Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
     * @param msg: Mensagem que será exibida ao usuário
     * @return Uma String contendo a linha que foi lida
     */
    String lerLinha(String msg) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.print(msg);
        String linha = this.input.nextLine();
        return linha;
    }

    /**
     * Faz a leitura de um número inteiro
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para int
     */
    int lerInteiro(String msg) throws NumberFormatException{
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        String linha = this.lerLinha(msg);
        return Integer.parseInt(linha);
    }

    /**
     * Faz a leitura de um double
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para double
     */
    double lerDouble(String msg) throws NumberFormatException{
        // Imprime uma mensagem ao usuário, lê uma linha contendo um double e retorna este double
        String linha = this.lerLinha(msg);
        return Double.parseDouble(linha);
    }


    void menu() {
        double valor1 = 0;
        double valor2 = 0;
        int opcao = -1;
        Factory f = new Factory();
        Operacao op;

        while(opcao != 0) {
            System.out.println("\n**Escolha uma opcao:**\n");
            System.out.println("1) Somar dois numeros.");
            System.out.println("2) Subtrair dois numeros.");
            System.out.println("3) Muliplicar dois numeros.");
            System.out.println("4) Dividir dois numeros.");
            System.out.println("0) Sair.");

            try{
                opcao = this.lerInteiro("Opcao: ");


                switch (opcao) {
                    case 0:
                        return;
                    case 1:
                        op = f.factory("Soma");
                        break;
                    case 2:
                        op = f.factory("Subtracao");
                        break;
                    case 3:
                        op = f.factory("Multiplicacao");
                        break;
                    case 4:
                        op = f.factory("Divisao");
                        break;
                
                    default:
                        op = null;
                        break;
                }

                if(op != null) {
                    valor1 = this.lerDouble("\nDigite o primeiro valor: ");
                    valor2 = this.lerDouble("Digite o segundo valor: ");

                    System.out.println("\nO resultado eh: "+op.resultado(valor1, valor2));
                }
                else{
                    System.out.println("\nOperacao invalida!");
                }
                
            }

            catch(NumberFormatException e) {
                System.out.println("\nEntrada invalida!");
            }

            catch(ArithmeticException a) {
                System.out.println("\nOperacao invalida!");
            }


        }
    }


}