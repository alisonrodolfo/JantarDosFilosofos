/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jantardosfilosofos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author aliso
 */
public class Grade implements Runnable
{

    // Cria padrões de comportamento dos filósofos
    final int PENSANDO = 0;
    final int FAMINTO  = 1;
    final int COMENDO  = 2;

    // Mensagem para cada um dos estados
    String mensagem = "";

    // Thread principal da aplicação
    Thread animador;

    // Criação dos semáforos da aplicação

    // O semáforo mutex que recebe o valor incial 1 para o contador
    // e é o semáforo principal da nossa aplicação
    public static Semaforo mutex = new Semaforo(1);

    // O vetor semáforos são normais e existe um semáforo para cada filósofo
    // que será criado, esses semafóros não recebem valores de inicialização
    // portanto iniciando o contador em 0
    public static Semaforo semaforos[] = new Semaforo[5];

    // Define um vetor para o estado de cada um dos filósofos presentes
    // na aplicação
    public static int estado[] = new int[5];

    // Cria 5 filósofos em um vetor para a aplicação
    static Filosofo filosofo[] = new Filosofo[5];


    // Método para inicializar tudo o que é preciso dentro da classe
    public void init ()
    {
        // Inicializa todos estados para zero
        for (int i = 0; i < estado.length; i++)
        {
            estado[i] = 0;
        }

        // Verifica se o Thread de animação é vazio
        if(animador == null)
        {
            // Então cria um novo Thread
            animador = new Thread(this);
            // Inicia sua execução
            animador.start();
        }

        // Define a prioridade principal para este atual Thread
        Thread.currentThread().setPriority(1);

        // Inicializa todos filósofos
        filosofo[0] = new Filosofo("Platao", 0);
        filosofo[1] = new Filosofo("Socrates", 1);
        filosofo[2] = new Filosofo("Aristoteles", 2);
        filosofo[3] = new Filosofo("Tales", 3);
        filosofo[4] = new Filosofo("Sofocles", 4);

        // Inicializa todos semáforos
        semaforos[0] = new Semaforo(0);
        semaforos[1] = new Semaforo(0);
        semaforos[2] = new Semaforo(0);
        semaforos[3] = new Semaforo(0);
        semaforos[4] = new Semaforo(0);

        // Inicia a execução de todos filósofos
        filosofo[0].start();
        filosofo[1].start();
        filosofo[2].start();
        filosofo[3].start();
        filosofo[4].start();
    }

    // Método de execução da classe, onde o ambiente será rodado
    public void run ()
    {        
        // Uma execução infinita
        init();
        do
        {
            // Dorme durante um tempo para redesenhar novamente
            try
            {
                
                Thread.sleep(1000L);
            }
            catch (InterruptedException ex)
            {
                // Exibe uma mensagem de controle de erro
                System.out.println("ERROR>" + ex.getMessage());
            }
        }
        while (true);
    }

}

