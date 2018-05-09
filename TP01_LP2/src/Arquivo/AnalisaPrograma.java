package Arquivo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author tomate
 */
public class AnalisaPrograma {
    private ArrayList<Character> listaCaracteres;
    private ArrayList<String> listaComandos;
    private String buffer;
    
    public AnalisaPrograma(ArrayList<Character> listaCaracteres){
        this.listaCaracteres = new ArrayList<>(listaCaracteres);
        listaComandos = new ArrayList<>();
        this.buffer = "";
    }
    
    public ArrayList<String> separaComandos(){
        boolean ehBloco = false;
        boolean ehString = false;
        boolean ehComando = false;
        int parenteses = 0;
        ArrayList<Object> blocoComando = new ArrayList<Object>();
        
        for(int i=0; i<listaCaracteres.size(); i++){
            ehComando = false;
            
            if(listaCaracteres.get(i) == ' '){
                do{
                    i++;
                }while(listaCaracteres.get(i) == ' ');
                i--;
            }
            
            else if(listaCaracteres.get(i) >= 'A' && listaCaracteres.get(i) <= 'Z' || listaCaracteres.get(i) >= 'a' && listaCaracteres.get(i) <= 'z'){
                if(listaCaracteres.get(i) == 'p' && listaCaracteres.get(i+1) == 'r' && listaCaracteres.get(i+2) == 'i' && listaCaracteres.get(i+3) == 'n' && listaCaracteres.get(i+4) == 't'){
                    if(listaCaracteres.get(i+5) == 'l' && listaCaracteres.get(i+6) == 'n'){
                        if(listaCaracteres.get(i+7) == ' '){
                            for(int j = i+7; j<listaCaracteres.size(); j++){
                                if(listaCaracteres.get(j) != ' '){
                                    if(listaCaracteres.get(j)=='('){
                                        ehComando=true;
                                    }
                                    break;
                                }
                            }
                        }
                        else if(listaCaracteres.get(i+7) == '('){
                            ehComando=true;
                        }
                        if(ehComando==true){
                            i=adicionaPrintln(i);
                        }
                    }
                    else if(listaCaracteres.get(i+5) == ' '){
                        for(int j = i+5; j<listaCaracteres.size(); j++){
                            if(listaCaracteres.get(j) != ' '){
                                if(listaCaracteres.get(j)=='('){
                                    ehComando=true;
                                    i=adicionaPrint(i);
                                }
                                break;
                            }
                        }
                    }
                    else if(listaCaracteres.get(i+5) == '('){
                            ehComando=true;
                            i=adicionaPrint(i);
                    }
                }
                else if(listaCaracteres.get(i) == 'r' && listaCaracteres.get(i+1) == 'e' && listaCaracteres.get(i+2) == 'a' && listaCaracteres.get(i+3) == 'd' && listaCaracteres.get(i+4) == 'i' && listaCaracteres.get(i+5) == 'n' && listaCaracteres.get(i+6) == 't'){
                    if(listaCaracteres.get(i+7) == ' '){
                        for(int j = i+7; j<listaCaracteres.size(); j++){
                            if(listaCaracteres.get(j) != ' '){
                                if(listaCaracteres.get(j)=='('){
                                    ehComando = true;
                                }
                                break;
                            }
                        }
                    }
                    else if(listaCaracteres.get(i+7) == '('){
                            ehComando = true;
                    }

                    if(ehComando==true){
                        i=adicionaReadint(i);
                    }
                }
                
                else if(listaCaracteres.get(i) == 'i' && listaCaracteres.get(i+1) == 'f'){
                    if(listaCaracteres.get(i+2) == ' '){
                        for(int j = i+2; j<listaCaracteres.size(); j++){
                            if(listaCaracteres.get(j) != ' '){
                                if(listaCaracteres.get(j)=='('){
                                    ehComando = true;
                                }
                                break;
                            }
                        }
                    }
                    else if(listaCaracteres.get(i+2) == '('){
                        ehComando = true;
                    }
                    if(ehComando==true){
                        i=adicionaIf(i);
                    }
                }
                else if(listaCaracteres.get(i) == 'w' && listaCaracteres.get(i+1) == 'h' && listaCaracteres.get(i+2) == 'i' && listaCaracteres.get(i+3) == 'l' && listaCaracteres.get(i+4) == 'e'){
                    if(listaCaracteres.get(i+6) == ' '){
                        for(int j = i+7; j<listaCaracteres.size(); j++){
                            if(listaCaracteres.get(j) != ' '){
                                if(listaCaracteres.get(j)=='('){
                                    ehComando = true;
                                }
                                break;
                            }
                        }
                    }
                    else if(listaCaracteres.get(i+6) == '('){
                            ehComando = true;
                    }

                    if(ehComando==true){
                        i=adicionaWhile(i);
                    }
                }
                
                else if(listaCaracteres.get(i) == 'f' && listaCaracteres.get(i+1) == 'o' && listaCaracteres.get(i+2) == 'r'){
                    if(listaCaracteres.get(i+3) == ' '){
                        ehComando = true;
                    }

                    if(ehComando==true){
                        i=adicionaFor(i);
                    }
                }
                else if(listaCaracteres.get(i) == 'e'){
                    if(listaCaracteres.get(i+1) == 'n' && listaCaracteres.get(i+2) == 'd'){
                        int j=adicionaEnd(i);
                        if(j==-1){//o end encontrado era o de encerrar o programa
                            break;
                        }
                        if(i!=j){ //testa se o "end" encontrado eh realmente um comando ou nao
                            i=j;
                            ehComando=true;
                        }
                    }
                    else if(listaCaracteres.get(i+1) == 'l' && listaCaracteres.get(i+2) == 's' && listaCaracteres.get(i+3) == 'e' && (listaCaracteres.get(i+4) == ' ' || listaCaracteres.get(i+4) == '\r')){
                        i=adicionaElse(i);
                        ehComando=true;
                    }
                }
                if(ehComando == false){
                    i=adicionaAtribuicao(i);
                }
            }
        }
        return listaComandos;
    }
    
