# Trabalho 2 — Projeto e Arquitetura de Software

Simulação em Java de uma central de atendimento, seguindo o conceito KISS.

## Executar

Com o JDK instalado, execute na pasta do projeto:

```sh
javac Cliente.java Atendente.java Main.java
java Main
```

## Funcionamento

- `Cliente` possui um identificador único na simulação e um tempo aleatório inteiro entre 5 e 15 segundos.
- `Main` inicia 10 atendentes e gera 30 clientes: o primeiro imediatamente e os demais a cada 2 segundos, durante aproximadamente 1 minuto. A própria thread principal representa a chegada dos clientes.
- `Atendente` estende `Thread`. Cada atendente retira um cliente da fila, informa o início, espera o tempo de atendimento e informa o término.
- A fila compartilhada usa `LinkedBlockingQueue`, que permite acesso concorrente seguro. `take()` aguarda quando a fila está vazia, sem ficar consultando repetidamente.
- Ao completar o minuto, os atendentes são interrompidos, inclusive os que ainda estão atendendo. Atendimentos interrompidos não entram no relatório. Clientes ainda na fila não são atendidos.
- O programa espera todas as threads terminarem com `join()` antes de exibir o total concluído por atendente.


## Saída esperada
```txt
Cliente 1 entrou na fila.
Atendente 1 iniciou o atendimento do cliente 1 (12 segundos).
Cliente 2 entrou na fila.
Atendente 2 iniciou o atendimento do cliente 2 (6 segundos).
Cliente 3 entrou na fila.
Atendente 3 iniciou o atendimento do cliente 3 (13 segundos).
Cliente 4 entrou na fila.
Atendente 4 iniciou o atendimento do cliente 4 (8 segundos).
Atendente 2 terminou o atendimento do cliente 2.
Cliente 5 entrou na fila.
Atendente 5 iniciou o atendimento do cliente 5 (14 segundos).
Cliente 6 entrou na fila.
Atendente 6 iniciou o atendimento do cliente 6 (11 segundos).
Atendente 1 terminou o atendimento do cliente 1.
Cliente 7 entrou na fila.
Atendente 7 iniciou o atendimento do cliente 7 (15 segundos).
Atendente 4 terminou o atendimento do cliente 4.
Cliente 8 entrou na fila.
Atendente 8 iniciou o atendimento do cliente 8 (8 segundos).
Cliente 9 entrou na fila.
Atendente 9 iniciou o atendimento do cliente 9 (9 segundos).
Atendente 3 terminou o atendimento do cliente 3.
Cliente 10 entrou na fila.
Atendente 10 iniciou o atendimento do cliente 10 (14 segundos).
Cliente 11 entrou na fila.
Atendente 2 iniciou o atendimento do cliente 11 (13 segundos).
Atendente 6 terminou o atendimento do cliente 6.
Atendente 5 terminou o atendimento do cliente 5.
Atendente 8 terminou o atendimento do cliente 8.
Cliente 12 entrou na fila.
Atendente 1 iniciou o atendimento do cliente 12 (11 segundos).
Cliente 13 entrou na fila.
Atendente 4 iniciou o atendimento do cliente 13 (6 segundos).
Atendente 9 terminou o atendimento do cliente 9.
Cliente 14 entrou na fila.
Atendente 3 iniciou o atendimento do cliente 14 (7 segundos).
Atendente 7 terminou o atendimento do cliente 7.
Cliente 15 entrou na fila.
Atendente 6 iniciou o atendimento do cliente 15 (9 segundos).
Atendente 4 terminou o atendimento do cliente 13.
Cliente 16 entrou na fila.
Atendente 5 iniciou o atendimento do cliente 16 (8 segundos).
Atendente 10 terminou o atendimento do cliente 10.
Cliente 17 entrou na fila.
Atendente 8 iniciou o atendimento do cliente 17 (11 segundos).
Atendente 2 terminou o atendimento do cliente 11.
Atendente 1 terminou o atendimento do cliente 12.
Atendente 3 terminou o atendimento do cliente 14.
Cliente 18 entrou na fila.
Atendente 9 iniciou o atendimento do cliente 18 (15 segundos).
Cliente 19 entrou na fila.
Atendente 7 iniciou o atendimento do cliente 19 (8 segundos).
Atendente 6 terminou o atendimento do cliente 15.
Atendente 5 terminou o atendimento do cliente 16.
Cliente 20 entrou na fila.
Atendente 4 iniciou o atendimento do cliente 20 (14 segundos).
Cliente 21 entrou na fila.
Atendente 10 iniciou o atendimento do cliente 21 (9 segundos).
Cliente 22 entrou na fila.
Atendente 2 iniciou o atendimento do cliente 22 (5 segundos).
Atendente 8 terminou o atendimento do cliente 17.
Atendente 7 terminou o atendimento do cliente 19.
Cliente 23 entrou na fila.
Atendente 1 iniciou o atendimento do cliente 23 (7 segundos).
Cliente 24 entrou na fila.
Atendente 3 iniciou o atendimento do cliente 24 (12 segundos).
Atendente 2 terminou o atendimento do cliente 22.
Cliente 25 entrou na fila.
Atendente 6 iniciou o atendimento do cliente 25 (15 segundos).
Atendente 9 terminou o atendimento do cliente 18.
Atendente 10 terminou o atendimento do cliente 21.
Cliente 26 entrou na fila.
Atendente 5 iniciou o atendimento do cliente 26 (14 segundos).
Atendente 1 terminou o atendimento do cliente 23.
Atendente 4 terminou o atendimento do cliente 20.
Cliente 27 entrou na fila.
Atendente 8 iniciou o atendimento do cliente 27 (14 segundos).
Cliente 28 entrou na fila.
Atendente 7 iniciou o atendimento do cliente 28 (8 segundos).
Cliente 29 entrou na fila.
Atendente 2 iniciou o atendimento do cliente 29 (11 segundos).
Atendente 3 terminou o atendimento do cliente 24.
Cliente 30 entrou na fila.
Atendente 9 iniciou o atendimento do cliente 30 (9 segundos).

Relatório de atendimentos concluídos:
Atendente 1: 3 atendimentos.
Atendente 2: 3 atendimentos.
Atendente 3: 3 atendimentos.
Atendente 4: 3 atendimentos.
Atendente 5: 2 atendimentos.
Atendente 6: 2 atendimentos.
Atendente 7: 2 atendimentos.
Atendente 8: 2 atendimentos.
Atendente 9: 2 atendimentos.
Atendente 10: 2 atendimentos.
```