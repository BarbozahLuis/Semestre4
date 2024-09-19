package com.example;

public class ExemploConceitoBasico { //classe do tipo publica 
    //atributos
    int idade = 25;
    double valor = 99.99;
    char letra = 'J';
    boolean teste = false;

    
    public static void main(String[] args) {
        int a = 30, b = 40;
        double c  = 3.5;
        boolean resultado = (a>b)&&(c < 5);

        System.out.println("soma a+b = "+(a+b));
        System.out.println("comapração a>b: "+(a>b));
        System.out.println(resultado);

    }

    public void declaracaoDeUmMetodo(int a , int b){//declaração de um método, sempre começa com a letra minuscula
        System.out.println(a+b);
    }

    public int metodoComReturn(int a, int b){ //declaração de método desta forma é necessário que exista algum retorno
        int c = a+b;
        return c;
    }
}
