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

/**
 *
 * @author mathe
 */
public class Compilador {

    private final AnalisaPrograma analisadorPrograma;
    private final LeituraArquivo leitorArquivo;
    private ArrayList<Comando> comandos;
    private Memoria memoria;

    public Compilador() throws ExcecaoArquivoVazio {
        this.leitorArquivo = new LeituraArquivo();
        this.analisadorPrograma = new AnalisaPrograma(leitorArquivo.retornaLista());

        //this.leitorArquivo.setDiretorio("C:\\Users\\melog\\OneDrive\\Área de Trabalho\\TP01_LP2\\TP01_LP2\\cefetiny.txt");
        this.comandos = new ArrayList<>();
        this.memoria = new Memoria();
    }

    public void rodarPrograma() throws ExcecaoArquivoVazio {
        ArrayList palavras = leitorArquivo.retornaLista();

        ArrayList lista = analisadorPrograma.separaComandos();
        AnalisaComandos analisa = new AnalisaComandos();
        comandos = analisa.comparaPalavras(lista);

//        palavras.forEach((palavra) -> {
//            comandos.add(analisadorComandos.comparaPalavras(palavra));
//        });
//        

        
//        comandos.forEach((comando) -> {
//            if (!comando.verificarSintaxe()) {
//                System.out.println("Sintaxe errada" + comando.toString());
//            }
//        });
        comandos.forEach((comando) -> {
            memoria = comando.executar(memoria);
        });
    }
}
