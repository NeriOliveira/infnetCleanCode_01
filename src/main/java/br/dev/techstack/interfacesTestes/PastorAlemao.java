package br.dev.techstack.interfacesTestes;

// TODA interface que só possuí um método abstrato, passou a ser uma Interface funcional

public class PastorAlemao implements Cachorro{
    @Override
    public void latir() {
        System.out.println("Latindo como um cachorro da raça P.Alemão");
    }

    @Override
    public void correr() {
        System.out.println("Correndo como um cachorro da raça P.Alemão");
    }

    @Override
    public void rosnar() {

    }
}
