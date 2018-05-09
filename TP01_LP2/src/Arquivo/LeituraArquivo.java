package Arquivo;

import Excecoes.ExcecaoArquivoVazio;
import com.sun.javafx.scene.control.skin.Utils;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Augusto, Felipe e João Victor.
 */
public class LeituraArquivo {
    private String diretorio;
    private ArrayList<Character> caracteres;

    public LeituraArquivo() {
        caracteres = new ArrayList<Character>();
    }
    public String getDiretorio() {
        return diretorio;
    }
    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }
    public ArrayList retornaLista()throws ExcecaoArquivoVazio {

        try {
            Scanner scanner = new Scanner(new FileInputStream("Ex5.txt"));

            scanner.useDelimiter("");

            while(scanner.hasNext()){
                caracteres.add(scanner.next().toCharArray()[0]);
            }
        }
        
        catch (FileNotFoundException ex) {
            Logger.getLogger(LeituraArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return caracteres;
    }
}
