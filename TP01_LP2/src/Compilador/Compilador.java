package Compilador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Arquivo.AnalisaPrograma;
import Comandos.AnalisaComandos;
import Arquivo.LeituraArquivo;
import Comandos.Comando;
import Excecoes.ExcecaoArquivoVazio;
import Memoria.Memoria;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathe
 */
public class Compilador {

    private AnalisaPrograma analisadorPrograma;
    private LeituraArquivo leitorArquivo;
    private ArrayList<Comando> comandos;
    private Memoria memoria;

    public Compilador() {
        this.analisadorPrograma = new AnalisaPrograma();
        this.leitorArquivo = new LeituraArquivo();
        this.leitorArquivo.setDiretorio("C:\\Users\\melog\\OneDrive\\Área de Trabalho\\TP01_LP2\\TP01_LP2\\cefetiny.txt");
        this.comandos = new ArrayList<>();
        this.memoria = new Memoria();
    }

    public void rodarPrograma() throws ExcecaoArquivoVazio {
        List<String> palavras = leitorArquivo.retornaLista();
        
        analisadorPrograma = new AnalisaPrograma (palavras);
        
//        palavras.forEach((palavra) -> {
//            comandos.add(analisadorComandos.comparaPalavras(palavra));
//        });
//        
//        comandos.forEach((comando) -> {
//            if (!comando.verificarSintaxe()) {
//                System.out.println("Sintaxe errada" + comando.toString());
//            }
//        });
//        comandos.forEach((comando) -> {
//            memoria = comando.executar(memoria);
//        });
    }
}
