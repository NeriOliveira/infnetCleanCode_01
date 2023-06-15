package br.dev.techstack.comparator;

import br.dev.techstack.Usuario;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class ComparandoPorPontos {
    public static void main(String[] args) {
        Usuario patrick = new Usuario("Patrick", 500);
        Usuario jamile = new Usuario("Jamile", 650);
        Usuario joao = new Usuario("Joao", 550);
        Usuario erica = new Usuario("Erica", 650);
        List<Usuario> usuarios = Arrays.asList(patrick, jamile, joao, erica);

        usuarios.sort(Comparator.comparing(u -> u.getPontos()));
        //Separando os objetos que estão dentro do Lambda acima:
        // Neste exemplo abaixo pode acontecer um problema de performace gerado pelo "auto-boxing", pois a variável que
        // armazena os pontos é do tipo "INT" e o Comparator.Comparing trata os dados como INTEGER.
        // Pode parecer "a mesma coisa", mas não é!!!!!
        Function<Usuario, Integer> extraiPontos = u -> u.getPontos();
        Comparator<Usuario> comparator = Comparator.comparing(extraiPontos);
        usuarios.sort(comparator);

        // Como resolver o problema do auto-boxing:
        ToIntFunction<Usuario> toIntFunction = u -> u.getPontos();
        Comparator<Usuario> comparatorInt = Comparator.comparingInt(toIntFunction);
        usuarios.sort(comparatorInt);

        //Lambda do toInt... Esse é o IDEAL:
        usuarios.sort(Comparator.comparingInt(u -> u.getPontos()));


    }
}
