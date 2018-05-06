package Comandos;

import static Constantes.Constantes.PALAVRAS_CONHECIDAS;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Augusto
 */
public class AnalisaComandos {
    
    ArrayList<Comando> comandos;
    String[] vetorComandos;

    public ArrayList<Comando> comparaPalavras(ArrayList<String> linhas) {
        
        vetorComandos = new String[linhas.size()];
        comandos = new ArrayList<>();
        int aux;
        int k;
        
        for (int i = 0; i < linhas.size(); i++) {
            
            if (linhas.get(i).contains(PALAVRAS_CONHECIDAS[11])){
                    if (" ".equals(linhas.get(i).substring(5)) || "(".equals(linhas.get(i).substring(5))){
                comandos.add(new ComandoPrint(linhas.get(i)));
                    }
            }
            if (linhas.get(i).contains(PALAVRAS_CONHECIDAS[12])){
                    if ("(".equals(linhas.get(i).substring(7)) || " ".equals(linhas.get(i).substring(7))) {
                comandos.add(new ComandoPrint(linhas.get(i)));
                    }   
            } else if (linhas.get(i).contains(PALAVRAS_CONHECIDAS[13])){
                    if ("(".equals(linhas.get(i).substring(7)) || " ".equals(linhas.get(i).substring(7))) {
                comandos.add(new ComandoReadInt(linhas.get(i)));
                    }
            } else if (linhas.get(i).contains(PALAVRAS_CONHECIDAS[0])){
                    if ("(".equals(linhas.get(i).substring(2)) || " ".equals(linhas.get(i).substring(2))) {
                aux = i + 1;
                k = 0;

                do {
                    vetorComandos[k] = linhas.remove(aux);
                    aux++;
                    k++;
                } while (!linhas.get(i).equals(PALAVRAS_CONHECIDAS[3]));

                ArrayList<String> auxIf;
                auxIf = new ArrayList<>();
                for (String comando : vetorComandos) {
                    auxIf.add(comando);
                }
                comandos.add(new ComandoIf(auxIf));
                    }
            } else if (linhas.get(i).contains(PALAVRAS_CONHECIDAS[4])){
                    if ("(".equals(linhas.get(i).substring(5)) || " ".equals(linhas.get(i).substring(5))) {
                aux = i + 1;
                k = 0;

                do {
                    vetorComandos[k] = linhas.remove(aux);
                    aux++;
                    k++;
                } while (!linhas.get(i).equals(PALAVRAS_CONHECIDAS[6]));

                comandos.add(new ComandoWhile(vetorComandos));
                    }
            } else if (linhas.get(i).contains(PALAVRAS_CONHECIDAS[7])){
                    if ("(".equals(linhas.get(i).substring(3)) || " ".equals(linhas.get(i).substring(3))) {
                aux = i + 1;
                k = 0;

                do {
                    vetorComandos[k] = linhas.remove(aux);
                    aux++;
                    k++;
                } while (!linhas.get(i).equals(PALAVRAS_CONHECIDAS[10]));

                comandos.add(new ComandoFor(vetorComandos));
                    }
            } else if (linhas.get(i).contains(":=")) {
                comandos.add(new ComandoAtribuicao(linhas.get(i)));
            } else if (linhas.get(i).equals(PALAVRAS_CONHECIDAS[14])) {
//                comandos.add(new ComandoEnd());
                i = linhas.size();
            }

        }

        return comandos;

    }
}
