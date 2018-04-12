package calculadora;
import calculadora.Excecoes.ExcecaoEntradaDados;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) throws ExcecaoEntradaDados {
        
        Scanner leitor = new Scanner(System.in);
        String entradasPermitidas = "0123456789()^*/+-,";
        System.out.println("Digite a expressao:");
        String expressaoLida = leitor.next();
        
        ReconhecimentoExpressoes obj = new ReconhecimentoExpressoes();
        obj.verificaEntradas(expressaoLida, entradasPermitidas);
        
        System.out.printf("Resultado: %.2f\n", Float.parseFloat(obj.calcularExpressao(expressaoLida)));        
    }
}
