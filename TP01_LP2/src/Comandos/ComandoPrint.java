package Comandos;

import Analisador.ReconhecimentoExpressoesNumericas;
import Memoria.Memoria;


public class ComandoPrint extends Comando<String>{
    private String linhaComando;
    char[] vetorComando;
    String impressao;
    int inicioParametros;

    public ComandoPrint(String linhaComando){
        super();
        
        this.linhaComando = linhaComando;
        vetorComando = linhaComando.toCharArray();
        impressao = new String();
        
        for(int i=5; i<vetorComando.length; i++){
            if(vetorComando[i]=='('){
                inicioParametros = i+1;
                break;
            }
        }
    }

    @Override
    public Memoria executar(Memoria memoria) {
        int contaStrings = 0;
        int contaVariaveis = 0;
        boolean concatenaVariavel = false;
        boolean ehVariavel = false;
        boolean ehString = false;
        String nomeVariavel = new String();

        for(int i=inicioParametros; i<vetorComando.length; i++){
            if(i==inicioParametros && vetorComando[i]!='"'){
                concatenaVariavel=true;
                contaVariaveis++;
            }
            
            else if(vetorComando[i]=='+' && concatenaVariavel==false){
                concatenaVariavel=true;
                if(vetorComando[i+1]!='"'){
                    contaVariaveis++;
                }
                else{
                    concatenaVariavel=false;
                }
            }
            
            else if(vetorComando[i]=='+' && concatenaVariavel==true){
                concatenaVariavel=false;
            }
            
            else if(vetorComando[i]=='"'&&vetorComando[i-1]!='\\'){
                contaStrings++;
            }
        }

        contaStrings=contaStrings/2;
        
        if(contaStrings==0){
            int numeros = 0;
            String expressao = "";
            for(int i = inicioParametros; i < vetorComando.length-1; i++){
                expressao += String.valueOf(vetorComando[i]);
                if(vetorComando[i]!='+' && vetorComando[i]!='-' && vetorComando[i]!='*' && vetorComando[i]!='/' && vetorComando[i]!='^'){
                    nomeVariavel+=vetorComando[i];
                }
                else{
                    if(memoria.getVariavel(nomeVariavel.trim()) instanceof Integer || memoria.getVariavel(nomeVariavel.trim()) instanceof Float){
                        numeros++;
                    }
                    nomeVariavel="";
                }
            }
            if(memoria.getVariavel(nomeVariavel.trim()) instanceof Integer || memoria.getVariavel(nomeVariavel.trim()) instanceof Float){
                numeros++;
            }
            nomeVariavel="";
            if(numeros == contaVariaveis+1 || numeros==1 && contaVariaveis==1){
                ReconhecimentoExpressoesNumericas expNum = new ReconhecimentoExpressoesNumericas();
                impressao = expNum.calcularExpressao(expressao, memoria);
            }
        }
        else{
            for (int i = inicioParametros; i < vetorComando.length; i++) {
                if(vetorComando[i]=='"'&&ehString==false){
                    ehString = true;
                }

                else if(ehString==true&&vetorComando[i]!='"'){
                    impressao+=String.valueOf(vetorComando[i]);
                }

                else if(ehString==true&&vetorComando[i]=='"'){
                    ehString=false;
                }

                else if(i==inicioParametros && vetorComando[i]!='"'){
                    ehVariavel=true;
                    nomeVariavel+=String.valueOf(vetorComando[i]);
                }

                else if(vetorComando[i] == '+' && ehVariavel == false && vetorComando[i+1] != '"' && vetorComando[i+1] != ' '){
                    ehVariavel=true;
                }

                else if(vetorComando[i] == '+' && ehVariavel == false && vetorComando[i+1] != '"' && vetorComando[i+1] == ' '){
                    for (i += 1; i < vetorComando.length; i++) {
                        if(vetorComando[i]!=' '){
                            break;
                        }
                    }
                    ehVariavel = true;
                    nomeVariavel += String.valueOf(vetorComando[i]);
                }

                else if(ehVariavel == true && vetorComando[i] != '+' && i != vetorComando.length-1 && vetorComando[i] != ' '){
                    nomeVariavel += String.valueOf(vetorComando[i]);
                }

                else if(ehVariavel == true && i != vetorComando.length-1 && vetorComando[i] == ' '){
                    for (i += 1; i < vetorComando.length; i++) {
                        if(vetorComando[i]=='+'){
                            if(vetorComando[i+1]=='"'){
                                ehVariavel = false;
                            }
                            else if(vetorComando[i+1]==' '){
                                for (i += 1; i < vetorComando.length; i++) {
                                    if(vetorComando[i]=='+'){
                                        impressao += String.valueOf(memoria.getVariavel(nomeVariavel));
                                        break;
                                    }
                                    else if(vetorComando[i] == '"'){
                                        ehVariavel = false;
                                        ehString = true;
                                        break;
                                    }
                                }
                            }
                            else if(vetorComando[i+1]!='"'){
                                ehVariavel = true;
                            }
                            impressao += String.valueOf(memoria.getVariavel(nomeVariavel));
                            nomeVariavel = new String();
                            break;
                        }
                        else if(vetorComando[i] == '"'){
                            ehString = true;
                            ehVariavel = false;
                            break;
                        }
                    }
                }

                else if(ehVariavel == true&&vetorComando[i] == '+'){
                    if(vetorComando[i+1]=='"'){
                        ehVariavel=false;
                    }
                    else if(vetorComando[i+1]==' '){
                        for (i += 1; i < vetorComando.length; i++) {
                            if(vetorComando[i]=='+'){
                                impressao += String.valueOf(memoria.getVariavel(nomeVariavel));
                                break;
                            }
                            else if(vetorComando[i] == '"'){
                                ehVariavel=false;
                                break;
                            }
                        }
                    }
                    else if(vetorComando[i+1]!='"'){
                        ehVariavel = true;
                    }
                    impressao += String.valueOf(memoria.getVariavel(nomeVariavel));
                    nomeVariavel = new String();
                }

                else if(i==vetorComando.length-1 && ehVariavel==true){
                    ehVariavel=false;
                    impressao += String.valueOf(memoria.getVariavel(nomeVariavel));
                    nomeVariavel = "";
                }

            }
        }
        if(vetorComando[5]=='l')
            System.out.print(impressao+"\n");
        
        else
            System.out.print(impressao);
        
        return memoria;
    }

