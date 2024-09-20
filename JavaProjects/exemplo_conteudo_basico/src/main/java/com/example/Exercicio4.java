package com.example;

public class Exercicio4 {
    //atributos
    int numero= -1;

    Scanner sc = new Scanner(System.in);

    //métodos
    //calcular fatorial - recursão
    public long fatorial (int numero){
        if (numero==0 || numero ==1) {
            return 1;
        }else{
            return numero*fatorial(numero-1);
        }
    }

    //fazer a operação
    public void calculadora() throws Exception{//declarar throws caso for utilizar
        while (true) {

            System.out.println("Digite um nº");
            if (numero<0) {
                throw new Exception("Não é permitido nº Negativo");
            }
            try {
                
                long resultado = fatorial(numero);
                System.out.println("o Fatorial é "+resultado);
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
}
