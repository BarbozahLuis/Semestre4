package br.com.luis;

public class ContatoNaoEncontrado extends Exception {
    public ContatoNaoEncontrado(String mensagem){
        super(mensagem);
    }
}
