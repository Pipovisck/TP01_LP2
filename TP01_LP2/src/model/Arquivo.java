package model;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Felipe
 */
public class Arquivo {
    private String diretorio;
    
    public Arquivo(){
        
    }

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }
    
    //Inserir método para retornar o arquivo lido
    
    public void imprimeConteudo(){
        String linha;
        
        try(FileReader arq = new FileReader(this.diretorio) //Abre o arquivo
        ) {
            BufferedReader lerArq = new BufferedReader(arq); //Lê o arquivo
            
            do{
                linha = lerArq.readLine(); //Lê linha por linha do arquivo
                
                if (linha == null) {
                    return;
                }
                
                System.out.println(linha);
            }while(linha != null);
            
            
        }catch (IOException e){
            System.err.println("Erro na abertura do arquivo.\n" + e.getMessage());
        }
    }
}