    @Override
    public boolean verificarSintaxe() {
        int contaStrings = 0;
        int contaVariaveis = 0;
        boolean concatenaVariavel = false;
        boolean ehVariavel = false;
        boolean ehString = false;
        boolean variavelPreenchida = false;

        for(int i=inicioParametros; i<vetorComando.length; i++){
            if(i==inicioParametros && vetorComando[i]!='"'){
                concatenaVariavel=true;
                contaVariaveis++;
            }
            else if(vetorComando[i]=='+' && concatenaVariavel==false){
                concatenaVariavel=true;
                if(vetorComando[i+1]!='"'){
                    contaVariaveis++;
                }
                else{
                    concatenaVariavel=false;
                }
            }
            else if(vetorComando[i]=='+' && concatenaVariavel==true){
                if(vetorComando[i+1]==' '){
                    for(int j = i+1; vetorComando[j]==' '; j++){
                        if(vetorComando[j+1]!='"' && vetorComando[j+1] != ' '){
                            return false;
                        }
                        else if(vetorComando[j+1]=='+'){
                            return false;
                        }
                    }
                }
                else if(vetorComando[i+1]!='"' && !((vetorComando[i+1] >= 'a' && vetorComando[i+1] <= 'z') || (vetorComando[i+1] >= 'A' && vetorComando[i+1] <= 'Z'))){
                    return false;
                }
                concatenaVariavel=false;
            }
            else if(vetorComando[i]=='"'&&vetorComando[i-1]!='\\'){
                contaStrings++;
            }
        }

        if(contaStrings%2!=0){
            return false;
        }

        contaStrings=contaStrings/2;

        for (int i = inicioParametros; i < vetorComando.length; i++) {
            if(vetorComando[i]=='"'&&ehString==false){
                if(ehVariavel==true){
                    return false;
                }
                ehString = true;
            }
            else if(ehString==true&&vetorComando[i]=='"'){
                ehString=false;
                if(vetorComando[i+1]!='+' && i!=vetorComando.length-2){
                    return false;
                }
            }
            else if(i==inicioParametros && vetorComando[i]!='"'){
                ehVariavel=true;
            }
            else if(vetorComando[i] == '+' && ehVariavel == false && vetorComando[i+1] != '"'){
                ehVariavel=true;
            }
            
            else if(ehVariavel == true && vetorComando[i] == '+' && variavelPreenchida == true){
                ehVariavel = false;
                variavelPreenchida = false;
            }
            
            else if(ehVariavel == true && vetorComando[i] == '+' && variavelPreenchida == false){
                return false;
            }
            
            else if(ehVariavel == true && (vetorComando[i] >= 'a' && vetorComando[i] <= 'z') || (vetorComando[i] >= 'A' && vetorComando[i] <= 'Z') && variavelPreenchida == false){
                variavelPreenchida = true;
            }
            
            else if(ehVariavel == true && vetorComando[i] >= '0' && vetorComando[i] <= '9' && variavelPreenchida == false){
                return false;
            }
            
            else if(ehVariavel==true && variavelPreenchida == true && vetorComando[i] == ' '){
                for(i += 1; i < vetorComando.length-1; i++){
                    if(vetorComando[i+1] == '+'){
                        break;
                    }
                    else if((vetorComando[i] >= 'a' && vetorComando[i] <= 'z') || (vetorComando[i] >= 'A' && vetorComando[i] <= 'Z')){
                        return false;
                    }
                }
            }
            
            else if(i==vetorComando.length-1 && ehVariavel==true){
                ehVariavel=false;
            }
        }
        return true;
    }
}