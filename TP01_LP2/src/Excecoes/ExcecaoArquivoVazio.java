package Excecoes;

/**
 *
 * @author tomate
 */
public class ExcecaoArquivoVazio extends Exception {

    public ExcecaoArquivoVazio() {
        this("O arquivo aberto para compilacao esta vazio!");
    }

    public ExcecaoArquivoVazio(String msg) {
        super(msg);
    }
}
