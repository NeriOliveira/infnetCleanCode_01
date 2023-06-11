package br.dev.techstack.funcionalInt;

public class TesteRunnable {
    public static void main(String[] args) {
        /*      -> THREAD: Thread é uma forma como um processo/tarefa de um programa de computador
                  é divido em duas ou mais tarefas que podem ser executadas concorrentemente.
        */

        //Antigamente, para fazer uma Thread para contar até mil
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i < 1000; i++){
                    System.out.println(i);
                }
            }
        };

        new Thread(r).start();

        /* A partir do Java 8, toda intervace só com 1 método abstrato é considerada uma Interface Funcional */
        Runnable rLambda = () -> {
            for(int i = 0 ; i < 1000; i++){
                System.out.println(i);
            }
        };
        new Thread(rLambda).start();

        //Outra forma de usar on Lambda direto na Thread:
        new Thread(() -> {
            for(int i = 0 ; i < 1000; i++){
                System.out.println(i);
            }
        }).start();
    }
}
