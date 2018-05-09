package Comandos;

import Analisador.ReconhecimentoExpressaoLogica;
import Memoria.Memoria;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class ComandoWhile extends Comando {

    private List<Comando> listaComandos;
    private String[] vetorLinhas; //Vetor que recebe todas as linhas do bloco de comando While
    private String expressao;
    private int inicioExpressao;
    private int fimExpressao;
    private Memoria memoria;

    public ComandoWhile(String[] vetorLinhas) {
        this.vetorLinhas = vetorLinhas;
        this.listaComandos = this.montaListaComandos();
        this.expressao = this.retornaExpressao();
    }

    @Override
    public Memoria executar(Memoria memoria) {
        this.memoria = memoria;
        ReconhecimentoExpressaoLogica expLog = new ReconhecimentoExpressaoLogica();
        boolean expressaoResolvida = expLog.calcularExpressao(this.expressao, this.memoria);
        
        while(expressaoResolvida == true){
            listaComandos.forEach((comando) -> {
                comando.executar(this.memoria);
            });
            
            expressaoResolvida = expLog.calcularExpressao(this.expressao, this.memoria);
        }
        
        return this.memoria;
    }

    @Override
    public boolean verificarSintaxe() {
        String comando = new String();
        String fazer = new String();
        String primeiraLinha = this.tiraEspaco(this.vetorLinhas[0].toCharArray());
        char[] linha1 = primeiraLinha.toCharArray();
        
        for (int i = 0; i < 5; i++) {
            comando += linha1[i];
        }
        if (!comando.equals("while")) {
            return false;
        }
        
        if (!this.vetorLinhas[this.inicioExpressao].equals("(") || !this.vetorLinhas[this.fimExpressao].equals(")")) {
            return false;
        }
        
        if (retornaExpressao() == null) {
            return false;
        }
        
        for (int i = this.fimExpressao + 1; i < linha1.length; i++) {
            fazer += linha1[i];
        }
        if (!fazer.equals("do")) {
            return false;
        }
        
        if (montaListaComandos() == null) {
            return false;
        }
        
        if (!this.vetorLinhas[this.vetorLinhas.length - 1].equals("endwhile")) {
            return false;
        }
        
        return true;
    }
    
    private String tiraEspaco(char[] linha){
        String linhaSemEspaco = new String();
        
        for(char i : linha){
            if (i != ' ') {
                linhaSemEspaco += i;
            }
        }
        
        return linhaSemEspaco;
    }
    private String retornaExpressao() {
        String linha = tiraEspaco(this.vetorLinhas[0].toCharArray());
        String express = new String();
        char[] vetor = linha.toCharArray();
        int inicio = 0;
        int fim = 0;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == '(') {
                inicio = i + 1;
                this.inicioExpressao = i;
                break;
            }
        }
        
        for (int i = vetor.length - 1; i >= 0; i--) {
            if (vetor[i] == ')') {
                fim = i;
                this.fimExpressao = i;
                break;
            }
        }

        for (int i = inicio; i < fim; i++) {
            express += vetor[i];
        }

        return express;
    }
    
    private List<Comando> montaListaComandos(){
        ArrayList<String> comand = new ArrayList<>();
        AnalisaComandos analisa = new AnalisaComandos();
        
        for (int i = 1; i < this.vetorLinhas.length - 1; i++) {
            comand.add(vetorLinhas[i]);
}
        
        return analisa.comparaPalavras(comand);
}
}