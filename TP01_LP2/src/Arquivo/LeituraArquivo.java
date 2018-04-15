package Arquivo;

import Excecoes.ExcecaoArquivoVazio;
import java.io.*;
import java.util.*;

/**
 *
 * @author Augusto, Felipe e João Victor.
 */
public class LeituraArquivo {
    private String diretorio;
    private List listaPalavras;

    public LeituraArquivo() {
        listaPalavras = new LinkedList();
    }
    public String getDiretorio() {
        return diretorio;
    }
    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }
    public List retornaLista()throws ExcecaoArquivoVazio {
        String linha;
        String[] palavras;

        //Esse try com parenteses foi adicionado no Java 7. Eh o java-with-resources e ja fecha os arquivos automaticamente.
        
        try (FileReader arq = new FileReader(this.diretorio);
            BufferedReader lerArq = new BufferedReader(arq)){

            linha = lerArq.readLine();
            if(linha == null){
                throw new ExcecaoArquivoVazio();
            }
            while (linha != null) {
                palavras = linha.split(" ");
                listaPalavras.addAll(Arrays.asList(palavras)); 
                linha = lerArq.readLine();
            }
        } catch (IOException e) {
                System.err.println("Erro na abertura do arquivo.\n" + e.getMessage());
        }
        
        //Teste
        System.out.println(listaPalavras.size());
        for(int i = 0; i < listaPalavras.size(); i ++)
            System.out.println(listaPalavras.get(i).toString() + " ");
        AnalisaPrograma x = new AnalisaPrograma(listaPalavras);
        x.excluiEspacos();
        //x.retornaListaLinhas();
        //Fim teste
        
        return listaPalavras;
    }
}
