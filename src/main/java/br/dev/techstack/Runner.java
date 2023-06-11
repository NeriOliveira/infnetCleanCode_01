/* Curso de Engenharia de Software da INFNET - Profº Leonardo Silva da Gloria*/

package br.dev.techstack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Runner {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        /*Exemplos de Criação de Listas e Características dos métodos*/
        Usuario patrick = new Usuario("Patrick", 500);
        Usuario jamile = new Usuario("Jamile", 650);
        Usuario joao = new Usuario("Joao", 550);
        Usuario erica = new Usuario("Erica", 650);

        //Lista 1
        List<Usuario> usuarios = Arrays.asList(patrick, jamile, joao, erica);

        //Lista 2
        ArrayList<Usuario> usuarios1 = new ArrayList<>();
        usuarios1.add(patrick);
        usuarios1.add(jamile);
        usuarios1.add(joao);
        usuarios1.add(erica);

        // NÃO DÁ PRA REMOVER CONTEÚDO QUANTO UTILIZA ESTE MÉTODO PRA CRIAR LISTA "Arrays.asList",
        // POIS É RETORNADO UM VALOR DE LISTA IMUTÁVEL
        //usuarios.remove(joao);


        //Método para imprimir o nome de todos os usuários
        // PADRÃOZÃO ANTIGO QUE TOODO MUNDO APRENDE:
        for(Usuario user: usuarios){
            System.out.println(user);
        }

        //A partir do JAVA 8, método "novo":
        System.out.println("========== For Each ==========");
        Mostrador mostrador = new Mostrador();
        usuarios.forEach(mostrador);


        System.out.println("========== Classe Anônima ==========");
        //Classe Anônima:
        //  Definição: As classes anônimas não podem serem instanciadas em outros lugares do código,
        //  porque ela não está salva como uma classe separada, junto com as outras no target
        //  É uma classe gerada "sem nome", por isso não é possível chamá-la outra vez

        Consumer<Usuario> consumer = new Consumer<>() {
            @Override
            public void accept(Usuario usuario) {
                System.out.println(usuario.getNome() + ":" + usuario.getPontos());
            }
        };
        usuarios.forEach(consumer);

        usuarios.forEach(new Consumer<Usuario>() {
            @Override
            public void accept(Usuario usuario) {
                System.out.println(usuario.getNome() + ":" + usuario.getPontos());
            }
        });


        System.out.println("========== Lambda ==========");
        //LAMBDA:
        // É a capacidade que uma linguagem vai ter para tratar uma função como um tipo de variável

        Consumer<Usuario> consumerLambda = (Usuario u) -> {
            System.out.println(u.getNome() + ":" + u.getPontos());
        };

        Consumer<Usuario> consumerLambda2 =  u -> {System.out.println(u.getNome() + ":" + u.getPontos());};

        Consumer<Usuario> consumerLambda3 =  u -> System.out.println(u.getNome() + ":" + u.getPontos());


        usuarios.forEach(consumerLambda3);

        usuarios.forEach(u -> System.out.println(u.getNome() + ":" + u.getPontos()));


        /* E se precisasse aplicar um método para todos os usuários, exemplo: "Tornar Moderador"*/

        //Antigamente:
        for(Usuario user : usuarios){
            user.tornaModerador();
        }

        //ATUALMENTE, depois do Java8 com suporte para Lambda:
        usuarios.forEach(u -> u.tornaModerador());
    }
}