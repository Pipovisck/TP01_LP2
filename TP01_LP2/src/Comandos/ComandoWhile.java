package Comandos;

import java.util.List;

/**
 *
 * @author aluno
 */
public class ComandoWhile extends Comando{
    private List<Comando> listaComandos;
    private String[] vetorLinhas; //Vetor que recebe todas as linhas do bloco de comando While
    private String expressao;
    
    public ComandoWhile(String[] vetorLinhas, List<Comando> listaComandos){
        this.vetorLinhas = vetorLinhas;
        this.listaComandos = listaComandos;
        this.expressao = retornaExpressao();
    }
    
    
    @Override
    public void executar() {
//        while(){
//            listaComandos.forEach((comando) -> {
//                comando.executar();
//            });
//        }
    }

    @Override
    public boolean verificarSintaxe() {
        return false;
    }
    
    private String retornaExpressao(){
        String linha = vetorLinhas[0];
        String express = new String();
        char[] vetor = linha.toCharArray();
        int inicio = 0;
        int fim = 0;
        
        for(int i = 0; i < vetor.length; i++){
            if(vetor[i] == '('){
                inicio = i + 1;
            }
            
            if(vetor[i] == ')'){
                fim = i;
            }    
        }
        
        for(int i = inicio; i < fim; i++){
            express += vetor[i];
        }
        
        return express;
    }
    
    
}