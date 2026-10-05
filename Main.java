import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Cliente> fila = new LinkedBlockingQueue<>();
        Atendente[] atendentes = new Atendente[10];

        for (int i = 0; i < atendentes.length; i++) {
            atendentes[i] = new Atendente(i + 1, fila);
            atendentes[i].start();
        }

        try {
            // 30 chegadas, com intervalo de 2 segundos: 1 minuto.
            for (int id = 1; id <= 30; id++) {
                Cliente cliente = new Cliente(id);
                System.out.printf("Cliente %d entrou na fila.%n", cliente.getId());
                fila.add(cliente);
                Thread.sleep(2000);
            }
        } finally {
            for (Atendente atendente : atendentes) {
                atendente.interrupt();
            }
            for (Atendente atendente : atendentes) {
                atendente.join();
            }
        }

        System.out.println("\nRelatório de atendimentos concluídos:");
        for (Atendente atendente : atendentes) {
            System.out.printf("%s: %d atendimentos.%n",
                    atendente.getName(), atendente.getAtendimentosRealizados());
        }
    }
}
