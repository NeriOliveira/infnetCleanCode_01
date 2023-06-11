package br.dev.techstack.interfacesTestes;
@FunctionalInterface
//  impede que sejam criados outros métodos para esta interface, para evitar que no momento de inserção de
//  um novo método para a interface Gato, a aplicação fique quebrada. Esta marcação serve para marcar a interface
//  e fazer que não permita/dê erro durante a compilação
public interface Gato {
    void miar();


    // A única possibilidade de adicionar outro método dentro de uma Interface Funcional, é se este método for
    // um método DEFAULT, como acontece na interface "Consumer"

    // DEFAULT METHODS são implementações dentro de uma Interface, além do método abstrato


}
