import java.util.concurrent.ThreadLocalRandom;

public class Cliente {
    private final int id;
    private final int tempoAtendimento;

    public Cliente(int id) {
        this.id = id;
        this.tempoAtendimento = ThreadLocalRandom.current().nextInt(5, 16);
    }

    public int getId() {
        return id;
    }

    public int getTempoAtendimento() {
        return tempoAtendimento;
    }
}
