import java.util.concurrent.BlockingQueue;

public class Atendente extends Thread {
    private final BlockingQueue<Cliente> fila;
    private int atendimentosRealizados;

    public Atendente(int id, BlockingQueue<Cliente> fila) {
        super("Atendente " + id);
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Cliente cliente = fila.take();
                System.out.printf("%s iniciou o atendimento do cliente %d (%d segundos).%n",
                        getName(), cliente.getId(), cliente.getTempoAtendimento());

                Thread.sleep(cliente.getTempoAtendimento() * 1000L);

                atendimentosRealizados++;
                System.out.printf("%s terminou o atendimento do cliente %d.%n",
                        getName(), cliente.getId());
            }
        } catch (InterruptedException e) {
            interrupt();
        }
    }

    public int getAtendimentosRealizados() {
        return atendimentosRealizados;
    }
}
