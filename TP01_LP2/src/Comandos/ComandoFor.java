package Comandos;

import Analisador.ReconhecimentoExpressoes;
import Memoria.Memoria;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class ComandoFor extends Comando{
    private List<Comando> listaComandos;
    private String[] vetorLinhas;
    private Memoria memoria;

    public ComandoFor(List<Comando> listaComandos, String[] vetorLinhas) {
        this.listaComandos = listaComandos;
        this.vetorLinhas = vetorLinhas;
    }

    @Override
    public Memoria executar(Memoria memoria) {
        this.memoria = memoria;
        ReconhecimentoExpressoes exp = new ReconhecimentoExpressoes();
        String atribuicao;
        String[] partesAtribuicao;
        String nomeVar;
        int valorVar;
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


        return this.memoria;
    }

    @Override
    public boolean verificarSintaxe() {
        String comando = new String();
        String atribuicao;
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
        
        return false;
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
        String operador = new String();
        
        for (int i = 3; i < linha.length; i++) {
            atribuicao += linha[i];
            
            if (linha[i] == 'd') {
                for (int j = i; j < i + 6; j++) {
                    operador += linha[j];
                }
                
                if (operador.equals("downto")) {
                    return atribuicao;
                }else{
                    operador = "";
                }
            }
            
            if (linha[i] == 't') {
                for (int j = i; j < i + 2; j++) {
                    operador += linha[j];
                }
                
                if (operador.equals("to")) {
                    return atribuicao;
                }else{
                    operador = "";
                }
            }
        }
        return null;
    }
    
}
