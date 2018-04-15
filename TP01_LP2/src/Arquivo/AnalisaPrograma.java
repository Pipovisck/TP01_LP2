package Arquivo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author tomate
 */
public class AnalisaPrograma {
    private List listaLinhasComando;
    private List listaPalavras;
    
    public AnalisaPrograma(){
        listaLinhasComando = new LinkedList();
        listaPalavras = new LinkedList();
    }
    
    public AnalisaPrograma(List listaPalavras){
        listaLinhasComando = new LinkedList();
        this.listaPalavras = listaPalavras;
    }
    
    public void setListaLinhasComando(List listaLinhasComando) {
        this.listaLinhasComando = listaLinhasComando;
    }
    
    public List getListaLinhasComando() {
        return listaLinhasComando;
    }
    
    public void setListaPalavras(List listaPalavras){
        this.listaPalavras = listaPalavras;
    }
    
    public List getListaPalavras(){
        return listaPalavras;
    }
    
    public List excluiEspacos(){
        String palavra;
        
        for(int i = 0; i < listaPalavras.size(); i++){
            if(listaPalavras.get(i).equals("") || listaPalavras.get(i).equals("/n") || 
                    listaPalavras.get(i).equals("/r") || listaPalavras.get(i).equals("/r/n")){
               listaPalavras.remove(i);
           } 
        }
        //Teste
        System.out.println("\n" + listaPalavras.size());
        while(!listaPalavras.isEmpty())
            System.out.println(listaPalavras.remove(0).toString() + " ");
        //Fim teste
        return listaPalavras;
    }
    public List retornaListaLinhas(){
        excluiEspacos();
        
        
        
        return listaLinhasComando;
    }
}
