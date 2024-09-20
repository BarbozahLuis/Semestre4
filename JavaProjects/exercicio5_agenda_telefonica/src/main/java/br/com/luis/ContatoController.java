package br.com.luis;

public class ContatoController {
    // atributos
    private Contato[] contatos;
    private int contadorDeContatos;

    //construtor
    public ContatoController(int maxContato){
        
        this.contatos = new Contato[maxContato];
        contadorDeContatos = 0;
    }

    //métodos - adicionar contato
    public void addContato(Contato contato) throws Exception{
        if (contadorDeContatos>=contatos.length) {
            throw new AgendaCheiaException(" Agenda cheia");
        }
        try {
            contatos[contadorDeContatos]=contato;
            contadorDeContatos++;
            System.out.println("Contato adicionado");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    //métodos - listar todos
    public void listarContato(){
        if (contadorDeContatos ==0) {
            System.out.println("Agenda Vazia");
        }else{
            for (int i = 0; i < contadorDeContatos; i++) {
                System.out.println(contatos[i].toString());
            }
        }
    }



    //métodos - buscar contato pelo nome
    public void buscaNome(String nome) throws ContatoNaoEncontrado{
        for (int i = 0; i < contatos.length; i++) {
            if (contadorDeContatos==0) {
                System.out.println("Agenda Vazia");
            }else{
                if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                    System.out.println(contatos[i].toString());
                }
            }
        }
        
    }
    //buscar
    public Contato buscarContato(String nome) throws ContatoNaoEncontrado{
        for (int i = 0; i < contadorDeContatos; i++) {
            if (contatos[i].getNome().equals(nome)) {
                return contatos[i];
            }
        }
        throw new ContatoNaoEncontrado("Contato não encontrado");
    }
}
