package br.com.luis;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ContatoController agenda = new ContatoController(5);
        int operacao=0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n------Agenda de Contatos");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Listar contato");
            System.out.println("3 - Buscar contato pelo nome");
            System.out.println("4 - Sair");
            try {
                operacao = sc.nextInt();
                switch (operacao) {
                    case 1:
                        System.out.println("Nome: ");
                        String nome = sc.next();
                        System.out.println("Endereço: ");
                        String endereco = sc.next();
                        System.out.println("Email: ");
                        String email = sc.next();
                        System.out.println("Telefone: ");
                        String telefone = sc.next();
                        Contato contato = new Contato(nome, email, endereco, telefone);
                        agenda.addContato(contato);

                        break;
                    case 2:
                    agenda.listarContato();
                    break;

                    case 3:
                        System.out.println("Digite o nome a ser buscado");
                        String nomeBuscado = sc.next();
                        agenda.buscaNome(nomeBuscado);
                    break;

                    case 4:
                    System.out.println("Saindo...");
                    break;



                    default:
                    System.out.println("Digite um número valido");
                        break;
                }
            } catch (Exception e) {
                System.err.println(e);
                System.out.println("Digite um valor valido");
                break;
            }
        } while (operacao !=4);
        sc.close();
    }
}