package calculadora.Excecoes;

public class ExcecaoEntradaDados extends Exception {

    public ExcecaoEntradaDados(){
        this("Você digitou algo diferente de um número inteiro ou dos operandos suportados.");
    }
    
    public ExcecaoEntradaDados(String msg){
        super(msg);
    }
}
