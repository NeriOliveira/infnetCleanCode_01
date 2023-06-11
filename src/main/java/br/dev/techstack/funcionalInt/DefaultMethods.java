package br.dev.techstack.funcionalInt;

import br.dev.techstack.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class DefaultMethods {
    public static void main(String[] args) {

        Usuario patrick = new Usuario("Patrick", 500);
        Usuario jamile = new Usuario("Jamile", 650);
        Usuario joao = new Usuario("Joao", 550);
        Usuario erica = new Usuario("Erica", 650);

        //Lista 1
        List<Usuario> usuarios = Arrays.asList(patrick, jamile, joao, erica);

        Consumer<Usuario> imprimeBarra = usuario -> System.out.println("====================");
        Consumer<Usuario> imprimeNome = usuario -> System.out.println(usuario.getNome());

        //Usando Paradigma Imperativo(Estruturado):
        usuarios.forEach(usuario -> {
            System.out.println("====================");
            System.out.println(usuario.getNome());
        });

        //Usando Paradigma Declarativo(Funcional):
        //  O método andThen é mais aconselhável para travalhar com assinconicidade:
        usuarios.forEach(imprimeBarra.andThen(imprimeNome));
    }
}
