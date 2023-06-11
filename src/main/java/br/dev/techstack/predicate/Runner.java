package br.dev.techstack.predicate;

import br.dev.techstack.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Runner {
    public static void main(String[] args) {
        Usuario patrick = new Usuario("Patrick", 500);
        Usuario jamile = new Usuario("Jamile", 650);
        Usuario joao = new Usuario("Joao", 550);
        Usuario erica = new Usuario("Erica", 650);
        Usuario teste = new Usuario("Teste", 200);

        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(patrick);
        usuarios.add(jamile);
        usuarios.add(joao);
        usuarios.add(erica);
        usuarios.add(teste);

        //ANTIGAMENTE / PARADIGMA ANTIGO:
        for(Usuario u : usuarios){
            if (u.getPontos() < 400 ){
                usuarios.remove(u);
                System.out.println("Usuário " + u.getNome() + " removido por não atingir o mínimo de 400 pontos.");
            }
        }

        //NOVA FORMULA USANDO "removeif":
        Predicate<Usuario> menorQue400 = new Predicate<Usuario>() {
            @Override
            public boolean test(Usuario usuario) {
                return usuario.getPontos() < 400;
            }
        };
        usuarios.remove(menorQue400);

        //Outra forma:
        usuarios.removeIf(u -> u.getPontos()<400);
    }
}
