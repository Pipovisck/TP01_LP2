package model;


import java.io.*;
import java.util.*;

/**
 *
 * @author Felipe
 */
public class Arquivo {
    private String diretorio;
    private List listaLinhas;
    
    public Arquivo(){
        listaLinhas = new LinkedList();
    }

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }
    
    public List retornaLista(){
        String linha;
        
        try{
            FileReader arq = new FileReader(this.diretorio); //Abre o arquivo
            BufferedReader lerArq = new BufferedReader(arq); //Lê o arquivo
            
            linha = lerArq.readLine(); //Lê uma linha do arquivo
            listaLinhas.add(linha);
            
            while(linha != null){
                linha = lerArq.readLine(); //Lê linha por linha do arquivo
                listaLinhas.add(linha);
            }
            
        }catch (IOException e){
            System.err.println("Erro na abertura do arquivo.\n" + e.getMessage());
        }
        
        return listaLinhas;
    }
    
    public void imprimeConteudo(){
        String linha;
        
        try { 
            FileReader arq = new FileReader(this.diretorio); //Abre o arquivo
            BufferedReader lerArq = new BufferedReader(arq); //Lê o arquivo
            
            linha = lerArq.readLine(); //Lê uma linha do arquivo
            System.out.println(linha);
            
            while(linha != null){
                linha = lerArq.readLine(); //Lê linha por linha do arquivo
                System.out.println(linha);
            }
            
            
        }catch (IOException e){
            System.err.println("Erro na abertura do arquivo.\n" + e.getMessage());
        }
    }
}
