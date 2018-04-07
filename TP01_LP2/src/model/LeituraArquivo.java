package model;
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
    public List retornaLista() {
        String linha;
        String[] palavras;
        
        //Esse try com parenteses foi adicionado no Java 7. Eh o java-with-resources e ja fecha os arquivos
        //automaticamente. No caso, ele fechara o arq (FileReader) e o lerArq (BufferedReader) sem nos preocuparmos com isso.
        
        try (FileReader arq = new FileReader(this.diretorio); //Abre o arquivo
            BufferedReader lerArq = new BufferedReader(arq)){ //Lê o arquivo

            linha = lerArq.readLine(); //Lê uma linha do arquivo
            if(linha != null){
                palavras = linha.split(" ");
                listaPalavras.add(palavras);
            }else{
                System.err.println("O arquivo está vazio!");
            }
            linha = lerArq.readLine(); //Lê linha por linha do arquivo
            while (linha != null) {
                palavras = linha.split(" ");
                listaPalavras.add(palavras); 
                linha = lerArq.readLine(); //Lê linha por linha do arquivo
            }
        } catch (IOException e) {
                System.err.println("Erro na abertura do arquivo.\n" + e.getMessage());
        }
        
        return listaPalavras;
    }

    public void imprimeConteudo() {
        String linha;
        
        //Esse try com parenteses foi adicionado no Java 7. Eh o java-with-resources e ja fecha os arquivos
        //automaticamente. No caso, ele fechara o arq (FileReader) e o lerArq (BufferedReader) sem nos preocuparmos com isso.
            
        try (FileReader arq = new FileReader(this.diretorio); //Abre o arquivo
                 BufferedReader lerArq = new BufferedReader(arq)){ //Lê o arquivo
                
                linha = lerArq.readLine(); //Lê uma linha do arquivo
                System.out.println(linha);
                
                while (linha != null) {
                    linha = lerArq.readLine(); //Lê linha por linha do arquivo
                    System.out.println(linha);
                }
            } catch (IOException e) {
            System.err.println("Erro na abertura do arquivo.\n" + e.getMessage());
        }
    }
}