    private int adicionaPrint(int i){
        while(listaCaracteres.get(i) != '('){
            buffer += (String.valueOf(listaCaracteres.get(i)));
            i++;
        }
        buffer += (String.valueOf(listaCaracteres.get(i)));
        i++;
        for(int parenteses = 1; parenteses > 0 && i<listaCaracteres.size(); i++){
            buffer += (String.valueOf(listaCaracteres.get(i)));

            if(listaCaracteres.get(i) == '('){
                parenteses++;
            }
            else if(listaCaracteres.get(i) == ')'){
                parenteses--;
            }
        }
        listaComandos.add(buffer);
        buffer = "";

        return i;
    }
    
    private int adicionaPrintln(int i){
        while(listaCaracteres.get(i) != '('){
            buffer += (String.valueOf(listaCaracteres.get(i)));
            i++;
        }
        buffer += (String.valueOf(listaCaracteres.get(i)));
        i++;
        for(int parenteses = 1; parenteses > 0 && i<listaCaracteres.size(); i++){
            buffer += (String.valueOf(listaCaracteres.get(i)));

            if(listaCaracteres.get(i) == '('){
                parenteses++;
            }
            else if(listaCaracteres.get(i) == ')'){
                parenteses--;
            }
        }
        listaComandos.add(buffer);
        buffer = "";

        return i;
    }
    
    private int adicionaReadint(int i){
        while(listaCaracteres.get(i) != '('){
            buffer += (String.valueOf(listaCaracteres.get(i)));
            i++;
        }
        buffer += (String.valueOf(listaCaracteres.get(i)));
        i++;
        for(int parenteses = 1; parenteses > 0 && i<listaCaracteres.size(); i++){
            buffer += (String.valueOf(listaCaracteres.get(i)));

            if(listaCaracteres.get(i) == '('){
                parenteses++;
            }
            else if(listaCaracteres.get(i) == ')'){
                parenteses--;
            }
        }

        listaComandos.add(buffer);
        buffer = "";
        return i;
    }
    
