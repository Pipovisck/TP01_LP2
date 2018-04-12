package calculadora.Excecoes;

public class ExcecaoPilhaVazia extends RuntimeException{
      
    public ExcecaoPilhaVazia(){
        this("Pilha"); 
    }  
    public ExcecaoPilhaVazia(String nome){
        super( nome + " está vazia" ); 
    } 
} 
