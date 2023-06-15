package br.dev.techstack.streams;

import br.dev.techstack.Usuario;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Usuario patrick = new Usuario("Patrick", 500);
        Usuario jamile = new Usuario("Jamile", 650);
        Usuario joao = new Usuario("Joao", 550);
        Usuario erica = new Usuario("Erica", 650);
        List<Usuario> usuarios = Arrays.asList(patrick, jamile, joao, erica);
        List<Usuario> usuariosAntigo = Arrays.asList(patrick, jamile, joao, erica);
        List<Usuario> usuariosStream = Arrays.asList(patrick, jamile, joao, erica);

        // PROPOSTA -> UMA LISTA COM OS 2 USUÁRIOS MAIS BEM PONTUADOS PARA TRANSFORMAR EM MODERADOR
        //Primeira opção:
        usuarios.sort(Comparator.comparingInt(Usuario::getPontos).reversed());
        usuarios.subList(0,2).forEach(Usuario::tornaModerador);
        usuarios.forEach(u -> System.out.println(u.getNome() + " : " + u.isModerador()));


        //Antigamente:
        Collections.sort(usuariosAntigo, new Comparator<Usuario>() {
            @Override
            public int compare(Usuario o1, Usuario o2) {
                return o1.getPontos() - o2.getPontos();
            }
        });
        Collections.reverse(usuariosAntigo);
        List<Usuario> top2 = usuariosAntigo.subList(0, 2);
        for(Usuario u:top2){
            u.tornaModerador();
        }

        //Método antigo para tornar moderador quem tem 1000 ou mais pontos:
        for(Usuario u:usuariosAntigo){
            if(u.getPontos() >= 600){
                u.tornaModerador();
            }
        }

        //Filtro com método Stram
        usuariosStream.stream().filter(u -> u.getPontos() >= 600);
        usuarios.forEach(System.out::println);

    }
}