    private int adicionaIf(int i){
        while(listaCaracteres.get(i) != '('){
            buffer += (String.valueOf(listaCaracteres.get(i)));
            i++;
        }
        buffer += (String.valueOf(listaCaracteres.get(i)));
        i++;
        for(int parenteses = 1; parenteses > 0 && i<listaCaracteres.size(); i++){
            buffer += (String.valueOf(listaCaracteres.get(i)));

            if(listaCaracteres.get(i) == '('){
                parenteses++;
            }
            else if(listaCaracteres.get(i) == ')'){
                parenteses--;
            }
        }
        if(listaCaracteres.get(i) == ' '){
            do{
                i++;
            }while(listaCaracteres.get(i) == ' ');
        }
        if(listaCaracteres.get(i) == 't' && listaCaracteres.get(i+1) == 'h' && listaCaracteres.get(i+2) == 'e' && listaCaracteres.get(i+3) == 'n'){
            for(int j = i; j < i+4; j++){
                buffer += String.valueOf(listaCaracteres.get(j));
            }
            i+=3;
        }
        listaComandos.add(buffer);
        buffer = "";
        return i;
    }
    
    private int adicionaElse(int i){
        for(int j = i; j < i+4; j++){
            buffer += String.valueOf(listaCaracteres.get(j));
        }
        i+=3;
        listaComandos.add(buffer);
        buffer = "";
        return i;
    }
    
    private int adicionaWhile(int i){
        while(listaCaracteres.get(i) != '('){
            buffer += (String.valueOf(listaCaracteres.get(i)));
            i++;
        }
        buffer += (String.valueOf(listaCaracteres.get(i)));
        i++;
        for(int parenteses = 1; parenteses > 0 && i<listaCaracteres.size(); i++){
            buffer += (String.valueOf(listaCaracteres.get(i)));

            if(listaCaracteres.get(i) == '('){
                parenteses++;
            }
            else if(listaCaracteres.get(i) == ')'){
                parenteses--;
            }
        }
        if(listaCaracteres.get(i) == ' '){
            do{
                i++;
            }while(listaCaracteres.get(i) == ' ');
        }
        if(listaCaracteres.get(i) == 'd' && listaCaracteres.get(i+1) == 'o'){
            for(int j = i; j < i+2; j++){
                buffer += String.valueOf(listaCaracteres.get(j));
            }
            i++;
        }
        listaComandos.add(buffer);
        buffer = "";
        return i;
    }
    
    private int adicionaFor(int i){
        for(i=i; i<listaCaracteres.size(); i++){
            buffer += (String.valueOf(listaCaracteres.get(i)));
            if(listaCaracteres.get(i-2)==' ' && listaCaracteres.get(i-1)=='d' && listaCaracteres.get(i)=='o' && (listaCaracteres.get(i+1)==' ' || listaCaracteres.get(i+1)=='\r')){
                break;
            }
        }
        listaComandos.add(buffer);
        buffer = "";
        return i;
    }
    
    private int adicionaEnd(int i){
        if(listaCaracteres.get(i+3)=='i' && listaCaracteres.get(i+4) == 'f'){
            for(int j=i; j < i+5; j++){
                buffer += String.valueOf(listaCaracteres.get(j));
            }
            i+=4;
            listaComandos.add(buffer);
            buffer = "";
        }
        else if(listaCaracteres.get(i+3) == 'f' && listaCaracteres.get(i+4) == 'o' && listaCaracteres.get(i+5) == 'r'){
            for(int j=i; j < i+6; j++){
                buffer += String.valueOf(listaCaracteres.get(j));
            }
            i+=5;
            listaComandos.add(buffer);
            buffer = "";
        }
        else if(listaCaracteres.get(i+3) == 'w' && listaCaracteres.get(i+4) == 'h' && listaCaracteres.get(i+5) == 'i' && listaCaracteres.get(i+6) == 'l' && listaCaracteres.get(i+7) == 'e'){
            for(int j=i; j < i+8; j++){
                buffer += String.valueOf(listaCaracteres.get(j));
            }
            i+=7;
            listaComandos.add(buffer);
            buffer = "";
        }
        else if(i == listaCaracteres.size()-1 || listaCaracteres.get(i+3) == ' '){
            for(int j=i; j < i+3; j++){
                buffer += String.valueOf(listaCaracteres.get(j));
            }
            i+=2;
            listaComandos.add(buffer);
            buffer = "";
            i=-1;
        }
        return i;
    }
    
