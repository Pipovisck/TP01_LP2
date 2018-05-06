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
    
    public AnalisaPrograma(ArrayList<Character> listaCaracteres){
        this.listaCaracteres = new ArrayList<>(listaCaracteres);
        listaComandos = new ArrayList<>();
    }
    
    public ArrayList<String> separaComandos(){
        String buffer = "";
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
            }
            
            else if(listaCaracteres.get(i) >= 'A' && listaCaracteres.get(i) <= 'Z' || listaCaracteres.get(i) >= 'a' && listaCaracteres.get(i) <= 'z'){
                if(listaCaracteres.get(i) == 'p'){
                    if(listaCaracteres.get(i+1) == 'r' && listaCaracteres.get(i+2) == 'i' && listaCaracteres.get(i+3) == 'n' && listaCaracteres.get(i+4) == 't'){
                        if(listaCaracteres.get(i+5) == 'l' && listaCaracteres.get(i+6) == 'n'){
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
                        }
                        else if(listaCaracteres.get(i+5) == ' '){
                            for(int j = i+5; j<listaCaracteres.size(); j++){
                                if(listaCaracteres.get(j) != ' '){
                                    if(listaCaracteres.get(j)=='('){
                                        ehComando = true;
                                    }
                                    break;
                                }
                            }
                        }
                        else if(listaCaracteres.get(i+5) == '('){
                                ehComando = true;
                        }
                        
                        if(ehComando==true){
                            while(listaCaracteres.get(i) != '('){
                                buffer += (String.valueOf(listaCaracteres.get(i)));
                                i++;
                            }
                            buffer += (String.valueOf(listaCaracteres.get(i)));
                            i++;
                            for(parenteses = 1; parenteses > 0 && i<listaCaracteres.size(); i++){
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
                        }
                    }
                }
                else if(listaCaracteres.get(i) == 'r'){
                    if(listaCaracteres.get(i+1) == 'e' && listaCaracteres.get(i+2) == 'a' && listaCaracteres.get(i+3) == 'd' && listaCaracteres.get(i+4) == 'i' && listaCaracteres.get(i+5) == 'n' && listaCaracteres.get(i+6) == 't'){
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
                            while(listaCaracteres.get(i) != '('){
                                buffer += (String.valueOf(listaCaracteres.get(i)));
                                i++;
                            }
                            buffer += (String.valueOf(listaCaracteres.get(i)));
                            i++;
                            for(parenteses = 1; parenteses > 0 && i<listaCaracteres.size(); i++){
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
                        }
                    }
                }
                
                else if(listaCaracteres.get(i) == 'i'){
                    if(listaCaracteres.get(i+1) == 'f'){
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
                            while(listaCaracteres.get(i) != '('){
                                buffer += (String.valueOf(listaCaracteres.get(i)));
                                i++;
                            }
                            buffer += (String.valueOf(listaCaracteres.get(i)));
                            i++;
                            for(parenteses = 1; parenteses > 0 && i<listaCaracteres.size(); i++){
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
                                i+=4;
                                ehBloco = true;
                            }
                            listaComandos.add(buffer);
                            buffer = "";
                        }
                    }
                }
                else if(listaCaracteres.get(i+3) == 'w'){
                    if(listaCaracteres.get(i+4) == 'h' && listaCaracteres.get(i+5) == 'i' && listaCaracteres.get(i+6) == 'l' && listaCaracteres.get(i+5) == 'e'){
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
                            while(listaCaracteres.get(i) != '('){
                                buffer += (String.valueOf(listaCaracteres.get(i)));
                                i++;
                            }
                            buffer += (String.valueOf(listaCaracteres.get(i)));
                            i++;
                            for(parenteses = 1; parenteses > 0 && i<listaCaracteres.size(); i++){
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
                                for(int j = i; j < i+4; j++){
                                    buffer += String.valueOf(listaCaracteres.get(j));
                                }
                                i+=4;
                                ehBloco = true;
                            }
                            listaComandos.add(buffer);
                            buffer = "";
                        }
                    }
                }
                
                else if(listaCaracteres.get(i) == 'f'){
                    if(listaCaracteres.get(i+1) == 'o' && listaCaracteres.get(i+2) == 'r'){
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
                            while(listaCaracteres.get(i) != '('){
                                buffer += (String.valueOf(listaCaracteres.get(i)));
                                i++;
                            }
                            buffer += (String.valueOf(listaCaracteres.get(i)));
                            i++;
                            for(parenteses = 1; parenteses > 0 && i<listaCaracteres.size(); i++){
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
                                for(int j = i; j < i+4; j++){
                                    buffer += String.valueOf(listaCaracteres.get(j));
                                }
                                i+=4;
                                ehBloco = true;
                            }
                            listaComandos.add(buffer);
                            buffer = "";
                        }
                    }
                }
                else if(listaCaracteres.get(i) == 'e'){
                    if(listaCaracteres.get(i+1) == 'n' && listaCaracteres.get(i+2) == 'd'){
                        if(listaCaracteres.get(i+3)=='i' && listaCaracteres.get(i+4) == 'f'){
                            for(int j=i; j < i+5; j++){
                                buffer += String.valueOf(listaCaracteres.get(j));
                            }
                            i+=5;
                            listaComandos.add(buffer);
                            buffer = "";
                            ehBloco=false;
                        }
                        else if(listaCaracteres.get(i+3) == 'f' && listaCaracteres.get(i+4) == 'o' && listaCaracteres.get(i+5) == 'r'){
                            for(int j=i; j < i+6; j++){
                                buffer += String.valueOf(listaCaracteres.get(j));
                            }
                            i+=6;
                            listaComandos.add(buffer);
                            buffer = "";
                            ehBloco=false;
                        }
                        else if(listaCaracteres.get(i+3) == 'w' && listaCaracteres.get(i+4) == 'h' && listaCaracteres.get(i+5) == 'i' && listaCaracteres.get(i+6) == 'l' && listaCaracteres.get(i+7) == 'e'){
                            for(int j=i; j < i+8; j++){
                                buffer += String.valueOf(listaCaracteres.get(j));
                            }
                            i+=8;
                            listaComandos.add(buffer);
                            buffer = "";
                            ehBloco=false;
                        }
                    }
                }
                if(ehComando == false){
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
                                    if(!(listaCaracteres.get(i) == '+' || listaCaracteres.get(i) == '-' || listaCaracteres.get(i) == '*' || listaCaracteres.get(i) == '/')){
                                        //ERRO AQUI
                                    }
                                    else{

                                    }
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
                        if(ehBloco == true){
                            blocoComando.add(buffer);
                        }
                        else{
                            listaComandos.add(buffer);
                        }
                        buffer = "";
                    }
                    else if(listaCaracteres.get(i) != ':' || listaCaracteres.get(i) == ':' && listaCaracteres.get(i+1) != '='){
                        //erro de sintaxe!!!
                    }
                }
            }
        }
        return listaComandos;
    }
}