package br.dev.techstack.comparator;

import br.dev.techstack.Usuario;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.comparing;

public class OrdenandoListaNovo {
    public static void main(String[] args) {
        Usuario patrick = new Usuario("Patrick", 500);
        Usuario jamile = new Usuario("Jamile", 650);
        Usuario joao = new Usuario("Joao", 550);
        Usuario erica = new Usuario("Erica", 650);

        //Lista 1
        List<Usuario> usuarios = Arrays.asList(patrick, jamile, joao, erica);

        usuarios.sort((u1, u2) -> String.CASE_INSENSITIVE_ORDER.compare(u1.getNome(), u2.getNome()));
        Comparator<Usuario> comparator = Comparator.comparing(u -> u.getNome());
        usuarios.sort(comparator);
        usuarios.sort(comparing(u -> u.getNome()));
    }
}