    private int adicionaAtribuicao(int i){
        for(i=i; i<listaCaracteres.size(); i++){
            if((listaCaracteres.get(i) >= 'A' && listaCaracteres.get(i) <= 'Z' || listaCaracteres.get(i) >= 'a' && listaCaracteres.get(i) <= 'z' || listaCaracteres.get(i) >= '0' && listaCaracteres.get(i) <= '9')){
                buffer += String.valueOf(listaCaracteres.get(i));
            }
            else{
                break;
            }
        }
        if(listaCaracteres.get(i) == ' '){
            do{
                i++;
            }while(listaCaracteres.get(i) == ' ');
        }
        if(listaCaracteres.get(i) == ':' && listaCaracteres.get(i+1) == '='){
            buffer += listaCaracteres.get(i);
            i++;
            buffer += listaCaracteres.get(i);
            i++;

            if(listaCaracteres.get(i) == ' '){
                do{
                    i++;
                }while(listaCaracteres.get(i) == ' ');
            }

            for(i = i; i<listaCaracteres.size(); i++){
                if(listaCaracteres.get(i) == '\r'){
                    char caracterAnterior = listaCaracteres.get(i-1);
                    if(listaCaracteres.get(i-1)==' '){
                        for(int j=i-2; j>=0; j++){
                            if(listaCaracteres.get(j) != ' '){
                                caracterAnterior = listaCaracteres.get(j);
                                break;
                            }
                        }
                    }
                    if(listaCaracteres.get(i+2)=='\r'){
                        i+=2;
                    }
                    if(listaCaracteres.get(i-1) == '+' || listaCaracteres.get(i-1) == '-' || listaCaracteres.get(i-1) == '*' || listaCaracteres.get(i-1) == '/'){
                        if((listaCaracteres.get(i+2) == '+' || listaCaracteres.get(i+2) == '-' || listaCaracteres.get(i+2) == '*' || listaCaracteres.get(i+2) == '/')){
                            break;
                        }
                    }
                    else if(caracterAnterior=='"'){
                        break;
                    }
                    else if(listaCaracteres.get(i-1) >= 'A' && listaCaracteres.get(i-1) <= 'Z' || listaCaracteres.get(i-1) >= 'a' && listaCaracteres.get(i-1) <= 'z' || listaCaracteres.get(i-1) >= '0' && listaCaracteres.get(i-1) <= '9'){
                        if(listaCaracteres.get(i+2) >= 'A' && listaCaracteres.get(i+2) <= 'Z' || listaCaracteres.get(i+2) >= 'a' && listaCaracteres.get(i+2) <= 'z' || listaCaracteres.get(i+2) >= '0' && listaCaracteres.get(i+2) <= '9'){
                            break;
                        }
                    }
                    i+=2;
                }
                buffer += listaCaracteres.get(i);
                if(listaCaracteres.get(i) == ' '){
                    if(listaCaracteres.get(i-1) == '+' || listaCaracteres.get(i-1) == '-' || listaCaracteres.get(i-1) == '*' || listaCaracteres.get(i-1) == '/'){
                        do{
                            i++;
                        }while(listaCaracteres.get(i) == ' ');
                    }
                    else{
                        do{
                            i++;
                        }while(listaCaracteres.get(i) == ' ');
                        if(!(listaCaracteres.get(i) == '+' || listaCaracteres.get(i) == '-' || listaCaracteres.get(i) == '*' || listaCaracteres.get(i) == '/')){
                            i--;
                            break;
                        }
                    }
                }
            }
            listaComandos.add(buffer);
            buffer = "";
        }
        return i;
    }
}