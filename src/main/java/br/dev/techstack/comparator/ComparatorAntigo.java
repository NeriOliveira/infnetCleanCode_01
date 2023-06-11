package br.dev.techstack.comparator;

import br.dev.techstack.Usuario;

import java.util.*;

public class ComparatorAntigo {
    public static void main(String[] args) {
        Usuario patrick = new Usuario("Patrick", 500);
        Usuario jamile = new Usuario("Jamile", 650);
        Usuario joao = new Usuario("Joao", 550);
        Usuario erica = new Usuario("Erica", 650);

        //Lista 1
        List<Usuario> usuarios = Arrays.asList(patrick, jamile, joao, erica);

        Comparator<Usuario> comparator = new Comparator<Usuario>() {
            @Override
            public int compare(Usuario u1, Usuario u2) {
                return u1.getNome().compareTo(u2.getNome());
            }
        };
        Comparator<Usuario> comparatorLambda = (u1, u2) -> {
            return u1.getNome().compareTo(u2.getNome());
        };
        Collections.sort(usuarios, comparator);
        Collections.sort(usuarios, comparatorLambda);
        Collections.sort(usuarios, (u1, u2) -> u1.getNome().compareTo(u2.getNome()));
    }
}
