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
            System.out.println("4 - Deletar contato");
            System.out.println("5 - Sair");
            try {
                operacao = sc.nextInt();
                switch (operacao) {
                     case 1:try {
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
                     } catch (Exception e) {
                        System.err.println(e);
                     }
                        

                        break;
                    case 2:
                    agenda.listarContato();
                    break;

                    case 3:try {
                        System.out.println("Digite o nome a ser buscado");
                        String nomeBuscado = sc.next();
                        System.out.println(agenda.buscarContato(nomeBuscado).toString());
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                        
                    break;

                    case 4:
                    try {
                        System.out.println("Digite o nome a ser buscado");
                        String nomeDeletar = sc.next();
                        agenda.removerContato(nomeDeletar);
                        System.out.println("Contato deletado com sucesso");
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    break;

                    case 5:
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
        } while (operacao !=5);
        sc.close();
    }
}