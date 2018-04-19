package Comandos;

import Analisador.ReconhecimentoExpressoes;
import Memoria.Memoria;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class ComandoFor extends Comando{
    private List<Comando> listaComandos;
    private String[] vetorLinhas;
    private Memoria memoria;
    private boolean to;
    private boolean downto;
    private int fimAtribuicao;

    public ComandoFor(String[] vetorLinhas) {
        this.vetorLinhas = vetorLinhas;
        this.listaComandos = pegaListaComandos();
        this.downto = false;
        this.to = false;
    }

    @Override
    public Memoria executar(Memoria memoria) {
        this.memoria = memoria;
        ReconhecimentoExpressoes exp = new ReconhecimentoExpressoes();
        String atribuicao;
        String[] partesAtribuicao;
        String nomeVar;
        int valorVar;
        String condicaoParada;
        char[] linha1 = vetorLinhas[0].toCharArray();
        String linhaSemEspaco = tiraEspaco(linha1);
        
        linha1 = linhaSemEspaco.toCharArray();
        
        //Parte que mexe com a atribuição
        atribuicao = pegaComandoAtribuicao(linha1);
        partesAtribuicao = atribuicao.split(":=");
        
        nomeVar = partesAtribuicao[0];
        valorVar = Integer.parseInt(exp.calcularExpressao(partesAtribuicao[1]));
        
        if(memoria.getVariavel(partesAtribuicao[0]) == null){
            memoria.add(nomeVar, valorVar);
        }else{
            memoria.setVariavel(nomeVar, valorVar);
        }
        
        condicaoParada = pegaCondicaoParada(linha1);
        
        //Cria o laço de repetição
        int iterador = Integer.parseInt(memoria.getVariavel(nomeVar).toString());
        
//        if (this.downto == true) {
//            while(condicaoParada == true){
//                listaComandos.forEach((comando) -> {
//                    comando.executar(this.memoria);
//                });
//                
//                iterador--;
//                memoria.setVariavel(nomeVar, iterador);
//            }
//            
//        }else if(this.to == true){
//            while(condicaoParada == true){
//                listaComandos.forEach((comando) -> {
//                    comando.executar(this.memoria);
//                });
//                
//                iterador++;
//                memoria.setVariavel(nomeVar, iterador);
//            }
//        }

        return this.memoria;
    }

    @Override
    public boolean verificarSintaxe() {
        String comando = new String();
        String atribuicao = new String();
        String condicaoParada = new String();
        String[] partesAtribuicao = new String[2];
        char[] linha1 = vetorLinhas[0].toCharArray();
        String linhaSemEspaco = tiraEspaco(linha1);
        
        linha1 = linhaSemEspaco.toCharArray();
        
        //Confere se o comando começa com um "for"
        for (int i = 0; i < 3; i++) {
            comando += linha1[i];
        }
        if (!comando.equals("for")) {
            return false;
        }
        
        //Parte que mexe com a atribuição
        atribuicao = pegaComandoAtribuicao(linha1);
        
        if (atribuicao == null) {
            return false;
        }
        
        //Parte que confere se existe condicao de parada
        condicaoParada = pegaCondicaoParada(linha1);
        
        if (condicaoParada == null) {
            return false;
        }
        
        
        return true;
    }
    
    private List<Comando> pegaListaComandos(){
        List listaComand = new LinkedList();
        for (int i = 1; i < vetorLinhas.length - 1; i++) {
            listaComand.add(vetorLinhas[i]);
        }
        
        return listaComand;
    }
    
    private String tiraEspaco(char[] linha){
        String linhaSemEspaço = new String();
        
        for (char i : linha) {
            if(i != ' '){
                linhaSemEspaço += i;
            }
        }
        
        return linhaSemEspaço;
    }
    
    private String pegaComandoAtribuicao(char[] linha){
        String atribuicao = new String();
        String incrementador = new String();
        
        for (int i = 3; i < linha.length; i++) {
            if (linha[i] == 'd') {
                for (int j = i; j < i + 6; j++) {
                    incrementador += linha[j];
                }
                
                if (incrementador.equals("downto")) {
                    this.downto = true;
                    this.fimAtribuicao = i+7;
                    return atribuicao;
                }else{
                    incrementador = "";
                }
            }
            
            if (linha[i] == 't') {
                for (int j = i; j < i + 2; j++) {
                    incrementador += linha[j];
                }
                
                if (incrementador.equals("to")) {
                    this.to = true;
                    this.fimAtribuicao = i+3;
                    return atribuicao;
                }else{
                    incrementador = "";
                }
            }
            
            atribuicao += linha[i];
        }
        
        return null;
    }
    
    private String pegaCondicaoParada(char[] linha){
        String condicaoParada = new String();
        
        for (int i = this.fimAtribuicao; i < linha.length; i++) {
            if (linha[i] == 'd' && linha[i + 1] == 'o' && (i + 1) == (linha.length - 1)) {
                return condicaoParada;
            }
            condicaoParada += linha[i];
        }
        
        return null;
    }
    
}
