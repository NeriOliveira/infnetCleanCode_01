package br.dev.techstack.methodRef;

import br.dev.techstack.Usuario;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Runner {
    public static void main(String[] args) {
        Usuario patrick = new Usuario("Patrick", 500);
        Usuario jamile = new Usuario("Jamile", 650);
        Usuario joao = new Usuario("Joao", 550);
        Usuario erica = new Usuario("Erica", 650);
        List<Usuario> usuarios = Arrays.asList(patrick, jamile, joao, erica);
        
        usuarios.forEach(u->u.tornaModerador());

        //OPERADOR "Dois Pontos": Método de inferência
        Consumer<Usuario> tornaModerador = Usuario::tornaModerador;
        usuarios.forEach(tornaModerador);

        //Usando Lambda com operador dois pontos:
        usuarios.forEach(Usuario::tornaModerador);

        /*
        Usuario::getNome == usuario -> usuario.getNome()
         */

        usuarios.sort(Comparator.comparing(usuario->usuario.getNome()));
        usuarios.sort(Comparator.comparing(Usuario::getNome));
        usuarios.sort((Comparator.comparingInt(Usuario::getPontos).reversed()));

        //Faz a comparação por pontos e depois por nomes; Gera o Consumer para enviar no método SORT
        Comparator<Usuario> comparatorComposto = Comparator.comparingInt(Usuario::getPontos).thenComparing(Usuario::getNome);
        usuarios.sort(comparatorComposto);

        //Faz tudo direto no método SORT
        usuarios.sort(Comparator.comparingInt(Usuario::getPontos).thenComparing(Usuario::getNome));
    }
}
